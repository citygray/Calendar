package calendar;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class PlanItem {
	public Date planDate;
	public String detail;
	public String attendee  = "";
	
	public static Date getDateformString(String strDate) {
		Date date = null;
		try {
			date = new SimpleDateFormat("yyyy-MM-dd").parse(strDate);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return date;
	}
	
	public PlanItem(String strDate, String detail) {
		this.planDate = getDateformString(strDate);
		this.detail = detail;
	}
	
	public Date getDate() {
		return planDate;
	}
	
	public void addAttendee(String name) {
		attendee += name +",";
	}
}
