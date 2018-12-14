package mx.edu.uacm.bibcientifica.domain;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.ColumnTransformer;

/**
 * Entidad del dominio. Investigador
 * @author Hugo gonzalez, Ana Sosa
 *
 */
@Entity()
public class Investigador {
	
	/**
	 * Id investigador
	 */
	@Id
	@Column()
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	/**
	 * nombre investigador
	 */
	@NotNull
	@Column
	private String nombre;
	
	/**
	 * apellido investigador
	 */
	@NotNull
	@Column
	private String apellido;
	
	/**
	 * telefono investigador
	 */
	@NotNull
	@Column
	private String telefono;
	
	/**
	 * correo investigador
	 */
	@NotNull
	@Column
	private String correo;
	
	/**
	 * contrasena investigador
	 */
	@NotNull
	@Column
	@ColumnTransformer(write=" MD5(?) ")
	private String contrasena;
	
	/**
	 * contrasena2 investigador
	 */
	@Column
	@ColumnTransformer(write=" MD5(?) ")
	private String contrasena2;
	
	/**
	 * genero investigador
	 */
	@NotNull
	@Column
	private String genero;
	
	/**
	 * tipoUsuario investigador
	 */
	@NotNull
	@Column
	private String tipoUsuario;
	
	/**
	 * articulosCientificos investigador
	 */
	@OneToMany(mappedBy="investigador", 
			cascade=CascadeType.ALL, 
			fetch=FetchType.EAGER)
	private List<ArticuloCientifico> articulosCientificos = new ArrayList<ArticuloCientifico>();
	
	/**
	 * Obtiene la contrasena del investigador
	 * @return
	 */
	public String getContrasena2() {
		return contrasena2;
	}

	/**
	 * Establece la contrasena del investigador
	 * @return
	 */
	public void setContrasena2(final String contrasena2) {
		this.contrasena2 = contrasena2;
	}
	
	/**
	 * Obtiene el tipo de usuario del investigador
	 * @return
	 */
	public String getTipoUsuario() {
		return tipoUsuario;
	}

	/**
	 * Establce el tipo de usuario del investigador
	 * @param tipoUsuario
	 */
	public void setTipoUsuario(final String tipoUsuario) {
		this.tipoUsuario = tipoUsuario;
	}
	
	/**
	 * Obtiene el id del investigador
	 * @return
	 */
	public Long getId() {
		return id;
	}
	
	/**
	 * Establce el id del investigador
	 * @param id
	 */
	public void setId(final Long id) {
		this.id = id;
	}
	
	/**
	 * Obtiene el nombre del investigador
	 * @return
	 */
	public String getNombre() {
		return nombre;
	}

	/**
	 * Establce el nombre del investigador
	 * @param nombre
	 */
	public void setNombre(final String nombre) {
		this.nombre = nombre;
	}

	/**
	 * Obtiene el apellido del investigador
	 * @return
	 */
	public String getApellido() {
		return apellido;
	}

	/**
	 * Establece el apellido del investigador
	 * @param apellido
	 */
	public void setApellido(final String apellido) {
		this.apellido = apellido;
	}

	/**
	 * Obtiene el telefono del investigador
	 * @return
	 */
	public String getTelefono() {
		return telefono;
	}

	/**
	 * Establce el telefono del investigador
	 * @param telefono
	 */
	public void setTelefono(final String telefono) {
		this.telefono = telefono;
	}

	/**
	 * Obtiene el correo del investigador
	 * @return
	 */
	public String getCorreo() {
		return correo;
	}

	/**
	 * Establce el corre del investigador
	 * @param correo
	 */
	public void setCorreo(final String correo) {
		this.correo = correo;
	}

	/**
	 * Obtiene el genero del investigador
	 * @return
	 */
	public String getGenero() {
		return genero;
	}

	/**
	 * Establece el genero del investigador
	 * @param genero
	 */
	public void setGenero(final String genero) {
		this.genero = genero;
	}

	/**
	 * Obtiene la contrasena del investigador
	 * @return
	 */
	public String getContrasena() {
		return contrasena;
	}

	/**
	 * Establece el contrasena del investigador
	 * @param contrasena
	 */
	public void setContrasena(final String contrasena) {
		this.contrasena = contrasena;
	}

	/**
	 * Obtiene los articulos del investigador
	 * @return
	 */
	public List<ArticuloCientifico> getArticulosCientificos() {
		return articulosCientificos;
	}

	/**
	 * Establece los articulos del investigador
	 * @param articulosCientificos
	 */
	public void setArticulosCientificos(List<ArticuloCientifico> articulosCientificos) {
		this.articulosCientificos = articulosCientificos;
	}

	
	
	

	
	

}
