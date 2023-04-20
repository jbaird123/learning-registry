// template routine Java
package routines;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintStream;
import java.net.InetAddress;
import java.net.UnknownHostException;

public class CoreLogs {

	public static String DEBUG_LEVEL = "DEBUG";
	public static String INFO_LEVEL = "INFO";
	public static String WARN_LEVEL = "WARN";
	public static String ERROR_LEVEL = "ERROR";
	public static String FATAL_LEVEL = "FATAL";
	
    public static boolean IS_FATAL_ENABLED = true;
    public static boolean IS_ERROR_ENABLED = true;
    public static boolean IS_WARN_ENABLED = true;
    public static boolean IS_INFO_ENABLED = true;
    public static boolean IS_DEBUG_ENABLED = true;

    private static String LOG_FILE_DIRECTORY;
    private static String LOG_FILE_NAME;
    private static String ERROR_LOG_FILE_NAME;
    private static boolean isLoggingInitialized = false;
    
    private static String HTML_FORMAT = "HTML";
    
    //Defines the email format for the log files.
    private static String LOG_FILE_FORMAT = HTML_FORMAT;
    
    //Stores the contents of the log file
    private static String LOG_FILE_CONTENTS = "";
    
  
    public static void setLogLevel(String istrLogLevel) {
    	String lstrLogLevel = INFO_LEVEL;
    	
        if (istrLogLevel != null && !istrLogLevel.trim().equals("")) {
        	lstrLogLevel = istrLogLevel;
        }
        infoMsg("Setting Log Level to "+lstrLogLevel); 
        
        //Set IS_DEBUG_ENABLED
        IS_DEBUG_ENABLED = lstrLogLevel.equals(DEBUG_LEVEL);
        
        //Set IS_INFO_ENABLED
        IS_INFO_ENABLED = lstrLogLevel.equals(INFO_LEVEL) || IS_DEBUG_ENABLED ;
        
        //Set IS_WARN_ENABLED
        IS_WARN_ENABLED = lstrLogLevel.equals(WARN_LEVEL) || IS_INFO_ENABLED;
        
        //Set IS_ERROR_ENABLED
        IS_ERROR_ENABLED = lstrLogLevel.equals(ERROR_LEVEL) || IS_WARN_ENABLED;
        
        //Set IS_FATAL_ENABLED
        IS_FATAL_ENABLED = lstrLogLevel.equals(FATAL_LEVEL) || IS_ERROR_ENABLED;
        
    }    //End OF setLogLevel
    
    
    public static String getLogFileContents()
    {
        return LOG_FILE_CONTENTS;
    }


    private static String setLogMsg(String istrLogMsg, String istrLogLevel) {
    	String lstrLogMsg = istrLogMsg;
        if (istrLogMsg != null && !istrLogMsg.trim().equals("")) 
        	lstrLogMsg = TalendDate.formatDate("yyyy-MM-dd HH:mm:ss", TalendDate.getCurrentDate()) + " : " + istrLogLevel + " : " + istrLogMsg;
        System.out.println(lstrLogMsg); 
                
        if (LOG_FILE_FORMAT.equals(HTML_FORMAT)){
    	  if (istrLogLevel==ERROR_LEVEL) {
              LOG_FILE_CONTENTS+=("<div style=\"color:#ff0000;\">" + lstrLogMsg+"</div>");
    	  } else {
    		  LOG_FILE_CONTENTS+=("<div>" + lstrLogMsg+"</div>");
    	  }
        } else {
        	LOG_FILE_CONTENTS+=(lstrLogMsg+"\n");
        }
            
        if ((getErrorLogFileName()!=null) && (getLogFileDirectory()!=null)) {   	
	        if (!(istrLogLevel.equals(INFO_LEVEL) || istrLogLevel.equals(DEBUG_LEVEL))) {
	        	// an error occurred, so also write to error log
	        	writeLogMessage(getErrorLogFileName(), getLogFileDirectory(), lstrLogMsg);
	        }
        }
        	
    	return lstrLogMsg;
    }    //End OF setLogMsg
    
    
    public static String debugMsg(String istrLogMsg) {
    	
    	String lstrLogMsg = "";
    	if(IS_DEBUG_ENABLED)
    		lstrLogMsg = setLogMsg(istrLogMsg, DEBUG_LEVEL);
        return lstrLogMsg;
    }    //End OF debugMsg
    
    public static String infoMsg(String istrLogMsg) {
    	
    	String lstrLogMsg = "";
    	if(IS_INFO_ENABLED)
    		lstrLogMsg = setLogMsg(istrLogMsg, INFO_LEVEL);
        return lstrLogMsg;
    }    //End OF infoMsg
    

    public static String warnMsg(String istrLogMsg) {
    	
    	String lstrLogMsg = "";
    	if(IS_WARN_ENABLED)
    		lstrLogMsg = setLogMsg(istrLogMsg, WARN_LEVEL);
        return lstrLogMsg;
    }    //End OF warnMsg

  
    public static String errorMsg(String istrLogMsg) {
    	
    	String lstrLogMsg = "";
    	if(IS_WARN_ENABLED)
    		lstrLogMsg = setLogMsg(istrLogMsg, ERROR_LEVEL);
        return lstrLogMsg;
    }    //End OF errorMsg


    
    public static String fatalMsg(String istrLogMsg) {
    	
    	String lstrLogMsg = "";
    	if(IS_WARN_ENABLED)
    		lstrLogMsg = setLogMsg(istrLogMsg, FATAL_LEVEL);
        return lstrLogMsg;
    }    //End OF fatalMsg


	public static String getLogFileDirectory() {
		return LOG_FILE_DIRECTORY;
	}


	private static void setLogFileDirectory(String logFileDirectory) {
		LOG_FILE_DIRECTORY = logFileDirectory;
	}


	public static String getLogFileName() {
		return LOG_FILE_NAME;
	}


	private static void setLogFileName(String logFileName) {
		LOG_FILE_NAME = logFileName;
	}


	public static String getErrorLogFileName() {
		return ERROR_LOG_FILE_NAME;
	}


	private static void setErrorLogFileName(String errorLogFileName) {
		ERROR_LOG_FILE_NAME = errorLogFileName;
	}
    
	//initialize global logging variables.  Create directories and files if necessary.
	public static void initializeLogging (String logFileDirectory, String logFileName, String errorLogFileName, String loggingDestination, String contextStr, String logLevel) {
		if (isLoggingInitialized) {return;}
		if (loggingDestination.equalsIgnoreCase("CONSOLE")) {
    		// do nothing
    	} else {
			//set global variables
			setLogFileDirectory(logFileDirectory);
			setLogFileName(logFileName);
			setErrorLogFileName(errorLogFileName);
			
			File logFilePath =new File(logFileDirectory);
			File logFile =new File(logFileDirectory + "/" + logFileName);
			File errorLogFile =new File(logFileDirectory + "/" + errorLogFileName);
	
			//if LOG file DIRECTORY doesn't exist, then create it
			if(!logFilePath.exists()){
					logFilePath.mkdir();
			}
			
			//if LOG file doesn't exist, then create it
			if(!logFile.exists()){
				try {
					logFile.createNewFile();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			//if ERROR LOG file doesn't exist, then create it
			if(!errorLogFile.exists()){
				try {
					errorLogFile.createNewFile();
				} catch (IOException e) {
					e.printStackTrace();
				} 
			}
	
			try {
				
				FileOutputStream logFileStream = new FileOutputStream(logFile,true); // append to log file
				
				PrintStream printStream = new PrintStream(logFileStream);
				System.setOut(printStream);
				System.setErr(printStream);
				} catch (FileNotFoundException e1) {
				e1.printStackTrace();
			}
    	}
		// set flag to true to avoide re-initializing later
		isLoggingInitialized=true;
		setLogLevel(logLevel);

		infoMsg("Job is running using the " + contextStr + " context group.");
		infoMsg("Job is running on the following server: " + getExecutionServer());
	}
	
	private static void writeLogMessage(String logFileName, String logFilePath, String logMessage) {
		File logFile =new File(logFilePath + "/" + logFileName);
		try {
			FileWriter fileWriter = new FileWriter(logFile.getPath(),true);
			BufferedWriter bufferWriter = new BufferedWriter(fileWriter);
			bufferWriter.write(logMessage + "\r\n");
			bufferWriter.close();
			fileWriter.close();
		} catch (IOException e1) {
			e1.printStackTrace();
		}
        
	}
	public static String getExecutionServer() {
        InetAddress ip;
        String hostName = "";
        try {
            ip = InetAddress.getLocalHost();
            hostName = ip.getHostName();
        } catch (UnknownHostException e) {
 
            e.printStackTrace();
        }

        return hostName.toLowerCase();
	}	
}
