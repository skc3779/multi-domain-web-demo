package com.domain.orm.configs;

import com.jolbox.bonecp.BoneCPDataSource;
import lombok.extern.slf4j.Slf4j;
import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.*;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.core.env.Environment;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

/**
 * Created by seokangchun on 14. 11. 28..
 */
@Configuration
@EnableTransactionManagement(mode = AdviceMode.PROXY, order = 0)
@PropertySource("classpath:connect.properties")
@ComponentScan(basePackages = {"com.domain.orm.services"})
@EnableJpaRepositories(basePackages={"com.domain.orm.repositories"}, entityManagerFactoryRef="entityManagerFactory")
@Slf4j
public class DomainConfiguration {

    public static final String CONNECT_USERNAME = "connect.username";
    public static final String CONNECT_PASSWORD = "connect.password";
    public static final String CONNECT_DRIVER = "connect.driver";
    public static final String CONNECT_URL = "connect.url";

    public static final String HIBERNATE_SHOW_SQL = "hibernate.show_sql";
    public static final String HIBERNATE_DIALECT = "hibernate.dialect";


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
        log.info("CONNECT_USERNAME 1 : {}", env.getProperty(CONNECT_USERNAME));
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
        dataSource.setReleaseHelperThreads(3);
        return dataSource;
    }

    /*
     * xml 파일을 가져 오기 의해 new ClassPathResource 를 사용
     */
    @Bean
    public LocalContainerEntityManagerFactoryBean entityManagerFactory() throws Exception{

        Map<String, String> jpaPropertyMap = new HashMap<String, String>();
        jpaPropertyMap.put(HIBERNATE_DIALECT, env.getProperty(HIBERNATE_DIALECT));
        LocalContainerEntityManagerFactoryBean entityManagerFactory = new LocalContainerEntityManagerFactoryBean();
        entityManagerFactory.setDataSource(dataSource());
        entityManagerFactory.setJpaVendorAdapter(hibernateJpaVendorAdapter());
        entityManagerFactory.setPackagesToScan("com.domain.orm.entities");
        entityManagerFactory.setJpaProperties(getHibernateProperties());
        return entityManagerFactory;
    }

    protected Properties getHibernateProperties() throws Exception {
        final Properties properties = new Properties();
        properties.put(HIBERNATE_DIALECT, env.getProperty(HIBERNATE_DIALECT));
        properties.put(HIBERNATE_SHOW_SQL, env.getProperty(HIBERNATE_SHOW_SQL));
        return properties;
    }

    @Bean
    @Role(BeanDefinition.ROLE_INFRASTRUCTURE)
    public HibernateJpaVendorAdapter hibernateJpaVendorAdapter() {
        boolean showSql = Boolean.valueOf(env.getProperty(HIBERNATE_SHOW_SQL));
        HibernateJpaVendorAdapter hibernateJpaVendorAdapter = new HibernateJpaVendorAdapter();
        hibernateJpaVendorAdapter.setShowSql(showSql);
        return hibernateJpaVendorAdapter;
    }

    /**
     * sessionFactoryFactory().getObject() FactoryFactory 이기 때문에 getObject() 받아야한다.
     */
    @Bean
    public JpaTransactionManager transactionManager() throws Exception {
        JpaTransactionManager transactionManager = new JpaTransactionManager();
        transactionManager.setDataSource(dataSource());
        transactionManager.setEntityManagerFactory(entityManagerFactory().getObject());
        return transactionManager;
    }

    @Bean
    public ObjectMapper objectMapper() {
        return new ObjectMapper();
    }
}
