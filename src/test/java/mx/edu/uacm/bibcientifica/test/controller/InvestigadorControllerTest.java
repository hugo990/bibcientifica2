package mx.edu.uacm.bibcientifica.test.controller;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultMatcher;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class InvestigadorControllerTest {
	
	private static Logger log = LogManager.getLogger(InvestigadorControllerTest.class);
	
	@Autowired
	private MockMvc mock;
	
	@Test
	public void testGuardarInvestigador() throws Exception {
		
		log.info("Entrando a testGuardarInvestigador");
			
		mock.perform(post("/investigador/guardar")
				.param("nombre", "Hugo")
				.param("apellido", "Gonzalez")
				.param("telefono", "5527639487")
				.param("genero", "Masculino")
				.param("correo", "hugo.gonzalez.dv10@gmail.com")
				).andExpect(status().isOk())
		         .andReturn();
		
	}
	
	@Test
	public void testEditarInvestiogador() throws Exception {
		mock.perform(post("/investigador/editar/36")
				.param("nombre", "Juana")
				.param("apellido", "Ortega")
				.param("telefono", "5527639487")
				.param("genero", "Femenino")
				.param("correo", "juana.ortega.dv10@gmail.com")
				).andExpect(status().isOk())
		         .andReturn();		
		
	}
	
	@Test
	public void testBorrarInvestigador() throws Exception {
		mock.perform(get("/investigador/borrar/36")
				).andExpect(status().isOk())
		         .andReturn();
	}
	
	@Test
	public void testLogin() throws Exception {
		mock.perform(post("/investigador/login")
				
				.param("contrasena", "123456789")
				).andExpect(status().isOk())
		         .andReturn();
	}
	

	@Test
	public void testExisteEmail() throws Exception {
		mock.perform(get("/investigador/existeEmail/hugo.gonzdalez.dv10@gmail.com")
				).andExpect(content().string("Existe"));
	}

}
