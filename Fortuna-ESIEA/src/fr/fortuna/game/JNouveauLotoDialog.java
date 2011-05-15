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

import fr.fortuna.controller.NouveauLoto;
import fr.fortuna.controller.Grille;
import fr.fortuna.controller.GrilleNouveauLoto;
import fr.fortuna.controller.TirageNouveauLoto;

class JNouveauLotoDialog extends JDialog
{
	JPanel mainPanel, grillePanel, buttonPanel;
	JGrilleNouveauLoto[] grilles;
	boolean superLoto;

	public JNouveauLotoDialog(JFrame parent, NouveauLoto loto, boolean superLoto)
	{
		super(parent, "Nouveau Loto");
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

		grilles = new JGrilleNouveauLoto[5];
		for (int i = 0; i < grilles.length; ++i)
		{
			grilles[i] = new JGrilleNouveauLoto(this, loto, i+1);
			grillePanel.add(grilles[i]);
		}
		buttonPanel.add(new JButton(new ValiderAction()));

		validate();
		pack();

		this.superLoto = superLoto;
	}

	public void afficherResultat(){
		List<Grille> grillesAValider=new ArrayList<Grille>();
		for(JGrilleNouveauLoto jgrille : grilles) {
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

		if (grillesAValider.size() == 0)
		{
			JOptionPane.showMessageDialog(this,
					"Veuillez remplir au moins une grille");
			return;
		}

		//	grillesAValider.add(grilles[0].getGrille());
		//for(int i=0; i<20; i++)	{
			TirageNouveauLoto tirage = new TirageNouveauLoto();
			if (superLoto)
				tirage.generateSuperLoto();
			else
				tirage.generateLoto();

			new ResultatsDialog(tirage.jouer(grillesAValider), this);
		//}
	}

	private class ValiderAction extends AbstractAction {
		public ValiderAction(){
			super("Jouer");
		}

		@Override
		public void actionPerformed(ActionEvent actionEvent) {
			afficherResultat();
		}
	}
}
