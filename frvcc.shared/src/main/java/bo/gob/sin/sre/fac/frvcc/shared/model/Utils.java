package bo.gob.sin.sre.fac.frvcc.shared.model;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.pulsar.shade.com.google.common.base.CaseFormat;
import org.springframework.beans.BeanWrapper;
import org.springframework.beans.BeanWrapperImpl;

import java.beans.FeatureDescriptor;
import java.io.IOException;
import java.io.Serializable;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.Objects;
import java.util.stream.Stream;

public final class Utils {
    public static final String ZERO = "0";
    public static final String CIEN = "100";
    public static String IMPUESTO_IVA = "0.13";
    public static String IMPUESTO_IPN_STI = "0.12";
    public static String IMPUESTO_STI = "0.10";
    public static String IMPUESTO_7RG = "0.05";
    public static String PORCENTAJE = "0.01";
    public static String IMPUESTO_RRIVA="0.05";
    public static String localDateTimeToString(LocalDateTime dateTime) {
        return dateTime.format(DateTimeFormatter.ISO_LOCAL_DATE_TIME);
    }

    public static String localDateToString(LocalDate dateTime) {
        return dateTime.format(DateTimeFormatter.ISO_LOCAL_DATE);
    }

    public static String localDateTimeToString(Timestamp timestamp) {
        return localDateTimeToString(timestamp.toLocalDateTime());
    }

    public static LocalDateTime stringToLocalDateTime(String  dateTime){
        return  LocalDateTime.parse(dateTime);
    }

    public static LocalDate stringToLocalDate(String  dateTime){
        return  LocalDate.parse(dateTime);
    }

    public static String jsonEncode(HashMap<String, Serializable> map) {
        try {
            return new ObjectMapper().writeValueAsString(map);
        } catch (JsonProcessingException e) {
            return "";
        }
    }

    public static HashMap<String, Serializable> jsonDecode(String body) {
        try {
            return new ObjectMapper().readValue(body, HashMap.class);
        } catch (IOException e) {
            return null;
        }
    }

    public static String toSnake(String text) {
        return CaseFormat.UPPER_CAMEL.to(CaseFormat.LOWER_UNDERSCORE, text);
    }

    public static String toCamel(String text) {
        return CaseFormat.LOWER_UNDERSCORE.to(CaseFormat.UPPER_CAMEL, text);
    }

    public static String toCamelFirstLower(String text) {
        return CaseFormat.LOWER_UNDERSCORE.to(CaseFormat.LOWER_CAMEL, text);
    }

    public static String[] getNullProperties(Object source) {
        final BeanWrapper wrappedSource = new BeanWrapperImpl(source);
        return Stream.of(wrappedSource.getPropertyDescriptors())
                .map(FeatureDescriptor::getName)
                .filter(propertyName -> Objects.isNull(wrappedSource.getPropertyValue(propertyName)))
                .toArray(String[]::new);
    }
    public static String[] getProperties(Object source) {
        final BeanWrapper wrappedSource = new BeanWrapperImpl(source);
        return Stream.of(wrappedSource.getPropertyDescriptors())
                .map(FeatureDescriptor::getName)
                .toArray(String[]::new);
    }
}
