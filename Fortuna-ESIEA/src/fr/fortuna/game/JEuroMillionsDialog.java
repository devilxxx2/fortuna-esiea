package fr.fortuna.game;

import javax.swing.JDialog;
import javax.swing.JFrame;

class JEuroMillionsDialog extends JDialog
{
	public JEuroMillionsDialog(JFrame parent)
	{
		super(parent, "Euromillions");
		setModal(false);
		setVisible(true);
		add(new JGrilleEuroMillions(2));
		pack();
	}
}
