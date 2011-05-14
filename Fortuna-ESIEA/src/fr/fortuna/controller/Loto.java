package fr.fortuna.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

public class Loto implements Jeu {
	private List<TirageLoto> tirages;
	
	public Loto(List<TirageLoto> t){
		tirages=t;
	}
	
	public List<TirageLoto> getTirages()
	{
		return tirages;
	}
	
	/*
	 * Recherche dans les anciens tirages les resultats d'une grille
	 * 
	 * @return ArrayList de Resultat, contenant le rang et les gains
	 */
	public ArrayList<Resultat> rechercheAncienResultat(Grille g) {
		if (!(g instanceof GrilleLoto))
			throw new IllegalArgumentException("GrilleLoto attendue");

		ArrayList<Resultat> retour = new ArrayList<Resultat>();	//ArrayList contenant les résultats
		GrilleLoto grille = (GrilleLoto) g;	//cast en Grille NouveauLoto
		Resultat resultat;
		TirageLoto tirage;
		Iterator it = tirages.iterator();
		
		while(it.hasNext()) {
			tirage = (TirageLoto)it.next();
			resultat = tirage.getResult(grille);
			if (resultat.getRang() != 0) {
				retour.add(resultat);
			}
		}
		return retour;		
	}
	
	/*
	 * Calcule les statistiques sur les boules du loto
	 * 
	 * @return liste de map avec les statistiques des boules et les numéros complémentaires
	 */
	public ArrayList<HashMap<Integer, Double>> calculStatJeu() {
		ArrayList<HashMap<Integer, Double>> resultat = new ArrayList<HashMap<Integer, Double>>();	//le retour
		HashMap<Integer, Double> mapBoule = new HashMap<Integer, Double>(49);	//Map des boules, qui sera rajouté dans l'ArrayList
		HashMap<Integer, Double> mapNumeroComplementaire = new HashMap<Integer, Double>(49);	//Pareil pour les numéros complémentaires
		int[] nbBouleTiree = new int[50];
		int[] nbComplementaireTiree = new int[50];
		int nbTirage = 0;
		int boule = 0;
		int numeroComplementaire = 0;
		double stat;	//Statistique calculée
		int i, j;	//Parcours de boucle
		TirageLoto tirageEnCours; //Sauvegarde du tirage dans la boucle
		
		Iterator it = tirages.iterator();
		//On parcourt l'ensemble des tirages
		while (it.hasNext()) {
			tirageEnCours = (TirageLoto) it.next();
			//Cas des boules
			for (i = 0; i < 6; i++) {
				boule = tirageEnCours.getBoules()[i];
				nbBouleTiree[boule]++; 
			}
			//Cas des numeros complementaires
			numeroComplementaire = tirageEnCours.getBouleComplementaire();
			nbComplementaireTiree[numeroComplementaire]++;
			nbTirage++;
		}
		//Calcul les stats pour les boules
		for (i = 1; i < nbBouleTiree.length; i++) {
			stat = (double)nbBouleTiree[i] / nbTirage;
			mapBoule.put(i, stat);
		}
		for (j = 1; j < nbComplementaireTiree.length; j++) {
			stat = (double)nbComplementaireTiree[j] / nbTirage;
			mapNumeroComplementaire.put(j, stat);
		}
		resultat.add(mapBoule);
		resultat.add(mapNumeroComplementaire);
		return resultat;
	}
	
	/*
	 * Calcule les statistiques sur les gagnants du Loto
	 * 
	 * @return une map contenant les tirages, et les statistiques des gagnants pour chaque rang
	 */
	public HashMap<TirageLoto, HashMap<Integer, Double>> calculStatGagnant() {
		HashMap<TirageLoto, HashMap<Integer, Double>> retour = new HashMap<TirageLoto, HashMap<Integer, Double>>();	//Map retournée
		HashMap<Integer, Double> statistiqueRang;	//Stock les statistiques pour chaque rang d'un tirage
		int[] nombreDeGagnantsRg;	//nombre de gagnant pour un tirage
		int i;	//variable de boucle 
		double stat; //statistique calculée
		TirageLoto tirageEnCours;
		Iterator it = tirages.iterator();
		
		//On parcourt l'ensemble des tirages
		while(it.hasNext()) {
			tirageEnCours = (TirageLoto) it.next();
			statistiqueRang = new HashMap<Integer, Double>();
			nombreDeGagnantsRg = tirageEnCours.getNombreDeGagnantsRg();
			for (i = 0; i < nombreDeGagnantsRg.length; i++) {
				stat = (double)nombreDeGagnantsRg[i] / tirageEnCours.getNombreDeGagnantsTotal();
				statistiqueRang.put(i+1, stat);
			}
			retour.put(tirageEnCours, statistiqueRang); 
		}
		return retour;
	}
	
	/*
	 * Calcule les statistiques sur les gains du Loto
	 * 
	 * @return une map contenant les tirages, et les statistiques des gains pour chaque rang
	 */
	public HashMap<TirageLoto, HashMap<Integer, Double>> calculStatGain() {
		HashMap<TirageLoto, HashMap<Integer, Double>> retour = new HashMap<TirageLoto, HashMap<Integer, Double>>();	//Map retournée
		HashMap<Integer, Double> statistiqueRang;	//Stock les statistiques pour chaque rang d'un tirage
		double[] tableauGain;
		int i;	//variable de boucle
		double stat; 	//statistique calculée
		TirageLoto tirageEnCours;
		Iterator it = tirages.iterator();
		
		//On parcourt l'ensemble des tirages
		while(it.hasNext()) {
			tirageEnCours = (TirageLoto) it.next();
			statistiqueRang = new HashMap<Integer, Double>();
			tableauGain = tirageEnCours.getGainParRg();
			for (i = 0; i < tableauGain.length; i++) {
				stat = tableauGain[i] / tirageEnCours.getGainTotal();
				statistiqueRang.put(i+1, stat);
			}
			retour.put(tirageEnCours, statistiqueRang);
		}
		return retour;
	}
}
