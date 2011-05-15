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

import fr.fortuna.controller.Euromillions;
import fr.fortuna.controller.NouveauLoto;
import fr.fortuna.controller.Loto;
import fr.fortuna.dao.EuromillionsCsvTirageDAO;
import fr.fortuna.dao.NouveauLotoCsvTirageDAO;
import fr.fortuna.dao.LotoCsvTirageDAO;
import fr.fortuna.dao.SuperLotoCsvTirageDAO;
import fr.fortuna.game.charts.StatChartNumeros;

import java.io.File;

public class MainFrame extends JFrame implements ActionListener{
	private JPanel panel;
	private Euromillions euromillions;
	private NouveauLoto nouveauloto;
	private NouveauLoto nouveausuperloto;
	private Loto loto;
	private Loto superloto;

	public MainFrame(){
		super("Jeux de Loto");

		File csv=new File("CSV Files/euromillions.csv");
		EuromillionsCsvTirageDAO te = new EuromillionsCsvTirageDAO(csv);
		euromillions = new Euromillions(te.loadAllTirages());

		csv=new File("CSV Files/nouveau_loto.csv");
		NouveauLotoCsvTirageDAO tnl = new NouveauLotoCsvTirageDAO(csv);
		nouveauloto = new NouveauLoto(tnl.loadAllTirages());

		csv=new File("CSV Files/nouveau_superloto.csv");
		NouveauLotoCsvTirageDAO tnsl = new NouveauLotoCsvTirageDAO(csv);
		nouveausuperloto = new NouveauLoto(tnsl.loadAllTirages());

		csv=new File("CSV Files/loto.csv");
		LotoCsvTirageDAO tl = new LotoCsvTirageDAO(csv);
		loto = new Loto(tl.loadAllTirages());

		csv=new File("CSV Files/sloto.csv");
		SuperLotoCsvTirageDAO tsl = new SuperLotoCsvTirageDAO(csv);
		superloto = new Loto(tsl.loadAllTirages());

		panel = new JPanel(new GridLayout(7, 1, 0, 5));

		panel.validate();
		panel.updateUI();

		createMenu();
		addButtons();

		add(panel);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setPreferredSize(new Dimension(350, 450));
		setResizable(false);
		setVisible(true);
		pack();
	}

	public void addButtons(){
		JButton b=new JButton("Jouer à Euromillions");
		b.addActionListener(this);
		panel.add(b);

		b=new JButton("Jouer au Nouveau Loto");
		b.addActionListener(this);
		panel.add(b);

		b=new JButton("Jouer au Nouveau SuperLoto");
		b.addActionListener(this);
		panel.add(b);

		b=new JButton("Jouer au Loto");
		b.addActionListener(this);
		panel.add(b);

		b=new JButton("Jouer au SuperLoto");
		b.addActionListener(this);
		panel.add(b);

		b=new JButton("Règles des jeux");
		b.addActionListener(this);
		panel.add(b);

		b=new JButton("Statistiques du Loto");
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

		menuItem=new JMenuItem("Nouveau SuperLoto");
		menuItem.addActionListener(this);
		menu.add(menuItem);

		menuItem=new JMenuItem("Loto");
		menuItem.addActionListener(this);
		menu.add(menuItem);

		menuBar.add(menu);

		setJMenuBar(menuBar);
	}

	public void popEuroMillions(){
		new JEuroMillionsDialog(this, euromillions);
	}

	public void popNouveauLoto(){
		new JNouveauLotoDialog(this, nouveauloto, false);
	}

	public void popNouveauSuperLoto(){
		new JNouveauLotoDialog(this, nouveausuperloto, true);
	}

	public void popLoto(){
		new JLotoDialog(this, loto);
	}

	public void popSuperLoto(){
		new JLotoDialog(this, superloto);
	}

	public static void main(String[] args) {
		new MainFrame();
	}

	@Override
	public void actionPerformed(ActionEvent e) {

		if ( e.getActionCommand().equals("Euromillions") || e.getActionCommand().equals("Jouer à Euromillions")){
			popEuroMillions();
		}
		if ( e.getActionCommand().equals("Nouveau Loto") || e.getActionCommand().equals("Jouer au Nouveau Loto")){
			popNouveauLoto();
		}
		if ( e.getActionCommand().equals("Loto") || e.getActionCommand().equals("Jouer au Loto")){
			popLoto();
		}
		if ( e.getActionCommand().equals("Jouer au Nouveau SuperLoto")){
			popNouveauSuperLoto();
		}
		if ( e.getActionCommand().equals("Jouer au SuperLoto")){
			popSuperLoto();
		}
		if( e.getActionCommand().equals("Statistiques du Loto")){
			new StatsGeneralesDialog(this, "Statistiques générales", new StatChartNumeros("Stats numero", true));
		}
		
		
	}
}
