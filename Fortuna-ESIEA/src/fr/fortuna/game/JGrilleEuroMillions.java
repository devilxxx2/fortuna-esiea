package fr.fortuna.game;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.AbstractAction;
import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JToggleButton;
import javax.swing.border.TitledBorder;

import fr.fortuna.controller.Grille;
import fr.fortuna.controller.GrilleEuroMillions;
import fr.fortuna.controller.TirageEuromillions;


public class JGrilleEuroMillions extends JPanel implements JGrille, ItemListener, ActionListener {

	private JGrilleNumeros nums;
	private JGrilleNumeros etoiles;
	private JPanel buttonPanel;
	private int numGrille;

	public JGrilleEuroMillions(int numeroGrille){
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
		
		JButton button=new JButton(new RandomAction());
		buttonPanel.add(button);

		button=new JButton(new ResetAction());
		buttonPanel.add(button);

		numGrille = numeroGrille;
	}

	public void resetGrille(){
		nums.reset();
		etoiles.reset();
	}

	public void randomFillGrille(){
		nums.randomFill(5);
		etoiles.randomFill(2);
	}
	
	@Override
	public Grille getGrille() {
		return new GrilleEuroMillions(nums.getNums(), etoiles.getNums(),
				numGrille);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub


	}

	@Override
	public void itemStateChanged(ItemEvent e) {
		// TODO Auto-generated method stub


	}

	private class RandomAction extends AbstractAction {

		public RandomAction(){
			super("Grille aléatoire");
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
}



