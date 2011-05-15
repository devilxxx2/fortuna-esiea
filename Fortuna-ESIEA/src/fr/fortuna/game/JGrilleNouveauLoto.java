package fr.fortuna.game;

import java.awt.Color;
import java.awt.Insets;
import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;
import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JToggleButton;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.border.TitledBorder;

import fr.fortuna.controller.Grille;
import fr.fortuna.controller.GrilleNouveauLoto;
import fr.fortuna.controller.TirageNouveauLoto;
import fr.fortuna.controller.NouveauLoto;

public class JGrilleNouveauLoto extends JPanel implements JGrille {
	private JGrilleNumeros nums;
	private JGrilleNumeros chance;
	private JPanel buttonPanel;
	private JDialog parent;
	private int numGrille;
	private NouveauLoto nouveauloto;

	public JGrilleNouveauLoto(JDialog parent, NouveauLoto loto, int num){
		super();

		buttonPanel=new JPanel();

		this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

		TitledBorder titledBorder=BorderFactory.createTitledBorder(
				BorderFactory.createMatteBorder(3, 3, 3, 3, Color.red),
				Integer.toString(num));
		titledBorder.setTitleJustification(TitledBorder.CENTER);
		this.setBorder(titledBorder);

		nums = new JGrilleNumeros(49, 7, "Numéros");
		chance = new JGrilleNumeros(10, 10, "Chance");

		this.add(nums);
		this.add(chance);

		this.add(buttonPanel);

		JButton button;
		buttonPanel.add(button = new JButton(new RandomAction()));
		button.setMargin(new Insets(0, 0, 0, 0));
		buttonPanel.add(button = new JButton(new ResetAction()));
		button.setMargin(new Insets(0, 0, 0, 0));
		buttonPanel.add(button = new JButton(new RechercherAction()));
		button.setMargin(new Insets(0, 0, 0, 0));

		this.parent = parent;
		this.nouveauloto = loto;
		this.numGrille = num;
	}

	public void resetGrille(){
		nums.reset();
		chance.reset();
	}

	public void randomFillGrille(){
		nums.randomFill(5);
		chance.randomFill(1);
	}

	public void search() {
		try
		{
			new RechercheDialog(nouveauloto.rechercheAncienResultat(
						new GrilleNouveauLoto(nums.getNums(), chance.getNums(),
							numGrille)), parent);
		}
		catch (IllegalArgumentException e)
		{
			JOptionPane.showMessageDialog(parent,
					"La grille est invalide.");
		}
	}

	@Override
	public Grille getGrille() {
		return new GrilleNouveauLoto(nums.getNums(), chance.getNums(), numGrille);
	}

	public int getNumGrille() {
		return numGrille;
	}

	public boolean isEmpty() {
		return nums.isEmpty() && chance.isEmpty();
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
