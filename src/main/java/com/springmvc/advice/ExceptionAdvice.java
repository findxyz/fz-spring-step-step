package com.springmvc.advice;

import org.apache.log4j.Logger;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.io.*;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by fz on 2015-5-29.
 */
@ControllerAdvice
public class ExceptionAdvice {

    private static final Logger logger = Logger.getLogger(ExceptionAdvice.class);

    @ResponseBody
    @ExceptionHandler(Exception.class)
    public Map processException(HttpServletRequest request, Exception e) throws IOException {

        Writer bw = new StringWriter();
        BufferedReader br = null;
        try{
            String line;
            br = new BufferedReader(new InputStreamReader(request.getInputStream()));
            while((line = br.readLine()) != null){
                bw.write(line);
            }
        }finally {
            bw.close();
            if(br != null){
                br.close();
            }
        }
        Map message = new HashMap();
        message.put("error", "出错了" + e.getMessage());
        message.put("header", request.getParameterMap());
        message.put("body", bw.toString());
        return message;
    }
}
