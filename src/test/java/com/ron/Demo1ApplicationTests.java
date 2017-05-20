package com.ron;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.ron.forum.Demo1Application;
import com.ron.forum.dao.UserDao;
import com.ron.forum.domain.User;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = Demo1Application.class)
public class Demo1ApplicationTests {
	
	@Autowired
	private UserDao userDao;
	@Test
	public void contextLoads() {
		User user = userDao.findByUsername("herong");
		Assert.assertNotNull(user);
	}

}
