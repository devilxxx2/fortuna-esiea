package fr.fortuna.controller;

import java.util.HashMap;

public class GrilleNouveauLoto implements Grille {
	private int[] nums;
	private int[] chance;
	private double prix;

	public GrilleNouveauLoto() {
	}

	public GrilleNouveauLoto(int[] nums, int[] chance) {
		setValue(nums, chance);
	}

	public void setValue(int[] nums, int[] chance) {
		this.prix = CombiNouveauLoto.getPrix(nums.length, chance.length);

		this.nums = nums;
		this.chance = chance;
	}

	public double getPrice() {
		return prix;
	}
}

class CombiNouveauLoto {
	// nb numéros, nb étoiles -> prix
	private static HashMap<Pair<Integer, Integer>, Double> combi;

	public static double getPrix(int numeros, int chance)
	{
		if (combi == null)
			buildCombi();
		Double d = combi.get(new Pair<Integer, Integer>(numeros, chance));
		if (d == null)
			throw new IllegalArgumentException();
		return d;
	}

	private static void buildCombi()
	{
		combi = new HashMap<Pair<Integer, Integer>, Double>();
		combi.put(new Pair<Integer, Integer>(5, 2), 2.);
		combi.put(new Pair<Integer, Integer>(5, 1), 2.);
		combi.put(new Pair<Integer, Integer>(5, 2), 4.);
		combi.put(new Pair<Integer, Integer>(5, 3), 6.);
		combi.put(new Pair<Integer, Integer>(5, 4), 8.);
		combi.put(new Pair<Integer, Integer>(5, 5), 10.);
		combi.put(new Pair<Integer, Integer>(5, 6), 12.);
		combi.put(new Pair<Integer, Integer>(5, 7), 14.);
		combi.put(new Pair<Integer, Integer>(5, 8), 16.);
		combi.put(new Pair<Integer, Integer>(5, 9), 18.);
		combi.put(new Pair<Integer, Integer>(5, 10), 20.);
		combi.put(new Pair<Integer, Integer>(6, 1), 12.);
		combi.put(new Pair<Integer, Integer>(6, 2), 24.);
		combi.put(new Pair<Integer, Integer>(6, 3), 36.);
		combi.put(new Pair<Integer, Integer>(6, 4), 48.);
		combi.put(new Pair<Integer, Integer>(6, 5), 60.);
		combi.put(new Pair<Integer, Integer>(6, 6), 72.);
		combi.put(new Pair<Integer, Integer>(6, 7), 84.);
		combi.put(new Pair<Integer, Integer>(6, 8), 96.);
		combi.put(new Pair<Integer, Integer>(6, 9), 108.);
		combi.put(new Pair<Integer, Integer>(6, 10), 120.);
		combi.put(new Pair<Integer, Integer>(7, 1), 42.);
		combi.put(new Pair<Integer, Integer>(7, 2), 84.);
		combi.put(new Pair<Integer, Integer>(7, 3), 126.);
		combi.put(new Pair<Integer, Integer>(7, 4), 168.);
		combi.put(new Pair<Integer, Integer>(7, 5), 210.);
		combi.put(new Pair<Integer, Integer>(7, 6), 252.);
		combi.put(new Pair<Integer, Integer>(7, 7), 294.);
		combi.put(new Pair<Integer, Integer>(7, 8), 336.);
		combi.put(new Pair<Integer, Integer>(8, 1), 112.);
		combi.put(new Pair<Integer, Integer>(8, 2), 224.);
		combi.put(new Pair<Integer, Integer>(8, 3), 336.);
		combi.put(new Pair<Integer, Integer>(9, 1), 252.);
	}
}
