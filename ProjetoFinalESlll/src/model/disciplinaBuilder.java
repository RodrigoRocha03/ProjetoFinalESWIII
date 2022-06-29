package model;

public class disciplinaBuilder {
private disciplina disciplina;
	
	public disciplinaBuilder() {
		this.disciplina = new disciplina();
		
	}
	
	public static disciplinaBuilder builder() {
		return new disciplinaBuilder();
	
	}
	
	public disciplinaBuilder addDados( String id, String nome) {
		this.disciplina.setId(id);
		this.disciplina.setNome(nome);
		return this;
	}
	
	public disciplinaBuilder addLocal(String salaDisciplina, String andarDisciplina) {
		this.disciplina.setSalaDisciplina(salaDisciplina);
		this.disciplina.setAndarDisciplina(andarDisciplina);
	return this;
	}

	public disciplina get() {
		this.disciplina = disciplina;
		return disciplina;
	}
}
