package fr.fortuna.dao;

import java.io.File;
import java.util.List;

import fr.fortuna.Tirage.Tirage;

public class Test1 {
	public static void main(String[] args)
	{
		File csv=new File("CSV Files/euromillions.csv");
		
		CsvTirageDAO t= new CsvTirageDAO(csv);
		
		String h="boule_1";
		String v="22";
		
		List<Tirage> l = t.loadTiragesByValue(h,v);
		
		System.out.println(l.get(0).getType());
		System.out.println(l.size());
	}
}
