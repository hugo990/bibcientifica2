package mx.edu.uacm.bibcientifica.controller;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import mx.edu.uacm.bibcientifica.domain.ArticuloCientifico;
import mx.edu.uacm.bibcientifica.domain.Investigador;
import mx.edu.uacm.bibcientifica.service.ArticuloCientificoService;
import mx.edu.uacm.bibcientifica.service.InvestigadorService;

/**
 * 
 * @author Hugo gonzalez, Ana Sosa
 *
 */
@Controller
@RequestMapping("/")
public class VistasController {
	
	private static Logger log = LogManager.getLogger(VistasController.class);
	
	/**
	 * Inyexion de dependencias
	 */
	@Autowired
	InvestigadorService investigadorService;
	
	/**
	 * Inyexion de dependencias
	 */
	@Autowired
	ArticuloCientificoService articuloCientificoService;
	
	/**
	 * Inyexion de dependencias
	 */
	@Autowired
	private HttpSession httpSession;

	/**
	 * Vista principal
	 * @return
	 */
	@GetMapping("/")
	public ModelAndView mostrarIndex() {
		return new ModelAndView("home");
	}
	
	/**
	 * Vista del login
	 * @return
	 */
	@GetMapping("login")
	public ModelAndView mostrarLogin() {
		if(httpSession.getAttribute("sesionActiva") == null) {
			return new ModelAndView("login");
		}
		return new ModelAndView("redirect:/");
	}
	
	/**
	 * Vista para registrar un investigador
	 * @return
	 */
	 @GetMapping("/investigador/registro")
	 public ModelAndView mostrarRegistroInvestigador() {
		 if(httpSession.getAttribute("sesionActiva") != null && httpSession.getAttribute("tipo").equals(new String("admin"))) {
			 return new ModelAndView("registroInvestigador");
		 }
		 
		 return new ModelAndView("redirect:/");
		  
	 }
	
	 /**
	  * Vista para registrar un articulo cientifico
	  * @param model
	  * @return
	  */
	 @GetMapping("/articulo/registro")
	 public ModelAndView mostrarRegistroArticulo(Map<String, Object> model) {
		 if(httpSession.getAttribute("sesionActiva") != null && httpSession.getAttribute("tipo").equals(new String("admin"))) {
			 List<Investigador> investigadores = investigadorService.obtenerInvestigadores();
			 log.info(investigadores.size());
			 model.put("invests", investigadores);
			 model.put("id", httpSession.getAttribute("id"));
			 return new ModelAndView("registroArticulo");
		 }
		 
		 return new ModelAndView("redirect:/");
	 }
	 
	 /**
	  * Vista de todos los articulos
	  * @param model
	  * @return
	  */
	 @GetMapping("/articulos/todos")
	 public ModelAndView mostrarArticulosTodos(Map<String, Object> model) {
		 if(httpSession.getAttribute("sesionActiva") != null && httpSession.getAttribute("tipo").equals(new String("admin"))) {
			 List<ArticuloCientifico> articulosCientificos = articuloCientificoService.obtenerArticulos();
			 model.put("arts", articulosCientificos);
			 return new ModelAndView("articulosTodos");
		 }
		 
		 return new ModelAndView("redirect:/");
	 }
	 
	 /**
	  * Vista de todos los investigadores
	  * @param model
	  * @return
	  */
	 @GetMapping("/investigadores/todos")
	 public ModelAndView mostrarInvestigadoresTodos(Map<String, Object> model) {
		 if(httpSession.getAttribute("sesionActiva") != null && httpSession.getAttribute("tipo").equals(new String("admin"))) {
			 List<Investigador> investigadores = investigadorService.obtenerInvestigadores();
			 log.info(investigadores.size());
			 model.put("invest", investigadores);
			 return new ModelAndView("investigadoresTodos");
		 }
		 
		 return new ModelAndView("redirect:/");
	 }
	 
	 /**
	  * Vista para editar un invetsigador
	  * @param model
	  * @param id
	  * @return
	  */
	 @GetMapping("/investigador/editar/{id}")
	 public ModelAndView editarInvestigador(Map<String, Object> model, @PathVariable("id") Long id) {
		 if(httpSession.getAttribute("sesionActiva") != null && httpSession.getAttribute("tipo").equals(new String("admin"))) {
			 Investigador investigador = investigadorService.obtenerInvetigador(id);
			 model.put("invest", investigador);
			 return new ModelAndView("editarInvestigador");
		 }
		 
		 return new ModelAndView("redirect:/");
	 }
	 
	 /**
	  * Vista para editar un articulo cientifico
	  * @param model
	  * @param id
	  * @return
	  */
	 @GetMapping("/articulo/editar/{id}")
	 public ModelAndView editarArticuloCientifico(Map<String, Object> model, @PathVariable("id") Long id) {
		 if(httpSession.getAttribute("sesionActiva") != null && httpSession.getAttribute("tipo").equals(new String("admin"))) {
			 List<Investigador> investigadores = investigadorService.obtenerInvestigadores();
			 ArticuloCientifico articuloCientifico = articuloCientificoService.obtenerArticuloCientifico(id);
			 model.put("invests", investigadores);
			 model.put("art", articuloCientifico);
			 return new ModelAndView("editarArticuloCientifico");
		 }
		 
		 return new ModelAndView("redirect:/");
	 }
}
