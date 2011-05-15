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
		if (!(g instanceof GrilleNouveauLoto))
			throw new IllegalArgumentException("GrilleNouveauLoto attendue");

		ArrayList<Resultat> retour = new ArrayList<Resultat>();	//ArrayList contenant les résultats
		GrilleNouveauLoto grille = (GrilleNouveauLoto) g;	//cast en Grille NouveauLoto
		Resultat resultat;
		TirageNouveauLoto tirage;
		Iterator it = tirages.iterator();
		
		while(it.hasNext()) {
			tirage = (TirageNouveauLoto)it.next();
			resultat = tirage.getResult(grille);
			if (resultat.getRang() != 0) {
				retour.add(resultat);
			}
		}
		return retour;		
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
			stat = (double)nbBouleTiree[i] / nbTirage;
			mapBoule.put(i, stat);
		}
		
		//Calcul les stats pour les numéros chance
		for (j = 1; j < nbNumeroChanceTiree.length; j++) {
			stat = (double)nbNumeroChanceTiree[j] / nbTirage;
			mapNumeroChance.put(j, stat);
		}
		resultat.add(mapBoule);
		resultat.add(mapNumeroChance);
		return resultat;
	}
}
