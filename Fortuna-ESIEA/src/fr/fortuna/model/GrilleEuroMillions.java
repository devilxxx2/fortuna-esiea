package fr.fortuna.model;

import java.util.HashMap;

class GrilleEuroMillions implements Grille {
	private int[] nums;
	private int[] stars;
	private double prix;

	public void setValue(int[] nums, int[] stars) {
		this.prix = CombiEuroMillions.getPrix(nums.length, stars.length);

		this.nums = nums;
		this.stars = stars;
	}

	public double getPrice() {
		return prix;
	}
}

class CombiEuroMillions {
	// nb numéros, nb étoiles -> prix
	private static HashMap<Pair<Integer, Integer>, Double> combi;

	public static double getPrix(int numeros, int etoiles)
	{
		if (combi == null)
			buildCombi();
		return combi.get(new Pair<Integer, Integer>(numeros, etoiles));
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
