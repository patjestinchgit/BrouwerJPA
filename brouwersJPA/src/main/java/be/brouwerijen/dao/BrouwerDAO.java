package be.brouwerijen.dao;

import java.util.List;

import be.brouwerijen.entities.Brouwer;
import be.brouwerijen.valueobjects.BrouwersOpNaam;

public interface BrouwerDAO {
	
	void create(Brouwer Brouwer);
	void delete(long id);
	List<Brouwer> findAll();
	List<Brouwer> findByNaam( BrouwersOpNaam beginnaam );
	List<Brouwer> brouwersopalfabet(char startletter);
	List<Brouwer> findByAlphabet(char letterURL);
	Brouwer read(long id);
	void update(Brouwer brouwer);
	
}
