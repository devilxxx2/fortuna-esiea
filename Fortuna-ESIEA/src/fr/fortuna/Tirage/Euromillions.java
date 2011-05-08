package fr.fortuna.Tirage;

import java.util.Iterator;
import java.util.List;
import java.util.HashMap;
import java.util.ArrayList;


public class Euromillions/* implements Jeu*/ {
	private List<TirageEuromillions> tirages;
	
	public Euromillions(List<TirageEuromillions> t){
		tirages=t;
	}
	
	public List<TirageEuromillions> getTirages()
	{
		return tirages;
	}
	
	private Euromillions(){}

	/*	@Override
	public void jouer(Grille g) {
		// TODO Auto-generated method stub
		
	}*/
	
	/*
	 * Calcule les statistiques sur les boules et étoiles d'euromillions
	 * 
	 * @return liste de map avec les statistiques  des boules et des étoiles
	 */
	public ArrayList<HashMap<Integer, Double>> calculStatJeu() {
		ArrayList<HashMap<Integer, Double>> resultat = new ArrayList<HashMap<Integer, Double>>();	//le retour
		HashMap<Integer, Double> mapBoule = new HashMap<Integer, Double>(50);	//Map des boules, qui sera rajouté dans l'ArrayList
		HashMap<Integer, Double> mapEtoile = new HashMap<Integer, Double>(9);	//Pareil pour les étoiles
		int[] nbBouleTiree = new int[51];
		int[] nbEtoileTiree = new int[10];
		int nbTirage = 0;
		int boule = 0;
		int etoile = 0;
		double stat;	//Statistique calculée
		int i, j;	//Parcours de boucle
		TirageEuromillions tirageEnCours; //Sauvegarde du tirage dans la boucle
		
		Iterator it = tirages.iterator();
		//On parcourt l'ensemble des tirages
		while (it.hasNext()) {
			tirageEnCours = (TirageEuromillions) it.next();
			//Cas des boules
			for (i = 0; i < 5; i++) {
				boule = tirageEnCours.getBoules()[i];
				nbBouleTiree[boule]++; 
			}
			//Cas des étoiles
			for ( j = 0; j < 2; j++) {
				etoile = tirageEnCours.getEtoiles()[j];
				nbEtoileTiree[etoile]++;
			}
			nbTirage++;
		}
		//Calcul les stats pour les boules
		for (i = 1; i < nbBouleTiree.length; i++) {
			stat = nbBouleTiree[i] / nbTirage;
			mapBoule.put(i, stat);
		}
		
		//Calcul les stats pour les étoiles
		for (j = 1; j < nbEtoileTiree.length; j++) {
			stat = nbEtoileTiree[j] / nbTirage;
			mapEtoile.put(j, stat);
		}
		resultat.add(mapBoule);
		resultat.add(mapEtoile);
		return resultat;
	}
	
	/*
	 * Calcule les statistiques sur les gagnants de l'euromillions en Europe
	 * 
	 * @return une map contenant les tirages, et les statistiques des gagnants pour chaque rang en Europe
	 */
	public HashMap<TirageEuromillions, HashMap<Integer, Double>> calculStatGagnantEurope() {
		HashMap<TirageEuromillions, HashMap<Integer, Double>> retour = new HashMap<TirageEuromillions, HashMap<Integer, Double>>();	//Map retournée
		HashMap<Integer, Double> statistiqueRang = new HashMap<Integer, Double>();	//Stock les statistiques pour chaque rang d'un tirage
		int[] nombreDeGagnantsRgEurope;	//nombre de gagnant en Europe pour un tirage
		int i;	//variable de boucle 
		double stat; //statistique calculée
		TirageEuromillions tirageEnCours;
		Iterator it = tirages.iterator();
		
		//On parcourt l'ensemble des tirages
		while(it.hasNext()) {
			tirageEnCours = (TirageEuromillions) it.next();
			nombreDeGagnantsRgEurope = tirageEnCours.getNombreDeGagnantsRgEurope();
			for (i = 0; i < nombreDeGagnantsRgEurope.length; i++) {
				stat = nombreDeGagnantsRgEurope[i] / tirageEnCours.getNombreDeGagnantsTotalEurope();
				statistiqueRang.put(i+1, stat);
			}
			retour.put(tirageEnCours, statistiqueRang); 				
		}
		
		return retour;
	}
	
	/*
	 * Calcule les statistiques sur les gagnants de l'euromillions en France
	 * 
	 *  @return une map contenant les tirages, et les statistiques des gagnants pour chaque rang en France
	 */
	public HashMap<TirageEuromillions, HashMap<Integer, Double>> calculStatGagnantFrance() {
		HashMap<TirageEuromillions, HashMap<Integer, Double>> retour = new HashMap<TirageEuromillions, HashMap<Integer, Double>>();	//Map retournée
		HashMap<Integer, Double> statistiqueRang = new HashMap<Integer, Double>();	//Stock les statistiques pour chaque rang d'un tirage
		int[] nombreDeGagnantsRgFrance;	//nombre de gagnant en France pour un tirage
		int i;	//variable de boucle 
		double stat; //statistique calculée
		TirageEuromillions tirageEnCours;
		Iterator it = tirages.iterator();
		
		//On parcourt l'ensemble des tirages
		while(it.hasNext()) {
			tirageEnCours = (TirageEuromillions) it.next();
			nombreDeGagnantsRgFrance = tirageEnCours.getNombreDeGagnantsRgFrance();
			for (i = 0; i < nombreDeGagnantsRgFrance.length; i++) {
				stat = nombreDeGagnantsRgFrance[i] / tirageEnCours.getNombreDeGagnantsTotalFrance();
				statistiqueRang.put(i+1, stat);
			}
			retour.put(tirageEnCours, statistiqueRang); 				
		}
		
		return retour;
	}
	
	/*
	 * Calcule les statistiques sur les gains de l'euromillions en Europe
	 * 
	 * @return une map contenant les tirages, et les statistiques des gains pour chaque rang en Europe
	 */
	public HashMap<TirageEuromillions, HashMap<Integer, Double>> calculStatGainEurope() {
		HashMap<TirageEuromillions, HashMap<Integer, Double>> retour = new HashMap<TirageEuromillions, HashMap<Integer, Double>>();	//Map retournée
		HashMap<Integer, Double> statistiqueRang = new HashMap<Integer, Double>();	//Stock les statistiques pour chaque rang d'un tirage
		double[] tableauGain;
		int i;	//variable de boucle
		double stat; 	//statistique calculée
		TirageEuromillions tirageEnCours;
		Iterator it = tirages.iterator();
		
		//On parcourt l'ensemble des tirages
		while(it.hasNext()) {
			tirageEnCours = (TirageEuromillions) it.next();
			tableauGain = tirageEnCours.getGainParRgEurope();
			for (i = 0; i < tableauGain.length; i++) {
				stat = tableauGain[i] / tirageEnCours.getGainTotalEurope();
				statistiqueRang.put(i+1, stat);
			}
			retour.put(tirageEnCours, statistiqueRang);
		}
		return retour;
	}
	
	/*
	 * Calcule les statistiques sur les gains de l'euromillions en France
	 * 
	 * @return une map contenant les tirages, et les statistiques des gains pour chaque rang en France
	 */
	public HashMap<TirageEuromillions, HashMap<Integer, Double>> calculStatGainFrance() {
		HashMap<TirageEuromillions, HashMap<Integer, Double>> retour = new HashMap<TirageEuromillions, HashMap<Integer, Double>>();	//Map retournée
		HashMap<Integer, Double> statistiqueRang = new HashMap<Integer, Double>();	//Stock les statistiques pour chaque rang d'un tirage
		double[] tableauGain;
		int i;	//variable de boucle
		double stat; 	//statistique calculée
		TirageEuromillions tirageEnCours;
		Iterator it = tirages.iterator();
		
		//On parcourt l'ensemble des tirages
		while(it.hasNext()) {
			tirageEnCours = (TirageEuromillions) it.next();
			tableauGain = tirageEnCours.getGainParRgFrance();
			for (i = 0; i < tableauGain.length; i++) {
				stat = tableauGain[i] / tirageEnCours.getGainTotalFrance();
				statistiqueRang.put(i+1, stat);
			}
			retour.put(tirageEnCours, statistiqueRang);
		}
		return retour;
	}
}

