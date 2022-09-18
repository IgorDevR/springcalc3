package comskyprocalcspringcalc;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/calculator")
public class CalcController {

	private final CalcService calcService;

	public CalcController(CalcService calcService) {
		this.calcService = calcService;
	}

	@GetMapping()
	public String greetings() {
		return calcService.calcGreetings();
	}

	@GetMapping(path = "/plus")
	public String calcAddition(@RequestParam double num1, @RequestParam double num2) {
		return String.format("%s + %s = %.2f", num1, num2, calcService.calcAddition(num1, num2));
	}

	@GetMapping(path = "/minus")
	public String calcSubtraction(@RequestParam double num1, @RequestParam double num2) {
		return String.format("%s - %s = %.2f", num1, num2, calcService.calcSubtraction(num1, num2));
	}

	@GetMapping(path = "/multiply")
	public String calcMultiply(@RequestParam double num1, @RequestParam double num2) {
		return String.format("%s * %s = %.2f", num1, num2, calcService.calcMultiply(num1, num2));
	}

	@GetMapping(path = "/divide")
	public String calcDivide(@RequestParam double num1, @RequestParam double num2) {
		return num2 == 0 ? "Деление на 0" : String.format("%s / %s = %.2f", num1, num2, calcService.calcDivide(num1, num2));
	}

}
