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

	public JEuroMillionsDialog(JFrame parent)
	{
		super(parent, "Euromillions");
		setModal(false);
		setVisible(true);


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

		grillePanel.add(new JGrilleEuroMillions(2));
		grillePanel.add(new JGrilleEuroMillions(2));
		buttonPanel.add(new JButton(new ValiderAction()));

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
			super("Valider");
		}

		@Override
		public void actionPerformed(ActionEvent arg0) {
			
			

		}

	}

}
