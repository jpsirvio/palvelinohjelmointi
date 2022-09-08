package s22.carDatabaseWeek3;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import s22.carDatabaseWeek3.domain.Car;
import s22.carDatabaseWeek3.domain.CarRepository;

@SpringBootApplication
public class CarDatabaseWeek3Application implements CommandLineRunner {
//public class CarDatabaseWeek3Application {

	private static final Logger log = LoggerFactory.getLogger(CarDatabaseWeek3Application.class);

	// we need repository interfaces to put demo data to db
	@Autowired
	CarRepository carRepository;

	public static void main(String[] args) {
		SpringApplication.run(CarDatabaseWeek3Application.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		System.out.println("LUODAAN DEMODATAA");
		// Add car object and link to owners and save these to db
		Car car1 = new Car("Ford", "Mustang", "Red", "ADF-1121", 2021, 59000);
		carRepository.save(car1);
		carRepository.save(new Car("Nissan", "Leaf", "White", "SSJ-3002", 2019, 29000));
		carRepository.save(new Car("Toyota", "Prius", "Silver", "KKO-0212", 2020, 39000));

		log.info("Tulostetaan IDEn konsoliin autot:");
		for (Car car : carRepository.findAll()) {
			log.info(car.toString());
		}

	}

	/*
	 * @Bean public CommandLineRunner demoData(CarRepository repository) { return
	 * (args) -> { System.out.println("save some cars"); repository.save(new
	 * Car("Ford", "Mustang", "Red", "ADF-1121", 2021, 59000)); repository.save(new
	 * Car("Nissan", "Leaf", "White", "SSJ-3002", 2019, 29000)); repository.save(new
	 * Car("Toyota", "Prius", "Silver", "KKO-0212", 2020, 39000));
	 * 
	 * System.out.println("tulostetaan autot"); for (Car car : repository.findAll())
	 * { System.out.println(car.toString()); }
	 * 
	 * }; }
	 */
}
