package be.brouwerijen.services;

import java.util.List;

import be.brouwerijen.entities.Brouwer;
import be.brouwerijen.valueobjects.BrouwersOpNaam;

public interface BrouwerService {
	void create(Brouwer brouwer);
	void delete(long id);
	List<Brouwer> findAll();
	List<Brouwer> findByNaam( BrouwersOpNaam beginnaam );
	List<Brouwer> findByAlphabet(char letterURL);
	Brouwer read(long id);
	void update(Brouwer brouwer);
}
