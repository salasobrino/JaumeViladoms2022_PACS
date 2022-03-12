package com.example.customerViladoms;

//import org.apache.commons.logging.Log;
//import org.apache.commons.logging.LogFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;


@Component
public class ApplicationCommandRunner implements CommandLineRunner {
	
	//protected final Log logger = LogFactory.getLog(getClass());
	private static final Logger logger = LoggerFactory.getLogger(ApplicationCommandRunner.class);

	@Autowired
	private CustomerRepository customerRepo;

	@Override
	public void run(String... args) throws Exception {

		logger.info("Welcome to the runner from commandLineRunner");

		customerRepo.deleteAll();	
		
		Customer customer1 = new Customer("1","Tom", "Jones");
		Customer customer2 = new Customer("2", "Silvia", "Eriksson");
		Customer customer3 = new Customer("3", "Anna", "Britzles");
		Customer customer4 = new Customer("4", "Paul", "Gates");
		

		customerRepo.save(customer1);
		customerRepo.save(customer2);
		customerRepo.save(customer3);
		customerRepo.save(customer4);
		
		

		//logger.info(customerservice.findAll());
		customerRepo.findAll().forEach((author) -> { logger.info("{}", author); });
		
		

	}
	

}
