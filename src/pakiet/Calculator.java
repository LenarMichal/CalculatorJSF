package pakiet;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import javax.annotation.PostConstruct;

@SessionScoped
@ManagedBean
public class Calculator  {

	private double tmp;
	public String display;
	private String operation;
	

	@PostConstruct
	public void init() {
		display = "";
		
	}

	public String getDisplay() {
		return display;
	}

	public void setDisplay(String display) {
		this.display = display;
	}

	public void addOperation(String operation) {

		tmp = Double.parseDouble(display);
		this.operation = operation;
		display = "";
	}

	public void clear() {

		display = "";
		
	}

	public void addDigit(String digit) {
		
		display = display + digit;
	}

	public void sqrt() {
		
		tmp = Double.parseDouble(display);

		display = "" + Math.sqrt(tmp);

	}

	public void calculate() {
		
		double value = Double.parseDouble(display);

		if ("+".equals(operation)) {
			display = "" + (tmp + value);
		} else if ("-".equals(operation)) {
			display = "" + (tmp - value);
		} else if ("*".equals(operation)) {
			display = "" + (tmp * value);
		} else if ("/".equals(operation) && value == 0) {
			display = "Error! Division by '0'";
			
		} else if ("/".equals(operation)) {
			display = "" + (tmp / value);
		} else if ("%".equals(operation)) {
			display = "" + ((tmp / 100) * value);
		}
	}

	public void plusMinusOperation() {
		
		tmp = Double.parseDouble(display);
		if (tmp > 0)
			display = "-" + display;
		if (tmp < 0) {
			tmp = -tmp;
			display = Double.toString(tmp);
		}

	}

}
