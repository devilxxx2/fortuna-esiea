package fr.fortuna.game;

import javax.swing.JDialog;
import javax.swing.JFrame;

class JLotoDialog extends JDialog
{
	public JLotoDialog(JFrame parent)
	{
		super(parent, "Loto");
		setModal(false);
		setVisible(true);
		add(new JGrilleLoto());
		pack();
	}
}
