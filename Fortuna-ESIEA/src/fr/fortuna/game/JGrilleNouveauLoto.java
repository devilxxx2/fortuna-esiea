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
		nums.reset();
		chance.reset();
	}

	public void randomFillGrille(){
		nums.randomFill(5);
		chance.randomFill(1);
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
