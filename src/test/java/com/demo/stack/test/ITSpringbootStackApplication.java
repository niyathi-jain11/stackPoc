package com.demo.stack.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;

import com.demo.stack.SpringbootStackApplication;

@RunWith(SpringRunner.class)
@TestPropertySource(locations = "classpath:test-application.properties")
public class ITSpringbootStackApplication {

	@Test
	public void testStackApplicationWithArguements() {
		SpringbootStackApplication.main(new String[] { "Invalid argument" });
	}

	// @Test
	public void testStackApplicationWithoutArguements() {
		SpringbootStackApplication.main(new String[0]);
	}
}