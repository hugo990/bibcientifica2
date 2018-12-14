package mx.edu.uacm.bibcientifica.service.impl;

import java.util.List;
import java.util.Optional;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import com.google.common.collect.Lists;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import mx.edu.uacm.bibcientifica.controller.InvestigadorController;
import mx.edu.uacm.bibcientifica.domain.Investigador;
import mx.edu.uacm.bibcientifica.repository.InvestigadorRepository;
import mx.edu.uacm.bibcientifica.service.InvestigadorService;

/**
 * Implementacion de servicio para el investigadors
 * @author PC
 *
 */
@Service
public class InvestigadorServiceImpl implements InvestigadorService {
	
	private static Logger log = LogManager.getLogger(InvestigadorController.class);
	
	/**
	 * Inyexion de dependencias
	 */
	@Autowired
	InvestigadorRepository investigadorRepository;
	

	/*@
	 * (non-Javadoc)
	 * @see mx.edu.uacm.bibcientifica.service.InvestigadorService#guardarInvestigador(mx.edu.uacm.bibcientifica.domain.Investigador)
	 */
	@Override
	public boolean guardarInvestigador(final Investigador investigador) {
		
		Investigador nuevoInvestigador = investigadorRepository.save(investigador);
		
		if(nuevoInvestigador != null) {
			return true;
		} else {
			log.info("El usuario no existe");
		}
		
		return false;
		
	}

	/*@
	 * (non-Javadoc)
	 * @see mx.edu.uacm.bibcientifica.service.InvestigadorService#editarInvestigador(mx.edu.uacm.bibcientifica.domain.Investigador, java.lang.Long)
	 */
	@Override
	public boolean editarInvestigador(final Investigador investigador, final Long id) {
		Optional<Investigador> invest = investigadorRepository.findById(id);
		
		if(invest.isPresent()) {
			Investigador inv = investigador;
			inv.setId(id);
			Investigador nuevoInvestigador = investigadorRepository.save(inv);
			if(nuevoInvestigador != null) {
				return true;
			}
		}
		return false;
	}

	/*@
	 * (non-Javadoc)
	 * @see mx.edu.uacm.bibcientifica.service.InvestigadorService#borrarInvestigador(java.lang.Long)
	 */
	@Override
	public boolean borrarInvestigador(final Long id) {
		Optional<Investigador> investigador = investigadorRepository.findById(id);
		
		if(investigador.isPresent()) {
			Investigador invest = investigador.get();
			investigadorRepository.delete(invest);
			return true;
		}
		
		
		return false;
	}

	/*@
	 * (non-Javadoc)
	 * @see mx.edu.uacm.bibcientifica.service.InvestigadorService#obtenerInvestigadorLogin(java.lang.String, java.lang.String)
	 */
	@Override
	public Investigador obtenerInvestigadorLogin(final String correo, final String contrasena) {
		
		Investigador investigador = investigadorRepository.findByInvestigador(correo, contrasena);
		
		if(investigador != null) {
			return investigador;
		}
		
		return null;
	}

	/*@
	 * (non-Javadoc)
	 * @see mx.edu.uacm.bibcientifica.service.InvestigadorService#existeEmail(java.lang.String)
	 */
	@Override
	public Investigador existeEmail(final String email) {
		Investigador investigador = investigadorRepository.findByEmail(email);
		
		if(investigador != null) {
			return investigador;			
		}
		
		return null;
	}

	/*@
	 * (non-Javadoc)
	 * @see mx.edu.uacm.bibcientifica.service.InvestigadorService#obtenerInvestigadores()
	 */
	@Override
	public List<Investigador> obtenerInvestigadores() {
		return Lists.newArrayList(investigadorRepository.findAll());
	}

	/*@
	 * (non-Javadoc)
	 * @see mx.edu.uacm.bibcientifica.service.InvestigadorService#obtenerInvetigador(java.lang.Long)
	 */
	@Override
	public Investigador obtenerInvetigador(final Long id) {
		return investigadorRepository.findById(id).orElse(null);
	}

}
