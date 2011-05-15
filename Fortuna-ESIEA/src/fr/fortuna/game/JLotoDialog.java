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

import fr.fortuna.controller.Loto;
import fr.fortuna.controller.Grille;
import fr.fortuna.controller.GrilleLoto;
import fr.fortuna.controller.TirageLoto;

class JLotoDialog extends JDialog
{
	JPanel mainPanel, grillePanel, buttonPanel;
	JGrilleLoto[] grilles;

	public JLotoDialog(JFrame parent, Loto loto)
	{
		super(parent, "Loto");
		setModal(false);
		setVisible(true);
		setResizable(false);

		mainPanel=new JPanel(new BorderLayout());

		grillePanel=new JPanel();

		add(mainPanel);

		mainPanel.add(grillePanel, BorderLayout.CENTER);

		grilles = new JGrilleLoto[5];
		for (int i = 0; i < grilles.length; ++i)
		{
			grilles[i] = new JGrilleLoto(this, loto, i+1);
			grillePanel.add(grilles[i]);
		}

		validate();
		pack();
	}
}
