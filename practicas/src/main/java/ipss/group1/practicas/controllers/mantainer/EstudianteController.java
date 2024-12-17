package ipss.group1.practicas.controllers.mantainer;

import ipss.group1.practicas.services.dtos.EstudianteDTO;
import ipss.group1.practicas.models.Estudiante;
import ipss.group1.practicas.services.EstudianteService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/admin/estudiantes")
public class EstudianteController {
    private final EstudianteService estudianteService;

    public EstudianteController(EstudianteService estudianteService) {
        this.estudianteService = estudianteService;
    }

    @GetMapping
    public List<EstudianteDTO> getAllEstudiantes() {
        return estudianteService.getAllEstudiantes();
    }

    @GetMapping("/{id}")
    public ResponseEntity<EstudianteDTO> getEstudianteById(@PathVariable Long id) {
        EstudianteDTO estudianteDTO = estudianteService.getEstudianteById(id);
        if (estudianteDTO != null) {
            return ResponseEntity.ok(estudianteDTO);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public EstudianteDTO createEstudiante(@RequestBody Estudiante estudiante) {
        return estudianteService.createEstudiante(estudiante);
    }

    @PutMapping("/{id}")
    public ResponseEntity<EstudianteDTO> updateEstudiante(@PathVariable Long id, @RequestBody Estudiante estudiante) {
        EstudianteDTO estudianteDTO = estudianteService.updateEstudiante(id, estudiante);
        if (estudianteDTO != null) {
            return ResponseEntity.ok(estudianteDTO);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteEstudiante(@PathVariable Long id) {
        if (estudianteService.deleteEstudiante(id)) {
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}