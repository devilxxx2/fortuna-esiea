package fr.fortuna.game;

import java.awt.Insets;
import java.awt.Color;
import java.awt.event.ActionEvent;

import javax.swing.JDialog;
import javax.swing.AbstractAction;
import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JToggleButton;
import javax.swing.JOptionPane;
import javax.swing.border.TitledBorder;

import fr.fortuna.controller.Euromillions;
import fr.fortuna.controller.Grille;
import fr.fortuna.controller.GrilleEuroMillions;
import fr.fortuna.controller.TirageEuromillions;

public class JGrilleEuroMillions extends JPanel implements JGrille {
	private JGrilleNumeros nums;
	private JGrilleNumeros etoiles;
	private JPanel buttonPanel;
	private int numGrille;
	private JDialog parent;
	private Euromillions euromillions;

	public JGrilleEuroMillions(JDialog parent, Euromillions em, int numeroGrille){
		super();

		buttonPanel=new JPanel();

		this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

		TitledBorder titledBorder=BorderFactory.createTitledBorder(
				BorderFactory.createMatteBorder(3, 3, 3, 3, Color.red),
				Integer.toString(numeroGrille));
		titledBorder.setTitleJustification(TitledBorder.CENTER);
		this.setBorder(titledBorder);

		nums = new JGrilleNumeros(50, 6, "Numéros");
		etoiles = new JGrilleNumeros(9, 3, "Etoiles");
		this.add(nums);
		this.add(etoiles);

		this.add(buttonPanel);

		JButton button;
		buttonPanel.add(button = new JButton(new RandomAction()));
		button.setMargin(new Insets(0, 0, 0, 0));
		buttonPanel.add(button = new JButton(new ResetAction()));
		button.setMargin(new Insets(0, 0, 0, 0));
		buttonPanel.add(button = new JButton(new RechercherAction()));
		button.setMargin(new Insets(0, 0, 0, 0));

		this.numGrille = numeroGrille;
		this.parent = parent;
		this.euromillions = em;
	}

	public void resetGrille(){
		nums.reset();
		etoiles.reset();
	}

	public void randomFillGrille(){
		nums.randomFill(5);
		etoiles.randomFill(2);
	}

	public void search() {
		GrilleEuroMillions g;
		try
		{
			g = new GrilleEuroMillions(nums.getNums(), etoiles.getNums(),
								numGrille);
		}
		catch (IllegalArgumentException e)
		{
			JOptionPane.showMessageDialog(parent,
					"La grille est invalide.");
			return;
		}
		try
		{
			new RechercheDialog(euromillions.rechercheAncienResultat(g), parent);
		}
		catch (IllegalArgumentException e)
		{
			JOptionPane.showMessageDialog(parent,
					"Vous n'avez rien gagné.");
		}
	}

	@Override
	public Grille getGrille() {
		return new GrilleEuroMillions(nums.getNums(), etoiles.getNums(),
				numGrille);
	}

	public int getNumGrille() {
		return numGrille;
	}

	public boolean isEmpty() {
		return nums.isEmpty() && etoiles.isEmpty();
	}

	private class RandomAction extends AbstractAction {
		public RandomAction(){
			super("Flash");
		}

		@Override
		public void actionPerformed(ActionEvent e) {
			resetGrille();
			randomFillGrille();
		}
	}

	private class ResetAction extends AbstractAction {
		public ResetAction() {
			super("Reset");
		}

		@Override
		public void actionPerformed(ActionEvent arg0) {
			resetGrille();
		}
	}

	private class RechercherAction extends AbstractAction {
		public RechercherAction() {
			super("Rechercher");
		}

		@Override
		public void actionPerformed(ActionEvent arg0) {
			search();
		}
	}
}
