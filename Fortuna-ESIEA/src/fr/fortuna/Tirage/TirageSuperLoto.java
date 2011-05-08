package fr.fortuna.Tirage;

import java.util.Arrays;

public class TirageSuperLoto implements Tirage {
	
	
	public TirageSuperLoto()
	{
		Boules=new int[6];
		NombreDeGagnantsRg=new int[7];
		RapportRang=new double[7];		
		GainParRg=new double[7];
	}
	
	private String NumeroDeTirage;
	private String Jour;
	private String DateTirage;
	private String DateForclusion;
	private int[] Boules;
	private int BouleComplémentaire;
	private int[] NombreDeGagnantsRg;
	private double[] RapportRang;
	private String NumeroJokerPlus;
	private String devise;
	private int NombreDeGagnantsTotal;
	private double GainTotal;
	private double[] GainParRg;
	
	public int[] getBoulesCroissantes()
	{
		int[] tmp=Boules;
		Arrays.sort(tmp);
		return tmp;
	}

	public void setNumeroDeTirage(String numeroDeTirage) {
		NumeroDeTirage = numeroDeTirage;
	}

	public String getNumeroDeTirage() {
		return NumeroDeTirage;
	}

	public void setJour(String jour) {
		Jour = jour;
	}

	public String getJour() {
		return Jour;
	}

	public void setRapportRang(double[] rapportRang) {
		RapportRang = rapportRang;
	}

	public double[] getRapportRang() {
		return RapportRang;
	}

	public void setDevise(String devise) {
		this.devise = devise;
	}

	public String getDevise() {
		return devise;
	}

	public void setNumeroJokerPlus(String numeroJokerPlus) {
		NumeroJokerPlus = numeroJokerPlus;
	}

	public String getNumeroJokerPlus() {
		return NumeroJokerPlus;
	}

	public int[] getNombreDeGagnantsRg() {
		return NombreDeGagnantsRg; 
	}

	public void setDateForclusion(String dateForclusion) {
		DateForclusion = dateForclusion;
	}

	public String getDateForclusion() {
		return DateForclusion;
	}

	public void setDateTirage(String dateTirage) {
		DateTirage = dateTirage;
	}

	public String getDateTirage() {
		return DateTirage;
	}

	public void setBoules(int[] boules) {
		Boules = boules;
	}

	public int[] getBoules() {
		return Boules;
	}


	public double getGainTotal() {
		return GainTotal;
	}

	
	public int getNombreDeGagnantsTotal() {
		return NombreDeGagnantsTotal;
	}
	
	/*
	 *  Calcule le nombre de gagnants total
	 */
	public void calcNombreDeGagnants() {
		for(int NombreDeGagnants : NombreDeGagnantsRg)
			NombreDeGagnantsTotal+=NombreDeGagnants;
	}
	
	/*
	 *  Calcule le gain total
	 */
	public void calcGain() {
		for(int i=0;i<NombreDeGagnantsRg.length;i++)
			GainTotal+=RapportRang[i]*NombreDeGagnantsRg[i];
	}

	
	/*
	 *  Calcule le gain par rang en france
	 */
	public void calcGainParRg() {
		for(int i=0;i<NombreDeGagnantsRg.length;i++)
			GainParRg[i]=RapportRang[i]*NombreDeGagnantsRg[i];
	}
	

	public double[] getGainParRg() {
		return GainParRg;
	}

	
	public boolean equals(TirageLoto t)
	{
		return ((t.getNumeroDeTirage().compareTo(NumeroDeTirage))==0);
	}

	public void setBouleComplémentaire(int bouleComplémentaire) {
		BouleComplémentaire = bouleComplémentaire;
	}

	public int getBouleComplémentaire() {
		return BouleComplémentaire;
	}

	public void setNombreDeGagnantsRg(int[] nbGag) {
		// TODO Auto-generated method stub
		NombreDeGagnantsRg=nbGag;
	}

}
