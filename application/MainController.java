package application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.control.Button;

public class MainController  {
	@FXML
	private Label result;
	private double number1=0.0;
	private String operator="";
	private boolean start=true;
	private Model model=new Model();

	
	@FXML
	public void processnumbers(ActionEvent event) {
		if(start) {
			result.setText("");
			start=false;
		}
		String value=((Button)event.getSource()).getText();
		result.setText(result.getText()+ value);
		
	}

	@FXML
	public void processOperator(ActionEvent event) {
		String value=((Button)event.getSource()).getText();
		if(!value.equals("=")) {
			if(!operator.isEmpty()) 
				return;
			operator=value;
			number1=Double.parseDouble(result.getText());
			result.setText("");
		}
		else
		{
			if(operator.isEmpty())
				return;
			 double number2=Double.parseDouble(result.getText());
			Double output=model.Calculate(number1,number2,operator);
			result.setText(String.valueOf(output));
			operator="";
			start=true;
		}
		
		
	}

	

}
