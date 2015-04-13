package com.convert;

import org.joda.time.DateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.ConversionService;
import org.springframework.core.convert.TypeDescriptor;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * Created by Administrator on 2015-4-9.
 */
@Component
public class MyService {

    private ConversionService conversionService;

    @Autowired
    public MyService(ConversionService conversionService){
        this.conversionService = conversionService;
    }

    public Object doIt(Object o, TypeDescriptor s, TypeDescriptor t){
        return this.conversionService.convert(o, s, t);
    }

}
