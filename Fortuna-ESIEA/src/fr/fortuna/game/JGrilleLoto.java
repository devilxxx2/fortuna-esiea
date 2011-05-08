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

public class JGrilleLoto extends JPanel implements JGrille {
	private JGrilleNumeros nums;

	public JGrilleLoto(){
		super();

		nums = new JGrilleNumeros(49, 7, "Loto");
		this.add(nums);
	}

	@Override
	public Grille getGrille() {
		// TODO Auto-generated method stub
		return null;
	}
}