package com.fiap.satagromonitor.controller;

import com.fiap.satagromonitor.model.AreaAgricola;
import com.fiap.satagromonitor.repository.AreaAgricolaRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/areas")
public class AreaAgricolaController {

    private final AreaAgricolaRepository repository;

    public AreaAgricolaController(AreaAgricolaRepository repository) {
        this.repository = repository;
    }

    @GetMapping
    public List<AreaAgricola> listarTodas() {
        return repository.findAll();
    }

    @PostMapping
    public AreaAgricola criar(@RequestBody AreaAgricola area) {
        return repository.save(area);
    }

    @GetMapping("/{id}")
    public AreaAgricola buscarPorId(@PathVariable Long id) {
        return repository.findById(id).orElseThrow();
    }

    @PutMapping("/{id}")
    public AreaAgricola atualizar(@PathVariable Long id, @RequestBody AreaAgricola areaAtualizada) {
        AreaAgricola area = repository.findById(id).orElseThrow();
        area.setNomeFazenda(areaAtualizada.getNomeFazenda());
        area.setCultura(areaAtualizada.getCultura());
        area.setHectares(areaAtualizada.getHectares());
        area.setLatitude(areaAtualizada.getLatitude());
        area.setLongitude(areaAtualizada.getLongitude());
        return repository.save(area);
    }

    @DeleteMapping("/{id}")
    public void deletar(@PathVariable Long id) {
        repository.deleteById(id);
    }
}
