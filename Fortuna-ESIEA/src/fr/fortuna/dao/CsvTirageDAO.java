package fr.fortuna.dao;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import fr.fortuna.Tirage.Tirage;

public class CsvTirageDAO implements TirageDAO {

	private File csvFile;
	private String header;
	
	@SuppressWarnings("unused")
	private CsvTirageDAO() {
	}

	public CsvTirageDAO(File f)
	{
		csvFile=f;
	}
	
	@Override
	public List<Tirage> loadAllTirages() {
		if(csvFile.exists()){
			final List<Tirage> tirages = new ArrayList<Tirage>();
	
			List<String> lines = readAllLines();
	
			for (String line : lines) {
				Tirage tirage = lineToTirage(line);
				tirages.add(tirage);
			}
			return tirages;
		}
		else
		{
			return null;
		}
	}
	
	@Override
	public List<Tirage> loadTiragesByValue(String title,String value) {
		String[] t = new String[1];
		String[] v = new String[1];
		
		t[0]=title;
		v[0]=value;
		
		return loadTiragesByValue(t,v);
	}
	
	@Override
	public List<Tirage> loadTiragesByValue(String[] titles,String[] values) {

		if(csvFile.exists()){
		
			final List<Tirage> tirages = new ArrayList<Tirage>();
	
			List<String> lines = readAllLines();
	
			for (String line : lines) {
				Tirage tirage = lineToTirage(line);
				if(tirage.matchesWith(titles, values))
					tirages.add(tirage);
			}
	
			return tirages;
		}
		else
		{
			return null;
		}
	}

	private List<String> readAllLines() {
		if(csvFile.exists()){
			
		List<String> lines = new ArrayList<String>();

		try {
			FileReader fr = new FileReader(csvFile);
			BufferedReader br = new BufferedReader(fr);

			boolean first = true;

			for (String line = br.readLine(); line != null; line = br.readLine()) {
				// la premiere ligne contient le titre des colonnes.
				if (first) {
					header=line;
					first = false;
					continue;
				}

				lines.add(line);

			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return lines;
		}
		else
		{
			return null;
		}
	}

	private Tirage lineToTirage(String line) {

		String[] values = line.split(";");
		String[] titles = header.split(";");

		HashMap<String,String> data=new HashMap<String,String>();
		
		for(int i=0;i<titles.length;i++)
		{
			data.put(titles[i], values[i]);
		}
		
		String type=csvFile.getName().substring(0, csvFile.getName().length()-4);	
		
		Tirage tirage=new Tirage(type,data);

		return tirage;
	}

	/* Getters / Setters */
	public File getCsvFile() {
		return csvFile;
	}

	public void setCsvFile(File csvFile) {
		this.csvFile = csvFile;
	}

}
