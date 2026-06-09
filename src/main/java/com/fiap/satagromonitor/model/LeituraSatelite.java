package com.fiap.satagromonitor.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "leituras_satelite")
public class LeituraSatelite {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDateTime dataLeitura = LocalDateTime.now();
    private Double ndvi;
    private Double temperaturaSolo;
    private Double umidadeSolo;
    private String riscoDesastre;
    private String observacoes;

    @ManyToOne
    @JoinColumn(name = "area_id")
    private AreaAgricola area;

    // Getters e Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public LocalDateTime getDataLeitura() { return dataLeitura; }
    public void setDataLeitura(LocalDateTime dataLeitura) { this.dataLeitura = dataLeitura; }

    public Double getNdvi() { return ndvi; }
    public void setNdvi(Double ndvi) { this.ndvi = ndvi; }

    public Double getTemperaturaSolo() { return temperaturaSolo; }
    public void setTemperaturaSolo(Double temperaturaSolo) { this.temperaturaSolo = temperaturaSolo; }

    public Double getUmidadeSolo() { return umidadeSolo; }
    public void setUmidadeSolo(Double umidadeSolo) { this.umidadeSolo = umidadeSolo; }

    public String getRiscoDesastre() { return riscoDesastre; }
    public void setRiscoDesastre(String riscoDesastre) { this.riscoDesastre = riscoDesastre; }

    public String getObservacoes() { return observacoes; }
    public void setObservacoes(String observacoes) { this.observacoes = observacoes; }

    public AreaAgricola getArea() { return area; }
    public void setArea(AreaAgricola area) { this.area = area; }
}
