package model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.antlr.v4.runtime.misc.NotNull;

@Entity
@Table(name = "Alunos")
public class aluno {

	@Column(name = "Nome" , length = 50)
	@NotNull
	private String nome = "";
	
	@Id
	@Column(name = "RA" , length = 13)
	@NotNull
	private String ra = "";
	
	@Column(name = "RG" , length = 10)
	@NotNull
	private String rg = "";

	@Override
	public String toString() {
		return "aluno [nome=" + nome + ", ra=" + ra + ", rg=" + rg + "]";
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getRa() {
		return ra;
	}

	public void setRa(String ra) {
		this.ra = ra;
	}

	public String getRg() {
		return rg;
	}

	public void setRg(String rg) {
		this.rg = rg;
	}

}