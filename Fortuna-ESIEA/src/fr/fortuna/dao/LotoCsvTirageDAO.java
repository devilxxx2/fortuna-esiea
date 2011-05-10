package fr.fortuna.dao;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import fr.fortuna.controller.*;

public class LotoCsvTirageDAO extends CsvTirageDAO {

	public LotoCsvTirageDAO(File f) {
		super(f);
	}

	//@Override
	protected TirageLoto lineToTirage(String line) {
		String[] values = line.split(";");

		TirageLoto t=new TirageLoto();
		
		t.setNumeroDeTirage(values[0]);
		t.setOrdreDeTirage(Integer.valueOf(values[1]));
		t.setJour(values[2]);
		t.setDateTirage(values[3]);
		t.setDateForclusion(values[4]);
		
		int[] boules=new int[6];
		int i=0;
		for(;i<6;i++)
			boules[i]=Integer.valueOf(values[5+i]);
		
		t.setBoules(boules);
		t.setBouleComplementaire(Integer.valueOf(values[5+i]));
		t.setNumeroJoker(values[7+i]);
		int j=0;
		int[] nbGag=new int[7];
		double[] Rap=new double[7];
		for(;j<14;j+=2)
		{
			nbGag[j/2]=Integer.valueOf(values[8+i+j]);
			Rap[j/2]=Double.valueOf(values[8+i+j+1].replace(',', '.'));
		}
		t.setNombreDeGagnantsRg(nbGag);
		t.setRapportRang(Rap);

		t.setNumeroJokerPlus(values[8+i+j]);
		t.setDevise(values[8+i+j+1]);

		t.calcNombreDeGagnants();
		t.calcGain();
		t.calcGainParRg();
		
		return t;
	}

	public List<TirageLoto> loadAllTirages() {
		if(csvFile.exists()){
			final List<TirageLoto> tirages = new ArrayList<TirageLoto>();
	
			List<String> lines = readAllLines();
	
			for (String line : lines) {
				TirageLoto tirage = lineToTirage(line);
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
