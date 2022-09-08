package s22.carDatabaseWeek3.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import s22.carDatabaseWeek3.domain.Car;
import s22.carDatabaseWeek3.domain.CarRepository;

@Controller
public class CarController {
	@Autowired
	CarRepository carRepository;

	@GetMapping("cars")
	public String showCars(Model model) {
		model.addAttribute("autot", carRepository.findAll());
		return "cars";
	}

	@GetMapping("addCar")
	public String addCar(Model model) {
		model.addAttribute("uusiAuto", new Car());
		return "newCar";
	}

	@GetMapping("editCar/{id}")
	public String editCar(@PathVariable("id") Long id, Model model) {
		model.addAttribute("editCar", carRepository.findById(id));
		return "editCar";
	}

	@PostMapping("saveCar")
	public String saveCar(Car car) {
		carRepository.save(car);
		return "redirect:cars";
	}
}
