package specifikacija;

public class ExportManager {
	
	private static Specifikacija specifikacija;
	
	public static void registerExporter(Specifikacija spec) {
		specifikacija = spec;		
	}
	
	public static Specifikacija getExporter(String fileName) {
		specifikacija.setFilename(fileName);
		return specifikacija;
	}

}
