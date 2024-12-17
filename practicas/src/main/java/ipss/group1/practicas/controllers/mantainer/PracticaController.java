// PracticaController.java
package ipss.group1.practicas.controllers.mantainer;

import ipss.group1.practicas.services.dtos.PracticaDTO;
import ipss.group1.practicas.models.Practica;
import ipss.group1.practicas.services.PracticaService;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/admin/practicas")
public class PracticaController {
    private final PracticaService practicaService;

    public PracticaController(PracticaService practicaService) {
        this.practicaService = practicaService;
    }

    @GetMapping
    public List<PracticaDTO> getAllPracticas() {
        return practicaService.getAllPracticas();
    }

    @GetMapping("/{id}")
    public ResponseEntity<PracticaDTO> getPracticaById(@PathVariable Long id) {
        PracticaDTO practicaDTO = practicaService.getPracticaById(id);
        if (practicaDTO != null) {
            return ResponseEntity.ok(practicaDTO);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public PracticaDTO createPractica(@RequestBody Practica practica) {
        return practicaService.createPractica(practica);
    }

    @PutMapping("/{id}")
    public ResponseEntity<PracticaDTO> updatePractica(@PathVariable Long id, @RequestBody Practica practica) {
        PracticaDTO practicaDTO = practicaService.updatePractica(id, practica);
        if (practicaDTO != null) {
            return ResponseEntity.ok(practicaDTO);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePractica(@PathVariable Long id) {
        if (practicaService.deletePractica(id)) {
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}