package be.brouwerijen.services;

import java.util.List;

import be.brouwerijen.entities.Brouwer;

public interface BrouwerService {
	void create(Brouwer brouwer);
	List<Brouwer> findAll();
	List<Brouwer> findByNaam( String beginnaam );
	List<Brouwer> findByAlphabet(char letterURL);
}
