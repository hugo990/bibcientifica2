package mx.edu.uacm.bibcientifica.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import mx.edu.uacm.bibcientifica.domain.Investigador;

/**
 * Operaciones CRUD para el investigador
 * @author Hugo gonzalez, Ana Sosa
 *
 */
public interface InvestigadorRepository extends CrudRepository<Investigador, Long> {

	/**
	 * Verifica si un usuario existe mediante su usuario y contraseña
	 * @param email
	 * @param contrasenia
	 * @return
	 */
	@Query(value="select * from investigador where correo= :correo AND contrasena = MD5(:pass)", nativeQuery=true)
	Investigador findByInvestigador(@Param("correo") String email, 
			@Param("pass") String contrasenia);
	
	/**
	 * Verifica si ya existe un correo
	 * @param email
	 * @return
	 */
	@Query(value="select * from investigador where correo= :correo", nativeQuery = true)
	Investigador findByEmail(@Param("correo") String email);
}
