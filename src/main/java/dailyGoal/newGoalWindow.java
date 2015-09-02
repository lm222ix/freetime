package dailyGoal;

import java.util.Date;

import timetable_pane.project_edit_and_add.timepicker.TimePicker;
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
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import dailyGoal.GUI;
import dailyGoal.GUI.eventBox;

public class newGoalWindow extends Stage {

	public Label label;
	public TextField userLabel;
	
	private HBox timeContainer;
	
	public Label time;
	public TimePicker tp;
	
	private Insets insets = new Insets(20,5,10,5);
	public newGoalWindow()
	{
		initStyle(StageStyle.UTILITY);
		
		label = new Label("What do you need to do?");
		userLabel = new TextField();
		
		timeContainer = new HBox();
		time = new Label("When?");
		tp = new TimePicker("Date: ");
		
		timeContainer.getChildren().addAll(tp);
		timeContainer.setPrefSize(200, 100);
//		timeContainer.setStyle("-fx-background-color: rgb(245,250,220);" +
//    			"-fx-border-width: 2;"
//                + "-fx-border-color: blue;" );
		FlowPane root = new FlowPane(0,5);
		
		root.getChildren().addAll(label,userLabel,time,timeContainer);
		root.setPadding(insets);
//		root.setMargin(time, new Insets(5,0,0,0));
//		root.setAlignment(Pos.CENTER);
		Scene scene = new Scene(root,200,350);
		
		setScene(scene);
		setResizable(false);
	}
}
