package converters;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import io.cucumber.java.ParameterType;

public class DateConverter {

    @ParameterType("([0-9]{2}/[0-9]{2}/[0-9]{4})")
    public Date date(String data) {
        try {
            return new SimpleDateFormat("dd/MM/yyyy").parse(data);
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
    }
}
