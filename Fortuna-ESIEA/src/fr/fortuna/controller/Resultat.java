package fr.fortuna.controller;

public class Resultat {

	private Tirage tirage;
	private Grille grille;
	private int rang;
	private double gain;
	
	public Resultat(Tirage t, GrilleEuroMillions g, int r, double ga ) {
		tirage = t;
		grille = g;
		rang = r;
		gain = ga;
		
	}
	
	public Resultat(Tirage t, GrilleNouveauLoto g, int r, double ga ) {
		tirage = t;
		grille = g;
		rang = r;
		gain = ga;
		
	}
	
	public Tirage getTirage() {
		return tirage;
	}
	
	public int getRang() {
		return rang;
	}
	
	public double getGain() {
		return gain;
	}
	
	public Grille getGrille() {
		return grille;
	}
}
