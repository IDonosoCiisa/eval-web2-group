// PracticaService.java
package ipss.group1.practicas.services;

import ipss.group1.practicas.services.dtos.PracticaDTO;
import ipss.group1.practicas.models.Practica;
import ipss.group1.practicas.repositories.PracticaRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PracticaService {
    private final PracticaRepository practicaRepository;

    public PracticaService(PracticaRepository practicaRepository) {
        this.practicaRepository = practicaRepository;
    }

    public List<PracticaDTO> getAllPracticas() {
        return practicaRepository.findAll().stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    public PracticaDTO getPracticaById(Long id) {
        return practicaRepository.findById(id)
                .map(this::convertToDTO)
                .orElse(null);
    }

    public PracticaDTO createPractica(Practica practica) {
        Practica savedPractica = practicaRepository.save(practica);
        return convertToDTO(savedPractica);
    }

    public PracticaDTO updatePractica(Long id, Practica practica) {
        if (practicaRepository.existsById(id)) {
            practica.setId(id);
            Practica updatedPractica = practicaRepository.save(practica);
            return convertToDTO(updatedPractica);
        } else {
            return null;
        }
    }

    public boolean deletePractica(Long id) {
        if (practicaRepository.existsById(id)) {
            practicaRepository.deleteById(id);
            return true;
        } else {
            return false;
        }
    }

    private PracticaDTO convertToDTO(Practica practica) {
        PracticaDTO dto = new PracticaDTO();
        dto.setId(practica.getId());
        dto.setDescripcion(practica.getDescripcion());
        dto.setEstudianteId(practica.getEstudiante().getId());
        dto.setTutorId(practica.getTutor().getId());
        dto.setEmpresaId(practica.getEmpresa().getId());
        return dto;
    }
}