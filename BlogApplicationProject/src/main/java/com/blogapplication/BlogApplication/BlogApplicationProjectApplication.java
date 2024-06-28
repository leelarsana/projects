package com.blogapplication.BlogApplication;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class BlogApplicationProjectApplication {

	//String[]: This denotes an array of String objects.
	//
	//An array in Java is a container object that holds a fixed number of values of a single type.
	//In this case, the type is String.
	//args: This is the name of the parameter, which is a conventional name but not a keyword. You can name it anything, but args is the most commonly used name.


	public static void main(String[] args) {

		SpringApplication.run(BlogApplicationProjectApplication.class, args);
	}

	@Bean//no need to ceate an object it will create an object outomatically in spring container
	public ModelMapper modelMapper(){

		return new ModelMapper();
	}

}
