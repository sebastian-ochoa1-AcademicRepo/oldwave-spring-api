package co.com.edu.udea.oldwavespringapi.helper;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;
import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;

@Converter
public class StringToListConverter implements AttributeConverter<List<String>, String> {

    @Override
    public String convertToDatabaseColumn(List<String> list) {
        if(list == null) return "";
        return String.join(",", list);
    }

    @Override
    public List<String> convertToEntityAttribute(String joined) {
        if(joined == null) return new ArrayList<>();
        return new ArrayList<>(Arrays.asList(joined.split(",")));
    }
}

