package fr.fortuna.Tirage;

import java.util.Arrays;

public class TirageLoto implements Tirage {
	
	
	public TirageLoto()
	{
		boules=new int[6];
		nombreDeGagnantsRg=new int[7];
		rapportRang=new double[7];		
		gainParRg=new double[7];
	}
	
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
