package routines;

import java.util.HashSet;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class DigitalSignature
{
	@JsonProperty("key_location")
    private Set<String> keyLocation;

    public Set<String> getKeyLocation ()
    {
        return keyLocation;
    }

    public void addKeyLocation (String keyLocation)
    {
    	keyLocation=Utils.cleanUpString(keyLocation);
    	if (keyLocation!=null) {
	    	if (this.keyLocation == null){
	    		this.keyLocation=new HashSet<String>();
	    	}
	        this.keyLocation.add(keyLocation);
    	}
    }

	@Override
	public String toString() {
		return "DigitalSignature [keyLocation=" + keyLocation + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((keyLocation == null) ? 0 : keyLocation.hashCode());
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
		DigitalSignature other = (DigitalSignature) obj;
		if (keyLocation == null) {
			if (other.keyLocation != null)
				return false;
		} else if (!keyLocation.equals(other.keyLocation))
			return false;
		return true;
	}

    
   
}

