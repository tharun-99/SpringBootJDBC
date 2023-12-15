package com.spring.boot.jdbc.jdbc;

import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.spring.boot.jdbc.jdbc.dao.UserDao;

@SpringBootApplication
public class JdbcApplication implements CommandLineRunner {

	@Autowired
	public UserDao userDao;

	public static void main(String[] args) {
		SpringApplication.run(JdbcApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		deleteUser();
	}

	public int createTable(){
		int res = this.userDao.createTable();
		return res;
	}

	public void createUser(){
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter id");
		Integer id = sc.nextInt();

		System.out.println("Enter name");
		String name = sc.next();

		System.out.println("Enter age");
		Integer age = sc.nextInt();

		System.out.println("Enter city");
		String city = sc.next();

		int res = this.userDao.insertUser(id, name, age, city);
		System.out.println("Updated no of rows : " + res);

		sc.close();
		
	}

	public void updateUser(){
		Integer id = 1;
		String name = "kumar";
		this.userDao.updateUser(id, name);
	}

	public void deleteUser(){
		Integer id = 1;
		this.userDao.deleteUser(id);
	}

}
