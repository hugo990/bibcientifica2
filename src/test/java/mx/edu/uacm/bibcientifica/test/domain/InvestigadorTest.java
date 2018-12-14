package mx.edu.uacm.bibcientifica.test.domain;

import java.util.Optional;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import mx.edu.uacm.bibcientifica.domain.Investigador;
import mx.edu.uacm.bibcientifica.repository.InvestigadorRepository;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class InvestigadorTest {
	
	private static Logger log = LogManager.getLogger(InvestigadorTest.class); 
	
	@Autowired
	InvestigadorRepository investigadorRepository;
	
	@Test
	public void testGuardarInvestigador() {
		log.info("Entrando a: testProbarGuardarInvestigador");
		
		Investigador investigador = new Investigador();
		
		investigador.setNombre("Hugo");
		investigador.setApellido("Gonzalez");
		investigador.setCorreo("hugo.gonzalez.dv10@gmail.com");
		investigador.setTelefono("5527639487");
		investigador.setContrasena("12345678");
		investigador.setGenero("Maculino");
		investigador.setTipoUsuario("admin");
		
		
		
		Assert.assertNotNull("El investigador se guardo", investigadorRepository.save(investigador));

	}
	
	@Test
	public void testEditarInvestigador() {
		
		log.info("Entrando a: testProbarGuardarInvestigador");
		
		Investigador investigador = new Investigador();
		
		investigador.setId(new Long(14));
		investigador.setNombre("Juan");
		investigador.setApellido("Gonzalez");
		investigador.setTelefono("5527639487");
		investigador.setGenero("Masculino");
		investigador.setCorreo("hugo.gonzalez.dv10@gmail.com");
		
		Assert.assertNotNull("El investigador se edito", investigadorRepository.save(investigador));
		
	}
	
	
	@Test
	public void testBorrarInvestigador() {
		
		log.info("Entrando a: testBorrarInvestigador");
		
		Optional<Investigador> invest = investigadorRepository.findById(new Long(14));
		
		if(invest.isPresent()) {
			Investigador investigador = invest.get();
			
			if(investigador != null) {
				investigadorRepository.delete(investigador);
				log.info("El investigador se elimino");
			}
			
		}			
	}
	
	@Test
	public void testExisteEmail() {
		Investigador investigador = investigadorRepository.findByEmail("hugo.gonzalez.dv10@gmail.com");
		log.info(investigador.getNombre() + " " + investigador.getApellido());
	}
}
