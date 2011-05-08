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

import javax.swing.BorderFactory;
import javax.swing.JPanel;
import javax.swing.JToggleButton;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;

public class JGrilleEuroMillions extends JPanel implements JGrille {
	private JGrilleNumeros nums;
	private JGrilleNumeros etoiles;

	public JGrilleEuroMillions(){
		super();

		nums = new JGrilleNumeros(50, 6, "Numéros");
		etoiles = new JGrilleNumeros(9, 3, "Étoiles");
		this.add(nums);
		this.add(etoiles);
	}

	@Override
	public ArrayList<Grille> getGrilles() {
		// TODO Auto-generated method stub
		return null;
	}
}
