package fr.fortuna.dao;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import fr.fortuna.Tirage.Tirage;

public abstract class CsvTirageDAO implements TirageDAO {

	protected File csvFile;
	
	@SuppressWarnings("unused")
	private CsvTirageDAO() {
	}

	public CsvTirageDAO(File f)
	{
		csvFile=f;
	}
	
	/*@Override
	public abstract List<Tirage> loadAllTirages();
*/
	protected List<String> readAllLines() {
		if(csvFile.exists()){
			
		List<String> lines = new ArrayList<String>();

		try {
			FileReader fr = new FileReader(csvFile);
			BufferedReader br = new BufferedReader(fr);

			boolean first = true;

			for (String line = br.readLine(); line != null; line = br.readLine()) {
				// la premiere ligne contient le titre des colonnes.
				if (first) {
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

	protected abstract Tirage lineToTirage(String line);

	/* Getters / Setters */
	public File getCsvFile() {
		return csvFile;
	}

	public void setCsvFile(File csvFile) {
		this.csvFile = csvFile;
	}

}
