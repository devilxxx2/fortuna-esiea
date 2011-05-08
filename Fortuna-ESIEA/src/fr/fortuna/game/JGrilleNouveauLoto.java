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

import fr.fortuna.model.Grille;
import fr.fortuna.model.GrilleNouveauLoto;

public class JGrilleNouveauLoto extends JPanel implements JGrille {
	private JGrilleNumeros nums;
	private JGrilleNumeros chance;

	public JGrilleNouveauLoto(){
		super();

		nums = new JGrilleNumeros(49, 7, "Numéros");
		chance = new JGrilleNumeros(10, 10, "Chance");
		this.add(nums);
		this.add(chance);
	}

	@Override
	public Grille getGrille() {
		return new GrilleNouveauLoto(nums.getNums(), chance.getNums());
	}
}
