package fr.fortuna.game;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.List;

import javax.swing.AbstractAction;
import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JPanel;

import fr.fortuna.controller.Euromillions;
import fr.fortuna.controller.Grille;
import fr.fortuna.controller.GrilleEuroMillions;
import fr.fortuna.controller.TirageEuromillions;

class JEuroMillionsDialog extends JDialog
{

	JPanel mainPanel, grillePanel, buttonPanel;
	GroupLayout layout;
	JGrilleEuroMillions[] grilles;

	public JEuroMillionsDialog(JFrame parent)
	{
		super(parent, "Euromillions");
		setModal(false);
		setVisible(true);
		setResizable(false);

		mainPanel=new JPanel(new BorderLayout());
	//	layout=new GroupLayout(mainPanel);
		//	mainPanel.setLayout(layout);

		grillePanel=new JPanel();
		buttonPanel=new JPanel();

		add(mainPanel);
		
		mainPanel.add(grillePanel, BorderLayout.CENTER);
		mainPanel.add(buttonPanel, BorderLayout.SOUTH);
		 

		grilles = new JGrilleEuroMillions[5];
		for (int i = 0; i < grilles.length; ++i)
		{
			grilles[i] = new JGrilleEuroMillions(i+1);
			grillePanel.add(grilles[i]);
		}
		buttonPanel.add(new JButton(new ValiderAction()));
		buttonPanel.add(new JButton(new RechercherAction()));

		


		validate();
		pack();
	}
	
	public void afficherResultat(){
		List<Grille> grillesAValider=new ArrayList<Grille>();
		for(JGrilleEuroMillions jgrille : grilles) {
			try{
			grillesAValider.add(jgrille.getGrille());
			}
			catch(IllegalArgumentException i){
				// Si la grille soumise n'est pas correcte, on attrape l'exception.
		//		System.out.println(i.getMessage());
			}
		}

	//	grillesAValider.add(grilles[0].getGrille());
		TirageEuromillions tirageEuro=new TirageEuromillions();
		tirageEuro.generate();
		int[] bla=tirageEuro.getBoulesCroissantes();

		new ResultatsDialog(tirageEuro.jouer(grillesAValider), this);
	}

	private class ValiderAction extends AbstractAction {
		public ValiderAction(){
			super("Jouer");
		}

		@Override
		public void actionPerformed(ActionEvent actionEvent) {
			afficherResultat();
		//	Euromillions em=new Euromillions();
			
		}
	}

	private class RechercherAction extends AbstractAction {
		public RechercherAction(){
			super("Rechercher");
		}

		@Override
		public void actionPerformed(ActionEvent actionEvent) {
		}
	}

}
