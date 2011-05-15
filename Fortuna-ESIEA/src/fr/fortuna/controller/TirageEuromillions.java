package fr.fortuna.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

public class TirageEuromillions implements Tirage {

	private String numeroDeTirage;
	private String jour;
	private String dateTirage;
	private String dateForclusion;
	private int[] boules;
	private int[] etoiles;
	private int[] nombreDeGagnantsRgEurope;
	private int[] nombreDeGagnantsRgFrance;
	private double[] rapportRang;
	private String numeroJokerPlus;
	private String devise;
	private int nombreDeGagnantsTotalFrance;
	private int nombreDeGagnantsTotalEurope;
	private double gainTotalFrance;
	private double gainTotalEurope;
	private double[] gainParRgFrance;
	private double[] gainParRgEurope;

	public TirageEuromillions()
	{
		boules=new int[5];
		etoiles=new int[2];
		nombreDeGagnantsRgEurope=new int[12];
		nombreDeGagnantsRgFrance=new int[12];
		rapportRang=new double[12];		
		gainParRgEurope=new double[12];
		gainParRgFrance=new double[12];
	}

	/*
	 * Calcule le rang et le gain pour une grille donnée
	 * 
	 * @return resultat du tirage pour la grille
	 */
	public Resultat getResult(Grille g){
		GrilleEuroMillions grille = (GrilleEuroMillions) g;
		int[] numsGrille = grille.getNums();
		int[] starsGrille = grille.getStars();
		int numMatch = 0;	//Le nombre de numéro gagnant
		int starsMatch = 0;	//Le nombre d'étoile gagnant
		int i, j;	//Variable de boucle
		
		//Calcul du nombre d'occurence de numéro
		for (i = 0; i < numsGrille.length; i++) {
			for (j = 0; j < boules.length; j++) {
				if (numsGrille[i] == boules[j]) {
					numMatch++;
				}
			}
		}
		
		//Calcul du nombre d'occurence d'étoile
		for (i = 0; i < starsGrille.length; i++) {
			for (j = 0; j < etoiles.length; j++) {
				if(starsGrille[i] == etoiles[j]) {
					starsMatch++;
				}
			}
		}
		
		//Retourne le resultat selon le nombre de numéro et d'étoile
		switch(numMatch) {
			case 5:
				switch(starsMatch) {
					case 2:
						return new Resultat(this, grille, 1, rapportRang[0]);
					case 1:
						return new Resultat(this, grille, 2, rapportRang[1]);
					case 0:
						return new Resultat(this, grille, 3, rapportRang[2]);
				}
				break;
				
			case 4:
				switch(starsMatch) {
					case 2:
						return new Resultat(this, grille, 4, rapportRang[3]);
					case 1:
						return new Resultat(this, grille, 5, rapportRang[4]);
					case 0:
						return new Resultat(this, grille, 6, rapportRang[5]);
				}
				break;
				
			case 3:
				switch(starsMatch) {
					case 2:
						return new Resultat(this, grille, 7, rapportRang[6]);
					case 1:
						return new Resultat(this, grille, 8, rapportRang[7]);
					case 0:
						return new Resultat(this, grille, 10, rapportRang[9]);
				}
				break;
			case 2:
				switch(starsMatch) {
					case 2:
						return new Resultat(this, grille, 9, rapportRang[8]);
					case 1:
						return new Resultat(this, grille, 12, rapportRang[11]);
				}
				break;
			case 1:
				switch(starsMatch) {
					case 2:
						return new Resultat(this, grille, 11, rapportRang[10]);
				}
		}
		return new Resultat(this, grille, 0, 0);	//Perdu
	}
	
	/*
	 * Permet de jouer une partie d'Euromillions
	 * 
	 * @return les résultats du tirage
	 */
	public ArrayList<Resultat> jouer(List<Grille> g) {
		ArrayList<Resultat> retour = new ArrayList<Resultat>();
		Resultat resultat;

		for (Grille grille : g) {
			if (!(grille instanceof GrilleEuroMillions))
				throw new IllegalArgumentException("GrilleEuroMillions attendue");
			resultat = this.getResult((GrilleEuroMillions)grille);
			retour.add(resultat);
		}
		return retour;
	}
	
	/*
	 * Génère un tirage aléatoire
	 * 
	 */
	public void generate() {
		ArrayList<Integer> boulesTombees = new ArrayList<Integer>();
		ArrayList<Integer> etoilesTombees = new ArrayList<Integer>();
		Random random = new Random();
		int boule;
		boolean ok;	//au cas où la boule retombe dans la boucle
		
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
		//initialisation des gains
		double[] tableauGain = new double[rapportRang.length];
		double gain;
		double[] maximumGain = new double[] { 180000000, 9999999, 1500000, 40000, 443, 350, 200, 60, 40, 30, 16, 13};
		double[] minimumGain = new double[] { 15000000, 300000, 150000, 13000, 300, 210, 113, 30, 20, 18, 9, 8.10};
		for (int i = 0; i < tableauGain.length; i++) {
			do {
				gain = random.nextDouble() * maximumGain[i];
			}
			while (gain < minimumGain[i]);
			gain = (10d*gain);
			gain = Math.round(gain)/10d;
			tableauGain[i] = gain;
		}
		rapportRang = tableauGain;	
	}
	
	/*
	 * Calcule les statistiques sur les gagnants de l'euromillions en Europe pour le tirage
	 * 
	 * @return map contenant les statistiques pour chaque rang
	 */
	public HashMap<Integer, Double> calculStatGagnantEurope() {
		HashMap<Integer, Double> retour = new HashMap<Integer, Double>();
		int i;	//variable de boucle
		double stat;
		for (i = 0; i < nombreDeGagnantsRgEurope.length; i++) {
			stat = (double)nombreDeGagnantsRgEurope[i] / nombreDeGagnantsTotalEurope;
			retour.put(i+1, stat);
		}
		return retour;		
	}
	
	/*
	 * Calcule les statistiques sur les gagnants de l'euromillions en France pour le tirage
	 * 
	 * @return map contenant les statistiques pour chaque rang
	 */
	
	public HashMap<Integer, Double> calculStatGagnantFrance() {
		HashMap<Integer, Double> retour = new HashMap<Integer, Double>();
		int i;	//variable de boucle
		double stat;
		for (i = 0; i < nombreDeGagnantsRgFrance.length; i++) {
			stat = (double)nombreDeGagnantsRgFrance[i] / nombreDeGagnantsTotalFrance;
			retour.put(i+1, stat);
		}
		return retour;		
	}
	
	/*
	 * Calcule les statistiques sur les gains de l'euromillions en Europe pour le tirage
	 * 
	 * @return map contenant les statistiques pour chaque rang
	 */
	public HashMap<Integer, Double> calculStatGainEurope() {
		HashMap<Integer, Double> retour = new HashMap<Integer, Double>();
		int i;	//variable de boucle
		double stat;
		for (i = 0; i < gainParRgEurope.length; i++) {
			stat = (double)gainParRgEurope[i] / gainTotalEurope;
			retour.put(i+1, stat);
		}
		return retour;		
	}
	
	/*
	 * Calcule les statistiques sur les gains de l'euromillions en France pour le tirage
	 * 
	 * @return map contenant les statistiques pour chaque rang
	 */
	public HashMap<Integer, Double> calculStatGainFrance() {
		HashMap<Integer, Double> retour = new HashMap<Integer, Double>();
		int i;	//variable de boucle
		double stat;
		for (i = 0; i < gainParRgFrance.length; i++) {
			stat = (double)gainParRgFrance[i] / gainTotalFrance;
			retour.put(i+1, stat);
		}
		return retour;		
	}
	
	
	
	public int[] getBoulesCroissantes()
	{
		int[] tmp=boules;
		Arrays.sort(tmp);
		return tmp;
	}
	
	public String getBoulesStr() {
		String boules = "";
		for(int i = 0; i < this.boules.length; i++)
			if (i == this.boules.length-1)
				boules += this.boules[i];
			else
				boules += this.boules[i] + " - ";
		return boules;
	}

	public int[] getEtoilesCroissantes()
	{
		int[] tmp=etoiles;
		Arrays.sort(tmp);
		return tmp;
	}

	public String getEtoilesStr(){
		String etoiles="";
		for(int i = 0; i < this.etoiles.length; i++)
			if (i == this.etoiles.length-1)
				etoiles += this.etoiles[i];
			else
				etoiles += this.etoiles[i] + " - ";
		return etoiles;
	}

	public String toString() {
		return getBoulesStr() + " ~ [" + getEtoilesStr() + "]";
	}

	public void setNumeroDeTirage(String numeroDeTirage) {
		this.numeroDeTirage = numeroDeTirage;
	}

	public String getNumeroDeTirage() {
		return numeroDeTirage;
	}

	public void setJour(String jour) {
		this.jour = jour;
	}

	public String getJour() {
		return jour;
	}

	public void setRapportRang(double[] rapportRang) {
		this.rapportRang = rapportRang;
	}

	public double[] getRapportRang() {
		return rapportRang;
	}

	public void setDevise(String devise) {
		this.devise = devise;
	}

	public String getDevise() {
		return devise;
	}

	public void setNumeroJokerPlus(String numeroJokerPlus) {
		this.numeroJokerPlus = numeroJokerPlus;
	}

	public String getNumeroJokerPlus() {
		return numeroJokerPlus;
	}

	public void setNombreDeGagnantsRgFrance(int[] nombreDeGagnantsRgFrance) {
		this.nombreDeGagnantsRgFrance = nombreDeGagnantsRgFrance;
	}

	public int[] getNombreDeGagnantsRgFrance() {
		return nombreDeGagnantsRgFrance;
	}

	public void setNombreDeGagnantsRgEurope(int[] nombreDeGagnantsRgEurope) {
		this.nombreDeGagnantsRgEurope = nombreDeGagnantsRgEurope;
	}

	public int[] getNombreDeGagnantsRgEurope() {
		return nombreDeGagnantsRgEurope;
	}

	public void setDateForclusion(String dateForclusion) {
		this.dateForclusion = dateForclusion;
	}

	public String getDateForclusion() {
		return dateForclusion;
	}

	public void setDateTirage(String dateTirage) {
		this.dateTirage = dateTirage;
	}

	public String getDateTirage() {
		return dateTirage;
	}

	public void setBoules(int[] boules) {
		this.boules = boules;
	}

	public int[] getBoules() {
		return boules;
	}

	public void setEtoiles(int[] etoiles) {
		this.etoiles = etoiles;
	}

	public int[] getEtoiles() {
		return etoiles;
	}

	public double getGainTotalFrance() {
		return gainTotalFrance;
	}

	public double getGainTotalEurope() {
		return gainTotalEurope;
	}

	public int getNombreDeGagnantsTotalFrance() {
		return nombreDeGagnantsTotalFrance;
	}

	public int getNombreDeGagnantsTotalEurope() {
		return nombreDeGagnantsTotalEurope;
	}
	/*
	 *  Calcule le nombre de gagnants total en france
	 */
	public void calcNombreDeGagnantsFrance() {
		for(int NombreDeGagnants : nombreDeGagnantsRgFrance)
			nombreDeGagnantsTotalFrance+=NombreDeGagnants;
	}

	/*
	 *  Calcule le nombre de gagnants total en Europe
	 */
	public void calcNombreDeGagnantsEurope() {
		for(int NombreDeGagnants : nombreDeGagnantsRgEurope)
			nombreDeGagnantsTotalEurope+=NombreDeGagnants;
	}

	/*
	 *  Calcule le gain total en france
	 */
	public void calcGainFrance() {
		for(int i=0;i<nombreDeGagnantsRgFrance.length;i++)
			gainTotalFrance+=rapportRang[i]*nombreDeGagnantsRgFrance[i];
	}

	/*
	 *  Calcule le gain total en Europe
	 */
	public void calcGainEurope() {
		for(int i=0;i<nombreDeGagnantsRgEurope.length;i++)
			gainTotalEurope+=rapportRang[i]*nombreDeGagnantsRgEurope[i];
	}

	/*
	 *  Calcule le gain par rang en france
	 */
	public void calcGainParRgFrance() {
		for(int i=0;i<nombreDeGagnantsRgFrance.length;i++)
			gainParRgFrance[i]=rapportRang[i]*nombreDeGagnantsRgFrance[i];
	}

	/*
	 *  Calcule le gain par rang en Europe
	 */
	public void calcGainParRgEurope() {
		for(int i=0;i<nombreDeGagnantsRgEurope.length;i++)
			gainParRgEurope[i]=rapportRang[i]*nombreDeGagnantsRgEurope[i];
	}

	public double[] getGainParRgFrance() {
		return gainParRgFrance;
	}


	public double[] getGainParRgEurope() {
		return gainParRgEurope;
	}

	public boolean equals(TirageEuromillions t)
	{
		return ((t.getNumeroDeTirage().compareTo(numeroDeTirage))==0);
	}

}
