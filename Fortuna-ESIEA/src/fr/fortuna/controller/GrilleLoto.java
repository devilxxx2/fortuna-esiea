package fr.fortuna.controller;

import java.util.HashMap;

public class GrilleLoto implements Grille {
	private int[] nums;

	public GrilleLoto() {
	}

	public GrilleLoto(int[] nums) {
		setValue(nums);
	}

	public void setValue(int[] nums) {
		if (nums.length != 6)
			throw new IllegalArgumentException("Seules les grilles de 6 numéros sont supportées");

		this.nums = nums;
	}

	public int[] getNums() {
		return nums;
	}

	public double getPrice() {
		return -1;
	}
}
