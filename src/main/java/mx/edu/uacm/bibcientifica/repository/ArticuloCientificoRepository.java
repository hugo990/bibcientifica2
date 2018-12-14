package mx.edu.uacm.bibcientifica.repository;

import org.springframework.data.repository.CrudRepository;

import mx.edu.uacm.bibcientifica.domain.ArticuloCientifico;

/**
 * Operaciones CRUD para el articulo cientifico
 * @author Hugo gonzalez, Ana Sosa
 *
 */
public interface ArticuloCientificoRepository extends CrudRepository<ArticuloCientifico, Long> {

}
