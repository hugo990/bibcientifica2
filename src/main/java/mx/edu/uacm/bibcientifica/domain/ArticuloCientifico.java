package mx.edu.uacm.bibcientifica.domain;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;

/**
 * Entidad del dominio. Articulo cientifico
 * @author Hugo gonzalez, Ana Sosa
 *
 */
@Entity
public class ArticuloCientifico {
	
	/**
	 * id investigador
	 */
	@Id()
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	/**
	 * titulo investigador
	 */
	@NotNull
	@Column
	private String titulo;
	
	/**
	 * palabraClave investigador
	 */
	@NotNull
	@Column
	private String palabraClave;
	
	/**
	 * palabraClave2 investigador
	 */
	@Column
	private String palabraClave2;
	
	/**
	 * id investigador
	 */
	@NotNull
	@Column
	private String nombreRevista;
	
	/**
	 * volumen investigador
	 */
	@NotNull
	@Column
	private String volumen;
	
	/**
	 * paginas investigador
	 */
	@NotNull
	@Column
	private String paginas;
	
	/**
	 * anoPublicacion investigador
	 */
	@NotNull
	@Column
	private String anoPublicacion;
		
	/**
	 * Investigador investigador
	 */
	@ManyToOne(cascade=CascadeType.REMOVE,
			fetch=FetchType.EAGER)
	private Investigador investigador;

	/**
	 * obtener el id del articulo cientifico
	 * @return
	 */
	public Long getId() {
		return id;
	}

	/**
	 * establecer el id del articulo cientifico
	 * @param id
	 */
	public void setId(final Long id) {
		this.id = id;
	}

	/**
	 * obtener el titulo del articulo cientifico
	 * @return
	 */
	public String getTitulo() {
		return titulo;
	}

	/**
	 * establecer el titulo del articulo cientifico
	 * @param titulo
	 */
	public void setTitulo(final String titulo) {
		this.titulo = titulo;
	}

	/**
	 * obtener la palabra clave del articulo cientifico
	 * @return
	 */
	public String getPalabraClave() {
		return palabraClave;
	}
	
	/**
	 * establecer la palabra clave del articulo cientifico
	 * @param palabraClave
	 */
	public void setPalabraClave(final String palabraClave) {
		this.palabraClave = palabraClave;
	}

	/**
	 * obtener la palabra clave del articulo cientifico
	 * @return
	 */
	public String getPalabraClave2() {
		return palabraClave2;
	}

	/**
	 * Establecer la palabra clave del articulo cientifico
	 * @param palabraClave2
	 */
	public void setPalabraClave2(final String palabraClave2) {
		this.palabraClave2 = palabraClave2;
	}

	/**
	 * Obtiene el nombre de la revista donde se publico el articulo cientifico
	 * @return
	 */
	public String getNombreRevista() {
		return nombreRevista;
	}

	/**
	 * Establece el nombre de la revista donde se publico el articulo cientifico
	 * @param nombreRevista
	 */
	public void setNombreRevista(final String nombreRevista) {
		this.nombreRevista = nombreRevista;
	}

	/**
	 * Obtiene el volumen de la revista del articulo cientifico
	 * @return
	 */
	public String getVolumen() {
		return volumen;
	}

	/**
	 * Establece el volumen de la revista del articulo cientifico
	 * @param volumen
	 */
	public void setVolumen(final String volumen) {
		this.volumen = volumen;
	}

	/**
	 * Obtiene el numero de las paginas donde apaerece el articulo cientifico
	 * @return
	 */
	public String getPaginas() {
		return paginas;
	}

	/**
	 * Establece el numero de las paginas donde apaerece el articulo cientifico
	 * @param paginas
	 */
	public void setPaginas(final String paginas) {
		this.paginas = paginas;
	}

	/**
	 * Obtiene el ano de publicacion del articulo cientifico
	 * @return
	 */
	public String getAnoPublicacion() {
		return anoPublicacion;
	}

	/**
	 * Establece el ano de publicacion del articulo cientifico
	 * @param anoPublicacion
	 */
	public void setAnoPublicacion(final String anoPublicacion) {
		this.anoPublicacion = anoPublicacion;
	}

	/**
	 * Obtiene el investigador que publico el articulo cientifico
	 * @return
	 */
	public Investigador getInvestigador() {
		return investigador;
	}
	
	/**
	 * Establece el investigador que publico el articulo cientifico
	 * @param investigador
	 */
	public void setInvestigador(final Investigador investigador) {
		this.investigador = investigador;
	}
}
