package dailyGoal;
 
import java.awt.MouseInfo;
import java.util.ArrayList;






import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.geometry.Orientation;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ScrollPane;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;
 
public class GUI extends Application {
    
	
    public ArrayList<eventBox> eventArray = new ArrayList<eventBox>();
	public FlowPane container;
    @Override
    public void start(Stage primaryStage) {
    	HBox top = new HBox();
    	top.setStyle(
				"-fx-background-color: rgb(245,250,250);" +
				"-fx-border-width: 0.1;"
	            + "-fx-border-color: black;" );
    	top.setPrefHeight(80);
    	top.setPrefWidth(350);
    	
    	HBox bot = new HBox();
    	bot.setStyle(
				"-fx-background-color: rgb(245,250,250);" +
				"-fx-border-width: 0.1;"
	            + "-fx-border-color: black;" );
    	bot.setPrefHeight(100);
    	bot.setPrefWidth(350);
    	bot.setAlignment(Pos.CENTER);
    	
    	ScrollPane middle = new ScrollPane();
    	middle.setStyle("-fx-background-color: rgb(245,250,250);" +
				"-fx-border-width: 2;"
	            + "-fx-border-color: black;" );
    	
    	middle.setHbarPolicy(ScrollPane.ScrollBarPolicy.NEVER);
    	container = new FlowPane(Orientation.VERTICAL);
    	middle.setContent(container);
    	container.setPrefWrapLength(1000);
    	
    	//Button
    	Button newEventBtn = new Button("Create new");
    	bot.getChildren().add(newEventBtn);
    	newEventBtn.setOnAction(event-> {
    		if(this.eventArray.size()>=10) {
    			System.out.println("No more than 10 items pls");
    		} else {
    			
    			newGoalWindow window = new newGoalWindow();
    			
    			window.setX(MouseInfo.getPointerInfo().getLocation().getX()+50);
    			window.setY(MouseInfo.getPointerInfo().getLocation().getY());
    			window.showAndWait();
    			//TODO, IMPLEMENT TIME
    			if(!window.userLabel.getText().equals("")) {
    				eventBox e = new eventBox();
        			this.eventArray.add(e);
        			container.getChildren().add(e);
    			} else {
    				//Do nothing
//    				System.out.println("Manual exit, do nothing");
    			}
    			
    		}
    	});
    	
    	
    	BorderPane root = new BorderPane();
    	root.setTop(top);
    	root.setCenter(middle);
    	root.setBottom(bot);
    	primaryStage.setScene(new Scene(root, 350, 500));
        primaryStage.show();
    }
    
    public class eventBox extends VBox {
//    	double width;
//    	double height;
    	Button checkOffBtn = new Button();
    	
    	public eventBox() {
    		this.setPrefWidth(325);
    		this.setPrefHeight(100);
    		checkOffBtn.setText("Done!");
    		checkOffBtn.setOnAction(event -> {
    			container.getChildren().remove(this);
    			eventArray.remove(this);
    		});
    		checkOffBtn.setTranslateX(235);
    		checkOffBtn.setTranslateY(30);
    		this.setStyle("-fx-background-color: rgb(245,250,220);" +
    			"-fx-border-width: 2;"
                + "-fx-border-color: blue;" );
    		this.getChildren().addAll(checkOffBtn);
    	}
    }
    
    public static void main(String[] args) {
        launch(args);
       
    }
}