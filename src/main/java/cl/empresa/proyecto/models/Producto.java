package cl.empresa.proyecto.models;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name="productos")

public class Producto {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	private String nombre;
	private String descripcion;
	private float precio;
	@Column(updatable=false)
	private Date createdAt;
	private Date updatedAt;
	
	//Establecer la relacion manytomany
	
	@ManyToMany(fetch=FetchType.LAZY)
	@JoinTable(
			name = "categorias_productos",
			joinColumns=@JoinColumn(name="producto_id"),
			inverseJoinColumns = @JoinColumn(name="categoria_id")
	)
	private List<Categoria> categorias;
	
	
	
	
	
	
}
