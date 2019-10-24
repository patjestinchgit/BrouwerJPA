package be.brouwerijen.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import be.brouwerijen.dao.BrouwerDAO;
import be.brouwerijen.entities.Brouwer;

@Service
class BrouwerServiceImpl implements BrouwerService {
	
	private BrouwerDAO brouwerDAO; 
	
	@Autowired
	public void create(BrouwerDAO brouwerdao) {
		// TODO Auto-generated method stub
		this.brouwerDAO=brouwerdao;
	}

	@Override
	public List<Brouwer> findAll() {
		// TODO Auto-generated method stub
		return brouwerDAO.findAll();
	}

	@Override
	public List<Brouwer> findByNaam(String beginnaam) {
		// TODO Auto-generated method stub
		return brouwerDAO.findByNaam(beginnaam);
	}

	@Override
	public void create(Brouwer brouwer) {
		// TODO Auto-generated method stub
		brouwerDAO.create(brouwer);
	}
	
	@Override
	public List<Brouwer> findByAlphabet(char letterURL){
		return brouwerDAO.findByAlphabet(letterURL);
	}

}
