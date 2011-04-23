package fr.fortuna.dao;

import fr.fortuna.Tirage.Tirage;
import java.util.List;

public interface TirageDAO {

	List<Tirage> loadAllTirages();

}
