package com.example.NutreAPP.models;

import java.time.LocalDate;
import java.util.UUID;



import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity 
@Table (name = "visualizacion")
public class Visualizacion {

    @Id 
    @GeneratedValue  (strategy = GenerationType.UUID)
    private UUID id;

    @Column (name="fechaVisualizacion", nullable = false, unique = false, length = 100)
    private LocalDate fechaVisualizacion;

    @Column (name="completado", nullable = false, unique = false )
    private Boolean completado;

    //creando relaciones
    @ManyToOne
    @JoinColumn(name = "idUsuario")
    @JsonBackReference(value = "usuarioVisualizacion")
    private Usuario usuario;

    @ManyToOne
    @JoinColumn(name = "idVideo")
    @JsonBackReference(value = "videoVisualizacion")
    private Video video;

    

    
    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Video getVideo() {
        return video;
    }

    public void setVideo(Video video) {
        this.video = video;
    }

    public Visualizacion() {
    }

    public Visualizacion(UUID id, LocalDate fechaVisualizacion, Boolean completado) {
        this.id = id;
        this.fechaVisualizacion = fechaVisualizacion;
        this.completado = completado;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public LocalDate getFechaVisualizacion() {
        return fechaVisualizacion;
    }

    public void setFechaVisualizacion(LocalDate fechaVisualizacion) {
        this.fechaVisualizacion = fechaVisualizacion;
    }

    public Boolean getCompletado() {
        return completado;
    }

    public void setCompletado(Boolean completado) {
        this.completado = completado;
    }

    
}
