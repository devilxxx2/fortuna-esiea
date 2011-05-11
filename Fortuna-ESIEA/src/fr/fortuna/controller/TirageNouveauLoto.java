package fr.fortuna.controller;

import java.util.Arrays;

public class TirageNouveauLoto implements Tirage {
	
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
	
	public TirageNouveauLoto()
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
				if (numeroChanceObtenu) {
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
				if (numeroChanceObtenu) {
					return new Resultat(this, grille, 6, rapportRang[5]);
				}
			break;
		}
		return new Resultat(this, grille, 0, 0); //perdu
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
