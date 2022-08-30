package palvelinohjelmointi.modelandview1.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ModelandviewController {
		
	@RequestMapping(value = "/hello", method = RequestMethod.GET)
	public String helloPage(@RequestParam(name="name") String name, @RequestParam(name="age") int age, Model model) {
		model.addAttribute("name", name);
		model.addAttribute("age", age);
		return "hello";
	}
	
}
