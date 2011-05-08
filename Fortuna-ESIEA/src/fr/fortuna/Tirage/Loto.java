package fr.fortuna.Tirage;

import java.util.List;

public class Loto /* implements Jeu*/{
	private List<TirageLoto> tirages;
	
	public Loto(List<TirageLoto> t){
		tirages=t;
	}
	
	public List<TirageLoto> getTirages()
	{
		return tirages;
	}
	
	private Loto(){}
}
