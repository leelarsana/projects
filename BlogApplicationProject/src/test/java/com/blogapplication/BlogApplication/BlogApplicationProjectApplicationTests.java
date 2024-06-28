package com.blogapplication.BlogApplication;

import com.blogapplication.BlogApplication.repesitorys.UserRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class BlogApplicationProjectApplicationTests {
	@Autowired
	private UserRepository userRepository;

	@Test
	void contextLoads() {


	}

	@Test
	public void repositoryTest()

	{
	    String className=this.userRepository.getClass().getName();
		String packName=this.userRepository.getClass().getPackageName();
		System.out.println(className);
		System.out.println(packName);

	}

}
