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

import mx.edu.uacm.bibcientifica.domain.ArticuloCientifico;
import mx.edu.uacm.bibcientifica.repository.ArticuloCientificoRepository;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class ArticuloCientificoTest {
	
	private static Logger log = LogManager.getLogger(InvestigadorTest.class); 
	
	@Autowired
	ArticuloCientificoRepository articuloCientificoRepository;
	
	@Test
	public void testGuardarArticuloCientifico() {
		
		log.info("Entrando a testGuardarArticuloCientifico");
		
		ArticuloCientifico articuloCientifico = new ArticuloCientifico();
		
		articuloCientifico.setTitulo("Electrochemical polymerization, characterization and in-situ conductivity studies of poly-3,4-ortho-xylendioxythiophene (PXDOT)");
		articuloCientifico.setPalabraClave("Energia");
		articuloCientifico.setNombreRevista("Synthetic Metals");
		articuloCientifico.setVolumen("245");
		articuloCientifico.setPaginas("135-143");
		articuloCientifico.setAnoPublicacion("2018");
		
		Assert.assertNotNull("El articulo cientifico se guardo", articuloCientificoRepository.save(articuloCientifico));
		
	}
	
	@Test
	public void testEditarArticuloCientifico() {
		
		log.info("Entrando a testEditarArticuloCientifico");
		
		ArticuloCientifico articuloCientifico = new ArticuloCientifico();
		
		articuloCientifico.setId(new Long(20));
		articuloCientifico.setTitulo("Conjugate thermal creep flow in a thin microchannel");
		articuloCientifico.setPalabraClave("Energia");
		articuloCientifico.setNombreRevista("Synthetic Metals");
		articuloCientifico.setVolumen("245");
		articuloCientifico.setPaginas("135-143");
		articuloCientifico.setAnoPublicacion("2018");
		
		Assert.assertNotNull("El articulo cientifico se edito", articuloCientificoRepository.save(articuloCientifico));
		
	}
	
	@Test
	public void borrarArticuloCientifico() {
		
		log.info("Entrando a testEditarArticuloCientifico");
		
		Optional<ArticuloCientifico> artCientifico = articuloCientificoRepository.findById(new Long(20));
		
		if(artCientifico.isPresent()) {
			ArticuloCientifico articuloCientifico = artCientifico.get();
			
			if(articuloCientifico != null) {
				articuloCientificoRepository.delete(articuloCientifico);
				log.info("El articulo cientifico se elimino");
				
			}
		}
		
		
	}

}
