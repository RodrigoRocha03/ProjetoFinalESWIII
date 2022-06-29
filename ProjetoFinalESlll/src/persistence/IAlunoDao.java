package persistence;

import java.sql.SQLException;
import java.util.List;

import model.aluno;

public interface IAlunoDao {

	void adicionar(aluno a)throws SQLException;
	
	List<aluno> pesquisarPorNome(String string)throws SQLException;
	
	void remove(aluno aluno)throws SQLException;
	
	void atualiza (aluno aluno)throws SQLException;

}
