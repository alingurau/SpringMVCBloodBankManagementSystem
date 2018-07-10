package ro.emanuel.project.pojo;

import java.beans.PropertyEditorSupport;
import java.sql.Date;
import java.text.SimpleDateFormat;

import com.sun.org.apache.xerces.internal.impl.xpath.regex.ParseException;

public class DateEditor extends PropertyEditorSupport {
	public void setAsText(String value) {
		try {
			setValue(new SimpleDateFormat("dd/MM/yyyy").parse(value));
		} catch (ParseException | java.text.ParseException e) {
			setValue(null);
		}
	}

	public String getAsText() {
		String s = "";
		if (getValue() != null) {
			s = new SimpleDateFormat("dd/MM/yyyy").format((Date) getValue());
		}
		return s;
	}
}