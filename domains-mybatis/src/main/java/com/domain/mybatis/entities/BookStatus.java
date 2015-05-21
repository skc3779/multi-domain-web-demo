package com.domain.mybatis.entities;

/**
 * Created by seokangchun on 15. 5. 21..
 */
public enum BookStatus {
    CANRENT(0), // 대출가능
    RENTNOW(1), // 대출중
    MISSING(2); // 분실

    private final int value;
    private BookStatus(int value){
        this.value = value;
    }

    public int intValue(){
        return this.value;
    }

    public static BookStatus valueOf(int value) {
        switch(value) {
            case 0 : return CANRENT;
            case 1 : return RENTNOW;
            case 2 : return MISSING;
            default :
                throw new IllegalArgumentException();
        }
    }
}
