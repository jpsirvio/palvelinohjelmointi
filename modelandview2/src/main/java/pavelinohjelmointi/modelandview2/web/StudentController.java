package pavelinohjelmointi.modelandview2.web;

import java.util.ArrayList;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import pavelinohjelmointi.modelandview2.domain.Student;

@Controller
public class StudentController {

	@RequestMapping(value="/hello", method = RequestMethod.GET)
	public String students(Model model) {
		
		ArrayList<Student> list = new ArrayList<Student>();
		list.add(new Student("Kate","Cole"));
		list.add(new Student("Dan","Brown"));
		list.add(new Student("Mike","Mars"));
		
		model.addAttribute("students", list);
		return "studentlist";
	}
	
	
	
}
