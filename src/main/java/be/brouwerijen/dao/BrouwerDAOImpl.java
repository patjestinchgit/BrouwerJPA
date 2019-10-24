/**
 * 
 */
package be.brouwerijen.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.IncorrectResultSizeDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;

import be.brouwerijen.entities.Brouwer;
import be.brouwerijen.valueobjects.Adres;
import be.brouwerijen.valueobjects.BrouwersOpNaam;

/**
 * @author patrick
 *
 */

@Repository
class BrouwerDAOImpl implements BrouwerDAO {
	private EntityManager entityManager;

	@PersistenceContext

	void setEntityManager(EntityManager entityManager) {

		this.entityManager = entityManager;
	}

	@Override
	public void create(Brouwer brouwer) {
		entityManager.persist(brouwer);
	}

	@Override
	public Brouwer read(long id) {
		return entityManager.find(Brouwer.class, id);
	}

	@Override
	public void update(Brouwer brouwer) {
		entityManager.merge(brouwer);

	}

	@Override
	public void delete(long id) {
		entityManager.remove(read(id));
	}

	@Override
	public List<Brouwer> findAll() {
		return entityManager.createNamedQuery("Brouwer.findAll", Brouwer.class).getResultList();
	}

	@Override
	public List<Brouwer> findByNaam(BrouwersOpNaam beginnaam) {
		// TODO Auto-generated method stub
		return entityManager.createNamedQuery("Brouwer.findByNaam", Brouwer.class).setParameter("beginnaam", beginnaam.getBeginnaam()+"%").getResultList();
	}

	@Override
	public List<Brouwer> brouwersopalfabet(char startletter) {
		// TODO Auto-generated method stub
		return entityManager.createNamedQuery("Brouwer.brouwersOpAlfabet", Brouwer.class).setParameter("startletter", startletter).getResultList();
	}

	@Override
	public List<Brouwer> findByAlphabet(char letterURL) {
		// TODO Auto-generated method stub
		return entityManager.createNamedQuery("Brouwer.findByAlphabet", Brouwer.class).setParameter("letterUrl", letterURL+"%").getResultList();
	}

}

/*
 * @Repository class BrouwerDAOImpl implements BrouwerDAO {
 * 
 * //private final Map<Long, Brouwer> brouwers = new ConcurrentHashMap<>();
 * private final JdbcTemplate jdbcTemplate; private final
 * NamedParameterJdbcTemplate namedParameterJdbcTemplate; private final
 * BrouwerRowMapper rowMapper = new BrouwerRowMapper(); private final
 * SimpleJdbcInsert simpleJdbcInsert;
 * 
 * private static final String BEGIN_SQL =
 * "select id, naam, omzet, straat, huisnr, gemeente, postcode "; private static
 * final String SQL_DELETE = "delete from brouwers where id = ?"; private static
 * final String SQL_UPDATE =
 * "update brouwers set naam=:naam, omzet=:omzet , straat=:straat, huisNr=:huisNr,"
 * + "postcode=:postcode, gemeente=:gemeente where id=:id"; private static final
 * String SQL_FIND_ALL = BEGIN_SQL + "from brouwers order by naam"; private
 * static final String SQL_FIND_ON_BEGINNAME = BEGIN_SQL +
 * "from brouwers where naam like ? order by naam"; private static final String
 * SQL_FIND_BY_LETTER = BEGIN_SQL +
 * "from brouwers where naam like ? order by naam"; private static final String
 * SQL_READ = BEGIN_SQL + "from brouwers where id = :id";
 * 
 * @Autowired BrouwerDAOImpl(JdbcTemplate jdbcTemplate,
 * NamedParameterJdbcTemplate namedParameterJdbcTemplate) { // TODO
 * Auto-generated constructor stub this.jdbcTemplate = jdbcTemplate;
 * this.namedParameterJdbcTemplate = namedParameterJdbcTemplate;
 * simpleJdbcInsert = new SimpleJdbcInsert(jdbcTemplate);
 * simpleJdbcInsert.withTableName("brouwers");
 * simpleJdbcInsert.usingGeneratedKeyColumns("id"); }
 * 
 * 
 * 
 * (non-Javadoc)
 * 
 * @see be.brouwerijen.dao.BrouwerDAO#create(be.brouwerijen.entities.Brouwer)
 * 
 * @Override public void create(Brouwer brouwer) { // TODO Auto-generated method
 * stub
 * 
 * brouwer.setId(Collections.max(brouwers.keySet()) + 1);
 * brouwers.put(brouwer.getId(), brouwer);
 * 
 * Map<String, Object> kolomWaarden = new HashMap<>(); kolomWaarden.put("naam",
 * brouwer.getNaam()); kolomWaarden.put("omzet", brouwer.getOmzet());
 * kolomWaarden.put("straat", brouwer.getAdres().getStraat());
 * kolomWaarden.put("huisNr", brouwer.getAdres().gethuisNr());
 * kolomWaarden.put("postcode", brouwer.getAdres().getPostcode());
 * kolomWaarden.put("gemeente", brouwer.getAdres().getGemeente()); Number id =
 * simpleJdbcInsert.executeAndReturnKey(kolomWaarden);
 * brouwer.setId(id.longValue());
 * 
 * }
 * 
 * @Override public void delete(long id) { // TODO Auto-generated method stub //
 * brouwers.remove(id); jdbcTemplate.update(SQL_DELETE, id); }
 * 
 * 
 * (non-Javadoc)
 * 
 * @see be.brouwerijen.dao.BrouwerDAO#findAll()
 * 
 * @Override public List<Brouwer> findAll() { // TODO Auto-generated method stub
 * // return new ArrayList<>(brouwers.values()); return
 * jdbcTemplate.query(SQL_FIND_ALL, rowMapper); }
 * 
 * 
 * (non-Javadoc)
 * 
 * @see be.brouwerijen.dao.BrouwerDAO#findByNaam(java.lang.String)
 * 
 * @Override public List<Brouwer> findByNaam(BrouwersOpNaam beginnaam) { // TODO
 * Auto-generated method stub
 * 
 * String beginnaamm = (beginnaam.getBeginnaam()).toUpperCase(); List<Brouwer>
 * result = new ArrayList<Brouwer>(); for (Brouwer brouwer : brouwers.values())
 * { System.out.println("beginnaam " + beginnaam + " brouwer " +
 * brouwer.getNaam()); if
 * (brouwer.getNaam().toUpperCase().startsWith(beginnaamm)) result.add(brouwer);
 * } return result;
 * 
 * Map<String, Object> parameters = new HashMap<>(); parameters.put("beginnaam",
 * beginnaam.getBeginnaam()+'%'); //return
 * namedParameterJdbcTemplate.query(SQL_FIND_ON_BEGINNAME, parameters,
 * rowMapper); return jdbcTemplate.query(SQL_FIND_ON_BEGINNAME, rowMapper,
 * beginnaam.getBeginnaam()+'%'); }
 * 
 * @Override public List<Brouwer> brouwersopalfabet(char startletter) { // TODO
 * Auto-generated method stub
 * 
 * return null; }
 * 
 * @Override public List<Brouwer> findByAlphabet(char letterURL) { // TODO
 * Auto-generated method stub
 * 
 * Map<String, Object> parameters = new HashMap<>(); parameters.put("naam",
 * letterURL); System.out.println("letterul "+letterURL+" parameters "+
 * parameters.toString()+
 * " ");//+namedParameterJdbcTemplate.query(SQL_FIND_BY_LETTER, parameters,
 * rowMapper)); return jdbcTemplate.query(SQL_FIND_BY_LETTER, rowMapper,
 * Character.toString(letterURL)+'%');
 * 
 * 
 * List<Brouwer> resultalphabet = new ArrayList<Brouwer>(); for (Brouwer brouwer
 * : brouwers.values()) {
 * 
 * String brouwerijnaam = brouwer.getNaam().toUpperCase();
 * 
 * char beginnaam = brouwerijnaam.charAt(0); System.out.println("letterUrl " +
 * letterURL + " beginnaam " + beginnaam + " Brouwer " + brouwer.getNaam() + " "
 * + brouwerijnaam); if (beginnaam == letterURL) resultalphabet.add(brouwer);
 * brouwerijnaam = brouwerijnaam.toLowerCase(); beginnaam =
 * brouwerijnaam.charAt(0); System.out.println("letterUrl " + letterURL +
 * " beginnaam " + beginnaam + " Brouwer " + brouwer.getNaam() + " " +
 * brouwerijnaam); if (beginnaam == letterURL) resultalphabet.add(brouwer); }
 * 
 * 
 * 
 * for(int a=0; a<brouwers.size(); a++)
 * System.out.println("brouwers "+resultalphabet.get(a).getNaam());
 * 
 * }
 * 
 * @Override public Brouwer read(long id) { // TODO Auto-generated method stub
 * // return brouwers.get(id); Map<String, Long> parameters =
 * Collections.singletonMap("id", id); try { return
 * namedParameterJdbcTemplate.queryForObject(SQL_READ, parameters, rowMapper); }
 * catch (IncorrectResultSizeDataAccessException ex) { return null; // record
 * niet gevonden } }
 * 
 * @Override public void update(Brouwer brouwer) { // TODO Auto-generated method
 * stub
 * 
 * System.out.println("brouwer ge update lijn 117 " + brouwer.getNaam());
 * brouwers.put(brouwer.getId(), brouwer);
 * 
 * System.out.println("brouwer id "+ brouwer.getId()); Map<String, Object>
 * parameters = new HashMap<>(); parameters.put("id", brouwer.getId());
 * parameters.put("naam", brouwer.getNaam()); parameters.put("omzet",
 * brouwer.getOmzet()); parameters.put("straat",
 * brouwer.getAdres().getStraat()); parameters.put("huisNr",
 * brouwer.getAdres().gethuisNr()); parameters.put("postcode",
 * brouwer.getAdres().getPostcode()); parameters.put("gemeente",
 * brouwer.getAdres().getGemeente());
 * namedParameterJdbcTemplate.update(SQL_UPDATE, parameters);
 * 
 * }
 * 
 * private static class BrouwerRowMapper implements RowMapper<Brouwer> {
 * 
 * @Override public Brouwer mapRow(ResultSet resultSet, int rowNum) throws
 * SQLException { return new Brouwer(resultSet.getLong("id"),
 * resultSet.getString("naam"), resultSet.getBigDecimal("omzet"), new
 * Adres(resultSet.getString("straat"), resultSet.getString("huisNr"),
 * resultSet.getInt("postcode"), resultSet.getString("gemeente"))); } }
 * 
 * }
 */