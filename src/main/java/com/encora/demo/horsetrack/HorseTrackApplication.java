package com.encora.demo.horsetrack;

import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Profile;

import com.encora.demo.horsetrack.controller.CommanModeImpl;
import com.encora.demo.horsetrack.dao.HorseRepository;
import com.encora.demo.horsetrack.dao.InventoryRepository;
import com.encora.demo.horsetrack.service.HorseService;
import com.encora.demo.horsetrack.service.ReportService;

@Profile("!test")
@SpringBootApplication
@EntityScan("com.encora.demo.horsetrack.model")
@ComponentScan({ "com.encora" })
public class HorseTrackApplication  implements CommandLineRunner  {

	  @Autowired
	  private ConfigurableApplicationContext context;

	  @Autowired
	  HorseRepository horseRepository;

	  @Autowired
	  InventoryRepository inventoryRepository;

	  @Autowired
	  HorseService horseService;

	  @Autowired
	  ReportService reportService;

	  @Autowired
	  CommanModeImpl commanModeImpl;

	  public static void main(String[] args) {
	    SpringApplication.run(HorseTrackApplication.class, args);
	  }

	  @Override
	  public void run(String... strings) throws Exception {

		  commanModeImpl.init();

		  commanModeImpl.startUpMessages();

	    Scanner commandString = new Scanner(System.in);
	    while (!(commanModeImpl.quit())) {

	    	commanModeImpl.execute(commandString.nextLine());

	    }

	    System.exit(SpringApplication.exit(context));

	  }
}
