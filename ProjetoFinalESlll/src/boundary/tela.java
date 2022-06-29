package boundary;

import java.util.Objects;

import controller.telaController;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.effect.Lighting;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
public class tela extends Application  {
	public  Stage stgStage;


   
    telaController telac = new telaController();

	private Stage stage;
    
    
     Button menuBtnPesquisarAluno = new Button("Pesquisar Alunos");
        
     Button menuBtnPesquisarDisciplina = new Button("Pesquisar Disciplinas");
        
     
   
       
    
    
   


    @Override
    public void start(Stage stage) throws Exception{
        stgStage = stage;
		GridPane menuPanePrincipal = new GridPane();

        
        menuPanePrincipal.getStylesheets().add(Objects.requireNonNull(tela.class.getResource("style.css")).toExternalForm());

        Label menuTitle = new Label("Menu portaria EMS");
        menuTitle.getStyleClass().add("titulo");
		
		
		menuBtnPesquisarAluno.setOnAction(e->{
			telac.acessaAluno();
		});
		
	
		menuBtnPesquisarDisciplina.setOnAction(e->{
			telac.acessaDisciplina();
		});
		

		menuPanePrincipal.setHgap(100);
		menuPanePrincipal.setVgap(70);
		menuPanePrincipal.add(menuTitle, 1, 1, 1, 1);
		menuPanePrincipal.add(menuBtnPesquisarAluno, 2,1);
		menuPanePrincipal.add(menuBtnPesquisarDisciplina, 2, 2);
		
		
		
		
		
		menuTitle.setEffect(new Lighting());
		
		
		Scene scn = new Scene(menuPanePrincipal, 1400, 800);
		stage.initStyle(StageStyle.UNDECORATED);
		
		stage.setScene(scn);
		stage.show();
		setStage(stage);
    }

  

	public static void main(String[] args) {
		Application.launch(tela.class, args);	}

	public  Stage getStage() {
		return stage;
	}

	public void setStage(Stage stage) {
		this.stage = stage;
	}
}