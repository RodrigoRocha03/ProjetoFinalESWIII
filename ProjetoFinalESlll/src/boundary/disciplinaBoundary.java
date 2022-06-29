package boundary;

import java.awt.Button;
import java.awt.TextField;
import java.util.Objects;



import controller.alunoController;
import controller.disciplinaController;
import javafx.application.Application;
import javafx.beans.binding.Bindings;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class disciplinaBoundary extends Application {

	public  Stage stgStage;

	private final 
	     TextField alnTxtNome = new TextField();
	     TextField alnTxtId = new TextField();
	     TextField alnTxtAndar = new TextField();
	     TextField alnTxtSala = new TextField();
	     
	     Button alnBtnCadastrar = new Button("Cadastrar");
	     Button alnBtnPesquisar = new Button("Pesquisar");
	     Button alnBtneditar = new Button("editar");
	     Button alnBtnremover = new Button("remover");
	     Button alnBtnInicio = new Button("Inicio");

	     Label alnLblAlunoNome = new Label("nome");
	     Label alnLblAlunoRg = new Label("rg");
	     Label alnLblAlunoRa = new Label("ra");
	     Label alnTitle = new Label("Aluno");
	    

	    private final disciplinaController alnControl = new disciplinaController();
	    
	   
	   

		@Override
		public void start(Stage stage) throws Exception {
	
			Bindings.bindBidirectional(alnTxtNome.textProperty(), alnControl.NomeProperty());
	        Bindings.bindBidirectional(alnTxtId.textProperty(), alnControl.idProperty());
	        Bindings.bindBidirectional(alnTxtAndar.textProperty(), alnControl.andarProperty());
	        Bindings.bindBidirectional(alnTxtSala.textProperty(), alnControl.salaProperty());
	        
			
	        BorderPane alnPanePrincipal = new BorderPane();
	        VBox alnPaneConteudo = new VBox();
	        GridPane alnPaneForm = new GridPane();
	        FlowPane alnPaneButton = new FlowPane();
	        alnPanePrincipal.getStylesheets().add(Objects.requireNonNull(tela.class.getResource("style.css")).toExternalForm());

	        alnTitle.getStyleClass().add("tabela de disciplinas");
	        
	        
	        
	        alnPaneForm.add(new Label("Nome:"), 0, 0);
	        alnPaneForm.add(new Label("Id:"), 0, 1);
	        alnPaneForm.add(new Label("Andar:"), 0, 2);
	        alnPaneForm.add(new Label("Sala:"), 0, 3);
	        alnPaneForm.add(alnTxtNome, 1, 0);
	        alnPaneForm.add(alnTxtId, 1, 1);
	        alnPaneForm.add(alnTxtAndar, 1, 2);
	        alnPaneForm.add(alnTxtSala, 1, 3);
	        
	        alnPaneForm.setVgap(10);
	        alnPaneForm.setHgap(5);
	        alnPaneForm.setAlignment(Pos.CENTER);

	        
	        alnPaneButton.getChildren().addAll(alnBtnCadastrar, alnBtnPesquisar, alnBtnInicio,alnBtneditar,alnBtnremover);

	        alnPaneButton.setHgap(50);
	        alnPaneButton.setVgap(25);
	        alnPaneButton.setAlignment(Pos.CENTER);

	        alnPaneConteudo.getChildren().addAll(alnTitle, alnPaneForm,alnPaneButton);
	        alnPaneConteudo.setSpacing(15);
	        alnPaneConteudo.setAlignment(Pos.CENTER);
	    	
	        alnPanePrincipal.setLeft(alnPaneConteudo);
	        alnPanePrincipal.setCenter(alnControl.getTable());
	        
	    	alnBtnCadastrar.setOnAction(e ->{
				try {
					alnControl.adicionar();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			});
			
			
			alnBtnPesquisar.setOnAction(e->{
				try {
					funControl.pesquisarPorNome();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			});
			
			alnBtneditar.setOnAction(e -> {
				try {
					funControl.atualiza();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			});
			alnBtnremover.setOnAction(e -> {
				try {
					funControl.delete();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			});

			
			alnBtnInicio.setOnAction(e ->{
				getStage().close();
			});
			
			

			
			Scene scn = new Scene(alnPanePrincipal, 1400,800);
			stage.initStyle(StageStyle.UNDECORATED);
			stage.setScene(scn);
			stage.show();
			setStage(stage);
		
	        
}




		private Stage getStage() {
			return stgStage;
		}




		private void setStage(Stage stage) {
			this.stgStage = stage;			
		}	
		
}

