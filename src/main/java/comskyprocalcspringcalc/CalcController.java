package comskyprocalcspringcalc;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/calculator")
public class CalcController {

    private final CalcServiceImp calcServiceImp;

    public CalcController(CalcServiceImp calcServiceImp) {
        this.calcServiceImp = calcServiceImp;
    }

    @GetMapping()
    public String greetings() {
        return calcServiceImp.calcGreetings();
    }

    @GetMapping(path = "/plus")
    public String calcAddition(@RequestParam double num1, double num2) {
        return String.format("%s + %s = %.2f", num1, num2, calcServiceImp.calcAddition(num1, num2));
    }

    @GetMapping(path = "/minus")
    public String calcSubtraction(@RequestParam int num1, int num2) {
        return String.format("%s - %s = %.2f", num1, num2, calcServiceImp.calcSubtraction(num1, num2));
    }

    @GetMapping(path = "/multiply")
    public String calcMultiply(@RequestParam int num1, int num2) {
        return String.format("%s * %s = %.2f", num1, num2, calcServiceImp.calcMultiply(num1, num2));
    }

    @GetMapping(path = "/divide")
    public String calcDivide(@RequestParam int num1, int num2) {
        return String.format("%s / %s = %.2f", num1, num2, calcServiceImp.calcDivide(num1, num2));
    }

}
