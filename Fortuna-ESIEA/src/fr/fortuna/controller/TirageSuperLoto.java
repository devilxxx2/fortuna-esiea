package fr.fortuna.controller;

import java.util.Arrays;

public class TirageSuperLoto implements Tirage {
	
	private String numeroDeTirage;
	private String jour;
	private String dateTirage;
	private String dateForclusion;
	private int[] boules;
	private int bouleComplementaire;
	private int[] nombreDeGagnantsRg;
	private double[] rapportRang;
	private String numeroJokerPlus;
	private String devise;
	private int nombreDeGagnantsTotal;
	private double gainTotal;
	private double[] gainParRg;
	
	public TirageSuperLoto()
	{
		boules=new int[6];
		nombreDeGagnantsRg=new int[7];
		rapportRang=new double[7];		
		gainParRg=new double[7];
	}
	
	/*
	 * Calcule le rang et le gain pour une grille donn�e
	 * 
	 * @return r�sultat du tirage pour la grille
	 */
	public Resultat getResult(Grille g) {
		GrilleLoto grille = (GrilleLoto) g;	//cast en GrilleLoto
		int[] numsGrille = grille.getNums();
		
		int numMatch = 0;	//Le nombre de num�ro gagnant
		boolean numeroComplementaireObtenu = false;	//Num�ro complementaire obtenu ou non
		int i, j;	//Variable de boucle
		
		//Calcul du nombre d'occurence de num�ro et du num�ro compl�mentaire
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
		
		//retourne le resultat et le gain selon le nombre de num�ro, et si il y a le num�ro compl�mentaire ou non
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
	
	public int[] getBoulesCroissantes()
	{
		int[] tmp=boules;
		Arrays.sort(tmp);
		return tmp;
	}

	public void setNumeroDeTirage(String numeroDeTirage) {
		numeroDeTirage = numeroDeTirage;
	}

	public String getNumeroDeTirage() {
		return numeroDeTirage;
	}

	public void setJour(String jour) {
		this.jour = jour;
	}

	public String getJour() {
		return this.jour;
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

	public void setBouleComplementaire(int bouleComplementaire) {
		this.bouleComplementaire = bouleComplementaire;
	}

	public int getBouleComplementaire() {
		return bouleComplementaire;
	}

	public void setNombreDeGagnantsRg(int[] nbGag) {
		// TODO Auto-generated method stub
		nombreDeGagnantsRg=nbGag;
	}

}
