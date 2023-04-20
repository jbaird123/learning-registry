package routines;
public class RejectLogging {
	private static int stagingId;
	
	public static void setStagingId(int currentStagingId){
		stagingId=currentStagingId;
	}

	public static void logReject(String tableName, String columnName, String value, String errorCode, String message) {
		CoreLogs.debugMsg("|" +stagingId+ "|"+ tableName + "|" + columnName + "|" + errorCode + "|" + message + "|" + value);
	}
}
