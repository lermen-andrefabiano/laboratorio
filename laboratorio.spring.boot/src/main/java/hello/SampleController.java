package hello;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@EnableAutoConfiguration
public class SampleController {

	@RequestMapping("/")
	@ResponseBody
	String home() {
		return "Hello";
	}
	
	@RequestMapping("/{id}")
	@ResponseBody
	String home(@PathVariable("id") int id) {
		return "Hello" + id;
	}

	public static void main(String[] args) {
		SpringApplication.run(SampleController.class, args);
	}

}
