package fr.fortuna.Tirage;

import java.util.HashMap;
import java.util.Map.Entry;

public class Tirage {
	private HashMap<String,String> data;
	
	public String type;
	
	private Tirage() {
		data=new HashMap<String,String>();
	}
	
	public Tirage(String t){
		this();
		type=t;
	}
	
	public Tirage(String t,HashMap<String,String> m)
	{
		this(t);
		data=m;
	}
	
	public String toString()
	{
		String res=type + "\n";
		for(Entry<String, String> entry : data.entrySet()) {
		    String cle = entry.getKey();
		    String valeur = entry.getValue();

		    res+=cle+ ": "+ valeur + "\n";
		}
		return res;
	}
	
	public String getValue(String title)
	{
		for(Entry<String, String> entry : data.entrySet()) {
		    String cle = entry.getKey();
		    String valeur = entry.getValue();
		    
		    if(title.equals(cle))
		    {
		    	return valeur;			
		    }
		  
		}
		
	    return "";
	}
	
	public String getType()
	{
		return type;
	}
	
	public boolean matchesWith(String titles,String values)
	{
		String[] t=new String[1];
		String[] v=new String[1];
		
		t[0]=titles;
		v[0]=values;
		
		return matchesWith(t,v);
	}
	
	public boolean matchesWith(String[] titles,String[] values)
	{
		if(titles.length==values.length)
		{
			boolean res=true;
			
			for(int i=0;i<titles.length && res==true;i++)
			{
				for(Entry<String, String> entry : data.entrySet()) {
				    String cle = entry.getKey();
				    String valeur = entry.getValue();
				    
				    if(titles[i].equals(cle))
				    {
				    	if(!values[i].equals(valeur))
				    		res=false;			
				    }
				    	
				}
			}
			
			return res;
		}
		else
			return false;
	}
}
