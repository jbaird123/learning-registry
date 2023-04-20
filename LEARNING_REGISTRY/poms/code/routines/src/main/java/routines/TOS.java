package routines;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class TOS
{
	@JsonProperty("submission_tos")
    private String submissionTOS;

    public String getSubmissionTOS () {
        return submissionTOS;
    }

    public void setSubmissionTOS (String submissionTOS) {
        this.submissionTOS = Utils.cleanUpString(submissionTOS);
    }

	@Override
	public String toString() {
		return "TOS [submissionTOS=" + submissionTOS + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((submissionTOS == null) ? 0 : submissionTOS.hashCode());
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
		TOS other = (TOS) obj;
		if (submissionTOS == null) {
			if (other.submissionTOS != null)
				return false;
		} else if (!submissionTOS.equals(other.submissionTOS))
			return false;
		return true;
	}

    
}

