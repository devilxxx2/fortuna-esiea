package fr.fortuna.dao;

import java.io.File;
import fr.fortuna.controller.*;
import java.util.List;

public class Test1 {
	public static void main(String[] args)
	{
		File csv=new File("CSV Files/nouveau_superloto.csv");
		
		NouveauLotoCsvTirageDAO t= new NouveauLotoCsvTirageDAO(csv);
		
		NouveauLoto eur= new NouveauLoto(t.loadAllTirages());
		
		System.out.println(eur.getTirages().get(0).getGainParRg()[0]);

	}
}
