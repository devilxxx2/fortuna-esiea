package fr.fortuna.Tirage;

import java.util.HashMap;
import java.util.Map.Entry;

public class Tirage {
	public HashMap<String,String> data;
	
	public Tirage() {
		data=new HashMap<String,String>();
	}
	
	public Tirage(HashMap<String,String> m)
	{
		data=m;
	}
	
	public String toString()
	{
		String res="";
		for(Entry<String, String> entry : data.entrySet()) {
		    String cle = entry.getKey();
		    String valeur = entry.getValue();

		    res+=cle+ ": "+ valeur + "\n";
		}
		return res;
	}
}
