package com.ttn.rabbitmq.producer;

import com.ttn.rabbitmq.producer.direct.PictureProducer;
import com.ttn.rabbitmq.producer.entity.Employee;
import com.ttn.rabbitmq.producer.entity.Furniture;
import com.ttn.rabbitmq.producer.entity.Picture;
import com.ttn.rabbitmq.producer.fanout.HRProducer;
import com.ttn.rabbitmq.producer.header.FurnitureProducer;
import com.ttn.rabbitmq.producer.topic.PictureProducerTopic;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

@EnableScheduling
@SpringBootApplication
public class Application{

	Logger logger = LoggerFactory.getLogger(Application.class);
	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
		System.out.println("welcome to rabbitmq session");
	}

/*
	//TODO: Fanout

	@Autowired
	private HRProducer hrProducer;

	@Override
	public void run(String... args) throws Exception {
		logger.info("About to send Message");
		for (int i = 1; i <= 5; i++) {
			Employee employee = new Employee((long) i, "Employee "+ i, new Date());
			hrProducer.sendMessage(employee);
		}
		logger.info("Message Sent");
	}


/*
	//TODO: Direct/ Topic (producerTopic)
	private final List<String> SOURCES = Arrays.asList("mobile", "web");
	private final List<String> TYPES = Arrays.asList("png","jpg", "svg");

	@Autowired
	private PictureProducerTopic producer;

	@Override
	public void run(String... args) throws Exception {
		logger.info("About to send Message");
		for (int i = 0; i < 5; i++) {
			Picture picture = new Picture();
			picture.setName("Picture "+ i);
			picture.setSize(ThreadLocalRandom.current().nextInt(10000));
			picture.setSource(SOURCES.get(i% SOURCES.size()));
			picture.setType(TYPES.get(i% TYPES.size()));
			producer.sendPicture(picture);
		}
		logger.info("Message Sent");
	}
*/

//
//	//TODO: Header
//	private final List<String> COLORS = Arrays.asList("white", "red","green");
//	private final List<String> MATERIAL = Arrays.asList("wood", "plastic", "steel");
//
//	@Autowired
//	private FurnitureProducer producer;
//
//	@Override
//	public void run(String... args) throws Exception {
//		logger.info("About to send Message");
//		for (int i =0 ; i < 10; i++) {
//			Furniture furniture = new Furniture();
//			furniture.setName("Furniture "+ i);
//			furniture.setPrice(ThreadLocalRandom.current().nextInt(100000));
//			furniture.setColor(COLORS.get(i% COLORS.size()));
//			furniture.setMaterial(MATERIAL.get(i% MATERIAL.size()));
//			producer.sendMessage(furniture);
//		}
//		logger.info("Message Sent");
//	}

/*
	//TODO: Retry

	@Autowired
	private HRProducer hrProducer;

	@Override
	public void run(String... args) throws Exception {
		logger.info("About to send Message");
		Employee employee = new Employee(1L, null, new Date());
		hrProducer.sendMessage(employee);
		logger.info("Message Sent");
	}

	*/
}