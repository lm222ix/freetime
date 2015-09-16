package timePicker;

import java.time.LocalDateTime;

import javafx.scene.control.Spinner;
import javafx.scene.control.SpinnerValueFactory;

/**
 * This is a custom class that extends the spinner class. 
 * 
 * @author Project Group 3
 * @since 2015-05-26
 */



public class HourSpinner extends Spinner<Integer> {

	
	private LocalDateTime ldt;
	
	public HourSpinner()
	{		
		ldt = LocalDateTime.now();
		SpinnerValueFactory<Integer> svf = new
				SpinnerValueFactory.IntegerSpinnerValueFactory(01, 23, ldt.getHour(), 1); 
		
		setValueFactory(svf);
		setPrefWidth(70);
		
		setEditable(false);
	}

	/**
	 * This is a public method that returns the selected value.
	 * 
	 * @return hour
	 */
	public int getHour()
	{
		return getValue();
	}
}