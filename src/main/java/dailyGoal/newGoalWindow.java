package dailyGoal;


import java.text.DateFormat;
import java.time.LocalDateTime;
import java.util.Calendar;
import java.util.Date;

import timePicker.TimePicker;
import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.image.Image;
import javafx.scene.layout.Border;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.util.Duration;
import dailyGoal.GUI;
import dailyGoal.GUI.eventBox;

public class newGoalWindow extends Stage {

	public Label label;
	public TextField userLabel;
	private LocalDateTime ldt;
	
	private HBox timeContainer;
	
	public Label time;
	public TimePicker tp;
	
	public Button create;
	public boolean flag;
	private Insets insets = new Insets(20,5,10,5);
	public newGoalWindow()
	{
		flag = false;
		
		
		
		//Button
		create = new Button("Create");
		create.setOnAction(event -> {
			this.close();
			flag = true;
		});
		VBox buttonContainer = new VBox();
		buttonContainer.setPrefSize(200, 25);
		buttonContainer.setTranslateY(50);
		buttonContainer.getChildren().add(create);
		buttonContainer.setAlignment(Pos.CENTER);
//		buttonContainer.setStyle("-fx-background-color: rgb(245,250,220);" +
//    			"-fx-border-width: 2;"
//                + "-fx-border-color: blue;" );
		
		//User description/Label
		initStyle(StageStyle.UTILITY);
		
		label = new Label("What do you need to do?");
		Font f = new Font("serif",16);
		label.setFont(f);
		userLabel = new TextField();
		
		//Date and timepicker
		timeContainer = new HBox();
		time = new Label("When?");
		tp = new TimePicker("Date: ");
		
		timeContainer.getChildren().addAll(tp);
		timeContainer.setPrefSize(200, 100);
//		timeContainer.setStyle("-fx-background-color: rgb(245,250,220);" +
//    			"-fx-border-width: 2;"
//                + "-fx-border-color: blue;" );
		
		
		
		
		//Pane stuff
		FlowPane root = new FlowPane(0,5);
		
		root.getChildren().addAll(label,userLabel,time,timeContainer, buttonContainer);
		root.setPadding(insets);
//		root.setMargin(time, new Insets(5,0,0,0));
//		root.setAlignment(Pos.CENTER);
		Scene scene = new Scene(root,200,350);
		
		setScene(scene);
		setResizable(false);
	}
}
