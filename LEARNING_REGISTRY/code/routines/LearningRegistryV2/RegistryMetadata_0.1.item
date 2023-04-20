package routines;

import java.util.HashSet;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class RegistryMetadata
{
	@JsonProperty("@id")
    private String id;
	
	@JsonProperty("@type")
    private String type;
	
	@JsonProperty("digital_signature")
	private DigitalSignature digitalSignature;

	private Set<String> keys;
    @JsonProperty("terms_of_service")
    private TOS TOS;
    
    @JsonProperty("payload_placement")
    private String payloadPlacement;
    
    private Identity identity;
    
    @JsonProperty("original_envelope")
    private String originalEnvelope;

    
    public Identity getIdentity ()
    {
        return identity;
    }

    public void setIdentity (Identity identity)
    {
        this.identity = identity;
    }

    public TOS getTOS ()
    {
        return TOS;
    }

    public void setTOS (TOS TOS)
    {
        this.TOS = TOS;
    }

    public Set<String> getKeys ()
    {
        return keys;
    }

    public void addKey (String key) {
    	key = Utils.cleanUpString(key);
    	if (key!=null) {
	    	if (this.keys == null) {
	    		this.keys = new HashSet<String>();    		
	    	}
	        this.keys.add(key);
    	}
    }

    public DigitalSignature getDigitalSignature ()
    {
        return digitalSignature;
    }

    public void setDigitalSignature (DigitalSignature digitalSignature)
    {
        this.digitalSignature = digitalSignature;
    }

    public String getOriginalEnvelope ()
    {
        return originalEnvelope;
    }

    public void setOriginalEnvelope (String originalEnvelope)
    {
        this.originalEnvelope = Utils.cleanUpString(originalEnvelope);
    }

    public String getPayloadPlacement ()
    {
        return payloadPlacement;
    }

    public void setPayloadPlacement (String payloadPlacement) {
        this.payloadPlacement = Utils.cleanUpString(payloadPlacement);
    }

    public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = Utils.cleanUpString(id);;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = Utils.cleanUpString(type);
	}

	public void setKeys(Set<String> keys) {
		this.keys = keys;
	}

	@Override
	public String toString() {
		return "RegistryMetadata [id=" + id + ", type=" + type
				+ ", digitalSignature=" + digitalSignature + ", keys=" + keys
				+ ", TOS=" + TOS + ", payloadPlacement=" + payloadPlacement
				+ ", identity=" + identity + ", originalEnvelope="
				+ originalEnvelope + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((TOS == null) ? 0 : TOS.hashCode());
		result = prime
				* result
				+ ((digitalSignature == null) ? 0 : digitalSignature.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result
				+ ((identity == null) ? 0 : identity.hashCode());
		result = prime * result + ((keys == null) ? 0 : keys.hashCode());
		result = prime
				* result
				+ ((originalEnvelope == null) ? 0 : originalEnvelope.hashCode());
		result = prime
				* result
				+ ((payloadPlacement == null) ? 0 : payloadPlacement.hashCode());
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
		RegistryMetadata other = (RegistryMetadata) obj;
		if (TOS == null) {
			if (other.TOS != null)
				return false;
		} else if (!TOS.equals(other.TOS))
			return false;
		if (digitalSignature == null) {
			if (other.digitalSignature != null)
				return false;
		} else if (!digitalSignature.equals(other.digitalSignature))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (identity == null) {
			if (other.identity != null)
				return false;
		} else if (!identity.equals(other.identity))
			return false;
		if (keys == null) {
			if (other.keys != null)
				return false;
		} else if (!keys.equals(other.keys))
			return false;
		if (originalEnvelope == null) {
			if (other.originalEnvelope != null)
				return false;
		} else if (!originalEnvelope.equals(other.originalEnvelope))
			return false;
		if (payloadPlacement == null) {
			if (other.payloadPlacement != null)
				return false;
		} else if (!payloadPlacement.equals(other.payloadPlacement))
			return false;
		if (type == null) {
			if (other.type != null)
				return false;
		} else if (!type.equals(other.type))
			return false;
		return true;
	}
	
	
}