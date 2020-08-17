package com.sea.springboot.advice;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ResultModel {
    private int code;
    private Object data;

    public static ResultModel ok(Object data) {
        ResultModel result = new ResultModel();
        result.setCode(200);
        result.setData(data);
        return result;
    }

    public static ResultModel error(String error) {
        ResultModel result = new ResultModel();
        result.setCode(500);
        result.setData(error);
        return result;
    }
}
