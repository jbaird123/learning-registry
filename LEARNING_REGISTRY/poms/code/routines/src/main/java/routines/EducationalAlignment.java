package routines;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class EducationalAlignment
{
	//for testing only
	//private String educationalAlignmentStagingId;
	
	@JsonProperty("@type")
	private String type;
	
	private String alignmentType;
    private String educationalFramework;
    private String targetName;
    
    @JsonIgnore
    private Set<String> targetUrl;
    @JsonProperty("targetUrl")
    private String targetUrlString;
    
    private String targetDescription;
    
    public EducationalAlignment() {
    	this.type="AlignmentObject";
    }

    /*
    //for testing only    
    public String getEducationalAlignmentStagingId() {
		return educationalAlignmentStagingId;
	}
    //for testing only
	public void setEducationalAlignmentStagingId(String educationalAlignmentStagingId) {
		this.educationalAlignmentStagingId = educationalAlignmentStagingId;
	}
	*/
	
	public String getType() {
		return type;
	}

	public void setType(String type) {
		if (type!=null) {
			//maybe it should just be hard-coded in the constructor "AlignmentObject"
			type=type.replace("http://schema.org/", "");
		}
		this.type=Utils.cleanUpString(type);
	}

	public String getAlignmentType () {
        return alignmentType;
    }

    public void setAlignmentType (String alignmentType) {
    	alignmentType=Utils.cleanUpString(alignmentType);
    	if (alignmentType != null) {
        	String formattedAlignmentType = AlignmentType.getFormattedName(alignmentType);
        	if (formattedAlignmentType!=null) {
        		this.alignmentType = formattedAlignmentType;	
        	} else {
    			RejectLogging.logReject("go_open_v1_staging","alignment_type",alignmentType, "enum_violation", "Invalid value");
        	}
    	} else {
    		this.alignmentType=null;
    	}
    }

    public String getTargetName ()
    {
        return targetName;
    }

    public void setTargetName (String targetName) {
		this.targetName=Utils.cleanUpString(targetName);
	}

    public String getEducationalFramework () {
        return educationalFramework;
    }

    public void setEducationalFramework (String educationalFramework) {
        this.educationalFramework = Utils.cleanUpString(educationalFramework);
    }

    public Set<String> getTargetUrl() {
		return targetUrl;
	}
	public void addTargetUrl(String targetUrl) {
		targetUrl = Utils.cleanUpString(targetUrl);
		String url;
		try {
			url = Utils.encodeUrl(targetUrl);
		} catch (Exception e) {
			url = targetUrl;
		}
		if ((url!=null) && (url.length()>0)) {
			if (this.targetUrl == null) {
	    		this.targetUrl = new HashSet<String>();
	    	}
			this.targetUrl.add(url);
		}
	}

	
	public String getTargetDescription() {
		return targetDescription;
	}

	public void setTargetDescription(String targetDescription) {
		this.targetDescription = Utils.cleanUpString(targetDescription);
	}
	
	public void setTargetUrlString() {
		if ((this.targetUrl!=null) && (!this.targetUrl.isEmpty()) ) {
			//convert to a List so we can sort it.
			List<String> targetUrlList = new ArrayList<String>(this.targetUrl);
			//sort the list
			Collections.sort(targetUrlList);

			for (int x=0; x<targetUrlList.size(); x++) {
				if (x==0) {
					//just take the first value
					this.targetUrlString = targetUrlList.get(x);
					if (targetUrlList.size()>1) {
						RejectLogging.logReject("go_open_v1_staging_educational_alignment","target_url",targetUrlList.get(x), "too_many_values", x + " preserving - " + targetUrlList.get(x));
					}
				} else {
					//ignore any subsequent URLs
					RejectLogging.logReject("go_open_v1_staging_educational_alignment","target_url",targetUrlList.get(x), "too_many_values", x + " purging - " + targetUrlList.get(x));
				}
			}
			/*
			this.targetUrlString = this.targetUrl.iterator().next();
			//log URLs that are being ignored.
			if (this.targetUrl.size()>1) {
				Iterator<String> it = this.targetUrl.iterator();//.next();
				for(int x=0;x<this.targetUrl.size();x++) {
					if (x==0) {
						RejectLogging.logReject("go_open_v1_staging_educational_alignment","target_url",this.targetUrlString, "too_many_values", x + " preserving - " + it.next());;
					} else {
						RejectLogging.logReject("go_open_v1_staging_educational_alignment","target_url",this.targetUrlString, "too_many_values", x + " purging - " + it.next());;
					}
				}
			}*/
			
		} else {
			this.targetUrlString=null;
		}
		
	}
	
	// targetUrl convenience method
	public void addTargetUrlsFromArray (String targetUrls) {
		if (!Utils.isNullOrEmpty(targetUrls)) {
			List<String> list = new ArrayList<String>();
			list = JsonUtils.jsonArrayOfStringsToList(targetUrls);
			for (int x=0; x<list.size(); x++) {
				addTargetUrl(list.get(x));	
			}
		}
    }

	@Override
	public String toString() {
		return "EducationalAlignment [type=" + type + ", alignmentType="
				+ alignmentType + ", educationalFramework="
				+ educationalFramework + ", targetName=" + targetName
				+ ", targetUrl=" + targetUrl + ", targetUrlString="
				+ targetUrlString + ", targetDescription=" + targetDescription
				+ "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((alignmentType == null) ? 0 : alignmentType.hashCode());
		result = prime
				* result
				+ ((educationalFramework == null) ? 0 : educationalFramework
						.hashCode());
		result = prime
				* result
				+ ((targetDescription == null) ? 0 : targetDescription
						.hashCode());
		result = prime * result
				+ ((targetName == null) ? 0 : targetName.hashCode());
		result = prime * result
				+ ((targetUrl == null) ? 0 : targetUrl.hashCode());
		result = prime * result
				+ ((targetUrlString == null) ? 0 : targetUrlString.hashCode());
		result = prime * result + ((type == null) ? 0 : type.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		EducationalAlignment other = (EducationalAlignment) obj;
		if (alignmentType == null) {
			if (other.alignmentType != null)
				return false;
		} else if (!alignmentType.equals(other.alignmentType))
			return false;
		if (educationalFramework == null) {
			if (other.educationalFramework != null)
				return false;
		} else if (!educationalFramework.equals(other.educationalFramework))
			return false;
		if (targetDescription == null) {
			if (other.targetDescription != null)
				return false;
		} else if (!targetDescription.equals(other.targetDescription))
			return false;
		if (targetName == null) {
			if (other.targetName != null)
				return false;
		} else if (!targetName.equals(other.targetName))
			return false;
		if (targetUrl == null) {
			if (other.targetUrl != null)
				return false;
		} else if (!targetUrl.equals(other.targetUrl))
			return false;
		if (targetUrlString == null) {
			if (other.targetUrlString != null)
				return false;
		} else if (!targetUrlString.equals(other.targetUrlString))
			return false;
		if (type == null) {
			if (other.type != null)
				return false;
		} else if (!type.equals(other.type))
			return false;
		return true;
	}
		
	
}

