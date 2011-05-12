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

	}

	public void resetGrille(){
		
		JToggleButton[] grilleNums=nums.getGrille();
		JToggleButton[] grilleStars=etoiles.getGrille();

		for(int i=0; i<grilleNums.length; i++)
			((JToggleButton)grilleNums[i]).setSelected(false);
		for(int i=0; i<grilleStars.length; i++)
			((JToggleButton)grilleStars[i]).setSelected(false);
		
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

	private class RandomAction extends AbstractAction {

		public RandomAction(){
			super("Grille aléatoire");
		}

		@Override
		public void actionPerformed(ActionEvent e) {
			
			resetGrille();
			
			TirageEuromillions tirage=new TirageEuromillions();
			tirage.generate();
			int[] randomBoules=tirage.getBoules();
			int[] randomStars=tirage.getEtoiles();

			JToggleButton[] grilleNums=nums.getGrille();
			JToggleButton[] grilleStars=etoiles.getGrille();

			for(int i=0; i<randomBoules.length;i++)
				System.out.println(randomBoules[i]+ "\n");
			for(int i=0; i<randomStars.length;i++)
				System.out.println(randomStars[i]);


			for(int i=0; i<randomBoules.length; i++)
				grilleNums[randomBoules[i]-1].setSelected(true);
			for(int i=0; i<randomStars.length; i++)
				grilleStars[randomStars[i]-1].setSelected(true);

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



