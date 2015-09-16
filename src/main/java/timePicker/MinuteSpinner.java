package timePicker;

import java.time.LocalDateTime;

import javafx.scene.control.Spinner;
import javafx.scene.control.SpinnerValueFactory;

/**
 * This is a custom class that extends the Spinner class.
 * 
 * @author Project Group 3
 * @since 2015-05-26
 */
public class MinuteSpinner extends Spinner<Integer> {
	
	
	private LocalDateTime ldt;
	
	public MinuteSpinner() 
	{
		ldt = LocalDateTime.now();
		SpinnerValueFactory<Integer> svf = new
				SpinnerValueFactory.IntegerSpinnerValueFactory(0, 59, ldt.getMinute(), 1); 
		
		setValueFactory(svf);
		setPrefWidth(70);
		
		setEditable(false);
	}

	/**
	 * This is a public method that will return the selected minute.
	 * @return minute
	 */
	public int getMinute()
	{
		return getValue();
	}
}
