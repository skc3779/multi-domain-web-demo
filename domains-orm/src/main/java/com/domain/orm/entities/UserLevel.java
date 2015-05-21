package com.domain.orm.entities;

/**
 * Created by seokangchun on 14. 11. 28..
 */

public enum UserLevel {
    NORMAL(0),	// 일반유저
    READER(1),	// 중간층유저
    MVP(2);		// 고급유저

    private final int value;
    private UserLevel(int value){
        this.value = value;
    }

    public int intValue(){
        return this.value;
    }

    public static UserLevel valueOf(int value) {
        switch(value) {
            case 0 : return NORMAL;
            case 1 : return READER;
            case 2 : return MVP;
            default :
                throw new IllegalArgumentException();
        }
    }
}
