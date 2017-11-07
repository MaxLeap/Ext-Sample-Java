package com.maxleap;

import com.maxleap.store.bean.UserJpa;
import com.maxleap.store.dao.UserRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class LeapcloudExtDemoApplicationTests {

	@Autowired
	private UserRepository userRepository;

	@Test
	public void contextLoads() {
		List<UserJpa> list = userRepository.findAll();
		System.out.println(list);
		UserJpa userJpa = new UserJpa();
		userJpa.setId(1L);
		userJpa.setFirstName("Jack");
		userJpa.setLastName("lucy");
		userJpa.setPassword("123");
		userJpa = userRepository.save(userJpa);
		System.out.println(userJpa);
		userJpa = userRepository.findOne(1L);
		System.out.println(userJpa);
		userJpa.setLastName("lucy2");
		userJpa.setPassword("321");
		userRepository.save(userJpa);
		list = userRepository.findAll();
		System.out.println(list);
		userRepository.delete(1L);
		list = userRepository.findAll();
		System.out.println(list);

	}

}
