package com.itony.safetyedu.microservice.serviceconfig;

import com.itony.safetyedu.ctools.R;
import org.springframework.jdbc.BadSqlGrammarException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import java.sql.SQLException;

@ControllerAdvice
public class GlobalExceptionHandler {

    //通用异常处理
    @ExceptionHandler(Exception.class)
    @ResponseBody
    public R error(Exception e)
    {
        e.printStackTrace();
        return R.error().message("Error invoke!").message(e.getMessage());
    }
    //特定异常处理
    @ExceptionHandler(ArithmeticException.class)
    @ResponseBody
    public R error(ArithmeticException e)
    {
        e.printStackTrace();
        return R.error().message("除数不能为零");
    }

    //特定异常处理
    @ExceptionHandler(SQLException.class)
    @ResponseBody
    public R error(SQLException e)
    {
        e.printStackTrace();
        return R.error().message(e.getMessage());
    }
    //特定异常处理--SQL语句异常
    @ExceptionHandler(BadSqlGrammarException.class)
    @ResponseBody
    public R error(BadSqlGrammarException e)
    {
        e.printStackTrace();
        return R.error().message(e.getMessage());
    }

    //特定异常处理--SQL语句异常
    @ExceptionHandler(ArrayIndexOutOfBoundsException.class)
    @ResponseBody
    public R error(ArrayIndexOutOfBoundsException e)
    {
        e.printStackTrace();
        return R.error().message("数组下标超出异常");
    }

    //自定义异常

    @ExceptionHandler(EduException.class)
    @ResponseBody
    public R error(EduException e)
    {
        e.printStackTrace();
        return R.error().message(e.getMessage()).code(e.getCode());
    }

}
