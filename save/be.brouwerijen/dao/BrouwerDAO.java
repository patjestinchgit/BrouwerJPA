package be.brouwerijen.dao;

import java.util.List;

import be.brouwerijen.entities.Brouwer;

public interface BrouwerDAO {
	
	void create(Brouwer Brouwer);
	List<Brouwer> findAll();
	List<Brouwer> findByNaam( String beginnaam );
	List<Brouwer> brouwersopalfabet(char startletter);
	List<Brouwer> findByAlphabet(char letterURL);
	
}
