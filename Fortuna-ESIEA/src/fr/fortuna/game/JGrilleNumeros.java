package fr.fortuna.game;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.lang.Math;
import java.util.Random;

import javax.swing.BorderFactory;
import javax.swing.JPanel;
import javax.swing.JToggleButton;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;

public class JGrilleNumeros extends JPanel {
	
	private JToggleButton[] grille;
	private final int NB_CASES;

	public JGrilleNumeros(int num, int cols, String title){
		super();

		GridLayout g = new GridLayout((int)Math.ceil(((double)num)/cols), cols);
		this.setLayout(g);

		NB_CASES = num;

		TitledBorder titledBorder=BorderFactory.createTitledBorder(
				BorderFactory.createLineBorder(Color.BLACK), title);
		titledBorder.setTitleJustification(TitledBorder.CENTER);
		this.setBorder(titledBorder);

		grille=new JToggleButton[NB_CASES];
		createGrille();
	}

	private void createGrille(){
		for(int i=0; i<NB_CASES; i++){
			JToggleButton box;
			box=new JToggleButton(Integer.toString(i+1));
			box.setMargin(new Insets(0, 0, 0, 0));

			add(box);
			grille[i] = box;
		}
	}

	public int[] getNums() {
		ArrayList<Integer> list = new ArrayList<Integer>();
		for (int i = 0; i < NB_CASES; ++i)
			if (grille[i].isSelected())
				list.add(i+1);
		int[] ret = new int[list.size()];
		
		/*
			Integer[] ret1=new Integer[list.size()];
			ret1=(Integer[])list.toArray(new Integer[0]);
		*/
		
		for (int i = 0; i < ret.length; ++i)
			ret[i] = list.get(i);
		return ret;
	}

	public boolean isEmpty() {
		for (int i = 0; i < NB_CASES; ++i)
			if (grille[i].isSelected())
				return false;
		return true;
	}

	public void reset() {
		for (int i = 0; i < NB_CASES; ++i)
			grille[i].setSelected(false);
	}

	public void randomFill(int num) {
		if (num > NB_CASES)
			throw new IllegalArgumentException("Plus de cases à cocher que de disponibles");

		Random random = new Random();
		int val;

		while (num > 0)
		{
			val = random.nextInt(NB_CASES);
			if (!grille[val].isSelected())
			{
				grille[val].setSelected(true);
				num--;
			}
		}
	}
}
