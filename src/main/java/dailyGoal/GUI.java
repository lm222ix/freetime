package dailyGoal;
 
import java.awt.MouseInfo;
import java.text.DateFormat;
import java.util.ArrayList;







import java.util.Calendar;
import java.util.Date;

import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Orientation;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;
import javafx.util.Duration;
 
public class GUI extends Application {
    
	public newGoalWindow window;
	public BorderPane root;
	public ScrollPane middle;
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
    	
    	middle = new ScrollPane();
    	middle.setStyle("-fx-background-color: rgb(245,250,250);" +
				"-fx-border-width: 2;"
	            + "-fx-border-color: black;" );
    	middle.setHbarPolicy(ScrollPane.ScrollBarPolicy.NEVER);
    	middle.setVbarPolicy(ScrollPane.ScrollBarPolicy.NEVER);
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
    			
    			window = new newGoalWindow();
    			window.setX(MouseInfo.getPointerInfo().getLocation().getX()-100);
    			window.setY(MouseInfo.getPointerInfo().getLocation().getY()-400);
    			window.showAndWait();
    			
    			if(window.flag) {
    				if(window.userLabel == null || window.userLabel.getLength() == 0) {
    					System.out.println("Label is null or empty");
    				} else if(window.tp.equals(null)) {
    					System.out.println("Time is not set correctly");
    				} else {
    					eventBox e = new eventBox();
            			this.eventArray.add(e);
            			container.getChildren().add(e);
            			if(eventArray.size()>=4) {
            				middle.setVbarPolicy(ScrollPane.ScrollBarPolicy.ALWAYS);
            			}
    				}
    				
        				
    			} else {
    				//Do nohting, window Xed out
    			}
    		}
    	});
    	
    	
    	root = new BorderPane();
    	root.setTop(top);
    	root.setCenter(middle);
    	root.setBottom(bot);
    	primaryStage.setScene(new Scene(root, 350, 500));
        primaryStage.show();
    }
    
    public class eventBox extends VBox {
//    	double width;
//    	double height;
    	Button checkOffBtn;
    	Label taskText;
    	Label taskTime;

    	public eventBox() {
    		createButton();
    		createLabel();

    		this.setPrefWidth(350);
    		this.setPrefHeight(100);
    		
    		this.setStyle("-fx-background-color: rgb(245,250,220);" +
    			"-fx-border-width: 2;"
                + "-fx-border-color: blue;" );
    		this.getChildren().addAll(checkOffBtn,taskText,taskTime);
    	}
    	private void createButton() {
    		checkOffBtn = new Button();
    		checkOffBtn.setText("Done!");
    		checkOffBtn.setOnAction(event -> {
    			container.getChildren().remove(this);
    			eventArray.remove(this);
    			if(eventArray.size()<4) {
    				middle.setVbarPolicy(ScrollPane.ScrollBarPolicy.NEVER);
    			}
    		});
    		checkOffBtn.setTranslateX(235);
    		checkOffBtn.setTranslateY(30);
    	}
    	private void createLabel() {
    		taskText = new Label();
    		taskText.setText(window.userLabel.getText());
    		taskTime = new Label();
    		taskTime.setText(intToString(window.tp.getHour()) + ":" +  intToString(window.tp.getMinute()));
    	}

    }
    
   
    
    private String intToString(int n) {
    	String s = "" + n;
		return s;
    }
    
    public static void main(String[] args) {
        launch(args);
       
    }
}
/*TODO, 
* Check buttons for Priority / Time or both in popupwindow
* Be able to sort after priority/time 
* Validate input from popupwindow
* 
*
*/