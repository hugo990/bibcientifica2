package mx.edu.uacm.bibcientifica.controller;

import java.util.Map;
import javax.servlet.http.HttpSession;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import mx.edu.uacm.bibcientifica.domain.Investigador;
import mx.edu.uacm.bibcientifica.service.InvestigadorService;

/**
 * 
 * @author Hugo gonzalez, Ana Sosa
 *
 */
@Controller
@RequestMapping("/investigador")
public class InvestigadorController {
	
	private static Logger log = LogManager.getLogger(InvestigadorController.class);
	
	/**
	 * Inyexion de dependencias
	 */
	@Autowired
	InvestigadorService investigadorService;
	
	/**
	 * Inyexion de dependencias
	 */
	@Autowired
	private HttpSession httpSession;
	
	/**
	 * Guarda un investigador
	 * @param investigador
	 * @return
	 */
	@PostMapping("/guardar")
	public ModelAndView guardarInvestigador(final Investigador investigador) {
		
		if(investigadorService.guardarInvestigador(investigador)) {
			return new ModelAndView("redirect:/investigador/registro");
		}
		
		return new ModelAndView("error");
	}
	
	/**
	 * 
	 * @param investigador
	 * @param id
	 * @return
	 */
	@PostMapping("/editar/{id}")
	public ModelAndView editarInvestigador(final Investigador investigador, @PathVariable("id") Long id) {
		
		if(investigadorService.editarInvestigador(investigador, id)) {
			return new ModelAndView("redirect:/investigadores/todos");
		}
		
		
		return new ModelAndView("error");
	}
	
	
	/**
	 * Borra un investigador
	 * @param id
	 * @return
	 */
	@GetMapping("/borrar/{id}")
	public ModelAndView borrarInvestigador(@PathVariable("id") Long id) {
		
		if(investigadorService.borrarInvestigador(id)) {
			return new ModelAndView("redirect:/investigador/registro");
		}
		
		return new ModelAndView("error");
		
	}
	
	/**
	 * Crea la sesion de un investigador
	 * @param model
	 * @param investigador
	 * @return
	 */
	@PostMapping("/login")
	public ModelAndView loginInvestigador(Map<String, Object> model, final Investigador investigador) {
		Investigador obtenerInvestigador = investigadorService.obtenerInvestigadorLogin(investigador.getCorreo(), investigador.getContrasena());
		log.info(obtenerInvestigador.getTipoUsuario());
		
		if(obtenerInvestigador != null) {
			httpSession.setAttribute("sesionActiva", "si");
			httpSession.setAttribute("tipo", obtenerInvestigador.getTipoUsuario());
			httpSession.setAttribute("id", obtenerInvestigador.getId());
			
			return new ModelAndView("redirect:/");
		}
		
		return new ModelAndView("redirect:/login");
	}
	
	/**
	 * Registra un investigador en la base de datos
	 * @param investigador
	 * @param result
	 * @return
	 */
	@PostMapping("/registro")
	public ModelAndView registroInvestigador(final Investigador investigador, BindingResult result) {
		if(result.hasErrors()) {
			return new ModelAndView("registroInvestigador");
		} else {
			if(investigadorService.guardarInvestigador(investigador)) {
				return new ModelAndView("redirect:/investigadores/todos");		
			}
		}
		return new ModelAndView("redirect:/investigador/registro");		
	}
	
	/**
	 * Cierra la sesion del investigador actual
	 * @return
	 */
	@GetMapping("logout")
	public ModelAndView logoutInvestigador() {
		httpSession.removeAttribute("sesionActiva");
		httpSession.removeAttribute("tipo");
		return new ModelAndView("redirect:/");
	}
	
	/**
	 * Verifica si un email ya ha sido regstrado en la base de datos
	 * @param email
	 * @return
	 */
	@GetMapping("/existeEmail/{email}")
	public ResponseEntity<String> existeEmail(@PathVariable("email") String email) {
		Investigador investigador = investigadorService.existeEmail(email);
		if(investigador != null) {
			return ResponseEntity.ok("Existe");
		}
		
		
		return ResponseEntity.ok("No existe");
	}

}
