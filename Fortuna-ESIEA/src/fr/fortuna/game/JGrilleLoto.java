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
import fr.fortuna.controller.GrilleLoto;
import fr.fortuna.controller.TirageLoto;
import fr.fortuna.controller.Loto;

public class JGrilleLoto extends JPanel implements JGrille {
	private JGrilleNumeros nums;
	private JPanel buttonPanel;
	private JDialog parent;
	private int numGrille;
	private Loto loto;

	public JGrilleLoto(JDialog parent, Loto loto, int num){
		super();

		buttonPanel=new JPanel();

		this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

		TitledBorder titledBorder=BorderFactory.createTitledBorder(
				BorderFactory.createMatteBorder(3, 3, 3, 3, Color.red),
				Integer.toString(num));
		titledBorder.setTitleJustification(TitledBorder.CENTER);
		this.setBorder(titledBorder);

		nums = new JGrilleNumeros(49, 7, "Numéros");

		this.add(nums);

		this.add(buttonPanel);

		JButton button;
		buttonPanel.add(button = new JButton(new RandomAction()));
		button.setMargin(new Insets(0, 0, 0, 0));
		buttonPanel.add(button = new JButton(new ResetAction()));
		button.setMargin(new Insets(0, 0, 0, 0));
		buttonPanel.add(button = new JButton(new RechercherAction()));
		button.setMargin(new Insets(0, 0, 0, 0));
		this.parent = parent;
		this.loto = loto;
		this.numGrille = num;
	}

	public void resetGrille(){
		nums.reset();
	}

	public void randomFillGrille(){
		nums.randomFill(6);
	}

	public void search() {
		GrilleLoto g;
		try
		{
			g = new GrilleLoto(nums.getNums(),
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
			new RechercheDialog(loto.rechercheAncienResultat(g), parent);
		}
		catch (IllegalArgumentException e)
		{
			JOptionPane.showMessageDialog(parent,
					"Vous n'avez rien gagné.");
		}
	}

	@Override
	public Grille getGrille() {
		return new GrilleLoto(nums.getNums(), numGrille);
	}

	public int getNumGrille() {
		return numGrille;
	}

	public boolean isEmpty() {
		return nums.isEmpty();
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
