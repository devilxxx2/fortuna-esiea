package fr.fortuna.dao;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import fr.fortuna.controller.*;

public class NouveauLotoCsvTirageDAO extends CsvTirageDAO {

	public NouveauLotoCsvTirageDAO(File f) {
		super(f);
	}

	//@Override
	protected TirageNouveauLoto lineToTirage(String line) {
		String[] values = line.split(";");

		TirageNouveauLoto t=new TirageNouveauLoto();
		
		t.setNumeroDeTirage(values[0]);
		t.setJour(values[1]);
		t.setDateTirage(values[2]);
		t.setDateForclusion(values[3]);
		
		int[] boules=new int[5];
		int i=0;
		for(;i<5;i++)
			boules[i]=Integer.valueOf(values[4+i]);
		
		t.setBoules(boules);
		t.setNumeroChance(Integer.valueOf(values[4+i]));
		int j=0;
		int[] nbGag=new int[6];
		double[] Rap=new double[6];
		for(;j<12;j+=2)
		{
			nbGag[j/2]=Integer.valueOf(values[6+i+j]);
			Rap[j/2]=Double.valueOf(values[6+i+j+1].replace(',', '.'));
		}
		t.setNombreDeGagnantsRg(nbGag);
		t.setRapportRang(Rap);

		t.setNumeroJokerPlus(values[6+i+j]);
		t.setDevise(values[6+i+j+1]);

		t.calcNombreDeGagnants();
		t.calcGain();
		t.calcGainParRg();
		
		return t;
	}

	public List<TirageNouveauLoto> loadAllTirages() {
		if(csvFile.exists()){
			final List<TirageNouveauLoto> tirages = new ArrayList<TirageNouveauLoto>();
	
			List<String> lines = readAllLines();
	
			for (String line : lines) {
				TirageNouveauLoto tirage = lineToTirage(line);
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
