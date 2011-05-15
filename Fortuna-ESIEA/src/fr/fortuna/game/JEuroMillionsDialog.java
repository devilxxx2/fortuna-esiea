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
import javax.swing.JOptionPane;

import fr.fortuna.controller.Euromillions;
import fr.fortuna.controller.Grille;
import fr.fortuna.controller.GrilleEuroMillions;
import fr.fortuna.controller.TirageEuromillions;

class JEuroMillionsDialog extends JDialog
{
	JPanel mainPanel, grillePanel, buttonPanel;
	JGrilleEuroMillions[] grilles;

	public JEuroMillionsDialog(JFrame parent, Euromillions euromillions)
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
			grilles[i] = new JGrilleEuroMillions(this, euromillions, i+1);
			grillePanel.add(grilles[i]);
		}
		buttonPanel.add(new JButton(new ValiderAction()));

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
				if (!jgrille.isEmpty())
				{
					JOptionPane.showMessageDialog(this,
							"La grille " + jgrille.getNumGrille() + " est invalide");
					return;
				}
			}
		}

		//	grillesAValider.add(grilles[0].getGrille());
		//for(int i=0; i<20; i++)	{
			TirageEuromillions tirageEuro=new TirageEuromillions();
			tirageEuro.generate();

			new ResultatsDialog(tirageEuro.jouer(grillesAValider), this);
		//}
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
}
