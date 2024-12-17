package ipss.group1.practicas.services;

import ipss.group1.practicas.services.dtos.JefeDTO;
import ipss.group1.practicas.models.Jefe;
import ipss.group1.practicas.repositories.JefeRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class JefeService {
    private final JefeRepository jefeRepository;

    public JefeService(JefeRepository jefeRepository) {
        this.jefeRepository = jefeRepository;
    }

    public List<JefeDTO> getAllJefes() {
        return jefeRepository.findAll().stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    public JefeDTO getJefeById(Long id) {
        return jefeRepository.findById(id)
                .map(this::convertToDTO)
                .orElse(null);
    }

    public JefeDTO createJefe(Jefe jefe) {
        Jefe savedJefe = jefeRepository.save(jefe);
        return convertToDTO(savedJefe);
    }

    public JefeDTO updateJefe(Long id, Jefe jefe) {
        if (jefeRepository.existsById(id)) {
            jefe.setId(id);
            Jefe updatedJefe = jefeRepository.save(jefe);
            return convertToDTO(updatedJefe);
        } else {
            return null;
        }
    }

    public boolean deleteJefe(Long id) {
        if (jefeRepository.existsById(id)) {
            jefeRepository.deleteById(id);
            return true;
        } else {
            return false;
        }
    }

    private JefeDTO convertToDTO(Jefe jefe) {
        JefeDTO dto = new JefeDTO();
        dto.setId(jefe.getId());
        dto.setNombre(jefe.getNombre());
        return dto;
    }
}