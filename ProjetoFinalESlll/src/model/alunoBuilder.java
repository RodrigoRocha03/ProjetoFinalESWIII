package model;

public class alunoBuilder {

		private aluno aluno;
		
		public alunoBuilder() {
			this.aluno = new aluno();
			
		}
		
		public static alunoBuilder builder() {
			return new alunoBuilder();
		
		}
		
		public alunoBuilder addDadosPessoais( String nome, String rg ) {
			
			this.aluno.setNome(nome);
			this.aluno.setRg(rg);
			return this;
		}
		
		public alunoBuilder addDadosInstitucionais(String ra) {
			this.aluno.setRa(ra);
		return this;
		}

		public aluno get() {
			this.aluno = aluno;
			return aluno;
		}
		

		
	}

