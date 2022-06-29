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
import model.disciplina;
import model.disciplinaBuilder;
import persistence.IDisciplinaDao;
import persistence.disciplinaDao;

public class disciplinaController {
	//nome ra rg
		

	  private ObservableList<disciplina> disciplinas = FXCollections.observableArrayList();
		private TableView<disciplina> tableDisciplina = new TableView<>();

		  
		private StringProperty nome =  new SimpleStringProperty();
		private StringProperty id = new SimpleStringProperty();
		private StringProperty sala = new SimpleStringProperty();
		private StringProperty andar = new SimpleStringProperty();
		

		
		private IDisciplinaDao idisciplinaDao = new disciplinaDao();

		
		
		
		public TableView<disciplina> getTable() {
	        return tableDisciplina;
	    }
		
		
	    public void setEntity(disciplina d) {
	        if (d != null) {
	            nome.set(d.getNome());
	             id.set(d.getId());
	           sala.set(d.getSalaDisciplina());
	           andar.set(d.getAndarDisciplina());
	            
	        }
	    }
	    
	    
		public disciplina getEntityFun() {
			disciplina d = new disciplina();
			d.setNome(nome.get().toLowerCase());
			d.setId(id.get().toLowerCase());
			d.setAndarDisciplina(andar.get().toLowerCase());
            d.setSalaDisciplina(sala.get().toLowerCase());
			
			return d;
			
			
		}
			@SuppressWarnings("unchecked")
		   public disciplinaController() {
		        TableColumn<disciplina, String> col1 = new TableColumn<>("Nome");
		       col1.setCellValueFactory(new PropertyValueFactory<>("nome"));

		        
		        TableColumn<disciplina, String> col2 = new TableColumn<>("ID");
		       col2.setCellValueFactory(new PropertyValueFactory<>("id"));

		        
		        TableColumn<disciplina, String> col3 = new TableColumn<>("Sala");
		        col3.setCellValueFactory(new PropertyValueFactory<>("sala"));

		        TableColumn<disciplina, String> col4 = new TableColumn<>("Andar");
		        col3.setCellValueFactory(new PropertyValueFactory<>("andar"));
		        
		        tableDisciplina.getColumns().addAll( col1, col2, col3, col4);
		           

				col1.setPrefWidth(190);
				col2.setPrefWidth(190);
				col3.setPrefWidth(190);
				

				

				
				
				tableDisciplina.setItems(disciplinas);
				tableDisciplina.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);
				
			}
		        
		        
		        

		public void limpar() {
			nome.setValue("");
			id.setValue("");
			andar.setValue("");
			sala.setValue("");
		}
		
		public String getNome() {
			return nome.get();
		}
		
		public StringProperty NomeProperty() {
			return nome;
		}
		
		public String getId() {
			return id.get();
		}
		
		public StringProperty idProperty() {
			return id;
		}
		
		public String getAndar() {
			return andar.get();
		}
		
		public StringProperty andarProperty() {
			return andar;
		}

		public String getSala() {
			return sala.get();
		}
		
		public StringProperty salaProperty() {
			return sala;
		}
		
		public void pesquisarPorNome() throws SQLException {
			 List<disciplina> disListPesquisa = idisciplinaDao.pesquisarPorNome(nome.get());
		      
		        disciplinas.clear();
		        disciplinas.addAll(disListPesquisa);
		        limpar();
		    }

		


		public void adicionar() throws SQLException {
			disciplina d = disciplinaBuilder.builder()
			.addDados(getId(), getNome())
			.addLocal(getSala(), getAndar())
			.get();
			
		
			disciplinas.add(d);
			
			
	        idisciplinaDao.adicionar(d);
			
		}
		public void atualiza() throws SQLException {
			disciplina d = new disciplina();
			idisciplinaDao.atualiza(d);
			limpar();
		}

		
		public void delete() throws SQLException {
			disciplina d = new disciplina();
			idisciplinaDao.remove(d);
			limpar();
		}
		
	}