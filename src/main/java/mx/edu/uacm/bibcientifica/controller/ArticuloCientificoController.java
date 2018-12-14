package mx.edu.uacm.bibcientifica.controller;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import mx.edu.uacm.bibcientifica.domain.ArticuloCientifico;
import mx.edu.uacm.bibcientifica.service.ArticuloCientificoService;

/**
 * 
 * @author Hugo gonzalez, Ana Sosa
 *
 */
@Controller
@RequestMapping("/artCientifico")
public class ArticuloCientificoController {
	
	/**
	 * Logger
	 */
	private static Logger log = LogManager.getLogger(ArticuloCientificoController.class);
	
	/**
	 * Inyexion de dependencias
	 */
	@Autowired
	ArticuloCientificoService articuloCientificoService;
	
	/**
	 * Guarda un articulo cientifico
	 * @param articuloCientifico
	 * @return
	 */
	@PostMapping("/guardar")
	public ModelAndView guardarArticuloCientifico(final ArticuloCientifico articuloCientifico) {
		
		if(articuloCientificoService.guardarArticuloCientifico(articuloCientifico)) {
			return new ModelAndView("redirect:/articulos/todos");			
		} else {
			return new ModelAndView("error");
		}
	}
	
	/**
	 * Editar un articulo cientifico
	 * @param articuloCientifico
	 * @param id
	 * @return
	 */
	@PostMapping("/editar/{id}")
	public ModelAndView editarArticuloCientifico(final ArticuloCientifico articuloCientifico, @PathVariable("id") Long id) {
		
		if(articuloCientificoService.editarArticuloCientifico(articuloCientifico, id)) {
			return new ModelAndView("sucess");
		} else {
			return new ModelAndView("error");
		}
	}
	
	/**
	 * Borrar un articulo cientifico
	 * @param id
	 * @return
	 */
	@GetMapping("/borrar/{id}")
	public ModelAndView borrarArticuloCientifico(@PathVariable("id") Long id) {
		log.info(id + " controller");
		if(articuloCientificoService.borrarArticuloCientifico(id)) {
			return new ModelAndView("redirect:/articulos/todos");
		}
		
		return new ModelAndView("error");
	}
	
	/**
	 * Registrar un articulo cientifico
	 * @param articuloCientifico
	 * @return
	 */
	@PostMapping("/registro")
	public ModelAndView registroArticuloCientifico(final ArticuloCientifico articuloCientifico) {
		
		if(articuloCientificoService.guardarArticuloCientifico(articuloCientifico)) {
			return new ModelAndView("redirect:/articulos/todos");
		}
		return new ModelAndView("error");
	}
	
	
	

}
