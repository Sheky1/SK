package implementacijaJSON;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.lang.reflect.Type;
import java.util.List;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import specifikacija.Entitet;
import specifikacija.Specifikacija;

public class ImplementacijaJSON extends Specifikacija {

	@Override
	public void napraviBazu(File file) {
		
	}

	@Override
	public void ucitaj() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void upisi() {
	    try {
	        BufferedWriter buffWriter = new BufferedWriter(new FileWriter(this.getFile(), true));
	        Gson gson = new Gson();
	        Type type = new TypeToken<List<Entitet>>() {}.getType();
	        String json = gson.toJson(this.getPodaci(), type);
	        buffWriter.append(json);
	        buffWriter.newLine();
	        buffWriter.close();
	    } catch (IOException e) {
	        e.printStackTrace();
	    }
	}

}
