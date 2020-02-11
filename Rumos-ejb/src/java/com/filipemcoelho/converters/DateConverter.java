package com.filipemcoelho.converters;

import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
import javax.persistence.Converter;
import javax.persistence.AttributeConverter;

@Converter(autoApply = true)
public class DateConverter implements AttributeConverter<LocalDate, Date> {

    @Override
    public Date convertToDatabaseColumn(LocalDate value) {
        return (value == null) ? null : Date.from(value.atStartOfDay(ZoneId.systemDefault()).toInstant());
    }

    @Override
    public LocalDate convertToEntityAttribute(Date dbData) {
        return (dbData == null) ? null : Instant.ofEpochMilli(dbData.getTime()).atZone(ZoneId.systemDefault()).toLocalDate();
    }
}
