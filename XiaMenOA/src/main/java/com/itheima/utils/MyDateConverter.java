package com.itheima.utils;

import org.springframework.core.convert.converter.Converter;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 自定义 java.util.Date日期转换器
 * 
 * 
 */
public class MyDateConverter implements Converter<String,Date> {


	@Override
	public Date convert(String s) {
		System.out.println(s);
		SimpleDateFormat format=new SimpleDateFormat("yyyy-MM-dd");
		try {
			return format.parse(s);
		}catch (Exception e){
			e.printStackTrace();
		}
		return null;
	}
}
