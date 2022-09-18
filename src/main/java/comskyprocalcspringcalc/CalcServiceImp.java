package comskyprocalcspringcalc;

import org.springframework.stereotype.Service;

@Service
public class CalcServiceImp implements CalcService {

	public String calcGreetings() {
		return "Добро пожаловать в калькулятор";
	}

	public double calcAddition(double num1, double num2) {
		return num1 + num2;
	}

	public double calcSubtraction(double num1, double num2) {
		return num1 - num2;
	}

	public double calcMultiply(double num1, double num2) {
		return num1 * num2;
	}

	public double calcDivide(double num1, double num2) {
		return num1 / num2;
	}


}
