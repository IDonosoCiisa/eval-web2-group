package ipss.group1.practicas.services.usecases;

import ipss.group1.practicas.services.dtos.PracticaDTO;
import ipss.group1.practicas.models.Practica;
import ipss.group1.practicas.repositories.PracticaRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ProfesorUseCase {
    private final PracticaRepository practicaRepository;

    public ProfesorUseCase(PracticaRepository practicaRepository) {
        this.practicaRepository = practicaRepository;
    }

    public List<PracticaDTO> getAllPracticas() {
        return practicaRepository.findAll().stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    public List<PracticaDTO> getPracticasByEstudianteId(Long estudianteId) {
        return practicaRepository.findAll().stream()
                .filter(practica -> practica.getEstudiante().getId().equals(estudianteId))
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    public Optional<PracticaDTO> getPracticaById(Long id) {
        return practicaRepository.findById(id)
                .map(this::convertToDTO);
    }

    public PracticaDTO createPractica(Practica practica) {
        Practica savedPractica = practicaRepository.save(practica);
        return convertToDTO(savedPractica);
    }

    public Optional<PracticaDTO> updatePractica(Long id, Practica practica) {
        return practicaRepository.findById(id)
                .map(existingPractica -> {
                    existingPractica.setDescripcion(practica.getDescripcion());
                    existingPractica.setEstudiante(practica.getEstudiante());
                    existingPractica.setTutor(practica.getTutor());
                    existingPractica.setEmpresa(practica.getEmpresa());
                    Practica updatedPractica = practicaRepository.save(existingPractica);
                    return convertToDTO(updatedPractica);
                });
    }

    public boolean deletePractica(Long id) {
        return practicaRepository.findById(id)
                .map(practica -> {
                    practicaRepository.delete(practica);
                    return true;
                })
                .orElse(false);
    }

    private PracticaDTO convertToDTO(Practica practica) {
        return PracticaDTO.PracticaDTOBuilder.aPracticaDTO()
                .withId(practica.getId())
                .withDescripcion(practica.getDescripcion())
                .withEstudianteId(practica.getEstudiante().getId())
                .withTutorId(practica.getTutor().getId())
                .withEmpresaId(practica.getEmpresa().getId())
                .build();
    }
}