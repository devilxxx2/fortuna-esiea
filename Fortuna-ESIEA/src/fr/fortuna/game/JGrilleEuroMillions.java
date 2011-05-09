package fr.fortuna.game;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.BorderFactory;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;

import fr.fortuna.model.Grille;
import fr.fortuna.model.GrilleEuroMillions;

public class JGrilleEuroMillions extends JPanel implements JGrille, ItemListener, ActionListener {

	private JGrilleNumeros nums;
	private JGrilleNumeros etoiles;

	public JGrilleEuroMillions(int numeroGrille){
		super();

		TitledBorder titledBorder=BorderFactory.createTitledBorder(
				BorderFactory.createMatteBorder(3, 3, 3, 3, Color.red),
				Integer.toString(numeroGrille));
		titledBorder.setTitleJustification(TitledBorder.CENTER);
		this.setBorder(titledBorder);

		nums = new JGrilleNumeros(50, 6, "Numéros");
		etoiles = new JGrilleNumeros(9, 3, "Etoiles");
		this.add(nums);
		this.add(etoiles);
	}

	@Override
	public Grille getGrille() {
		return new GrilleEuroMillions(nums.getNums(), etoiles.getNums());
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void itemStateChanged(ItemEvent e) {
		// TODO Auto-generated method stub


	}
}
