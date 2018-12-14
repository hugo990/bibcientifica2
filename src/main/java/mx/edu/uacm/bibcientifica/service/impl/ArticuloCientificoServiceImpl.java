package mx.edu.uacm.bibcientifica.service.impl;

import java.util.List;
import java.util.Optional;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.google.common.collect.Lists;

import mx.edu.uacm.bibcientifica.domain.ArticuloCientifico;
import mx.edu.uacm.bibcientifica.repository.ArticuloCientificoRepository;
import mx.edu.uacm.bibcientifica.repository.InvestigadorRepository;
import mx.edu.uacm.bibcientifica.service.ArticuloCientificoService;

/**
 * Implementacion de la capa de servicios para el articulo cinetifico
 * @author Hugo gonzalez, Ana Sosa
 */
@Service
public class ArticuloCientificoServiceImpl implements ArticuloCientificoService {
	
	/**
	 * Logger
	 */
	private static Logger log = LogManager.getLogger(ArticuloCientificoServiceImpl.class);

	/**
	 * Inyexion de dependencias
	 */
	@Autowired
	ArticuloCientificoRepository articuloCientificoRepository;
	
	/**
	 * Inyexion de dependencias
	 */
	@Autowired
	InvestigadorRepository investigadorRepository;
	
	/*@
	 * (non-Javadoc)
	 * @see mx.edu.uacm.bibcientifica.service.ArticuloCientificoService#guardarArticuloCientifico(mx.edu.uacm.bibcientifica.domain.ArticuloCientifico)
	 */
	@Override
	public boolean guardarArticuloCientifico(final ArticuloCientifico articuloCientifico) {
		
		ArticuloCientifico nuevoArticuloCientifico = articuloCientificoRepository.save(articuloCientifico);
		
		if(nuevoArticuloCientifico != null) {
			return true;
		}
		
		return false;
	}

	/*@
	 * (non-Javadoc)
	 * @see mx.edu.uacm.bibcientifica.service.ArticuloCientificoService#editarArticuloCientifico(mx.edu.uacm.bibcientifica.domain.ArticuloCientifico, java.lang.Long)
	 */
	@Override
	public boolean editarArticuloCientifico(final ArticuloCientifico articuloCientifico, final Long id) {
		Optional<ArticuloCientifico> artCientifico = articuloCientificoRepository.findById(id);
		
		if(artCientifico.isPresent()) {
			ArticuloCientifico articuloCient = articuloCientifico;
			articuloCient.setId(id);
			ArticuloCientifico aC = articuloCientificoRepository.save(articuloCient);
			
			if(aC != null) {
				return true;
			}
		}		
		return false;
	}

	/*@
	 * (non-Javadoc)
	 * @see mx.edu.uacm.bibcientifica.service.ArticuloCientificoService#borrarArticuloCientifico(java.lang.Long)
	 */
	@Override
	public boolean borrarArticuloCientifico(final Long id) {
		
		Optional<ArticuloCientifico> articuloCientifico = articuloCientificoRepository.findById(id);
		log.info(id + " service");
		if(articuloCientifico.isPresent()) {
			ArticuloCientifico artCientifico = articuloCientifico.get();
			articuloCientificoRepository.delete(artCientifico);
			return true;
		}
		
		return false;
	}

	/*@
	 * (non-Javadoc)
	 * @see mx.edu.uacm.bibcientifica.service.ArticuloCientificoService#obtenerArticulos()
	 */
	@Override
	public List<ArticuloCientifico> obtenerArticulos() {
		return Lists.newArrayList(articuloCientificoRepository.findAll());
	}

	/*@
	 * (non-Javadoc)
	 * @see mx.edu.uacm.bibcientifica.service.ArticuloCientificoService#obtenerArticuloCientifico(java.lang.Long)
	 */
	@Override
	public ArticuloCientifico obtenerArticuloCientifico(final Long id) {
		return articuloCientificoRepository.findById(id).orElse(null);
	}

}
