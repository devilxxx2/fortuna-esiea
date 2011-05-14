package fr.fortuna.controller;

import java.util.ArrayList;
import java.util.Random;

public class TestJouer {
	
	public static void main(String[] args) {
		int[] boules;
		int[] etoiles;
		ArrayList<Grille> listeGrilles = new ArrayList<Grille>();
		ArrayList<Integer> boulesTombees;
		ArrayList<Integer> etoilesTombees;
		GrilleEuroMillions grille;
		Random random = new Random();
		int boule;
		boolean ok;	//au cas où la boule retombe dans la boucle
		
		for (int k = 0; k < 5; k++) {
			boulesTombees = new ArrayList<Integer>();
			etoilesTombees = new ArrayList<Integer>();
			boules = new int[5];
			etoiles = new int[2];
			
			//Cas des boules
			for (int i = 0; i < boules.length; i++) {
				ok = false;
				while(!ok) {
					boule = random.nextInt(50) + 1;	//nombre aléatoire entre 1 et 50 
					if (!boulesTombees.contains(boule)) {
						boules[i] = boule;
						boulesTombees.add(boule);
						ok = true;
					}
				}
			}
			
			//Cas des étoiles
			for (int i = 0; i < etoiles.length; i++) {
				ok = false;
				while(!ok) {
					boule = random.nextInt(9) + 1;	//nombre aléatoire entre 1 et 9 
					if (!etoilesTombees.contains(boule)) {
						etoiles[i] = boule;
						etoilesTombees.add(boule);
						ok = true;
					}
				}
			}
			grille = new GrilleEuroMillions(boules, etoiles, k);
			listeGrilles.add(grille);
		}
		
		TirageEuromillions tirage = new TirageEuromillions();
		tirage.generate();
		ArrayList<Resultat> listResultats = tirage.jouer(listeGrilles);
		
		TirageEuromillions tirageEuromillions = (TirageEuromillions) (listResultats.get(0).getTirage());
		System.out.print("Boule : " + tirageEuromillions.getBoules()[0] + " ");
		System.out.print(tirageEuromillions.getBoules()[1] + " ");
		System.out.print(tirageEuromillions.getBoules()[2] + " ");
		System.out.print(tirageEuromillions.getBoules()[3] + " ");
		System.out.println(tirageEuromillions.getBoules()[4] + " ");
		System.out.print("Etoile : " + tirageEuromillions.getEtoiles()[0] + " ");
		System.out.println(tirageEuromillions.getEtoiles()[1] + " ");
		System.out.println();
		
		for (int l = 0; l < listResultats.size(); l++) {
			System.out.println("Resultat " + (l+1));
			Resultat resultat = listResultats.get(l);
			GrilleEuroMillions grille2 =  (GrilleEuroMillions)resultat.getGrille();
			System.out.print("Boule : " + grille2.getNums()[0] + " ");
			System.out.print(grille2.getNums()[1] + " ");
			System.out.print(grille2.getNums()[2] + " ");
			System.out.print(grille2.getNums()[3] + " ");
			System.out.println(grille2.getNums()[4] + " ");
			System.out.print("Etoile : " + grille2.getStars()[0] + " ");
			System.out.println(grille2.getStars()[1] + " ");
			System.out.println("Rang : " + resultat.getRang());
			System.out.println("Gain : " + resultat.getGain());
			System.out.println();
			
		}
	}

}
