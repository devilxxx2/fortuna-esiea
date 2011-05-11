package fr.fortuna.game;

import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;

public class MainFrame extends JFrame implements ActionListener{
	private JPanel panel;

	public MainFrame(){
		super("Jeux de Loto");

		setVisible(true);
		setSize(750, 500);

		panel = new JPanel(new GridLayout(4, 1, 0, 5));

/*		setPreferredSize(new Dimension(750, 500));
		setSize(750, 500);  */
		panel.validate();
		panel.updateUI();

		createMenu();
		addButtons();

		add(panel);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setPreferredSize(new Dimension(350, 450));
		setResizable(false);
		pack();
	}

	public void addButtons(){
		JButton b=new JButton("Jouer à Euromillions");
		b.addActionListener(this);
		panel.add(b);

		b=new JButton("Jouer au Nouveau Loto");
		b.addActionListener(this);
		panel.add(b);

		b=new JButton("Règles des jeux");
		b.addActionListener(this);
		panel.add(b);
	}

	public void createMenu(){
		JMenuBar menuBar=new JMenuBar();
		JMenu menu=new JMenu("Jeux");

		JMenuItem menuItem=new JMenuItem("Euromillions");
		menuItem.addActionListener(this);
		menu.add(menuItem);

		menuItem=new JMenuItem("Nouveau Loto");
		menuItem.addActionListener(this);
		menu.add(menuItem);

		menuBar.add(menu);

		setJMenuBar(menuBar);
	}

	public void popEuroMillions(){
		new JEuroMillionsDialog(this);
	}

	public void popNouveauLoto(){
		new JNouveauLotoDialog(this);
	}

	public static void main(String[] args) {
		new MainFrame();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() instanceof JMenuItem) {
			JMenuItem item=(JMenuItem)(e.getSource());
			if ( item.getText().equals("Euromillions")){
				popEuroMillions();
			}
			if ( item.getText().equals("Nouveau Loto")){
				popNouveauLoto();
			}
		}
		if(e.getSource() instanceof JButton){
			JButton button=(JButton)(e.getSource());
			if ( button.getText().equals("Jouer à Euromillions")){
				popEuroMillions();
			}
			if ( button.getText().equals("Jouer au Nouveau Loto")){
				popNouveauLoto();
			}
		}
	}
}
