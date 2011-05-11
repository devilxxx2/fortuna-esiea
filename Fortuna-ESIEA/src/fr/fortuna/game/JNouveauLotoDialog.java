package fr.fortuna.game;

import javax.swing.JDialog;
import javax.swing.JFrame;

class JNouveauLotoDialog extends JDialog
{
	public JNouveauLotoDialog(JFrame parent)
	{
		super(parent, "Loto");
		setModal(false);
		setVisible(true);
		add(new JGrilleNouveauLoto());
		pack();
	}
}
