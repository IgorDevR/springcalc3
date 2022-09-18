package comskyprocalcspringcalc;

import org.springframework.web.bind.annotation.RequestParam;

public interface CalcService {
    String calcGreetings();

    double calcAddition(double num1, double num2);

    double calcSubtraction(double num1, double num2);

    double calcMultiply(double num1, double num2);

    double calcDivide(double num1, double num2);
}
