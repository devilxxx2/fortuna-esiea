package fr.fortuna.game;

import java.awt.Color;
import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;
import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JToggleButton;
import javax.swing.border.TitledBorder;

import fr.fortuna.controller.Grille;
import fr.fortuna.controller.GrilleNouveauLoto;
import fr.fortuna.controller.TirageNouveauLoto;


public class JGrilleNouveauLoto extends JPanel implements JGrille {
	
	private JGrilleNumeros nums;
	private JGrilleNumeros chance;
	private JPanel buttonPanel;
	
	public JGrilleNouveauLoto(){
		super();
		
		buttonPanel=new JPanel();
		
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
		
		this.add(buttonPanel);
		
		JButton button=new JButton(new RandomAction());
		buttonPanel.add(button);

		button=new JButton(new ResetAction());
		buttonPanel.add(button);
		
	}
	
	public void resetGrille(){
		
		JToggleButton[] grilleNums=nums.getGrille();
		JToggleButton[] grilleChances=chance.getGrille();

		for(int i=0; i<grilleNums.length; i++)
			((JToggleButton)grilleNums[i]).setSelected(false);
		for(int i=0; i<grilleChances.length; i++)
			((JToggleButton)grilleChances[i]).setSelected(false);
		
	}
	

	@Override
	public Grille getGrille() {
		return new GrilleNouveauLoto(nums.getNums(), chance.getNums());
	}
	
	private class RandomAction extends AbstractAction {

		public RandomAction(){
			super("Grille aléatoire");
		}

		@Override
		public void actionPerformed(ActionEvent e) {
			
			resetGrille();
			
			TirageNouveauLoto tirage=new TirageNouveauLoto();
			tirage.generate();
			int[] randomBoules=tirage.getBoules();
			int randomChances=tirage.getNumeroChance();

			JToggleButton[] grilleNums=nums.getGrille();
			JToggleButton[] grilleChances=chance.getGrille();

			for(int i=0; i<randomBoules.length;i++)
				System.out.println(randomBoules[i]+ "\n");
				System.out.println(randomChances);


			for(int i=0; i<randomBoules.length; i++)
				grilleNums[randomBoules[i]-1].setSelected(true);
				grilleChances[randomChances-1].setSelected(true);

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
