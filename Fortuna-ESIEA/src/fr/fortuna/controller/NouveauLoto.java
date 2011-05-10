package fr.fortuna.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

public class NouveauLoto /* implements Jeu*/{
	private List<TirageNouveauLoto> tirages;
	
	public NouveauLoto(List<TirageNouveauLoto> t){
		tirages=t;
	}
	
	public List<TirageNouveauLoto> getTirages()
	{
		return tirages;
	}
	
	private NouveauLoto(){}
	
	/*
	 * Recherche dans les anciens tirages les resultats d'une grille
	 * 
	 * @return ArrayList de Resultat, contenant le rang et les gains
	 */
	public ArrayList<Resultat> rechercheAncienResultat(Grille g) {
		ArrayList<Resultat> retour = new ArrayList<Resultat>();	//ArrayList contenant les résultats
		GrilleNouveauLoto grille = (GrilleNouveauLoto) g;	//cast en Grille NouveauLoto
		Resultat resultat;
		TirageNouveauLoto tirage;
		int rang = 0;
		double gain = 0;
		Iterator it = tirages.iterator();
		
		while(it.hasNext()) {
			tirage = (TirageNouveauLoto)it.next();
			rang = this.calculRang(grille, tirage);
			if (rang != 0) {
				gain = tirage.getRapportRang()[rang-1];
				resultat = new Resultat(tirage, grille, rang, gain);
				retour.add(resultat);
			}
		}
		return retour;		
	}
	
	/*
	 * Calcule le rang d'une grille pour un tirage
	 * 
	 * @return le rang
	 */
	private int calculRang(Grille g, Tirage t) {
		GrilleNouveauLoto grille = (GrilleNouveauLoto) g;	//cast en GrilleNouveauLoto
		TirageNouveauLoto tirage = (TirageNouveauLoto) t; //cast en TirageNouveauLoto
		int[] numsGrille = grille.getNums();
		int[] chanceGrille = grille.getChance();
		int[] numsTirage = tirage.getBoules();
		int chanceTirage = tirage.getNumeroChance();
		
		int numMatch = 0;	//Le nombre de numéro gagnant
		boolean numeroChanceObtenu = false;	//Numéro chance obtenu ou non
		int i, j;	//Variable de boucle
		
		//Calcul du nombre d'occurence de numéro
		for (i = 0; i < numsGrille.length; i++) {
			for (j = 0; j < numsTirage.length; j++) {
				if (numsGrille[i] == numsTirage[j]) {
					numMatch++;
				}
			}
		}
		
		//Verification du numéro chance
		for (i = 0; i < chanceGrille.length; i++) {
			if(chanceGrille[i] == chanceTirage) {
				numeroChanceObtenu = true;
			}
		}
		
		//retourne le rang selon le nombre de numéro, et si il y a le numéro chance ou non
		switch(numMatch) {
			case 5:
				if(numeroChanceObtenu) {
					return 1;
				}
				else {
					return 2;
				}
				
			case 4:
				return 3;
				
			case 3:
				return 4;
				
			case 2:
				return 5;
				
			case 0:
				if(numeroChanceObtenu) {
					return 6;
				}
			break;
		}
		return 0; //perdu
	}
	
	/*
	 * Calcule les statistiques sur les boules et des numéros chance du Nouveau Loto
	 * 
	 * @return liste de map avec les statistiques  des boules et des numéros chance
	 */
	public ArrayList<HashMap<Integer, Double>> calculStatJeu() {
		ArrayList<HashMap<Integer, Double>> resultat = new ArrayList<HashMap<Integer, Double>>();	//le retour
		HashMap<Integer, Double> mapBoule = new HashMap<Integer, Double>(49);	//Map des boules, qui sera rajouté dans l'ArrayList
		HashMap<Integer, Double> mapNumeroChance = new HashMap<Integer, Double>(10);	//Pareil pour les numéros chance
		int[] nbBouleTiree = new int[50];
		int[] nbNumeroChanceTiree = new int[11];
		int nbTirage = 0;
		int boule = 0;
		int numeroChance = 0;
		double stat;	//Statistique calculée
		int i, j;	//Parcours de boucle
		TirageNouveauLoto tirageEnCours; //Sauvegarde du tirage dans la boucle
		
		Iterator it = tirages.iterator();
		//On parcourt l'ensemble des tirages
		while (it.hasNext()) {
			tirageEnCours = (TirageNouveauLoto) it.next();
			//Cas des boules
			for (i = 0; i < 5; i++) {
				boule = tirageEnCours.getBoules()[i];
				nbBouleTiree[boule]++; 
			}
			//Cas des numéros chances
			numeroChance = tirageEnCours.getNumeroChance();
			nbNumeroChanceTiree[numeroChance]++;
			nbTirage++;
		}
		//Calcul les stats pour les boules
		for (i = 1; i < nbBouleTiree.length; i++) {
			stat = nbBouleTiree[i] / nbTirage;
			mapBoule.put(i, stat);
		}
		
		//Calcul les stats pour les numéros chance
		for (j = 1; j < nbNumeroChanceTiree.length; j++) {
			stat = nbNumeroChanceTiree[j] / nbTirage;
			mapNumeroChance.put(j, stat);
		}
		resultat.add(mapBoule);
		resultat.add(mapNumeroChance);
		return resultat;
	}
	
	/*
	 * Calcule les statistiques sur les gagnants du nouveau loto
	 * 
	 * @return une map contenant les tirages, et les statistiques des gagnants pour chaque rang
	 */
	public HashMap<TirageNouveauLoto, HashMap<Integer, Double>> calculStatGagnant() {
		HashMap<TirageNouveauLoto, HashMap<Integer, Double>> retour = new HashMap<TirageNouveauLoto, HashMap<Integer, Double>>();	//Map retournée
		HashMap<Integer, Double> statistiqueRang = new HashMap<Integer, Double>();	//Stock les statistiques pour chaque rang d'un tirage
		int[] nombreDeGagnantsRg;	//nombre de gagnant en Europe pour un tirage
		int i;	//variable de boucle 
		double stat; //statistique calculée
		TirageNouveauLoto tirageEnCours;
		Iterator it = tirages.iterator();
		
		//On parcourt l'ensemble des tirages
		while(it.hasNext()) {
			tirageEnCours = (TirageNouveauLoto) it.next();
			nombreDeGagnantsRg = tirageEnCours.getNombreDeGagnantsRg();
			for (i = 0; i < nombreDeGagnantsRg.length; i++) {
				stat = nombreDeGagnantsRg[i] / tirageEnCours.getNombreDeGagnantsTotal();
				statistiqueRang.put(i+1, stat);
			}
			retour.put(tirageEnCours, statistiqueRang); 				
		}
		
		return retour;
	}
	
	/*
	 * Calcule les statistiques sur les gains du nouveau loto
	 * 
	 * @return une map contenant les tirages, et les statistiques des gains pour chaque rang
	 */
	public HashMap<TirageNouveauLoto, HashMap<Integer, Double>> calculStatGain() {
		HashMap<TirageNouveauLoto, HashMap<Integer, Double>> retour = new HashMap<TirageNouveauLoto, HashMap<Integer, Double>>();	//Map retournée
		HashMap<Integer, Double> statistiqueRang = new HashMap<Integer, Double>();	//Stock les statistiques pour chaque rang d'un tirage
		double[] tableauGain;
		int i;	//variable de boucle
		double stat; 	//statistique calculée
		TirageNouveauLoto tirageEnCours;
		Iterator it = tirages.iterator();
		
		//On parcourt l'ensemble des tirages
		while(it.hasNext()) {
			tirageEnCours = (TirageNouveauLoto) it.next();
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
