package edu.altair.apicrm.entities;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "eventos_calendario", schema = "crm")
public class Eventos_calendario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "titulo", nullable = false, length = 150)
    private String titulo;
    
    @Column(name = "fecha", nullable = false)
    private LocalDate fecha;

    @Column(name = "tipo", nullable = false, length = 20)
    private String tipo;

    @Column(name = "descripcion", length = 500)
    private String descripcion;

    // Constructores
    public Eventos_calendario() {}

	public Eventos_calendario(Long id, String titulo, LocalDate fecha, String tipo, String descripcion) {
		super();
		this.id = id;
		this.titulo = titulo;
		this.fecha = fecha;
		this.tipo = tipo;
		this.descripcion = descripcion;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public LocalDate getFecha() {
		return fecha;
	}

	public void setFecha(LocalDate fecha) {
		this.fecha = fecha;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

    
}

