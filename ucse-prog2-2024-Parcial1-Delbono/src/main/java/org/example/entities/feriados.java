package org.example.entities;

import jakarta.persistence.*;

@Entity
@Table(name="feriados")
public class feriados {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "dia")
    private String descripcion;
    @Column(name = "descripcion")
    private String mes;
    @Column(name = "dia")
    private String anio;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "dia_trabajo_id")
    private dias dias;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getMes() {
        return mes;
    }

    public void setMes(String mes) {
        this.mes = mes;
    }

    public String getAnio() {
        return anio;
    }

    public void setAnio(String anio) {
        this.anio = anio;
    }

    public org.example.entities.dias getDias() {
        return dias;
    }

    public void setDias(org.example.entities.dias dias) {
        this.dias = dias;
    }
}
