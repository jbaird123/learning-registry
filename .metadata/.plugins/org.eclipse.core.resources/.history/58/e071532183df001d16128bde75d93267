package routines;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;
import java.nio.charset.StandardCharsets;

import org.apache.commons.validator.routines.EmailValidator;
import org.apache.commons.validator.routines.UrlValidator;
import org.apache.http.NameValuePair;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.client.utils.URLEncodedUtils;


public class Utils {

	public static boolean isNullOrEmpty(String string) {
		return ((string==null) || (string.length()==0));
	}
	
	public static String cleanUpString(String string) {
		if (Utils.isNullOrEmpty(string)) {
			return null;
		} else {
			string = string.trim();
			if (string==null) {return null;}
			return string.trim();
		} 
	}
	
	//converts a list of strings into a delimited string
    public static String listToDelimitedString(List<String> list, String delimiter) {
    	if ((list==null) || (list.size()==0)) {
    		return null;
    	}
    	for (int x=0;x<list.size();x++) {
    		String temp = quote(list.get(x));
    		list.set(x, temp);
    	}
		return String.join(delimiter,list); 
	}
    
    //removes double quotes from the beginning and end of a string
    public static String unquote( String str )
    {
      int length = str == null ? -1 : str.length();
      if( str == null || length == 0 )
        return null;

      if( length > 1 && str.charAt( 0 ) == '\"' && str.charAt( length - 1 ) == '\"' )
      {
        str = str.substring( 1, length - 1 );
      }

      return str;
    }

    //surrounds a string with double quotes if not already surrounded
    public static String quote( String str )
    {
      int length = str == null ? -1 : str.length();
      if( str == null || length == 0 )
        return "\"\"";

      if( length > 1 && str.charAt( 0 ) == '\"' && str.charAt( length - 1 ) == '\"' )
      {
        //string is already quoted so do nothing
      } else {
    	  str = "\"" + str + "\"";
      }

      return str;
    }

    public static String encodeUrl( String url ) throws MalformedURLException
    {
    	URL newUrl = new URL(url);
    	String newUrlString = "";
    	
    	String query = newUrl.getQuery();
    	String path = newUrl.getPath();
    	String host = newUrl.getHost();
    	int port = newUrl.getPort();
    	String protocol = newUrl.getProtocol();

    	List<NameValuePair> params = null;
    	if (query!=null) {
	    	params =
	                URLEncodedUtils.parse(query, StandardCharsets.UTF_8);
	    	}
    	URIBuilder builder = new URIBuilder();
    	
    	if (params!=null) {
    		builder.setScheme(protocol)
    	            .setHost(host)
    	            .setPort(port)
    	            .setPath(path)
    	            .setParameters(params)
    	            ;
    	
    	} else {
    		builder.setScheme(protocol)
    	            .setHost(host)
    	            .setPort(port)
    	            .setPath(path)
    	            ;
    		
    	}
	    
		try {
			URI uri = builder.build();
			newUrlString = uri.toString();
		} catch (Exception e) {
			throw new MalformedURLException();
		}
		
		return newUrlString;
    }

    public static boolean regexMatcher(String pattern, String line) {

      // Create a Pattern object
      Pattern r = Pattern.compile(pattern);
      
      // Now create matcher object.
      Matcher m = r.matcher(line);
      boolean found = m.find();
	      
	   return found;
 }
    
    public static boolean isValidUrl(String url) {
		 boolean returnValue = false;
		 try {
	    	UrlValidator urlValidator = new UrlValidator();
	    	if (url==null) {
	    		return false;
	    	}
	    	if (!(url.startsWith("http://")) && !(url.startsWith("https://"))) {
	    		url = "http://" + url;
	    	}
	    	returnValue = urlValidator.isValid(url);
		 } catch (Exception e) {
			 return false;
		 }
	    	return returnValue;
	    }
	 
	 public static boolean isValidEmailAddress(String emailAddress) {
	    	return EmailValidator.getInstance().isValid(emailAddress);
	    }



	    /**
	     * appendDelimiter: checks whether the input string is null or empty and if not, appends the delimiter.
	     */ 
	    public static String appendDelimiter(String istrInputString, String istrDelimiter) {
	    	String ostrReturnString;
	    	
	        if ((istrInputString == null) || (istrInputString.equals(""))) {
	        	ostrReturnString = istrInputString;
	        } else {
	        	ostrReturnString = istrInputString+istrDelimiter;
	        }
	        return ostrReturnString;
	    }
	    
	     /**
	     * isNull: checks whether the input string is null or empty and if so, returns the alternate value.
	     */     
	    public static String isNull(String istrInputString, String istrAlternate) {
	    	String ostrReturnString;
	    	
	        if ((istrInputString == null) || (istrInputString.equals(""))) {
	        	ostrReturnString = istrAlternate;
	        } else {
	        	ostrReturnString = istrInputString;
	        }
	        return ostrReturnString;
	    }
	    
	    /**
	     * isNull: checks whether the input string is null or empty and if so, returns the alternate value.
	     */     
	    public static Integer isNull(Integer iintInput, Integer iintAlternate) {
	    	Integer ointReturnInteger;
	    	
	        if (iintInput == null)  {
	        	ointReturnInteger = iintAlternate;
	        } else {
	        	ointReturnInteger = iintInput;
	        }
	        return ointReturnInteger;
	    }

}
