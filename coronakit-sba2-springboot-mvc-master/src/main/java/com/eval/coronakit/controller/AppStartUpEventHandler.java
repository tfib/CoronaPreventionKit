package com.eval.coronakit.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import com.eval.coronakit.dao.RolesRepository;
import com.eval.coronakit.dao.UserRepository;
import com.eval.coronakit.entity.Roles;
import com.eval.coronakit.entity.User;

@Component
public class AppStartUpEventHandler {

	@Autowired
	private UserRepository userRepo;
	@Autowired
	private RolesRepository rolesRepo;

	@EventListener
	public void appReady(ApplicationReadyEvent event) {
		System.out.println("============In App Startup================");
		try {
		userRepo.save(new User("First", "abc", true, "test@gmail.com", "9876543210"));
		userRepo.save(new User("Second", "abc", true, "test@gmail.com", "9876543210"));
		userRepo.save(new User("Admin", "admin", true, "test@gmail.com", "9876543210"));
		rolesRepo.save(new Roles("First", "USER"));
		rolesRepo.save(new Roles("Second", "USER"));
		rolesRepo.save(new Roles("Second", "ADMIN"));
		rolesRepo.save(new Roles("Admin", "ADMIN"));
		}catch(Exception e) {
			System.out.println(e);
		}
		System.out.println("============End of App Startup================");
	}

}
