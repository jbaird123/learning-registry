package routines;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;

import org.apache.commons.lang3.StringEscapeUtils;

public class JsonUtils {

	// this class us used to "un-nest" single element arrays.
	public static String unNestJsonArray(String jsonString, boolean alwaysReturnAnArrayFlag) {
		String returnString = null;
		if (Utils.isNullOrEmpty(jsonString)) {
			return null;
		}
		
		JsonNode rootNode = null;
		
		try {
			rootNode = toJsonNode(jsonString);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		ArrayNode tempArray = null;
		JsonNode tempJsonNode = rootNode;

		boolean exitFlag = false;
		while (exitFlag == false) {
			if (tempJsonNode.isArray()) {
				tempArray = (ArrayNode) tempJsonNode;
				if (tempArray.size() == 1) {
					// this is a single element array, so un-nest it.
					tempJsonNode = tempArray.get(0);
				} else if (tempArray.size() == 0) {
					// this is a zero element array, exit.
					return null;
				} else {
					// more than one element, so this cannot be un-nested
					// further. Exit.
					exitFlag = true;
				}

			} else {
				// not an array, so exit
				exitFlag = true;
			}
		}
		if (alwaysReturnAnArrayFlag == true) {
			if (tempJsonNode.isArray() == false) {
				//convert to an array
				ArrayNode newJsonArray = (new ObjectMapper()).createArrayNode();
				newJsonArray.add(tempJsonNode);
				tempJsonNode = newJsonArray;
				returnString = tempJsonNode.toString();
			} else {
				//already an array, so just convert to string
				returnString = tempJsonNode.toString();
			}
		} else {
			if (tempJsonNode.isValueNode()) {
				returnString = tempJsonNode.asText();
			} else {
				//not a value node, so just return whatever it is
				returnString = tempJsonNode.toString();
			}
		}
		return returnString;
	}

	public static List<String> jsonArrayOfStringsToList(String jsonArrayString) {
		//convert json array of strings to list
		if ((jsonArrayString==null) || (jsonArrayString.length()==0)) {
			return null;
		}
		List<String> list = new ArrayList<String>();
		JsonNode jsonNode;
		try {
			jsonNode = toJsonNode(jsonArrayString);
			if (jsonNode.isArray()) {
				ArrayNode arrayNode = (ArrayNode)jsonNode;
				//convert jsonArray to List 
				for (int i = 0; i < arrayNode.size(); i++) {
					String temp = arrayNode.get(i).asText();
					
					if (Utils.isNullOrEmpty(arrayNode.get(i).asText())) {
						//asText returned null, so this element is an object or an array.  Use toString instead
						temp=arrayNode.get(i).toString();
					} else {
						//asText returned a value, so use it
						temp=arrayNode.get(i).asText();
					}
					if (!Utils.isNullOrEmpty(temp)) {
						temp=temp.trim();
						if(!Utils.isNullOrEmpty(temp)) {
							list.add(temp);
						}
					}
				}
			} else {
				String temp=null;
				if (Utils.isNullOrEmpty(jsonNode.asText())) {
					//asText returned null, so this element is an object or an array.  Use toString instead
					temp=jsonNode.toString();
				} else {
					//asText returned a value, so use it
					temp=jsonNode.asText();
				}
				
				if (!Utils.isNullOrEmpty(temp)) {
					temp=temp.trim();
					if(!Utils.isNullOrEmpty(temp)) {
						list.add(temp);
					}
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		} 
		return list;
	 }

	public static JsonNode toJsonNode(String jsonString) throws JsonProcessingException, IOException {
		if (Utils.isNullOrEmpty(jsonString) ) {
			return null;
		}
		//string preparation
		//remove all white space from the test string before determining the type of string
		String testString = jsonString.replaceAll("\\s+","");
		
		if (
		   (testString.startsWith("[\"") && testString.endsWith("\"]"))
		 ||(testString.startsWith("[\"") && testString.endsWith("]]"))
		 ||(testString.startsWith("[\"") && testString.endsWith("}]"))
		 ||(testString.startsWith("[[") && testString.endsWith("\"]"))
		 ||(testString.startsWith("[[") && testString.endsWith("]]"))
		 ||(testString.startsWith("[[") && testString.endsWith("}]"))
		 ||(testString.startsWith("[{") && testString.endsWith("\"]"))
		 ||(testString.startsWith("[{") && testString.endsWith("]]"))
		 ||(testString.startsWith("[{") && testString.endsWith("}]"))
		 ||(testString.equals("[]"))
		 ) {
			// it's an array, no preparation necessary
		} else if (
			(testString.startsWith("{\"") && testString.endsWith("\"}"))
	      ||(testString.equals("{}"))
		  ) {
			// it's an object, no preparation necessary
		} else {
			// it's a string, so escape special characters and make sure it is enclosed in quotes
			jsonString = StringEscapeUtils.escapeJava(jsonString);
			jsonString=Utils.quote(jsonString);
		}
		
		ObjectMapper mapper = new ObjectMapper();
		JsonNode jsonNode = null;
		try {
			jsonNode = mapper.readTree(jsonString);
		} catch (Exception e) {
			//This catch is only a precaution.  It should never be called.
			//in case our best efforts above to detect the type of string (array, object, string)
			//and parse it correctly fail, then just treat it as a string in order to 
			//avoid a failure.
			jsonString = Utils.quote(StringEscapeUtils.escapeJava(jsonString) );
			//try to parse again
			jsonNode = mapper.readTree(jsonString);
		}
		return jsonNode;
	}
}

