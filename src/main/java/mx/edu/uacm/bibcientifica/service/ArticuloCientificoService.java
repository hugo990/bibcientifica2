package mx.edu.uacm.bibcientifica.service;

import java.util.List;

import mx.edu.uacm.bibcientifica.domain.ArticuloCientifico;
import mx.edu.uacm.bibcientifica.domain.Investigador;

/**
 * Capa de servicios para el articulo cientifico 
 * @author Hugo gonzalez, Ana Sosa
 *
 */
public interface ArticuloCientificoService {
	
	/**
	 * Guarda un articulo cientifico
	 * @param articuloCientifico
	 * @return
	 */
	boolean guardarArticuloCientifico(final ArticuloCientifico articuloCientifico);
	
	/**
	 * Edita un articulo cientifico por id
	 * @param articuloCientifico
	 * @param id
	 * @return
	 */
	boolean editarArticuloCientifico(final ArticuloCientifico articuloCientifico, Long id);
	
	/**
	 * Borra un articulo cientifico por id
	 * @param id
	 * @return
	 */
	boolean borrarArticuloCientifico(final Long id);
	
	/**
	 * Obtiene todos los articulos cientificos
	 * @return
	 */
	List<ArticuloCientifico> obtenerArticulos();
	
	/**
	 * Obtiene un articulo cientifico por id
	 * @param id
	 * @return
	 */
	ArticuloCientifico obtenerArticuloCientifico(final Long id);

}
