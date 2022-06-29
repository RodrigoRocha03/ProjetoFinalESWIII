package persistence;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import org.hibernate.SessionFactory;

import model.aluno;

public class alunoDao implements IAlunoDao{

	private SessionFactory sf;
	
	public alunoDao(SessionFactory sf) {
		this.sf = sf;
	}
	public alunoDao() {
		
	}

	@Override
	public void adicionar(aluno a) throws SQLException {
		EntityManager entityManager = sf.createEntityManager();
		EntityTransaction transaction = entityManager.getTransaction();
		transaction.begin();
		entityManager.persist(a);
		transaction.commit();
	}

	@Override
	public void atualiza(aluno a) throws SQLException {
		EntityManager entityManager = sf.createEntityManager();
		EntityTransaction transaction = entityManager.getTransaction();
		transaction.begin();
		entityManager.merge(a);
		transaction.commit();
	}

	@Override
	public void remove(aluno a) throws SQLException {
		String sql = "DELETE FROM aluno WHERE ra = ?";
		EntityManager entityManager = sf.createEntityManager();
		EntityTransaction transaction = entityManager.getTransaction();
		transaction.begin();
		Query query = entityManager.createNativeQuery(sql);
		query.setParameter(1, a.getRa());
		query.executeUpdate();
		transaction.commit();		
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<aluno> pesquisarPorNome(String a1)throws SQLException {
		List<aluno> a = new ArrayList<aluno>();
		String sql = "SELECT * FROM aluno WHERE cpf = ?";
		EntityManager entityManager = sf.createEntityManager();
		a = (List<aluno>) entityManager.find(aluno.class, a1);
		Query query = entityManager.createNativeQuery(sql);
		List<Object[]> listFuncioanrio = query.getResultList();
		for (Object[] linha : listFuncioanrio) {
			aluno a2 = new aluno();
			a2.setRa(linha[1].toString());
			a2.setNome(linha[2].toString());
			a2.setRg(linha[3].toString());
			
			
		
			
			a.add(a2);
		}
		return a;
	}

}