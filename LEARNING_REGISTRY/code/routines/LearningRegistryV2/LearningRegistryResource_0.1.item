package routines;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({ "objects", "id", "type", "name", "thumbnailUrl","url","description"
	               ,"typicalAgeRange","keywords","educationalAlignment","dateCreated","dateModified","language"
	               ,"mediaType","learningResourceType","interactivityType","useRightsUrl","accessRights","publisher"
	               ,"author","accessibilityFeature","accessibilityHazard"})

public class LearningRegistryResource
{
	public LearningRegistryResource() {
		
		this.objects = new ArrayList<Object>();
		
		LearningRegistryResourceContext learningRegistryResourceContext = new LearningRegistryResourceContext();
		learningRegistryResourceContext.setVocab("http://schema.org/");
		
		URL url = new URL();
		url.setType("@id");
		learningRegistryResourceContext.setUrl(url);
		
		this.objects.add(learningRegistryResourceContext);
		
		learningRegistryResourceContext = new LearningRegistryResourceContext();
		learningRegistryResourceContext.setLrmi("http://lrmi.net/the-specification#");
		learningRegistryResourceContext.setEducationalAlignment("lrmi:educationalAlignment");
		learningRegistryResourceContext.setTypicalAgeRange("lrmi:typicalAgeRange");
		learningRegistryResourceContext.setInteractivityType("lrmi:interactivityType");
		learningRegistryResourceContext.setLearningResourceType("lrmi:learningResourceType");
		learningRegistryResourceContext.setUseRightsUrl("lrmi:useRightsUrl");
		this.objects.add(learningRegistryResourceContext);
		
		learningRegistryResourceContext = new LearningRegistryResourceContext();
		learningRegistryResourceContext.setMetadataRegistry("http://lr-staging.learningtapestry.com/api/schemas/learning_registry#");
		RegistryMetadata registryMetadata = new RegistryMetadata();
		registryMetadata.setId("metadataregistry:registry_metadata");
		registryMetadata.setType("@id");
		learningRegistryResourceContext.setRegistryMetadata(registryMetadata);
		this.objects.add(learningRegistryResourceContext);
		
		this.type="CreativeWork";
    	
	}
	
	
	@JsonProperty("@context") 
	private List<Object> objects;

	// a few examples show this is a URL which is the same as the "url"
	@JsonProperty("@id")
	private String id;
	
	@JsonProperty("@type")
	private String type;
	
    private String name;
    private String thumbnailUrl;
    private String url;
    private String description;
    
    @JsonIgnore
    private Set<String> typicalAgeRange;
    @JsonProperty("typicalAgeRange")
    private Object typicalAgeRangeObject;
    
    @JsonIgnore
    private Set<String> keywords;
    @JsonProperty("keywords")
    private String keywordsString;
    
    private Set<EducationalAlignment> educationalAlignment;
    private String dateCreated;
	private String dateModified;
	@JsonIgnore
    private Set<String> language;
    @JsonProperty("language")
    private Object languageObject;
    
    private Set<String> mediaType;
  
    @JsonIgnore
    private Set<String> learningResourceType;
    @JsonProperty("learningResourceType")
    private Object learningResourceTypeObject;
    
    @JsonProperty("interactivityType")
    private String interactivityTypeString;
    
    @JsonIgnore
    private Set<String> interactivityType;
    
    private String useRightsUrl;
    private String accessRights;
    private Publisher publisher;
    private Author author;
    
    private Set<String> accessibilityFeature;
    
    private Set<String> accessibilityHazard;
    
    @JsonProperty("registry_metadata")
    private RegistryMetadata registryMetadata;
    
    
    
    public String getId() {
		return id;
	}

	public void setId(String id) {
		String urlEncoded;
		try {
			urlEncoded = Utils.encodeUrl(Utils.cleanUpString(id));
		} catch (Exception e) {
			urlEncoded = id;
		}
		if ((urlEncoded!=null) && (urlEncoded.length()>0)) {
			this.id = urlEncoded;
		}
	}

	public String getType() {
		return type;
	}

	
    public String getDateModified () {
        return dateModified;
    }

    public void setDateModified (String dateModified) {
        this.dateModified = Utils.cleanUpString(dateModified);
    }

    public Set<String> getKeywords () {
        return keywords;
    }

    public void addKeywords (String keyword)
    {
    	keyword = Utils.cleanUpString(keyword);
    	if (keyword!=null) {
    		if (this.keywords == null) {
        		this.keywords = new HashSet<String>();
        	}
            this.keywords.add(keyword);
    	}
    }

    public Set<String> getAccessibilityHazard () {
        return accessibilityHazard;
    }

    public void addAccessibilityHazard (String accessibilityHazard)
    {
    	accessibilityHazard=Utils.cleanUpString(accessibilityHazard);
    	String formattedAccessibilityHazard = AccessibilityHazard.getFormattedName(accessibilityHazard);
    	if ((formattedAccessibilityHazard!=null) && (formattedAccessibilityHazard.length()>0)) {
    		if (this.accessibilityHazard == null) {
        		this.accessibilityHazard = new HashSet<String>();
        	}
    		this.accessibilityHazard.add(formattedAccessibilityHazard);	
    	} else {
			RejectLogging.logReject("go_open_v1_staging","accessibility_hazard",accessibilityHazard, "enum_violation",  "Invalid value");
    	}
    }

    public String getUrl () {
        return url;
    }

    public void setUrl (String url)
    {
    	url = Utils.cleanUpString(url);
    	String urlEncoded;
		try {
			urlEncoded = Utils.encodeUrl(url);
		} catch (Exception e) {
			urlEncoded = url;
		}
		if ((urlEncoded!=null) && (urlEncoded.length()>0)) {
			this.url = urlEncoded;
		}
    }

    public Set<String> getMediaType () {
        return mediaType;
    }

    public void addMediaType (String mediaType)
    {
    	mediaType = Utils.cleanUpString(mediaType);
    	String formattedMediaType = MediaType.getFormattedName(mediaType);
    	if (formattedMediaType!=null) {
    		if (this.mediaType == null) {
        		this.mediaType = new HashSet<String>();
        	}
    		this.mediaType.add(formattedMediaType);	
    	} else {
    		RejectLogging.logReject("go_open_v1_staging","media_type",mediaType, "enum_violation", "Invalid value");
    	}
    }

    public Set<String> getInteractivityType () {
        return interactivityType;
    }

    public void addInteractivityType (String interactivityType)
    {
    	interactivityType = Utils.cleanUpString(interactivityType);
    	String formattedInteractivityType = InteractivityType.getFormattedName(interactivityType);
    	if ((formattedInteractivityType!=null) && (formattedInteractivityType.length()>0)) {
        	if (this.interactivityType == null) {
        		this.interactivityType = new HashSet<String>();
        	}
    		this.interactivityType.add(formattedInteractivityType);	
    	} else {
    		RejectLogging.logReject("go_open_v1_staging","interactivity_type",interactivityType, "enum_violation", "Invalid value");
    	}
    }

    public Publisher getPublisher () {
        return publisher;
    }

    public void setPublisher (Publisher publisher)
    {
        if (
        (publisher!=null) &&
           (
	        (publisher.getType()!=null) ||
			(publisher.getName()!=null) ||
			(publisher.getUrl()!=null) ||
			(publisher.getEmail()!=null) 
			)
		) {
        	this.publisher = publisher;
		} else {
			this.publisher=null;
		}
			
    }

    public Author getAuthor ()
    {
        return author;
    }

    public void setAuthor (Author author)
    {
        if (
        (author!=null) &&
           (
	        (author.getType()!=null) ||
			(author.getName()!=null) ||
			(author.getUrl()!=null) ||
			(author.getEmail()!=null) 
			)
		) {
        	this.author = author;
		} else {
			this.author=null;
		}
			
    }

    public RegistryMetadata getRegistryMetadata ()
    {
    	return registryMetadata;
    }

    public void setRegistryMetadata (RegistryMetadata registryMetadata)
    {
        this.registryMetadata = registryMetadata;
    }

    public Set<String> getTypicalAgeRange ()
    {
        return typicalAgeRange;
    }

    public void addTypicalAgeRange (String typicalAgeRange)
    {
    	//light cleanup
    	typicalAgeRange = typicalAgeRange.replace("+", "-");
    	typicalAgeRange = Utils.cleanUpString(typicalAgeRange);
    	
    	if (typicalAgeRange!=null) {
    		//check the pattern match before adding to set
    		if (Utils.regexMatcher("^(\\d{1,2})(-|-\\d{1,2})?$", typicalAgeRange)) {
    	    	if (this.typicalAgeRange == null) {
    	    		this.typicalAgeRange = new HashSet<String>();
    	    	}
    	        this.typicalAgeRange.add(typicalAgeRange);
    		} else {
    			RejectLogging.logReject("go_open_v1_staging", "typicalAgeRange", typicalAgeRange, "validation_failed", "Failed regex test for typicalAgeRange");
    		}
    	}
    }

    public String getAccessRights () {
        return accessRights;
    }

    public void setAccessRights (String accessRights) {
        this.accessRights = Utils.cleanUpString(accessRights);
    }

    public Set<String> getLearningResourceType () {
        return learningResourceType;
    }

    public void addLearningResourceType (String learningResourceType)
    {
    	learningResourceType = Utils.cleanUpString(learningResourceType);
	    if (learningResourceType!=null) {
	    	if (this.learningResourceType == null) {
	    		this.learningResourceType = new HashSet<String>();
	    	}
	        this.learningResourceType.add(learningResourceType);
    	}
    }
    

    public String getDescription () {
        return description;
    }

    public void setDescription (String description) {
        this.description = Utils.cleanUpString(description);
    }

    public String getName () {
        return name;
    }

    public void setName (String name) {
        this.name = Utils.cleanUpString(name);
    }

    public String getThumbnailUrl () {
        return thumbnailUrl;
    }

    public void setThumbnailUrl (String thumbnailUrl)
    {
    	thumbnailUrl = Utils.cleanUpString(thumbnailUrl);
    	String urlEncoded = thumbnailUrl;
		try {
			urlEncoded = Utils.encodeUrl(urlEncoded);
		} catch (Exception e) {
			urlEncoded = thumbnailUrl;
		}
		if (!Utils.isNullOrEmpty(urlEncoded)) {
			this.thumbnailUrl = urlEncoded;
		}
    }

    public String getDateCreated () {
        return dateCreated;
    }

    public void setDateCreated (String dateCreated) {
        this.dateCreated = Utils.cleanUpString(dateCreated);
    }

    public Set<EducationalAlignment> getEducationalAlignment ()
    {
        return educationalAlignment;
    }

	public void addEducationalAlignment (EducationalAlignment educationalAlignment) {
    	if (educationalAlignment!=null) {
    		if (
    				(educationalAlignment.getAlignmentType()!=null)
				||  (educationalAlignment.getEducationalFramework()!=null)
				||  (educationalAlignment.getTargetDescription()!=null)
				||  (educationalAlignment.getTargetName()!=null)
				||  (educationalAlignment.getTargetUrl()!=null)
				||  (educationalAlignment.getType()!=null)
				) {
	    			//some values exist, so add the educationalAlignment
	            	if (this.educationalAlignment == null) {
	            		this.educationalAlignment= new HashSet<EducationalAlignment>();
	            	}
	            	int x = this.educationalAlignment.size();
	                this.educationalAlignment.add(educationalAlignment);
	                if (x==this.educationalAlignment.size()) {
	                	//value was rejected as a duplicate since the set did not increase in size.
	                	RejectLogging.logReject("go_open_v1_staging_educational_alignment", "educationalAlignment Object", educationalAlignment.toString(), "duplicate", "Rejected as duplicate");
	                } else {
	                //	RejectLogging.logReject("go_open_v1_staging_educational_alignment", "educationalAlignment Object", educationalAlignment.toString(), "added", "Not a duplicate!!!");
	                }
    		}
    	}
    }

    public Set<String> getLanguage () {
        return language;
    }

    public void addLanguage (String language)
    {
    	language = Utils.cleanUpString(language);
    	if (!Utils.isNullOrEmpty(language)) {
			if (this.language == null) {
				this.language = new HashSet<String>();
			}
			this.language.add(language);
    	}
    }

    public String getUseRightsUrl () {
        return useRightsUrl;
    }

    public void setUseRightsUrl (String useRightsUrl)
    {
    	useRightsUrl = Utils.cleanUpString(useRightsUrl);
    	String urlEncoded = useRightsUrl;
		try {
			urlEncoded = Utils.encodeUrl(urlEncoded);
		} catch (Exception e) {
			urlEncoded = useRightsUrl;
		}
		this.useRightsUrl = urlEncoded;
    }

    public Set<String> getAccessibilityFeature () {
        return accessibilityFeature;
    }

    public void addAccessibilityFeature (String accessibilityFeature)
    {
    	accessibilityFeature = Utils.cleanUpString(accessibilityFeature);
    	String formattedAccessibilityFeature = AccessibilityFeature.getFormattedName(accessibilityFeature);
    	if (!Utils.isNullOrEmpty(formattedAccessibilityFeature)) {
    		if (this.accessibilityFeature == null) {
        		this.accessibilityFeature = new HashSet<String>();
        	}
    		this.accessibilityFeature.add(formattedAccessibilityFeature);	
    	} else {
			RejectLogging.logReject("go_open_v1_staging","accessibility_feature",accessibilityFeature, "enum_violation", "Invalid value");
    	}
    }

    public void setEducationalAlignment(Set<EducationalAlignment> educationalAlignment) {
		this.educationalAlignment = (Set<EducationalAlignment>) educationalAlignment;
	}

	public void setMediaType(Set<String> mediaType) {
		this.mediaType = mediaType;
	}

	public void setAccessibilityFeature(Set<String> accessibilityFeature) {
		this.accessibilityFeature = accessibilityFeature;
	}

	public void setAccessibilityHazard(Set<String> accessibilityHazard) {
		this.accessibilityHazard = accessibilityHazard;
	}

	// convenience methods
	
	//author convenience methods
	public void setAuthorName(String authorName) {
		Author author;
		if (getAuthor()==null) {
			author = new Author();
		} else {
			author = getAuthor();
		}
		author.setName(authorName);
		setAuthor(author);
	}
	public void setAuthorType(String authorType) {
		Author author;
		if (getAuthor()==null) {
			author = new Author();
		} else {
			author = getAuthor();
		}
		author.setType(authorType);
		setAuthor(author);
	}
	public void setAuthorEmail(String authorEmail) {
		Author author;
		if (getAuthor()==null) {
			author = new Author();
		} else {
			author = getAuthor();
		}
		author.setEmail(authorEmail);
		setAuthor(author);
	}
	public void setAuthorUrl(String authorUrl) {
		Author author;
		if (getAuthor()==null) {
			author = new Author();
		} else {
			author = getAuthor();
		}
		author.setUrl(authorUrl);
		setAuthor(author);
	}
	
	//publisher convenience methods
	public void setPublisherName(String publisherName) {
		Publisher publisher;
		if (getPublisher()==null) {
			publisher = new Publisher();
		} else {
			publisher = getPublisher();
		}
		publisher.setName(publisherName);
		setPublisher(publisher);
	}
	/*public void setPublisherType(String publisherType) {
		Publisher publisher;
		if (getPublisher()==null) {
			publisher = new Publisher();
		} else {
			publisher = getPublisher();
		}
		publisher.setType(publisherType);
		setPublisher(publisher);
	}*/
	public void setPublisherEmail(String publisherEmail) {
		Publisher publisher;
		if (getPublisher()==null) {
			publisher = new Publisher();
		} else {
			publisher = getPublisher();
		}
		publisher.setEmail(publisherEmail);
		setPublisher(publisher);
	}
	public void setPublisherUrl(String publisherUrl) {
		Publisher publisher;
		if (getPublisher()==null) {
			publisher = new Publisher();
		} else {
			publisher = getPublisher();
		}
		publisher.setUrl(publisherUrl);
		setPublisher(publisher);
	}
	
	// typicalAgeRange convenience method
	public void addTypicalAgeRangesFromArray (String typicalAgeRange) {
		if (typicalAgeRange!=null) {
			List<String> list = new ArrayList<String>();
			list = JsonUtils.jsonArrayOfStringsToList(typicalAgeRange);
			for (int x=0; x<list.size(); x++) {
				addTypicalAgeRange(list.get(x));	
			}
		}
    }

	// keyword convenience method
	public void addKeywordsFromArray (String keyword) {
		if (keyword!=null) {
			List<String> list = new ArrayList<String>();
			list = JsonUtils.jsonArrayOfStringsToList(keyword);
			for (int x=0; x<list.size(); x++) {
				addKeywords(list.get(x));	
			}
		}
    }

	// language convenience method
	public void addLanguagesFromArray (String language) {
		if (language!=null) {
			List<String> list = new ArrayList<String>();
			list = JsonUtils.jsonArrayOfStringsToList(language);
			for (int x=0; x<list.size(); x++) {
				addLanguage(list.get(x));	
			}
		}
    }
	
	// media type convenience method
	public void addMediaTypesFromArray (String mediaType) {
		if (mediaType!=null) {
			List<String> list = new ArrayList<String>();
			list = JsonUtils.jsonArrayOfStringsToList(mediaType);
			for (int x=0; x<list.size(); x++) {
				addMediaType(list.get(x));	
			}
		}
    }
	
	// learning resource type convenience method
		public void addLearningResourceTypeFromArray (String learningResourceType) {
			if (learningResourceType!=null) {
				List<String> list = new ArrayList<String>();
				list = JsonUtils.jsonArrayOfStringsToList(learningResourceType);
				for (int x=0; x<list.size(); x++) {
					addLearningResourceType(list.get(x));	
				}
			}
	    }
	
	// interactivity type convenience method
		public void addInteractivityTypeFromArray (String interactivityType) {
			if (interactivityType!=null) {
				List<String> list = new ArrayList<String>();
				list = JsonUtils.jsonArrayOfStringsToList(interactivityType);
				for (int x=0; x<list.size(); x++) {
					addInteractivityType(list.get(x));	
				}
			}
	    }	
	
	// accessibility feature convenience method
		public void addAccessibilityFeatureFromArray (String accessibilityFeature) {
			if (accessibilityFeature!=null) {
				List<String> list = new ArrayList<String>();
				list = JsonUtils.jsonArrayOfStringsToList(accessibilityFeature);
				for (int x=0; x<list.size(); x++) {
					addAccessibilityFeature(list.get(x));	
				}
			}
	    }
	
	// accessibility feature convenience method
		public void addAccessibilityHazardFromArray (String accessibilityHazard) {
			if (accessibilityHazard!=null) {
				List<String> list = new ArrayList<String>();
				list = JsonUtils.jsonArrayOfStringsToList(accessibilityHazard);
				for (int x=0; x<list.size(); x++) {
					addAccessibilityHazard(list.get(x));	
				}
			}
	    }	
		
	// key location convenience method
		public void addKeyLocationsFromArray (String keyLocations) {
			if (keyLocations!=null) {
				List<String> list = new ArrayList<String>();
				list = JsonUtils.jsonArrayOfStringsToList(keyLocations);
				for (int x=0; x<list.size(); x++) {
					if (Utils.cleanUpString(list.get(x))!=null) {
						// check for nulls, create if null
						if(this.registryMetadata==null) {
							this.registryMetadata = new RegistryMetadata();
						}
						//check for nulls, create if null
						if(this.registryMetadata.getDigitalSignature()==null) {
							this.registryMetadata.setDigitalSignature(new DigitalSignature());
						}
						//add the key location
						this.registryMetadata.getDigitalSignature().addKeyLocation(Utils.cleanUpString(list.get(x)));	
					}
					
					
				}
			}
	    }	
	// keys convenience method
		public void addKeysFromArray (String keys) {
			if (keys!=null) {
				List<String> list = new ArrayList<String>();
				list = JsonUtils.jsonArrayOfStringsToList(keys);
				for (int x=0; x<list.size(); x++) {
					if (Utils.cleanUpString(list.get(x))!=null) {
						// check for nulls, create if null
						if(this.registryMetadata==null) {
							this.registryMetadata = new RegistryMetadata();
						}
						
						//add the key 
						this.registryMetadata.addKey(Utils.cleanUpString(list.get(x)));	
					}
				}
			}
	    }	
	// TOS convenience method
		public void setTOS (String tos) {
			if (tos!=null) {
				// check for nulls, create if null
				if(this.registryMetadata==null) {
					this.registryMetadata = new RegistryMetadata();
				}
						
				//set the TOS 
				TOS newTOS = new TOS();
				newTOS.setSubmissionTOS(tos);
				this.registryMetadata.setTOS(newTOS);	
			}
	    }		

	// payload placement convenience method
	public void setPayloadPlacement (String payloadPlacement) {
		if (payloadPlacement!=null) {
			// check for nulls, create if null
			if(this.registryMetadata==null) {
				this.registryMetadata = new RegistryMetadata();
			}
					
			//set the payload placement 
			this.registryMetadata.setPayloadPlacement(payloadPlacement);	
		}
    }		

	// submitter convenience method
	public void setSubmitter (String submitter) {
		if (submitter!=null) {
			// check for nulls, create if null
			if(this.getRegistryMetadata()==null) {
				this.registryMetadata = new RegistryMetadata();
			}
			if(this.registryMetadata.getIdentity()==null) {
				this.registryMetadata.setIdentity(new Identity());
			}
					
			//set the submitter 
			this.registryMetadata.getIdentity().setSubmitter(submitter);	
		}
    }		
	// signer convenience method
	public void setSigner (String signer) {
		if (signer!=null) {
			// check for nulls, create if null
			if(this.getRegistryMetadata()==null) {
				this.registryMetadata = new RegistryMetadata();
			}
			if(this.registryMetadata.getIdentity()==null) {
				this.registryMetadata.setIdentity(new Identity());
			}
					
			//set the signer 
			this.registryMetadata.getIdentity().setSigner(signer);	
		}
    }		

	// submitterType convenience method
	public void setSubmitterType (String submitterType) {
		if (submitterType!=null) {
			// check for nulls, create if null
			if(this.getRegistryMetadata()==null) {
				this.registryMetadata = new RegistryMetadata();
			}
			if(this.registryMetadata.getIdentity()==null) {
				this.registryMetadata.setIdentity(new Identity());
			}
					
			//set the signer 
			this.registryMetadata.getIdentity().setSubmitterType(submitterType);	
		}
    }	
	
	private void setInteractivityTypeString() {
		if ((this.interactivityType!=null)&& (!this.interactivityType.isEmpty()) &&(this.interactivityType.size()>0)) {
			//convert to a List so we can sort it.
			List<String> interactivityTypeList = new ArrayList<String>(this.interactivityType);
			//sort the list
			Collections.sort(interactivityTypeList);

			for (int x=0; x<interactivityTypeList.size(); x++) {
				if (x==0) {
					//just take the first value
					this.interactivityTypeString = interactivityTypeList.get(x);
					if (interactivityTypeList.size()>1) {
						//RejectLogging.logReject("go_open_v1_staging","interactivity_type",interactivityTypeList.get(x), "too_many_values", x + " preserving - " + interactivityTypeList.get(x));
					}
				} else {
					//ignore any subsequent values
					//RejectLogging.logReject("go_open_v1_staging","interactivity_type",interactivityTypeList.get(x), "too_many_values", x + " purging - " + interactivityTypeList.get(x));
				}
			}			
		} else {
			this.interactivityTypeString=null;
		}
		
	}
	
	public String toJson() {
		//typicalAgeRange
		//requested by Anderson, typicalAgeRange should be sent as a string if only one value is present, otherwise as an array.
		if (this.typicalAgeRange!=null) {
        	if (this.typicalAgeRange.size()==1) {
        		//send a string
            	this.typicalAgeRangeObject = this.typicalAgeRange.iterator().next().toString();
        	} else if (this.typicalAgeRange.size()>1){
        		//send an array
        		this.typicalAgeRangeObject = this.typicalAgeRange;
        	} else {
        		this.typicalAgeRange = null;
        	}
        }
		

        //interactivityTypeString
        setInteractivityTypeString();
		
		
		// keywords
		if ((this.keywords==null) || (this.keywords.isEmpty())) {
			this.keywordsString=null;
		} else {
			this.keywordsString=Utils.listToDelimitedString(new ArrayList<String>(this.keywords), ",");
		}

        if (this.educationalAlignment!=null) {
        	for (EducationalAlignment educationalAlignment: this.educationalAlignment ) {
        	//this sets the targetUrlString to a single URL.  If there are multiple URLs, all but the first are ignored
			educationalAlignment.setTargetUrlString();
        	}
    	}
        
        //requested by Anderson, language should be sent as a string if only one value is present, otherwise as an array.
        if (this.language!=null) {
        	if (this.language.size()==1) {
        		//send a string
            	this.languageObject = this.language.iterator().next().toString();
        	} else if (this.language.size()>1){
        		//send an array
        		this.languageObject = this.language;
        	} else {
        		this.languageObject = null;
        	}
        }
        
        //requested by Anderson, learningResourceType should be sent as a string if only one value is present, otherwise as an array.
        if (this.learningResourceType!=null) {
        	if (this.learningResourceType.size()==1) {
        		//send a string
            	this.learningResourceTypeObject = this.learningResourceType.iterator().next().toString();
        	} else if (this.learningResourceType.size()>1){
        		//send an array
        		this.learningResourceTypeObject = this.learningResourceType;
        	} else {
        		this.learningResourceTypeObject = null;
        	}
        }        
        
		ObjectMapper mapper = new ObjectMapper();
		// Convert object to JSON string 
		String jsonInString;
		try {
			//jsonInString = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(this);
			jsonInString = mapper.writeValueAsString(this);
		} catch (JsonProcessingException e) {
			e.printStackTrace();
			jsonInString = null;
		}
		return jsonInString;
	}

	@Override
	public String toString() {
		return "LearningRegistryResource [objects=" + objects + ", id=" + id
				+ ", type=" + type + ", name=" + name + ", thumbnailUrl="
				+ thumbnailUrl + ", url=" + url + ", description="
				+ description + ", typicalAgeRange=" + typicalAgeRange
				+ ", typicalAgeRangeObject=" + typicalAgeRangeObject
				+ ", keywords=" + keywords + ", keywordsString="
				+ keywordsString + ", educationalAlignment="
				+ educationalAlignment + ", dateCreated=" + dateCreated
				+ ", dateModified=" + dateModified + ", language=" + language
				+ ", languageObject=" + languageObject + ", mediaType="
				+ mediaType + ", learningResourceType=" + learningResourceType
				+ ", learningResourceTypeObject=" + learningResourceTypeObject
				+ ", interactivityTypeString=" + interactivityTypeString
				+ ", interactivityType=" + interactivityType
				+ ", useRightsUrl=" + useRightsUrl + ", accessRights="
				+ accessRights + ", publisher=" + publisher + ", author="
				+ author + ", accessibilityFeature=" + accessibilityFeature
				+ ", accessibilityHazard=" + accessibilityHazard
				+ ", registryMetadata=" + registryMetadata + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((accessRights == null) ? 0 : accessRights.hashCode());
		result = prime
				* result
				+ ((accessibilityFeature == null) ? 0 : accessibilityFeature
						.hashCode());
		result = prime
				* result
				+ ((accessibilityHazard == null) ? 0 : accessibilityHazard
						.hashCode());
		result = prime * result + ((author == null) ? 0 : author.hashCode());
		result = prime * result
				+ ((dateCreated == null) ? 0 : dateCreated.hashCode());
		result = prime * result
				+ ((dateModified == null) ? 0 : dateModified.hashCode());
		result = prime * result
				+ ((description == null) ? 0 : description.hashCode());
		result = prime
				* result
				+ ((educationalAlignment == null) ? 0 : educationalAlignment
						.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime
				* result
				+ ((interactivityType == null) ? 0 : interactivityType
						.hashCode());
		result = prime
				* result
				+ ((interactivityTypeString == null) ? 0
						: interactivityTypeString.hashCode());
		result = prime * result
				+ ((keywords == null) ? 0 : keywords.hashCode());
		result = prime * result
				+ ((keywordsString == null) ? 0 : keywordsString.hashCode());
		result = prime * result
				+ ((language == null) ? 0 : language.hashCode());
		result = prime * result
				+ ((languageObject == null) ? 0 : languageObject.hashCode());
		result = prime
				* result
				+ ((learningResourceType == null) ? 0 : learningResourceType
						.hashCode());
		result = prime
				* result
				+ ((learningResourceTypeObject == null) ? 0
						: learningResourceTypeObject.hashCode());
		result = prime * result
				+ ((mediaType == null) ? 0 : mediaType.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((objects == null) ? 0 : objects.hashCode());
		result = prime * result
				+ ((publisher == null) ? 0 : publisher.hashCode());
		result = prime
				* result
				+ ((registryMetadata == null) ? 0 : registryMetadata.hashCode());
		result = prime * result
				+ ((thumbnailUrl == null) ? 0 : thumbnailUrl.hashCode());
		result = prime * result + ((type == null) ? 0 : type.hashCode());
		result = prime * result
				+ ((typicalAgeRange == null) ? 0 : typicalAgeRange.hashCode());
		result = prime
				* result
				+ ((typicalAgeRangeObject == null) ? 0 : typicalAgeRangeObject
						.hashCode());
		result = prime * result + ((url == null) ? 0 : url.hashCode());
		result = prime * result
				+ ((useRightsUrl == null) ? 0 : useRightsUrl.hashCode());
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
		LearningRegistryResource other = (LearningRegistryResource) obj;
		if (accessRights == null) {
			if (other.accessRights != null)
				return false;
		} else if (!accessRights.equals(other.accessRights))
			return false;
		if (accessibilityFeature == null) {
			if (other.accessibilityFeature != null)
				return false;
		} else if (!accessibilityFeature.equals(other.accessibilityFeature))
			return false;
		if (accessibilityHazard == null) {
			if (other.accessibilityHazard != null)
				return false;
		} else if (!accessibilityHazard.equals(other.accessibilityHazard))
			return false;
		if (author == null) {
			if (other.author != null)
				return false;
		} else if (!author.equals(other.author))
			return false;
		if (dateCreated == null) {
			if (other.dateCreated != null)
				return false;
		} else if (!dateCreated.equals(other.dateCreated))
			return false;
		if (dateModified == null) {
			if (other.dateModified != null)
				return false;
		} else if (!dateModified.equals(other.dateModified))
			return false;
		if (description == null) {
			if (other.description != null)
				return false;
		} else if (!description.equals(other.description))
			return false;
		if (educationalAlignment == null) {
			if (other.educationalAlignment != null)
				return false;
		} else if (!educationalAlignment.equals(other.educationalAlignment))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (interactivityType == null) {
			if (other.interactivityType != null)
				return false;
		} else if (!interactivityType.equals(other.interactivityType))
			return false;
		if (interactivityTypeString == null) {
			if (other.interactivityTypeString != null)
				return false;
		} else if (!interactivityTypeString
				.equals(other.interactivityTypeString))
			return false;
		if (keywords == null) {
			if (other.keywords != null)
				return false;
		} else if (!keywords.equals(other.keywords))
			return false;
		if (keywordsString == null) {
			if (other.keywordsString != null)
				return false;
		} else if (!keywordsString.equals(other.keywordsString))
			return false;
		if (language == null) {
			if (other.language != null)
				return false;
		} else if (!language.equals(other.language))
			return false;
		if (languageObject == null) {
			if (other.languageObject != null)
				return false;
		} else if (!languageObject.equals(other.languageObject))
			return false;
		if (learningResourceType == null) {
			if (other.learningResourceType != null)
				return false;
		} else if (!learningResourceType.equals(other.learningResourceType))
			return false;
		if (learningResourceTypeObject == null) {
			if (other.learningResourceTypeObject != null)
				return false;
		} else if (!learningResourceTypeObject
				.equals(other.learningResourceTypeObject))
			return false;
		if (mediaType == null) {
			if (other.mediaType != null)
				return false;
		} else if (!mediaType.equals(other.mediaType))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (objects == null) {
			if (other.objects != null)
				return false;
		} else if (!objects.equals(other.objects))
			return false;
		if (publisher == null) {
			if (other.publisher != null)
				return false;
		} else if (!publisher.equals(other.publisher))
			return false;
		if (registryMetadata == null) {
			if (other.registryMetadata != null)
				return false;
		} else if (!registryMetadata.equals(other.registryMetadata))
			return false;
		if (thumbnailUrl == null) {
			if (other.thumbnailUrl != null)
				return false;
		} else if (!thumbnailUrl.equals(other.thumbnailUrl))
			return false;
		if (type == null) {
			if (other.type != null)
				return false;
		} else if (!type.equals(other.type))
			return false;
		if (typicalAgeRange == null) {
			if (other.typicalAgeRange != null)
				return false;
		} else if (!typicalAgeRange.equals(other.typicalAgeRange))
			return false;
		if (typicalAgeRangeObject == null) {
			if (other.typicalAgeRangeObject != null)
				return false;
		} else if (!typicalAgeRangeObject.equals(other.typicalAgeRangeObject))
			return false;
		if (url == null) {
			if (other.url != null)
				return false;
		} else if (!url.equals(other.url))
			return false;
		if (useRightsUrl == null) {
			if (other.useRightsUrl != null)
				return false;
		} else if (!useRightsUrl.equals(other.useRightsUrl))
			return false;
		return true;
	}

	
	
	
}