package ipss.group1.practicas.controllers;

import ipss.group1.practicas.models.Practica;
import ipss.group1.practicas.services.dtos.PracticaDTO;
import ipss.group1.practicas.services.usecases.ProfesorUseCase;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/profesores")
public class ProfesorUseCaseController {
    private final ProfesorUseCase profesorUseCase;

    public ProfesorUseCaseController(ProfesorUseCase profesorUseCase) {
        this.profesorUseCase = profesorUseCase;
    }

    @GetMapping("/practicas")
    public List<PracticaDTO> getAllPracticas() {
        return profesorUseCase.getAllPracticas();
    }

    @GetMapping("/practicas/{id}")
    public ResponseEntity<PracticaDTO> getPracticaById(@PathVariable Long id) {
        Optional<PracticaDTO> practicaDTO = profesorUseCase.getPracticaById(id);
        return practicaDTO.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @GetMapping("/estudiantes/{estudianteId}/practicas")
    public List<PracticaDTO> getPracticasByEstudianteId(@PathVariable Long estudianteId) {
        return profesorUseCase.getPracticasByEstudianteId(estudianteId);
    }

    @PostMapping("/practicas")
    public PracticaDTO createPractica(@RequestBody Practica practica) {
        return profesorUseCase.createPractica(practica);
    }

    @PutMapping("/practicas/{id}")
    public ResponseEntity<PracticaDTO> updatePractica(@PathVariable Long id, @RequestBody Practica practica) {
        Optional<PracticaDTO> updatedPractica = profesorUseCase.updatePractica(id, practica);
        return updatedPractica.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @DeleteMapping("/practicas/{id}")
    public ResponseEntity<Void> deletePractica(@PathVariable Long id) {
        if (profesorUseCase.deletePractica(id)) {
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}