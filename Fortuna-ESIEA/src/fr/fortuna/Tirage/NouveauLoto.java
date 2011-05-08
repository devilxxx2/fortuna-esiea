package fr.fortuna.Tirage;

import java.util.List;

public class NouveauLoto /* implements Jeu*/{
	private List<TirageNouveauLoto> tirages;
	
	public NouveauLoto(List<TirageNouveauLoto> t){
		tirages=t;
	}
	
	public List<TirageNouveauLoto> getTirages()
	{
		return tirages;
	}
	
	private NouveauLoto(){}
}
