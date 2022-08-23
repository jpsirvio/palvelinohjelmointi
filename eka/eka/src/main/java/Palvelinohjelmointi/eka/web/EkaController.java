package Palvelinohjelmointi.eka.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class EkaController {
		
	@RequestMapping("index")
	@ResponseBody
	public String indexPage() {
		return "This is the main page";
	}

	@RequestMapping("contact")
	@ResponseBody
	public String contactPage() {
		return "This is the contact page";
	}
		
	@RequestMapping("hello")
	@ResponseBody
	public String helloPage(@RequestParam(name="loc", defaultValue="moon") String location, @RequestParam(name="name", defaultValue="John") String nimi) {
		return "Welcome to the " + location + " " + nimi + "!";
	}

}
