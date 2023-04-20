package routines;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class Identity
{

    private String submitter;
    private String signer;
    
    @JsonProperty("submitter_type")
    private String submitterType;

    public String getSigner ()
    {
        return signer;
    }

    public void setSigner (String signer) {
        this.signer = Utils.cleanUpString(signer);
    }

    public String getSubmitter () {
        return submitter;
    }

    public void setSubmitter (String submitter) {
        this.submitter = Utils.cleanUpString(submitter);
    }

    public String getSubmitterType () {
        return this.submitterType;
    }

    public void setSubmitterType (String submitterType) {
        this.submitterType = Utils.cleanUpString(submitterType);
    }
	@Override
	public String toString() {
		return "Identity [submitter=" + submitter + ", signer=" + signer + ", submitterType=" + submitterType + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((signer == null) ? 0 : signer.hashCode());
		result = prime * result
				+ ((submitter == null) ? 0 : submitter.hashCode());
		result = prime * result
				+ ((submitterType == null) ? 0 : submitterType.hashCode());
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
		Identity other = (Identity) obj;
		if (signer == null) {
			if (other.signer != null)
				return false;
		} else if (!signer.equals(other.signer))
			return false;
		if (submitter == null) {
			if (other.submitter != null)
				return false;
		} else if (!submitter.equals(other.submitter))
			return false;
		if (submitterType == null) {
			if (other.submitterType != null)
				return false;
		} else if (!submitterType.equals(other.submitterType))
			return false;
		return true;
	}
	

}
