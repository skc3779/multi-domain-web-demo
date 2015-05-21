package com.domain.orm.entities;

/**
 * Created by seokangchun on 14. 11. 28..
 */
public enum HistoryActionType {
    RENT(0),	// 대출함
    RETURN(1);	// 반납함

    private final int value;
    private HistoryActionType(int value){
        this.value = value;
    }

    public int intValue(){
        return this.value;
    }

    public static HistoryActionType valueOf(int value) {
        switch(value) {
            case 0 : return RENT;
            case 1 : return RETURN;
            default :
                throw new IllegalArgumentException();
        }
    }
}
