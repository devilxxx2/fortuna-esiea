package fr.fortuna.dao;

import java.io.File;
import java.util.List;

import fr.fortuna.Tirage.Tirage;

public class Test1 {
	public static void main(String[] args)
	{
		CsvTirageDAO t= new CsvTirageDAO();
		
		File csv=new File("D:\\Projet JAVA\\Fortuna-ESIEA\\CSV Files\\euromillions.csv");
		
		t.setCsvFile(csv);
		
		List<Tirage> l = t.loadAllTirages();
		
		System.out.println(l.get(0));
	}
}
