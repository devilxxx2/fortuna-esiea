package fr.fortuna.game;

import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;
import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JPanel;

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

		mainPanel=new JPanel();
		layout=new GroupLayout(mainPanel);
		//	mainPanel.setLayout(layout);

		grillePanel=new JPanel();
		buttonPanel=new JPanel();

		add(mainPanel);
		/*
		mainPanel.add(grillePanel);
		mainPanel.add(buttonPanel);
		 */

		grilles = new JGrilleEuroMillions[5];
		for (int i = 0; i < grilles.length; ++i)
		{
			grilles[i] = new JGrilleEuroMillions(i+1);
			grillePanel.add(grilles[i]);
		}
		buttonPanel.add(new JButton(new ValiderAction()));
		buttonPanel.add(new JButton(new RechercherAction()));

		layout.setAutoCreateGaps(true);
		layout.setAutoCreateContainerGaps(true);

		layout.setVerticalGroup(
				layout.createSequentialGroup()
				.addGroup(layout.createParallelGroup()
						.addComponent(grillePanel)
						.addComponent(buttonPanel)
				)
		);


		validate();
		pack();
	}

	private class ValiderAction extends AbstractAction {
		public ValiderAction(){
			super("Jouer");
		}

		@Override
		public void actionPerformed(ActionEvent arg0) {
		}
	}

	private class RechercherAction extends AbstractAction {
		public RechercherAction(){
			super("Rechercher");
		}

		@Override
		public void actionPerformed(ActionEvent arg0) {
		}
	}

}
