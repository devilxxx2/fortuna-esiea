package fr.fortuna.controller;

import java.util.Arrays;

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


	public int[] getBoulesCroissantes()
	{
		int[] tmp=boules;
		Arrays.sort(tmp);
		return tmp;
	}

	public int[] getEtoilesCroissantes()
	{
		int[] tmp=etoiles;
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
