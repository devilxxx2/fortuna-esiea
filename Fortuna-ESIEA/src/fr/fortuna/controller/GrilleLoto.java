package fr.fortuna.controller;

import java.util.HashMap;

public class GrilleLoto implements Grille {
	private int[] nums;
	private int numeroGrille;

	public GrilleLoto(int[] nums, int numeroGrille) {
		setValue(nums);
		this.numeroGrille = numeroGrille;
	}

	public void setValue(int[] nums) {
		if (nums.length != 6)
			throw new IllegalArgumentException("Seules les grilles de 6 numéros sont supportées");

		this.nums = nums;
	}
	
	public int[] getNums() {
		return nums;
	}

	public String getNumsString() {
		String nums = "";
		for(int i = 0; i < this.nums.length; i++)
			if (i == this.nums.length-1)
				nums += this.nums[i];
			else
				nums += this.nums[i] + " - ";
		return nums;
	}
	
	public String toString() {
		return getNumsString();
	}

	public double getPrice() {
		return 0.6;
	}

	public int getNumeroGrille() {
		return numeroGrille;
	}
}
