package com.fiap.satagromonitor.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "areas_agricolas")
public class AreaAgricola {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String nomeFazenda;

    private String cultura;
    private Double hectares;
    private Double latitude;
    private Double longitude;

    private LocalDateTime dataCadastro = LocalDateTime.now();

    @OneToMany(mappedBy = "area", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<LeituraSatelite> leituras = new ArrayList<>();

    // Getters e Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getNomeFazenda() { return nomeFazenda; }
    public void setNomeFazenda(String nomeFazenda) { this.nomeFazenda = nomeFazenda; }

    public String getCultura() { return cultura; }
    public void setCultura(String cultura) { this.cultura = cultura; }

    public Double getHectares() { return hectares; }
    public void setHectares(Double hectares) { this.hectares = hectares; }

    public Double getLatitude() { return latitude; }
    public void setLatitude(Double latitude) { this.latitude = latitude; }

    public Double getLongitude() { return longitude; }
    public void setLongitude(Double longitude) { this.longitude = longitude; }

    public LocalDateTime getDataCadastro() { return dataCadastro; }
    public void setDataCadastro(LocalDateTime dataCadastro) { this.dataCadastro = dataCadastro; }

    public List<LeituraSatelite> getLeituras() { return leituras; }
    public void setLeituras(List<LeituraSatelite> leituras) { this.leituras = leituras; }
}
