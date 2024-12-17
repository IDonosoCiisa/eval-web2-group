package ipss.group1.practicas.services;

import ipss.group1.practicas.services.dtos.EstudianteDTO;
import ipss.group1.practicas.models.Estudiante;
import ipss.group1.practicas.repositories.EstudianteRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class EstudianteService {
    private final EstudianteRepository estudianteRepository;

    public EstudianteService(EstudianteRepository estudianteRepository) {
        this.estudianteRepository = estudianteRepository;
    }

    public List<EstudianteDTO> getAllEstudiantes() {
        return estudianteRepository.findAll().stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    public EstudianteDTO getEstudianteById(Long id) {
        return estudianteRepository.findById(id)
                .map(this::convertToDTO)
                .orElse(null);
    }

    public EstudianteDTO createEstudiante(Estudiante estudiante) {
        Estudiante savedEstudiante = estudianteRepository.save(estudiante);
        return convertToDTO(savedEstudiante);
    }

    public EstudianteDTO updateEstudiante(Long id, Estudiante estudiante) {
        if (estudianteRepository.existsById(id)) {
            estudiante.setId(id);
            Estudiante updatedEstudiante = estudianteRepository.save(estudiante);
            return convertToDTO(updatedEstudiante);
        } else {
            return null;
        }
    }

    public boolean deleteEstudiante(Long id) {
        if (estudianteRepository.existsById(id)) {
            estudianteRepository.deleteById(id);
            return true;
        } else {
            return false;
        }
    }

    private EstudianteDTO convertToDTO(Estudiante estudiante) {
        EstudianteDTO dto = new EstudianteDTO();
        dto.setId(estudiante.getId());
        dto.setNombre(estudiante.getNombre());
        return dto;
    }
}