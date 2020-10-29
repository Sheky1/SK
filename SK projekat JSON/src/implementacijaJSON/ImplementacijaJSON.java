package implementacijaJSON;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
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
	    try {
	        BufferedReader buffReader = new BufferedReader(new FileReader(this.getFile()));
	        String line;
	        Gson gson = new Gson();
	        Type type = new TypeToken<List<Entitet>>() {}.getType();
	        while ((line = buffReader.readLine()) != null) {
	        	this.getPodaci().addAll(gson.fromJson(line, type));
	        }
	        buffReader.close();
	    } catch (IOException e) {
	        e.printStackTrace();
	    }
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
