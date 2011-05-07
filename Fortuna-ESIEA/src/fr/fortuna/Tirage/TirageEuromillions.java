package fr.fortuna.Tirage;

import java.util.Arrays;

public class TirageEuromillions implements Tirage {
	public TirageEuromillions()
	{
		Boules=new int[5];
		Etoiles=new int[2];
		NombreDeGagnantsRgEurope=new int[12];
		NombreDeGagnantsRgFrance=new int[12];
		RapportRang=new double[12];		
	}
	
	private String NumeroDeTirage;
	private String Jour;
	private String DateTirage;
	private String DateForclusion;
	private int[] Boules;
	private int[] Etoiles;
	private int[] NombreDeGagnantsRgEurope;
	private int[] NombreDeGagnantsRgFrance;
	private double[] RapportRang;
	private String NumeroJokerPlus;
	private String devise;
	private int NombreDeGagnantsTotalFrance;
	private int NombreDeGagnantsTotalEurope;
	private double GainTotalFrance;
	private double GainTotalEurope;
	
	public int[] getBoulesCroissantes()
	{
		int[] tmp=Boules;
		Arrays.sort(tmp);
		return tmp;
	}
	
	public int[] getEtoilesCroissantes()
	{
		int[] tmp=Etoiles;
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

	public void setNombreDeGagnantsRgFrance(int[] nombreDeGagnantsRgFrance) {
		NombreDeGagnantsRgFrance = nombreDeGagnantsRgFrance;
	}

	public int[] getNombreDeGagnantsRgFrance() {
		return NombreDeGagnantsRgFrance;
	}

	public void setNombreDeGagnantsRgEurope(int[] nombreDeGagnantsRgEurope) {
		NombreDeGagnantsRgEurope = nombreDeGagnantsRgEurope;
	}

	public int[] getNombreDeGagnantsRgEurope() {
		return NombreDeGagnantsRgEurope;
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

	public void setEtoiles(int[] etoiles) {
		Etoiles = etoiles;
	}

	public int[] getEtoiles() {
		return Etoiles;
	}

	public double getGainTotalFrance() {
		return GainTotalFrance;
	}

	public double getGainTotalEurope() {
		return GainTotalEurope;
	}
	
	public int getNombreDeGagnantsTotalFrance() {
		return NombreDeGagnantsTotalFrance;
	}
	
	public int getNombreDeGagnantsTotalEurope() {
		return NombreDeGagnantsTotalEurope;
	}
	/*
	 *  Calcule le nombre de gagnants total en france
	 */
	public void calcNombreDeGagnantsFrance() {
		for(int NombreDeGagnants : NombreDeGagnantsRgFrance)
			NombreDeGagnantsTotalFrance+=NombreDeGagnants;
	}
	
	/*
	 *  Calcule le nombre de gagnants total en Europe
	 */
	public void calcNombreDeGagnantsEurope() {
		for(int NombreDeGagnants : NombreDeGagnantsRgEurope)
			NombreDeGagnantsTotalEurope+=NombreDeGagnants;
	}
	
	/*
	 *  Calcule le gain total en france
	 */
	public void calcGainFrance() {
		for(int i=0;i<NombreDeGagnantsRgFrance.length;i++)
			GainTotalFrance+=RapportRang[i]*NombreDeGagnantsRgFrance[i];
	}
	
	/*
	 *  Calcule le gain total en Europe
	 */
	public void calcGainEurope() {
		for(int i=0;i<NombreDeGagnantsRgEurope.length;i++)
			GainTotalEurope+=RapportRang[i]*NombreDeGagnantsRgEurope[i];
	}
	
}
