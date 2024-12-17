package ipss.group1.practicas.services;

import ipss.group1.practicas.services.dtos.TutorDTO;
import ipss.group1.practicas.models.Tutor;
import ipss.group1.practicas.repositories.TutorRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class TutorService {
    private final TutorRepository tutorRepository;

    public TutorService(TutorRepository tutorRepository) {
        this.tutorRepository = tutorRepository;
    }

    public List<TutorDTO> getAllTutores() {
        return tutorRepository.findAll().stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    public TutorDTO getTutorById(Long id) {
        return tutorRepository.findById(id)
                .map(this::convertToDTO)
                .orElse(null);
    }

    public TutorDTO createTutor(Tutor tutor) {
        Tutor savedTutor = tutorRepository.save(tutor);
        return convertToDTO(savedTutor);
    }

    public TutorDTO updateTutor(Long id, Tutor tutor) {
        if (tutorRepository.existsById(id)) {
            tutor.setId(id);
            Tutor updatedTutor = tutorRepository.save(tutor);
            return convertToDTO(updatedTutor);
        } else {
            return null;
        }
    }

    public boolean deleteTutor(Long id) {
        if (tutorRepository.existsById(id)) {
            tutorRepository.deleteById(id);
            return true;
        } else {
            return false;
        }
    }

    private TutorDTO convertToDTO(Tutor tutor) {
        TutorDTO dto = new TutorDTO();
        dto.setId(tutor.getId());
        dto.setNombre(tutor.getNombre());
        return dto;
    }
}