package fr.fortuna.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;
import java.util.List;

public class TirageNouveauSuperLoto implements Tirage {
	
	private String numeroDeTirage;
	private String jour;
	private String dateTirage;
	private String dateForclusion;
	private int[] boules;
	private int numeroChance;
	private int[] nombreDeGagnantsRg;
	private double[] rapportRang;
	private String numeroJokerPlus;
	private String devise;
	private int nombreDeGagnantsTotal;
	private double gainTotal;
	private double[] gainParRg;
	
	public TirageNouveauSuperLoto()
	{
		boules=new int[5];
		nombreDeGagnantsRg=new int[6];
		rapportRang=new double[6];		
		gainParRg=new double[6];
	}
	
	/*
	 * Calcule le rang et le gain pour une grille donnée
	 * 
	 * @return résultat du tirage pour la grille
	 */
	public Resultat getResult(Grille g) {
		if (!(g instanceof GrilleNouveauLoto))
			throw new IllegalArgumentException("GrilleNouveauLoto attendue");

		GrilleNouveauLoto grille = (GrilleNouveauLoto) g;	//cast en GrilleNouveauLoto
		int[] numsGrille = grille.getNums();
		int[] chanceGrille = grille.getChance();
		
		int numMatch = 0;	//Le nombre de numéro gagnant
		boolean numeroChanceObtenu = false;	//Numéro chance obtenu ou non
		int i, j;	//Variable de boucle
		
		//Calcul du nombre d'occurence de numéro
		for (i = 0; i < numsGrille.length; i++) {
			for (j = 0; j < boules.length; j++) {
				if (numsGrille[i] == boules[j]) {
					numMatch++;
				}
			}
		}
		
		//Verification du numéro chance
		for (i = 0; i < chanceGrille.length; i++) {
			if(chanceGrille[i] == numeroChance) {
				numeroChanceObtenu = true;
			}
		}
		
		//retourne le resultat et le gain selon le nombre de numéro, et si il y a le numéro chance ou non
		switch(numMatch) {
			case 5:
				if(numeroChanceObtenu) {
					return new Resultat(this, grille, 1, rapportRang[0]);	//rang 1 (cagnotte)
				}
				else {
					return new Resultat(this, grille, 2, rapportRang[1]);
				}
				
			case 4:
				return new Resultat(this, grille, 3, rapportRang[2]);
				
			case 3:
				return new Resultat(this, grille, 4, rapportRang[3]);
				
			case 2:
				return new Resultat(this, grille, 5, rapportRang[4]);
				
			case 0:
				if(numeroChanceObtenu) {
					return new Resultat(this, grille, 6, rapportRang[5]);
				}
			break;
		}
		return new Resultat(this, grille, 0, 0); //perdu
	}
	
	/*
	 * Permet de jouer une partie de Nouveau Super Loto
	 * 
	 * @return les résultats du tirage
	 */
	public ArrayList<Resultat> jouer(List<Grille> g) {
		ArrayList<Resultat> retour = new ArrayList<Resultat>();
		Resultat resultat;

		for (Grille grille : g) {
			if (!(grille instanceof GrilleNouveauLoto))
				throw new IllegalArgumentException("GrilleEuroMillions attendue");
			resultat = this.getResult((GrilleNouveauLoto)grille);
			retour.add(resultat);
		}
		return retour;
	}
	
	/*
	 * Génère un tirage aléatoire
	 */
	public void generate() {
		ArrayList<Integer> boulesTombees = new ArrayList<Integer>();
		Random random = new Random();
		int boule;
		boolean ok;	//au cas où la boule retombe dans la boucle
		
		//Cas des boules
		for (int i = 0; i < boules.length; i++) {
			ok = false;
			while(!ok) {
				boule = random.nextInt(49) + 1;	//nombre aléatoire entre 1 et 50 
				if (!boulesTombees.contains(boule)) {
					boules[i] = boule;
					boulesTombees.add(boule);
					ok = true;
				}
			}
		}
		
		//Cas du numéro chance
		boule = random.nextInt(10) + 1;	//nombre aléatoire entre 1 et 10 
		numeroChance = boule;

		//initialisation des gains
		double[] tableauGain = new double[rapportRang.length];
		double gain;
		double[] maximumGain = new double[] { 30000000, 700000, 4000, 30, 20};
		double[] minimumGain = new double[] { 3000000, 200000, 1000, 10, 5};
		for (int i = 0; i < tableauGain.length - 1; i++) {
			do {
				gain = random.nextDouble() * maximumGain[i];
			}
			while (gain < minimumGain[i]);
			gain = (10d*gain);
			gain = Math.round(gain)/10d;
			tableauGain[i] = gain;
		}
		tableauGain[5] = 2d;
		rapportRang = tableauGain;
			
	}
	
	public int[] getBoulesCroissantes()
	{
		int[] tmp=boules;
		Arrays.sort(tmp);
		return tmp;
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

	public int[] getNombreDeGagnantsRg() {
		return nombreDeGagnantsRg; 
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


	public double getGainTotal() {
		return gainTotal;
	}

	
	public int getNombreDeGagnantsTotal() {
		return nombreDeGagnantsTotal;
	}
	
	/*
	 *  Calcule le nombre de gagnants total
	 */
	public void calcNombreDeGagnants() {
		for(int NombreDeGagnants : nombreDeGagnantsRg)
			nombreDeGagnantsTotal+=NombreDeGagnants;
	}
	
	/*
	 *  Calcule le gain total
	 */
	public void calcGain() {
		for(int i=0;i<nombreDeGagnantsRg.length;i++)
			gainTotal+=rapportRang[i]*nombreDeGagnantsRg[i];
	}

	
	/*
	 *  Calcule le gain par rang en france
	 */
	public void calcGainParRg() {
		for(int i=0;i<nombreDeGagnantsRg.length;i++)
			gainParRg[i]=rapportRang[i]*nombreDeGagnantsRg[i];
	}
	

	public double[] getGainParRg() {
		return gainParRg;
	}

	
	public boolean equals(TirageLoto t)
	{
		return ((t.getNumeroDeTirage().compareTo(numeroDeTirage))==0);
	}


	public void setNumeroChance(int numeroChance) {
		this.numeroChance = numeroChance;
	}

	public int getNumeroChance() {
		return this.numeroChance;
	}

	public void setNombreDeGagnantsRg(int[] nbGag) {
		// TODO Auto-generated method stub
		nombreDeGagnantsRg=nbGag;
	}
	
}
