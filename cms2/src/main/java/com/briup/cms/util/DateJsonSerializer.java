package com.briup.cms.util;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * java对象转json字符串的时候，日期转换格式设置
 */
public class DateJsonSerializer extends JsonSerializer<Date>{

	@Override
	public void serialize(Date date, JsonGenerator jsonGenerator, SerializerProvider sp) throws IOException {

		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

		String dateStr = dateFormat.format(date);

		jsonGenerator.writeNumber(date.getTime()/1000);

		jsonGenerator.writeString(dateStr);
		
	}

}
