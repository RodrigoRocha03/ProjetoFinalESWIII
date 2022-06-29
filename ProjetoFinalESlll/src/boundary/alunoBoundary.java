package boundary;

import java.awt.Button;
import java.awt.TextField;
import java.util.Objects;
import controller.alunoController;
import javafx.application.Application;
import javafx.beans.binding.Bindings;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class alunoBoundary extends Application {

	private  Stage stgStage;

	private final TextField alnTxtNome = new TextField();
	private final TextField alnTxtnome = new TextField();
	private final TextField alnTxtRa = new TextField();
	private final TextField alnTxtRg = new TextField();

	private final Button alnBtnCadastrar = new Button("Cadastrar");
	private final Button alnBtnPesquisar = new Button("Pesquisar");
	private final Button alnBtneditar = new Button("editar");
	private final Button alnBtnremover = new Button("remover");
	private final Button alnBtnInicio = new Button("Inicio");

	     Label alnLblAlunonome = new Label("nome");
	     Label alnLblAlunorg = new Label("rg");
	     Label alnLblAlunora = new Label("ra");
	     Label alnTitle = new Label("Alunos");
	    

	    private final alunoController alnControl = new alunoController();
	     

		@Override
		public void start(Stage stage) throws Exception {
	
			Bindings.bindBidirectional(alnControl.NomeProperty(), alnTxtNome.textProperty() );
	        Bindings.bindBidirectional(alnControl.raProperty(), alnTxtRa.textProperty());
	        Bindings.bindBidirectional(alnControl.rgProperty(), alnTxtRg.textProperty());
	        
			
	        BorderPane alnPanePrincipal = new BorderPane();
	        VBox alnPaneConteudo = new VBox();
	        GridPane alnPaneForm = new GridPane();
	        FlowPane alnPaneButton = new FlowPane();
	        alnPanePrincipal.getStylesheets().add(Objects.requireNonNull(tela.class.getResource("style.css")).toExternalForm());

	        alnTitle.getStyleClass().add("tabela de alunos");
	        
	        
	        
	        alnPaneForm.add(new Label("Nome:"), 0, 0);
	        alnPaneForm.add(new Label("Ra:"), 0, 1);
	        alnPaneForm.add(new Label("Rg:"), 0, 2);
	        alnPaneForm.add(alnTxtnome, 1, 0);
	        alnPaneForm.add(alnTxtRa, 1, 1);
	        alnPaneForm.add(alnTxtRg, 1, 2);
	        
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
