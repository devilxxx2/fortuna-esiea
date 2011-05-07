package fr.fortuna.dao;

import java.io.File;
import fr.fortuna.Tirage.*;
import java.util.List;

import fr.fortuna.Tirage.Tirage;

public class Test1 {
	public static void main(String[] args)
	{
		File csv=new File("CSV Files/euromillions.csv");
		
		EuromillionsCsvTirageDAO t= new EuromillionsCsvTirageDAO(csv);
		
		Euromillions eur= new Euromillions(t.loadAllTirages());
		
		System.out.println(eur.getTirages().get(0).getNombreDeGagnantsTotalFrance());

	}
}
