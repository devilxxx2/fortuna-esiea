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
				BorderFactory.createLineBorder(Color.RED), title);
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
			// box.setSize(2, 2);
			//box.setPreferredSize(new Dimension(8,8));
			// box.setMaximumSize(new Dimension(2,2));
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
		for (int i = 0; i < ret.length; ++i)
			ret[i] = list.get(i);
		return ret;
	}
}
