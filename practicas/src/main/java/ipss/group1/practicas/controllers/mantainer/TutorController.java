package ipss.group1.practicas.controllers.mantainer;

import ipss.group1.practicas.services.dtos.TutorDTO;
import ipss.group1.practicas.models.Tutor;
import ipss.group1.practicas.services.TutorService;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/admin/tutores")
public class TutorController {
    private final TutorService tutorService;

    public TutorController(TutorService tutorService) {
        this.tutorService = tutorService;
    }

    @GetMapping
    public List<TutorDTO> getAllTutores() {
        return tutorService.getAllTutores();
    }

    @GetMapping("/{id}")
    public ResponseEntity<TutorDTO> getTutorById(@PathVariable Long id) {
        TutorDTO tutorDTO = tutorService.getTutorById(id);
        if (tutorDTO != null) {
            return ResponseEntity.ok(tutorDTO);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public TutorDTO createTutor(@RequestBody Tutor tutor) {
        return tutorService.createTutor(tutor);
    }

    @PutMapping("/{id}")
    public ResponseEntity<TutorDTO> updateTutor(@PathVariable Long id, @RequestBody Tutor tutor) {
        TutorDTO tutorDTO = tutorService.updateTutor(id, tutor);
        if (tutorDTO != null) {
            return ResponseEntity.ok(tutorDTO);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTutor(@PathVariable Long id) {
        if (tutorService.deleteTutor(id)) {
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}