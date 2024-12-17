package ipss.group1.practicas.controllers.mantainer;

import ipss.group1.practicas.services.dtos.JefeDTO;
import ipss.group1.practicas.models.Jefe;
import ipss.group1.practicas.services.JefeService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/admin/jefes")
public class JefeController {
    private final JefeService jefeService;

    public JefeController(JefeService jefeService) {
        this.jefeService = jefeService;
    }

    @GetMapping
    public List<JefeDTO> getAllJefes() {
        return jefeService.getAllJefes();
    }

    @GetMapping("/{id}")
    public ResponseEntity<JefeDTO> getJefeById(@PathVariable Long id) {
        JefeDTO jefeDTO = jefeService.getJefeById(id);
        if (jefeDTO != null) {
            return ResponseEntity.ok(jefeDTO);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public JefeDTO createJefe(@RequestBody Jefe jefe) {
        return jefeService.createJefe(jefe);
    }

    @PutMapping("/{id}")
    public ResponseEntity<JefeDTO> updateJefe(@PathVariable Long id, @RequestBody Jefe jefe) {
        JefeDTO jefeDTO = jefeService.updateJefe(id, jefe);
        if (jefeDTO != null) {
            return ResponseEntity.ok(jefeDTO);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteJefe(@PathVariable Long id) {
        if (jefeService.deleteJefe(id)) {
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}