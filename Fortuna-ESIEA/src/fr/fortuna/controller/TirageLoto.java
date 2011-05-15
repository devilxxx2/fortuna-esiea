package fr.fortuna.controller;

import java.util.Arrays;
import java.util.HashMap;

public class TirageLoto implements Tirage {
	
	private String numeroDeTirage;
	private int ordreDeTirage;
	private String jour;
	private String dateTirage;
	private String dateForclusion;
	private int[] boules;
	private int bouleComplementaire;
	private int[] nombreDeGagnantsRg;
	private double[] rapportRang;
	private String numeroJoker;
	private String numeroJokerPlus;
	private String devise;
	private int nombreDeGagnantsTotal;
	private double gainTotal;
	private double[] gainParRg;
	
	public TirageLoto()
	{
		boules=new int[6];
		nombreDeGagnantsRg=new int[7];
		rapportRang=new double[7];		
		gainParRg=new double[7];
	}
	
	/*
	 * Calcule le rang et le gain pour une grille donnée
	 * 
	 * @return résultat du tirage pour la grille
	 */
	public Resultat getResult(Grille g) {
		if (!(g instanceof GrilleLoto))
			throw new IllegalArgumentException("GrilleLoto attendue");

		GrilleLoto grille = (GrilleLoto) g;	//cast en GrilleLoto
		int[] numsGrille = grille.getNums();
		
		int numMatch = 0;	//Le nombre de numéro gagnant
		boolean numeroComplementaireObtenu = false;	//Numéro complementaire obtenu ou non
		int i, j;	//Variable de boucle
		
		//Calcul du nombre d'occurence de numéro et du numéro complémentaire
		for (i = 0; i < numsGrille.length; i++) {
			for (j = 0; j < boules.length; j++) {
				if (numsGrille[i] == boules[j]) {
					numMatch++;
				}
				if (!numeroComplementaireObtenu && numsGrille[i] == bouleComplementaire) {
					numeroComplementaireObtenu = true;
				}
			}
		}
		
		//retourne le resultat et le gain selon le nombre de numéro, et si il y a le numéro complémentaire ou non
		switch(numMatch) {
			case 6:
					return new Resultat(this, grille, 1, rapportRang[0]);	//rang 1 (cagnotte)
				
			case 5:
				if (numeroComplementaireObtenu) {
					return new Resultat(this, grille, 2, rapportRang[1]);
				}
				else {
					return new Resultat(this, grille, 3, rapportRang[2]);
				}
				
			case 4:
				if (numeroComplementaireObtenu) {
					return new Resultat(this, grille, 4, rapportRang[3]);
				}
				else {
					return new Resultat(this, grille, 5, rapportRang[4]);
				}
				
			case 3:
				if (numeroComplementaireObtenu) {
					return new Resultat(this, grille, 6, rapportRang[5]);
				}
				else {
					return new Resultat(this, grille, 7, rapportRang[6]);
				}
		}
		return new Resultat(this, grille, 0, 0); //perdu
	}
	
	/*
	 * Calcule les statistiques sur les gagnants du Loto
	 * 
	 * @return une map les statistiques des gagnants pour chaque rang
	 */
	public HashMap<Integer, Double> calculStatGagnant() {
		HashMap<Integer, Double> retour = new HashMap<Integer, Double>();
		int i;	//variable de boucle
		double stat;
		
		for (i = 0; i < nombreDeGagnantsRg.length; i++) {
			stat = (double)nombreDeGagnantsRg[i] / nombreDeGagnantsTotal;
			retour.put(i+1, stat);
		}
		return retour;
	}
	
	/*
	 * Calcule les statistiques sur les gains du Loto
	 * 
	 * @return une map les statistiques des gains pour chaque rang
	 */
	public HashMap<Integer, Double> calculStatGain() {
		HashMap<Integer, Double> retour = new HashMap<Integer, Double>();
		int i;	//variable de boucle
		double stat;
		
		for (i = 0; i < gainParRg.length; i++) {
			stat = (double)gainParRg[i] / gainTotal;
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
		return (((t.getNumeroDeTirage().compareTo(numeroDeTirage))==0) && t.getOrdreDeTirage()==ordreDeTirage);
	}

	public void setOrdreDeTirage(int ordreDeTirage) {
		this.ordreDeTirage = ordreDeTirage;
	}

	public int getOrdreDeTirage() {
		return ordreDeTirage;
	}

	public void setBouleComplementaire(int bouleComplementaire) {
		this.bouleComplementaire = bouleComplementaire;
	}

	public int getBouleComplementaire() {
		return bouleComplementaire;
	}

	public void setNumeroJoker(String numeroJoker) {
		this.numeroJoker = numeroJoker;
	}

	public String getNumeroJoker() {
		return numeroJoker;
	}
	
	public void setNombreDeGagnantsRg(int[] nbGag) {
		// TODO Auto-generated method stub
		nombreDeGagnantsRg=nbGag;
	}
	
}
