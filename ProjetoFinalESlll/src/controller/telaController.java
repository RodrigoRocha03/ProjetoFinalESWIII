package controller;

import boundary.alunoBoundary;
import boundary.disciplinaBoundary;
import javafx.stage.Stage;

public class telaController {
	alunoBoundary aluno = new alunoBoundary();
	disciplinaBoundary disciplina = new disciplinaBoundary();
	
	
	public void acessaAluno() {
		try {
			aluno.start(new Stage());
		}catch(Exception e3) {
			e3.printStackTrace();
		}
	}
	
	
	
	public void acessaDisciplina() {
		try {
			disciplina.start(new Stage());
		}catch(Exception e5) {
			e5.printStackTrace();
		}
	}
}
