package com.web.vo;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by seokangchun on 14. 12. 1..
 */
@Getter
@Setter
public class ApiResultData implements Serializable {

    private static final long serialVersionUID = 0L;

    private boolean ok;
    private Object data;
    private String message;
    private Date date;

    public ApiResultData(Object data) {
        this.ok = true;
        this.data = data;
        this.message = "";
        this.date = new Date();
    }

    public ApiResultData(Exception err) {
        this.ok = false;
        this.data = null;
        this.message = err.getMessage();
        this.date = new Date();
    }

}
