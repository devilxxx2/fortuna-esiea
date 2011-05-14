package fr.fortuna.controller;

import java.util.HashMap;

public class GrilleEuroMillions implements Grille {
	private int[] nums;
	private int[] stars;
	private double prix;
	private int numeroGrille;

	public GrilleEuroMillions() {
	}

	public GrilleEuroMillions(int[] nums, int[] stars, int numeroGrille) {
		setValue(nums, stars);
		this.numeroGrille=numeroGrille;
	}

	public void setValue(int[] nums, int[] stars) {
		this.prix = CombiEuroMillions.getPrix(nums.length, stars.length);

		this.nums = nums;
		this.stars = stars;
	}

	public double getPrice() {
		return prix;
	}
	
	public int[] getNums() {
		return nums;
	}
	
	public String getNumsString() {
		String numeros="";
		for(int i=0; i<nums.length; i++){
			if(i!=0 && i<nums.length-1) numeros+=" " + nums[i] + " -";
			else if(i==nums.length-1) numeros+=" " + nums[i];
			else numeros+=nums[i] + " -";
		}
		
		return numeros;
	}
	
	public int[] getStars() {
		return stars;
	}
	
	public String getStarsString() {
		String stars="";
		for(int i=0; i<this.stars.length; i++){
			if(i!=0) stars+=" " + this.stars[i] + " -";
			else if(i==this.stars.length-1) stars+=" " + this.stars[i];
			else stars+=this.stars[i];
		}
		
		return stars;
	}

	public int getNumeroGrille() {
		return numeroGrille;
	}

	public void setNumeroGrille(int numeroGrille) {
		this.numeroGrille = numeroGrille;
	}
}

class CombiEuroMillions {
	// nb numéros, nb étoiles -> prix
	private static HashMap<Pair<Integer, Integer>, Double> combi;

	public static double getPrix(int numeros, int etoiles)
	{
		if (combi == null)
			buildCombi();
		Double d = combi.get(new Pair<Integer, Integer>(numeros, etoiles));
		if (d == null)
			throw new IllegalArgumentException();
		return d;
	}

	private static void buildCombi()
	{
		combi = new HashMap<Pair<Integer, Integer>, Double>();
		combi.put(new Pair<Integer, Integer>(5, 2), 2.);
		combi.put(new Pair<Integer, Integer>(5, 3), 6.);
		combi.put(new Pair<Integer, Integer>(5, 4), 12.);
		combi.put(new Pair<Integer, Integer>(5, 5), 20.);
		combi.put(new Pair<Integer, Integer>(5, 6), 30.);
		combi.put(new Pair<Integer, Integer>(5, 7), 42.);
		combi.put(new Pair<Integer, Integer>(5, 8), 56.);
		combi.put(new Pair<Integer, Integer>(5, 9), 72.);
		combi.put(new Pair<Integer, Integer>(6, 2), 12.);
		combi.put(new Pair<Integer, Integer>(6, 3), 36.);
		combi.put(new Pair<Integer, Integer>(6, 4), 72.);
		combi.put(new Pair<Integer, Integer>(6, 5), 120.);
		combi.put(new Pair<Integer, Integer>(6, 6), 180.);
		combi.put(new Pair<Integer, Integer>(6, 7), 252.);
		combi.put(new Pair<Integer, Integer>(6, 8), 336.);
		combi.put(new Pair<Integer, Integer>(7, 2), 42.);
		combi.put(new Pair<Integer, Integer>(7, 3), 126.);
		combi.put(new Pair<Integer, Integer>(7, 4), 252.);
		combi.put(new Pair<Integer, Integer>(8, 2), 112.);
		combi.put(new Pair<Integer, Integer>(8, 3), 336.);
		combi.put(new Pair<Integer, Integer>(9, 2), 252.);
	}
}
