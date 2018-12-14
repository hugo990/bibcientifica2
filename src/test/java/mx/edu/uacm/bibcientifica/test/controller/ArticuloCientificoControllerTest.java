package mx.edu.uacm.bibcientifica.test.controller;

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

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class ArticuloCientificoControllerTest {
	
	private static Logger log = LogManager.getLogger(InvestigadorControllerTest.class);
	
	@Autowired
	private MockMvc mock;
	
	@Test
	public void testGuardarArticuloCientifico() throws Exception {
		
		mock.perform(post("/artCientifico/guardar")
				.param("titulo", "Electrochemical polymerization, characterization and in-situ conductivity studies of poly-3,4-ortho-xylendioxythiophene (PXDOT)")
				.param("palabraClave", "Energia")
				.param("nombreRevista", "Synthetic Metals")
				.param("volumen", "245")
				.param("paginas", "135-143")
				.param("anoPublicacion", "2018")
				).andExpect(status().isOk())
		         .andReturn();
		
	}
	
	@Test
	public void testEditarArticuloCientifico() throws Exception {
		
		mock.perform(post("/artCientifico/editar/33")
				.param("titulo", "Conjugate thermal creep flow in a thin microchannel")
				.param("palabraClave", "Energia")
				.param("nombreRevista", "Synthetic Metals")
				.param("volumen", "245")
				.param("paginas", "135-143")
				.param("anoPublicacion", "2018")
				).andExpect(status().isOk())
		         .andReturn();
		
	}
	
	@Test
	public void testBorrarArticuloCientifico() throws Exception {
		
		mock.perform(get("/artCientifico/borrar/33")
				).andExpect(status().isOk())
		         .andReturn();
		
	}

}
