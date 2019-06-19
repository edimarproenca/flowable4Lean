package com.flowable.demo4learn.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.flowable.demo4learn.controllers.CrudPersonController;

@RunWith(SpringRunner.class)
@WebMvcTest(CrudPersonController.class)
public class ControllerTest {
	
	@Autowired
	private MockMvc mockMvc;

	@Test
	public void runFindByIdTest() throws Exception {
		this.mockMvc.perform(MockMvcRequestBuilders
				.get("/findById?id=1")
				.accept(MediaType.APPLICATION_JSON)).andDo(System.out::println);
	}

}
