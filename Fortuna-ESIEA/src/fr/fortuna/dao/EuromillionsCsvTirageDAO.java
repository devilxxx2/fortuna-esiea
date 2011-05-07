package fr.fortuna.dao;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import fr.fortuna.Tirage.*;

public class EuromillionsCsvTirageDAO extends CsvTirageDAO {

	public EuromillionsCsvTirageDAO(File f) {
		super(f);
	}

	//@Override
	protected TirageEuromillions lineToTirage(String line) {
		String[] values = line.split(";");

		TirageEuromillions t=new TirageEuromillions();
		
		t.setNumeroDeTirage(values[0]);
		t.setJour(values[1]);
		t.setDateTirage(values[2]);
		t.setDateForclusion(values[3]);
		
		int[] boules=new int[5];
		int i=0;
		for(;i<5;i++)
			boules[i]=Integer.valueOf(values[4+i]);
		
		t.setBoules(boules);
		
		int[] etoiles=new int[2];
		etoiles[0]=Integer.valueOf(values[4+i]);
		etoiles[1]=Integer.valueOf(values[5+i]);
		t.setEtoiles(etoiles);
		
		int j=0;
		int[] nbGagEur=new int[12];
		int[] nbGagFr=new int[12];
		double[] Rap=new double[12];
		for(;j<36;j+=3)
		{
			nbGagFr[j/3]=Integer.valueOf(values[8+i+j]);
			nbGagEur[j/3]=Integer.valueOf(values[8+i+j+1]);
			Rap[j/3]=Double.valueOf(values[8+i+j+2].replace(',', '.'));
		}
		t.setNombreDeGagnantsRgFrance(nbGagFr);
		t.setNombreDeGagnantsRgEurope(nbGagEur);
		t.setRapportRang(Rap);

		t.setNumeroJokerPlus(values[8+i+j]);
		t.setDevise(values[8+i+j+1]);

		t.calcNombreDeGagnantsEurope();
		t.calcNombreDeGagnantsFrance();
		t.calcGainEurope();
		t.calcGainFrance();
		t.calcGainParRgEurope();
		t.calcGainParRgFrance();
		
		return t;
	}

	public List<TirageEuromillions> loadAllTirages() {
		if(csvFile.exists()){
			final List<TirageEuromillions> tirages = new ArrayList<TirageEuromillions>();
	
			List<String> lines = readAllLines();
	
			for (String line : lines) {
				TirageEuromillions tirage = lineToTirage(line);
				tirages.add(tirage);
			}
			return tirages;
		}
		else
		{
			return null;
		}
	}

}
