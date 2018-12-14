package mx.edu.uacm.bibcientifica.test.service;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import mx.edu.uacm.bibcientifica.domain.Investigador;
import mx.edu.uacm.bibcientifica.service.InvestigadorService;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class InvestigadorServiceTest {
	
	private static Logger log = LogManager.getLogger(InvestigadorServiceTest.class);
	
	@Autowired
	InvestigadorService investigadorService;
	
	@Test
	public void testGuardarInvestigador() {
		
		log.info("Entrando a testGuardarInvestigador");
		
		Investigador investigador = new Investigador();
		
		investigador.setNombre("Hugo");
		investigador.setApellido("Gonzalez");
		investigador.setTelefono("5527639487");
		investigador.setGenero("Masculino");
		investigador.setCorreo("hugo.gonzalez.dv10@gmail.com");
		
		Assert.assertTrue("Se agrego al investigador", investigadorService.guardarInvestigador(investigador));
		
	}
	
	@Test
	public void testEditarInvestigador() {
		
		log.info("Entrando a testEditarInvestigador");
		
		Investigador investigador = new Investigador();
		
		investigador.setNombre("Juana");
		investigador.setApellido("Ortega");
		investigador.setTelefono("5527639487");
		investigador.setGenero("Femenino");
		investigador.setCorreo("juana.ortega.dv10@gmail.com");
		
		Assert.assertTrue("El investiador se modifico", investigadorService.editarInvestigador(investigador, new Long(24)));
		
	}
	
	@Test
	public void testBorrarInvestigador() {
		
		Assert.assertTrue("Se elimino al investigador", investigadorService.borrarInvestigador(new Long(24)));
	}
	
	@Test
	public void testExisteEmail() {
		Investigador investigador = investigadorService.existeEmail("hugo.gonzalez.dv10@gmail.com");
		
		log.info(investigador.getNombre() + " " + investigador.getApellido());
		
		
	}

}
