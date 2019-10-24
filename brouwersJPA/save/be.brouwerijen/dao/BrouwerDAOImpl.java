/**
 * 
 */
package be.brouwerijen.dao;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import org.springframework.stereotype.Repository;

import be.brouwerijen.entities.Brouwer;
import be.brouwerijen.valueobjects.Adres;

/**
 * @author patrick
 *
 */
@Repository
class BrouwerDAOImpl implements BrouwerDAO {

	private final Map<Long, Brouwer> brouwers = new ConcurrentHashMap<>();
	
	BrouwerDAOImpl() {
		// TODO Auto-generated constructor stub
		brouwers.put(1L, new Brouwer(1L,"brouwer1",1,new Adres("straat1","1",1,"gemeente1")));
		brouwers.put(2L, new Brouwer(2L,"brouwer2",2,new Adres("straat2","2",2,"gemeente2")));
		brouwers.put(3L, new Brouwer(3L,"brouwer3",3,new Adres("straat3","3",3,"gemeente3")));
		brouwers.put(4L, new Brouwer(4L,"brouwer4",4,new Adres("straat4","4",4,"gemeente4")));
	}

	/* (non-Javadoc)
	 * @see be.brouwerijen.dao.BrouwerDAO#create(be.brouwerijen.entities.Brouwer)
	 */
	@Override
	public void create(Brouwer brouwer) {
		// TODO Auto-generated method stub
		brouwer.setBrouwerNr(Collections.max(brouwers.keySet())+1);
		brouwers.put(brouwer.getBrouwerNr(), brouwer);
	}

	/* (non-Javadoc)
	 * @see be.brouwerijen.dao.BrouwerDAO#findAll()
	 */
	@Override
	public List<Brouwer> findAll() {
		// TODO Auto-generated method stub
		return new ArrayList<>(brouwers.values());
	}

	/* (non-Javadoc)
	 * @see be.brouwerijen.dao.BrouwerDAO#findByNaam(java.lang.String)
	 */
	@Override
	public List<Brouwer> findByNaam(String beginnaam) {
		// TODO Auto-generated method stub
		beginnaam= beginnaam.toUpperCase();
		List<Brouwer> result= new ArrayList<Brouwer>();
		for(Brouwer brouwer: brouwers.values()) {
			if(brouwer.getNaam().toUpperCase().startsWith(beginnaam)) result.add(brouwer);
		}
		return result;
	}

	@Override
	public List<Brouwer> brouwersopalfabet(char startletter) {
		// TODO Auto-generated method stub
		
		
		return null;
	}

	@Override
	public List<Brouwer> findByAlphabet(char letterURL) {
		// TODO Auto-generated method stub
		List<Brouwer> resultalphabet= new ArrayList<Brouwer>();
		for (Brouwer brouwer: brouwers.values()) {
			
			String brouwerijnaam= brouwer.getNaam().toUpperCase();
			
			char beginnaam= brouwerijnaam.charAt(0);
			System.out.println("letterUrl "+letterURL+" beginnaam "+beginnaam+" Brouwer "+brouwer.getNaam()+" "+brouwerijnaam);
			if(beginnaam== letterURL) resultalphabet.add(brouwer);
			brouwerijnaam= brouwerijnaam.toLowerCase();
			beginnaam= brouwerijnaam.charAt(0);
			System.out.println("letterUrl "+letterURL+" beginnaam "+beginnaam+" Brouwer "+brouwer.getNaam()+" "+brouwerijnaam);
			if(beginnaam== letterURL) resultalphabet.add(brouwer);
		}
		
		/*
		 * for(int a=0; a<brouwers.size(); a++)
		 * System.out.println("brouwers "+resultalphabet.get(a).getNaam());
		 */
		
		return resultalphabet;
	}

}
