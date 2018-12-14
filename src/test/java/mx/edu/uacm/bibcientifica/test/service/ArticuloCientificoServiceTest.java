package mx.edu.uacm.bibcientifica.test.service;

import java.util.ArrayList;
import java.util.List;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import mx.edu.uacm.bibcientifica.domain.ArticuloCientifico;
import mx.edu.uacm.bibcientifica.domain.Investigador;
import mx.edu.uacm.bibcientifica.service.ArticuloCientificoService;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class ArticuloCientificoServiceTest {
	
	private static Logger log = LogManager.getLogger(InvestigadorServiceTest.class);
	
	@Autowired
	ArticuloCientificoService articuloCientificoService;
	
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
		
		Investigador investigador = new Investigador();
		
		investigador.setNombre("Hugo");
		investigador.setApellido("Gonzalez");
		investigador.setTelefono("5527639487");
		investigador.setGenero("Masculino");
		investigador.setCorreo("hugo.gonzalez.dv10@gmail.com");
		
		List<Investigador> investigadores = new ArrayList<Investigador>();
		
		investigadores.add(investigador);
				
		
		
		Assert.assertTrue("Se agrego el articulo cientifico", articuloCientificoService.guardarArticuloCientifico(articuloCientifico));
		
		
	}
	
	@Test
	public void testEditarArticuloCIentifico() {
		
		log.info("Entrando a testEditarArticuloCIentifico");
		
		ArticuloCientifico articuloCientifico = new ArticuloCientifico();
		
		articuloCientifico.setTitulo("Conjugate thermal creep flow in a thin microchannel");
		articuloCientifico.setPalabraClave("Energia3");
		articuloCientifico.setNombreRevista("Synthetic Metals");
		articuloCientifico.setVolumen("245");
		articuloCientifico.setPaginas("135-143");
		articuloCientifico.setAnoPublicacion("2018");
		
		Investigador investigador = new Investigador();
		
		investigador.setNombre("Hugo");
		investigador.setApellido("Gonzalez");
		investigador.setTelefono("5527639487");
		investigador.setGenero("Masculino");
		investigador.setCorreo("hugo.gonzalez.dv10@gmail.com");
		
		List<Investigador> investigadores = new ArrayList<Investigador>();
		
		investigadores.add(investigador);
				
		
		
		Assert.assertTrue("El articulo cientifico se edito", articuloCientificoService.editarArticuloCientifico(articuloCientifico, new Long(45)));
	}
	
	@Test
	public void testBorrarArticuloCientifico() {
		
		Assert.assertTrue("El articulo cientifico se borro", articuloCientificoService.borrarArticuloCientifico(new Long(6)));
		
	}

}
