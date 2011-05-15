package fr.fortuna.controller;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

import fr.fortuna.dao.NouveauLotoCsvTirageDAO;

public class TestStat {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		//Cas de test NouveauSuperLoto	
		
		
		File csv=new File("CSV Files/nouveau_superloto.csv");
		NouveauLotoCsvTirageDAO t= new NouveauLotoCsvTirageDAO(csv);
		NouveauLoto eur= new NouveauLoto(t.loadAllTirages());
		
		int i, j;
		
		//Test sur mes StatJeu
		/*
		ArrayList<HashMap<Integer, Double>> tableauStat = eur.calculStatJeu();
		HashMap<Integer, Double> tableauBoule;
		for (i = 0; i < tableauStat.size(); i++) {
			tableauBoule = tableauStat.get(i);
			if (i == 0) {		
				for (j = 1; j <= tableauBoule.size(); j++) {
					System.out.println("Boule Numéro " + (j) + " : " + tableauBoule.get(j));
				}
			}
			else if (i == 1) {
				for (j = 1; j <= tableauBoule.size(); j++) {
					System.out.println("Numero Chance Numéro " + (j) + " : " + tableauBoule.get(j));
				}
			}
		}
		*/
		
		/*
		//Test sur les Stat des gagnants
		HashMap<TirageNouveauSuperLoto, HashMap<Integer, Double>> mapStatGagnant = eur.calculStatGagnant();
		HashMap<Integer, Double> mapStatGagnantTirage;
		for (TirageNouveauSuperLoto mapKey : mapStatGagnant.keySet()) {
			mapStatGagnantTirage = mapStatGagnant.get(mapKey);
			System.out.println("Tirage du " + mapKey.getDateTirage());
			for (i = 1; i <= mapStatGagnantTirage.size(); i++) {
				System.out.println("Stat au rang " + i + " : " + mapStatGagnantTirage.get(i));
			}
		}
		*/
		
		/*
		//Test sur les Stat des gains
		HashMap<TirageNouveauSuperLoto, HashMap<Integer, Double>> mapStatGain = eur.calculStatGain();
		HashMap<Integer, Double> mapStatGainTirage;
		for (TirageNouveauSuperLoto mapKey : mapStatGain.keySet()) {
			mapStatGainTirage = mapStatGain.get(mapKey);
			System.out.println("Tirage du " + mapKey.getDateTirage());
			for (i = 1; i <= mapStatGainTirage.size(); i++) {
				System.out.println("Stat au rang " + i + " : " + mapStatGainTirage.get(i));
			}
		}
		*/
		
		
		
		TirageEuromillions tirage=new TirageEuromillions();
		tirage.generate();
		int[] randomBoules=tirage.getBoules();
		int[] randomStars=tirage.getEtoiles();
		System.out.println("BOULE 1 : " + randomBoules[0]);
		System.out.println("BOULE 2 : " + randomBoules[1]);
		System.out.println("BOULE 3 : " + randomBoules[2]);
		System.out.println("BOULE 4 : " + randomBoules[3]);
		System.out.println("BOULE 5 : " + randomBoules[4]);
		System.out.println("ETOILE 1 : " + randomStars[0]);
		System.out.println("ETOILE 2 : " + randomStars[1]);
		
	}

}
