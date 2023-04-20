package routines;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({ "type", "name", "url","email"})

public class Author
{

	@JsonProperty("@type")
	private String type;
	
    private String name;
    private String url;
    private String email;
    private String sameAs;

    public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type=Utils.cleanUpString(type);
		if (!Utils.isNullOrEmpty(type)) {
			if (type.indexOf("Person") > 0) {
				type="Person";
			} else if (type.indexOf("Organization") > 0) {
				type="Organization";
			}
		}
		if (this.type!=null) {
			this.type=type.replace("http://schema.org/", "");
		}
	}

	public String getEmail ()
    {
        return email;
    }

	public void setEmail(String email) {
		this.email=Utils.cleanUpString(email); 
	}

    public String getName ()
    {
        return name;
    }

	public void setName(String name) {
		this.name=Utils.cleanUpString(name);
	}

    public String getUrl ()
    {
        return url;
    }

    public void setUrl (String url)
    {
		if (url!=null) {
			//In extremely rare cases, we will receive a json array instead of a string for the URL
			//The code below takes the first URL of the set and uses it, ignoring any others
			List<String> list = new ArrayList<String>();
			list = JsonUtils.jsonArrayOfStringsToList(url);
			for (int x=0; x<list.size(); x++) {
				if (x==0) {
					url=Utils.cleanUpString(list.get(x));
				} else if (x==1) {
					setSameAs(Utils.cleanUpString(list.get(x)));
				}
			}
		}
		
    	String urlEncoded;
		try {
			urlEncoded = Utils.encodeUrl(url);
		} catch (Exception e) {
			urlEncoded = url;
		}
		if ((urlEncoded!=null) && (urlEncoded.length()>0)) {
			this.url = url;
		}
    }

    
	public String getSameAs() {
		return sameAs;
	}

	public void setSameAs(String sameAs) {
		this.sameAs = sameAs;
	}

	@Override
	public String toString() {
		return "Author [type=" + type + ", name=" + name + ", url=" + url
				+ ", email=" + email + ", sameAs=" + sameAs + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((sameAs == null) ? 0 : sameAs.hashCode());
		result = prime * result + ((type == null) ? 0 : type.hashCode());
		result = prime * result + ((url == null) ? 0 : url.hashCode());
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
		Author other = (Author) obj;
		if (email == null) {
			if (other.email != null)
				return false;
		} else if (!email.equals(other.email))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (sameAs == null) {
			if (other.sameAs != null)
				return false;
		} else if (!sameAs.equals(other.sameAs))
			return false;
		if (type == null) {
			if (other.type != null)
				return false;
		} else if (!type.equals(other.type))
			return false;
		if (url == null) {
			if (other.url != null)
				return false;
		} else if (!url.equals(other.url))
			return false;
		return true;
	}

	
    
}

