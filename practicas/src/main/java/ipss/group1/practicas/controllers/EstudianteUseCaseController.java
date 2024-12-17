package ipss.group1.practicas.controllers;

import ipss.group1.practicas.services.dtos.PracticaDTO;
import ipss.group1.practicas.services.usecases.EstudianteUseCase;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/estudiantes")
public class EstudianteUseCaseController {
    private final EstudianteUseCase estudianteUseCase;

    public EstudianteUseCaseController(EstudianteUseCase estudianteUseCase) {
        this.estudianteUseCase = estudianteUseCase;
    }

    @GetMapping("/{estudianteId}/practicas")
    public List<PracticaDTO> getPracticasByEstudianteId(@PathVariable Long estudianteId) {
        return estudianteUseCase.getPracticasByEstudianteId(estudianteId);
    }

    @PostMapping("/{estudianteId}/practicas")
    public ResponseEntity<PracticaDTO> createPractica(@PathVariable Long estudianteId, @RequestBody PracticaDTO practicaDTO) {
        PracticaDTO createdPractica = estudianteUseCase.createPractica(practicaDTO, estudianteId);
        return ResponseEntity.ok(createdPractica);
    }
}