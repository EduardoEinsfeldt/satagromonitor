package com.fiap.satagromonitor.controller;

import com.fiap.satagromonitor.model.AreaAgricola;
import com.fiap.satagromonitor.model.LeituraSatelite;
import com.fiap.satagromonitor.repository.AreaAgricolaRepository;
import com.fiap.satagromonitor.repository.LeituraSateliteRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/leituras")
public class LeituraSateliteController {

    private final LeituraSateliteRepository leituraRepository;
    private final AreaAgricolaRepository areaRepository;

    public LeituraSateliteController(LeituraSateliteRepository leituraRepository,
                                     AreaAgricolaRepository areaRepository) {
        this.leituraRepository = leituraRepository;
        this.areaRepository = areaRepository;
    }

    @GetMapping
    public List<LeituraSatelite> listarTodas() {
        return leituraRepository.findAll();
    }

    @PostMapping
    public LeituraSatelite criar(@RequestBody LeituraRequest request) {
        AreaAgricola area = areaRepository.findById(request.getAreaId())
                .orElseThrow(() -> new RuntimeException("Área não encontrada"));

        LeituraSatelite leitura = new LeituraSatelite();
        leitura.setNdvi(request.getNdvi());
        leitura.setTemperaturaSolo(request.getTemperaturaSolo());
        leitura.setUmidadeSolo(request.getUmidadeSolo());
        leitura.setRiscoDesastre(request.getRiscoDesastre());
        leitura.setObservacoes(request.getObservacoes());
        leitura.setArea(area);

        return leituraRepository.save(leitura);
    }

    @GetMapping("/{id}")
    public LeituraSatelite buscarPorId(@PathVariable Long id) {
        return leituraRepository.findById(id).orElseThrow();
    }

    @DeleteMapping("/{id}")
    public void deletar(@PathVariable Long id) {
        leituraRepository.deleteById(id);
    }

    // Classe interna simples para receber o JSON no POST
    public static class LeituraRequest {
        private Long areaId;
        private Double ndvi;
        private Double temperaturaSolo;
        private Double umidadeSolo;
        private String riscoDesastre;
        private String observacoes;

        // Getters e Setters
        public Long getAreaId() { return areaId; }
        public void setAreaId(Long areaId) { this.areaId = areaId; }
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
    }
}
