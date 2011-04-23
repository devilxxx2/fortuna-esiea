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

	@Override
	public List<Tirage> loadAllTirages() {

		final List<Tirage> tirages = new ArrayList<Tirage>();

		List<String> lines = readAllLines(csvFile);

		for (String line : lines) {
			Tirage tirage = lineToTirage(line);
			tirages.add(tirage);
		}

		return tirages;
	}

	private List<String> readAllLines(File file) {
		List<String> lines = new ArrayList<String>();

		try {
			FileReader fr = new FileReader(file);
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

	private Tirage lineToTirage(String line) {

		String[] values = line.split(";");
		String[] titles = header.split(";");

		HashMap<String,String> data=new HashMap<String,String>();
		
		for(int i=0;i<titles.length;i++)
		{
			data.put(titles[i], values[i]);
		}
		
		Tirage tirage=new Tirage(data);

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
