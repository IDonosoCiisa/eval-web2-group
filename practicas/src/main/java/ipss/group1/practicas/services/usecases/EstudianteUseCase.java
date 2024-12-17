package ipss.group1.practicas.services.usecases;

import ipss.group1.practicas.services.dtos.PracticaDTO;
import ipss.group1.practicas.models.Practica;
import ipss.group1.practicas.repositories.EstudianteRepository;
import ipss.group1.practicas.repositories.PracticaRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class EstudianteUseCase {
    private final PracticaRepository practicaRepository;
    private final EstudianteRepository estudianteRepository;

    public EstudianteUseCase(PracticaRepository practicaRepository, EstudianteRepository estudianteRepository) {
        this.practicaRepository = practicaRepository;
        this.estudianteRepository = estudianteRepository;
    }

    public List<PracticaDTO> getPracticasByEstudianteId(Long estudianteId) {
        return practicaRepository.findAll().stream()
                .filter(practica -> practica.getEstudiante().getId().equals(estudianteId))
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    public PracticaDTO createPractica(PracticaDTO practicaDTO, Long estudianteId) {
        Practica practica = new Practica();
        practica.setDescripcion(practicaDTO.getDescripcion());
        estudianteRepository.findById(estudianteId).ifPresent(practica::setEstudiante);
        practicaRepository.save(practica);
        return convertToDTO(practica);
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