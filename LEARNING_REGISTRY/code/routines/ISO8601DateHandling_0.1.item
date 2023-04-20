package routines;

import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormatter;
import org.joda.time.format.ISODateTimeFormat;


public class ISO8601DateHandling {
	
	public static String getCurrentDateTimeInISOFormat(){
		DateTime dt = new DateTime();
		DateTimeFormatter fmt = ISODateTimeFormat.dateTimeNoMillis().withZoneUTC();
		return fmt.print(dt);
	}
	
	
}
