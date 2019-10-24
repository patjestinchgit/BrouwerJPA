package be.brouwerijen.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

import be.brouwerijen.dao.BrouwerDAO;
import be.brouwerijen.entities.Brouwer;
import be.brouwerijen.valueobjects.BrouwersOpNaam;

@Service
@ReadOnlyTransactionalService
class BrouwerServiceImpl implements BrouwerService {
	
	private BrouwerDAO brouwerDAO; 
	
	@Autowired
	public void create(BrouwerDAO brouwerdao) {
		// TODO Auto-generated method stub
		this.brouwerDAO=brouwerdao;
	}
	
	@Override
	@ModifyingTransactionalServiceMethod
	public void delete(long id) {
		this.brouwerDAO.delete(id);
	}

	@Override
	public List<Brouwer> findAll() {
		// TODO Auto-generated method stub
		return brouwerDAO.findAll();
	}

	@Override
	public List<Brouwer> findByNaam(BrouwersOpNaam beginnaam) {
		// TODO Auto-generated method stub
		return brouwerDAO.findByNaam(beginnaam);
	}

	@Override
	@ModifyingTransactionalServiceMethod
	public void create(Brouwer brouwer) {
		// TODO Auto-generated method stub
		brouwerDAO.create(brouwer);
	}
	
	@Override
	public List<Brouwer> findByAlphabet(char letterURL){
		return brouwerDAO.findByAlphabet(letterURL);
	}

	@Override
	public Brouwer read(long id) {
		// TODO Auto-generated method stub
		return brouwerDAO.read(id);
	}

	@Override
	@ModifyingTransactionalServiceMethod
	public void update(Brouwer brouwer) {
		// TODO Auto-generated method stub
		brouwerDAO.update(brouwer);
		
	}

}
