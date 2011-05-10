package fr.fortuna.game;

import java.awt.Color;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;

import fr.fortuna.controller.Grille;
import fr.fortuna.controller.GrilleNouveauLoto;

public class JGrilleNouveauLoto extends JPanel implements JGrille {
	private JGrilleNumeros nums;
	private JGrilleNumeros chance;

	public JGrilleNouveauLoto(){
		super();

		this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

		TitledBorder titledBorder=BorderFactory.createTitledBorder(
				BorderFactory.createMatteBorder(3, 3, 3, 3, Color.red),
				Integer.toString(2));
		titledBorder.setTitleJustification(TitledBorder.CENTER);
		this.setBorder(titledBorder);

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
