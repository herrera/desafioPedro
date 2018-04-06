/*
 * Copyright 2016 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package desafio;

import static org.hamcrest.Matchers.containsString;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;


import java.math.BigDecimal;

import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.web.client.RestTemplate;

import desafio.saraiva.SaraivaApi;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class InicioControllerTests {

    @Autowired
    private MockMvc mockMvc;


    @Autowired
	private  BookRepository bookRepository;

    @Test
    public void teste1Inclusao() throws Exception {
    	
    	mockMvc.perform(
                post("/book")
                .contentType(MediaType.APPLICATION_FORM_URLENCODED)
                .param("sku", "9731880")).andExpect(status().isOk());
                    	
     }

  @Test
  public void teste2Consulta() throws Exception {
	  Book book = new Book (new Long(9731880), "Origem", "Arqueiro", new BigDecimal("39.90"));
	  
	  	  		 
      this.mockMvc.perform(
    		  get("/book/9731880"))
    		  .andExpect(status().isOk());
   }

  @Test
  public void teste4Exclusao() throws Exception {
        		
		this.mockMvc.perform(
    		  delete("/book/9731880"))
    		  .andExpect(status().isNoContent());  
   }

  @Test
  public void teste3Listagem1() throws Exception {
	  
	  		 
      this.mockMvc.perform(
    		get("/book")
      		.param("price", "35")
      		.param("limit", "2")
      		).andExpect(status().isOk());
   }
  
    //    @Test
//    public void noParamGreetingShouldReturnDefaultMessage() throws Exception {

//        this.mockMvc.perform(get("/greeting")).andDo(print()).andExpect(status().isOk())
//                .andExpect(jsonPath("$.content").value("Hello, World!"));
//    }
    
//    @Test
//    public void contextLoads() throws Exception {
//    }

//    @Test
//    public void paramGreetingShouldReturnTailoredMessage() throws Exception {

//        this.mockMvc.perform(get("/greeting").param("name", "Spring Community"))
//                .andDo(print()).andExpect(status().isOk())
//                .andExpect(jsonPath("$.content").value("Hello, Spring Community!"));
//    }
                
                

}
