package controller;

import java.sql.SQLException;
import java.util.List;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import model.aluno;
import model.alunoBuilder;
import persistence.IAlunoDao;
import persistence.alunoDao;

public class alunoController {
	//nome ra rg
		

	  private ObservableList<aluno> alunos = FXCollections.observableArrayList();
		private TableView<aluno> tableAluno = new TableView<>();

		  
		private StringProperty nome =  new SimpleStringProperty();
		private StringProperty ra = new SimpleStringProperty();
		private StringProperty rg = new SimpleStringProperty();
		//private StringProperty setor = new SimpleStringProperty();
		//private StringProperty telefone = new SimpleStringProperty();
		

		
		private IAlunoDao ialunoDao = new alunoDao();

		
		
		
		public TableView<aluno> getTable() {
	        return tableAluno;
	    }
		
		
	    public void setEntity(aluno a) {
	        if (a != null) {
	            nome.set(a.getNome());
	           ra.set(a.getRa());
	           rg.set(a.getRg());
	            
	        }
	    }
	    
	    
		public aluno getEntityFun() {
			aluno a = new aluno();
			a.setNome(nome.get().toLowerCase());
			a.setRa(ra.get().toLowerCase());
			a.setRg(rg.get().toLowerCase());
			
			return a;
		}
			@SuppressWarnings("unchecked")
		   public alunoController() {
		        TableColumn<aluno, String> col1 = new TableColumn<>("Nome");
		       col1.setCellValueFactory(new PropertyValueFactory<>("nome"));

		        
		        TableColumn<aluno, String> col2 = new TableColumn<>("RA");
		       col2.setCellValueFactory(new PropertyValueFactory<>("ra"));

		        
		        TableColumn<aluno, String> col3 = new TableColumn<>("RG");
		        col3.setCellValueFactory(new PropertyValueFactory<>("rg"));

		        tableAluno.getColumns().addAll( col1, col2, col3);
		           

				col1.setPrefWidth(190);
				col2.setPrefWidth(190);
				col3.setPrefWidth(190);
				

				

				
				
				tableAluno.setItems(alunos);
				tableAluno.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);
				
			}
		        
		        
		        

		public void limpar() {
			nome.setValue("");
			ra.setValue("");
			rg.setValue("");
			
		}
		
		public String getNome() {
			return nome.get();
		}
		
		public StringProperty NomeProperty() {
			return nome;
		}
		
		public String getRa() {
			return ra.get();
		}
		
		public StringProperty raProperty() {
			return ra;
		}
		
		public String getRg() {
			return rg.get();
		}
		
		public StringProperty rgProperty() {
			return rg;
		}

		public void pesquisarPorNome() throws SQLException {
			 List<aluno> alnListPesquisa = ialunoDao.pesquisarPorNome(nome.get());
		      
		        alunos.clear();
		        alunos.addAll(alnListPesquisa);
		        limpar();
		    }

		


		public void adicionar() throws SQLException {
			aluno a = alunoBuilder.builder()
			.addDadosPessoais(nome.get(), rg.get())
			.addDadosInstitucionais(ra.get())
			.get();
			
		
			alunos.add(a);
			
			
	        ialunoDao.adicionar(a);
			
		}
		public void atualiza() throws SQLException {
			aluno a = new aluno();
			ialunoDao.atualiza(a);
			limpar();
		}

		
		public void delete() throws SQLException {
			aluno a = new aluno();
			ialunoDao.remove(a);
			limpar();
		}
		
	}