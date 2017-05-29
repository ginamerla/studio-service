package com.marke.app.coreservice.utils;

import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import org.apache.commons.lang3.StringUtils;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;

public class LocalDateDeserializer extends StdDeserializer<LocalDate> {
	private static final long serialVersionUID = 1L;
    public static final String ISO_LOCAL_DATE_FORMAT = "yyyy-MM-dd";

    protected LocalDateDeserializer(Class<LocalDate> clazz) {
        super(clazz);// 28
    }// 29

    public LocalDate deserialize(JsonParser parser, DeserializationContext context) throws IOException {
        String text = parser.getText();// 34
        String fieldName = parser.getCurrentName();// 35
        if (!StringUtils.isBlank(text)) {// 37
            try {
                return LocalDate.parse(text, DateTimeFormatter.ISO_LOCAL_DATE);// 39
            } catch (Exception arg5) {// 40
                throw new RuntimeException(arg5);
            }
        } else {
            return null;// 44
        }
    }
}
