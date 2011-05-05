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
	 * @return liste avec les statistiques 
	 */
	public ArrayList<HashMap<Integer, Double>> calculStatEuromillions() {
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
}


