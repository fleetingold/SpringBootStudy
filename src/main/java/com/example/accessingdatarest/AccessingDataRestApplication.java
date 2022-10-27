package com.example.accessingdatarest;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class AccessingDataRestApplication {

	public static void main(String[] args) {
		SpringApplication.run(AccessingDataRestApplication.class, args);
	}

	@Bean
	public CommandLineRunner demo(NavigationGroupInUsersRepository repository) {
		return (args) -> {
			// save a few NavigationGroupInUsers
			NavigationGroupInUsers navigationGroupInUsers = new NavigationGroupInUsers();
			navigationGroupInUsers.setId("0CF41101-3898-4856-B572-CA6BB52C37AA");
			navigationGroupInUsers.setNavigationGroupId("062B3E5A-6F3D-4612-B4B3-427803E7B1D1");
			navigationGroupInUsers.setUserId("285C7D21-E3D4-40B7-903C-58CFDDDB0D96");
			navigationGroupInUsers.setApplicationId("A326DCF9-7270-41C8-8A8D-42F7DC2B45DC");
			repository.save(navigationGroupInUsers);

			// fetch all customers
			for (NavigationGroupInUsers item : repository.findAll()) {
				System.out.println(item.toString());
			}

			// fetch an individual customer by ID
			NavigationGroupInUsers item02 = repository.findById(navigationGroupInUsers.getId()).get();
			System.out.println(item02.toString());
			
		};
	}
}
