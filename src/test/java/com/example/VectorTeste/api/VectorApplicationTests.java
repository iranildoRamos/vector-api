package com.example.VectorTeste.api;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.vector.api.VectorApplication;

@ContextConfiguration(classes= {VectorApplication.class})
@RunWith(SpringRunner.class)
@SpringBootTest
public class VectorApplicationTests {

	@Test
	public void contextLoads() {
	}

}
