package NotFinished;


public class Languages {
	
	private Integer language_id;
	private String iso;
	private String name;
	

	public Languages() {
	}


	public Languages(Integer language_id, String iso, String name) {
		super();
		this.language_id = language_id;
		this.iso = iso;
		this.name = name;
	}


	public Integer getLanguage_id() {
		return language_id;
	}


	public void setLanguage_id(Integer language_id) {
		this.language_id = language_id;
	}


	public String getIso() {
		return iso;
	}


	public void setIso(String iso) {
		this.iso = iso;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}



}
