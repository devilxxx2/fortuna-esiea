package fr.fortuna.Tirage;

import java.util.List;

public class NouveauSuperLoto /* implements Jeu*/{
	private List<TirageNouveauSuperLoto> tirages;
	
	public NouveauSuperLoto(List<TirageNouveauSuperLoto> t){
		tirages=t;
	}
	
	public List<TirageNouveauSuperLoto> getTirages()
	{
		return tirages;
	}
	
	private NouveauSuperLoto(){}
}
