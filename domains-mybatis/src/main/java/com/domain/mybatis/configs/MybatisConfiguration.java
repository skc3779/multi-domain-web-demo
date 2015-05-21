package com.domain.mybatis.configs;

import com.domain.mybatis.core.Mapper;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.jolbox.bonecp.BoneCPDataSource;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;
import java.io.IOException;

/**
 * Created by seokangchun on 15. 5. 21..
 */
@Slf4j
@Configuration
@EnableTransactionManagement
@PropertySource("classpath:connect.properties")
@ComponentScan(basePackages = {"com.domain.mybatis.services"})
@MapperScan(basePackages = {"com.domain.mybatis.modules"},
            annotationClass = Mapper.class, sqlSessionFactoryRef = "sqlSessionFactory",
            sqlSessionTemplateRef = "sqlSessionTemplate")
public class MybatisConfiguration {
    public static final String CONNECT_USERNAME = "connect.username";
    public static final String CONNECT_PASSWORD = "connect.password";
    public static final String CONNECT_DRIVER = "connect.driver";
    public static final String CONNECT_URL = "connect.url";

    @Autowired
    private Environment env;

    /**
     * XML를 클래스로 하용하기 위해서는 꼭 존재 해야한다.
     * @return
     */
    @Bean
    public static PropertySourcesPlaceholderConfigurer propertySourcesPlaceholderConfigurer() {
        System.setProperty("org.jboss.logging.provider", "slf4j");
        PropertySourcesPlaceholderConfigurer propertySourcesPlaceholderConfigurer = new PropertySourcesPlaceholderConfigurer();
        propertySourcesPlaceholderConfigurer.setFileEncoding("UTF-8");
        return propertySourcesPlaceholderConfigurer;
    }

    @Bean(destroyMethod="close")
    public DataSource dataSource(){
        BoneCPDataSource dataSource = new BoneCPDataSource();
        log.info("CONNECT_USERNAME : {}", env.getProperty(CONNECT_USERNAME));
        dataSource.setUsername(env.getProperty(CONNECT_USERNAME));
        dataSource.setPassword(env.getProperty(CONNECT_PASSWORD));
        dataSource.setJdbcUrl(env.getProperty(CONNECT_URL));
        dataSource.setDriverClass(env.getProperty(CONNECT_DRIVER));
        dataSource.setIdleConnectionTestPeriodInMinutes(60);
        dataSource.setIdleMaxAgeInMinutes(240);
        dataSource.setMaxConnectionsPerPartition(5);
        dataSource.setMinConnectionsPerPartition(5);
        dataSource.setPartitionCount(3);
        dataSource.setAcquireIncrement(5);
        return dataSource;
    }

    /**
     * 스프링이 트랜잭션을 관리할때 사용하는 트랜잭션매니저를 등록한다.
     */
    @Bean
    public PlatformTransactionManager transactionManager() {
        return new DataSourceTransactionManager(dataSource());
    }

    @Bean
    public SqlSessionFactoryBean sqlSessionFactory(DataSource dataSource, ApplicationContext applicationContext) throws IOException {
        SqlSessionFactoryBean sessionFactoryBean = new SqlSessionFactoryBean();

        // mybatis가 사용한 DataSource를 등록
        sessionFactoryBean.setDataSource(dataSource);

        // mybatis 설정파일의 위치설정
        sessionFactoryBean.setConfigLocation(applicationContext.getResource("classpath:META-INF/mybatis/configuration.xml"));

        // entities 클래스 이름을 짧은 별칭으로 등록
        sessionFactoryBean.setTypeAliasesPackage("com.domain.mybatis.entities");

        // META-INF/mybatis/mappers 패키지 이하의 모든 XML을 매퍼로 등록
        sessionFactoryBean.setMapperLocations(applicationContext.getResources("classpath:META-INF/mybatis/mappers/**/*.xml"));

        return sessionFactoryBean;
    }

    /**
     * 마이바티스 {@link org.apache.ibatis.session.SqlSession} 빈을 등록한다.
     *
     * SqlSessionTemplate은 SqlSession을 구현하고 코드에서 SqlSession를 대체하는 역할을 한다.
     * 쓰레드에 안전하게 작성되었기 때문에 여러 DAO나 매퍼에서 공유 할 수 있다.
     */
    @Bean(destroyMethod = "clearCache")
    public SqlSessionTemplate sqlSessionTemplate(SqlSessionFactory sqlSessionFactory) {
        return new SqlSessionTemplate(sqlSessionFactory);
    }

    @Bean
    public ObjectMapper objectMapper() {
        return new ObjectMapper();
    }

}
