package fr.fortuna.Tirage;

import java.util.List;

public class SuperLoto /* implements Jeu*/{
	private List<TirageSuperLoto> tirages;
	
	public SuperLoto(List<TirageSuperLoto> t){
		tirages=t;
	}
	
	public List<TirageSuperLoto> getTirages()
	{
		return tirages;
	}
	
	private SuperLoto(){}
}
