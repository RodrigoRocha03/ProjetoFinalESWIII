package persistence;

import java.sql.SQLException;
import java.util.List;

import model.disciplina;

public interface IDisciplinaDao {

	void adicionar(disciplina d)throws SQLException;
	
	List<disciplina> pesquisarPorNome(String string)throws SQLException;
	
	void remove(disciplina disciplina)throws SQLException;
	
	void atualiza (disciplina disciplina)throws SQLException;

}
