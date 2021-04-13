package com.itony.safetyedu.microservice.serviceconfig;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data   //自动生成Get/Set
@NoArgsConstructor  //无参构造自动生成
@AllArgsConstructor //有参构造自动生成
public class EduException extends RuntimeException{
    private Integer code;
    private String message;


}
