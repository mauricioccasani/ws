package pe.com.mau.app.util;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.TimeZone;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

public class ClaseUtils {
	
	 public static String printPrettyJSONString(Object o) throws JsonProcessingException {
		    return new ObjectMapper().setDateFormat(ClaseUtils.getLocalFormat())
		        .configure(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS, false).writerWithDefaultPrettyPrinter()
		        .writeValueAsString(o);
		  }
	 public static DateFormat getLocalFormat() {
		    DateFormat dateFormat = new SimpleDateFormat(Constante.FORMATOFECHACABECERA);
		    dateFormat.setTimeZone(TimeZone.getDefault());
		    return dateFormat;
		  }
}
