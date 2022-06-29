package persistence;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import org.hibernate.SessionFactory;
import model.disciplina;

public class disciplinaDao implements IDisciplinaDao{

	private SessionFactory sf;
	
	public disciplinaDao(SessionFactory sf) {
		this.sf = sf;
	}
	public disciplinaDao() {
		
	}

	@Override
	public void adicionar(disciplina d) throws SQLException {
		EntityManager entityManager = sf.createEntityManager();
		EntityTransaction transaction = entityManager.getTransaction();
		transaction.begin();
		entityManager.persist(d);
		transaction.commit();
	}

	@Override
	public void atualiza(disciplina d) throws SQLException {
		EntityManager entityManager = sf.createEntityManager();
		EntityTransaction transaction = entityManager.getTransaction();
		transaction.begin();
		entityManager.merge(d);
		transaction.commit();
	}

	@Override
	public void remove(disciplina d) throws SQLException {
		String sql = "DELETE FROM disciplina WHERE id = ?";
		EntityManager entityManager = sf.createEntityManager();
		EntityTransaction transaction = entityManager.getTransaction();
		transaction.begin();
		Query query = entityManager.createNativeQuery(sql);
		query.setParameter(1, d.getId());
		query.executeUpdate();
		transaction.commit();		
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<disciplina> pesquisarPorNome(String d1)throws SQLException {
		List<disciplina> d = new ArrayList<disciplina>();
		String sql = "SELECT * FROM disciplina WHERE cpf = ?";
		EntityManager entityManager = sf.createEntityManager();
		d = (List<disciplina>) entityManager.find(disciplina.class, d1);
		Query query = entityManager.createNativeQuery(sql);
		List<Object[]> listDisciplina = query.getResultList();
		for (Object[] linha : listDisciplina) {
			disciplina d2 = new disciplina();
			d2.setId(linha[1].toString());
			d2.setNome(linha[2].toString());
			d2.setAndarDisciplina(linha[3].toString());
			d2.setSalaDisciplina(linha[4].toString());
			
		
			
			d.add(d2);
		}
		return d;
	}

}