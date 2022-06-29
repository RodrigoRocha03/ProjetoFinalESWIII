package model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import org.antlr.v4.runtime.misc.NotNull;

@Entity
@Table(name = "disciplinas")
public class disciplina {

	@Id
	@Column(name = "ID" , length = 11)
	@NotNull
	private String id = "";
	
	@Column(name = "Nome" , length = 50)
	@NotNull
	private String nome = "";
	
	@Column(name = "Sala" , length = 30)
	@NotNull
	private String salaDisciplina = "";
	
	@Column(name = "Andar" , length = 30)
	@NotNull
	private String andarDisciplina = "";
	 
	
	@Override
	public String toString() {
		return "disciplina [id=" + id + ", nome=" + nome + ", salaDisciplina=" + salaDisciplina + ", andarDisciplina="
				+ andarDisciplina + "]";
	}

	public String getSalaDisciplina() {
		return salaDisciplina;
	}

	public void setSalaDisciplina(String salaDisciplina) {
		this.salaDisciplina = salaDisciplina;
	}

	public String getAndarDisciplina() {
		return andarDisciplina;
	}

	public void setAndarDisciplina(String string) {
		this.andarDisciplina = string;
	}

	public String getId() {
		return id;
	}

	public void setId(String string) {
		this.id = string;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	
}