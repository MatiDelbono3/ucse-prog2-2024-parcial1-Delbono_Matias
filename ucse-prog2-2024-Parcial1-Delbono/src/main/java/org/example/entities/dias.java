package org.example.entities;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name="dias")
public class dias {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "dia")
    private String dia;
    @Column(name = "mes")
    private String mes;
    @Column(name = "anio")
    private String anio;
    @OneToMany(mappedBy = "dia", fetch = FetchType.LAZY)
    private List<feriados> feriados;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDia() {
        return dia;
    }

    public void setDia(String dia) {
        this.dia = dia;
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

    public List<org.example.entities.feriados> getFeriados() {
        return feriados;
    }

    public void setFeriados(List<org.example.entities.feriados> feriados) {
        this.feriados = feriados;
    }
}
