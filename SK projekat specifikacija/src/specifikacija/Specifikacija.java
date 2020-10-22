package specifikacija;

public abstract class Specifikacija {

	private String filename;
	
	public Specifikacija() {		
	}

	public abstract void save();
	
	
	public String getFilename() {
		return filename;
	}

	public void setFilename(String filename) {
		this.filename = filename;
	}
	
}
