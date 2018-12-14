package mx.edu.uacm.bibcientifica.service;

import java.util.List;

import mx.edu.uacm.bibcientifica.domain.Investigador;

/**
 * Capa de servicio para el investigador
 * @author Hugo gonzalez, Ana Sosa
 *
 */
public interface InvestigadorService {
	
	/**
	 * Guarda un investigador
	 * @param investigador
	 * @return
	 */
	boolean guardarInvestigador(final Investigador investigador);
	
	/**
	 * Edita un investigador por id
	 * @param investigador
	 * @param id
	 * @return
	 */
	boolean editarInvestigador(final Investigador investigador, Long id);
	
	/**
	 * Borra un investigador por id
	 * @param id
	 * @return
	 */
	boolean borrarInvestigador(final Long id);
	
	/**
	 * Obtiene un investigador medediante su correo y contrasena
	 * @param correo
	 * @param contrasena
	 * @return
	 */
	Investigador obtenerInvestigadorLogin(final String correo, final String contrasena);
	
	/**
	 * Verifica si un email existe en la base de datos 
	 * @param email
	 * @return
	 */
	Investigador existeEmail(final String email);
	
	
	/**
	 * Obtiene todos los investigadores
	 * @return
	 */
	List<Investigador> obtenerInvestigadores();
	
	/**
	 * Obtiene un investigador por id
	 * @param id
	 * @return
	 */
	Investigador obtenerInvetigador(final Long id);

}
