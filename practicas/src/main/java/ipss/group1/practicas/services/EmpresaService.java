package ipss.group1.practicas.services;

import ipss.group1.practicas.services.dtos.EmpresaDTO;
import ipss.group1.practicas.models.Empresa;
import ipss.group1.practicas.repositories.EmpresaRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class EmpresaService {
    private final EmpresaRepository empresaRepository;

    public EmpresaService(EmpresaRepository empresaRepository) {
        this.empresaRepository = empresaRepository;
    }

    public List<EmpresaDTO> getAllEmpresas() {
        return empresaRepository.findAll().stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    public EmpresaDTO getEmpresaById(Long id) {
        return empresaRepository.findById(id)
                .map(this::convertToDTO)
                .orElse(null);
    }

    public EmpresaDTO createEmpresa(Empresa empresa) {
        Empresa savedEmpresa = empresaRepository.save(empresa);
        return convertToDTO(savedEmpresa);
    }

    public EmpresaDTO updateEmpresa(Long id, Empresa empresa) {
        if (empresaRepository.existsById(id)) {
            empresa.setId(id);
            Empresa updatedEmpresa = empresaRepository.save(empresa);
            return convertToDTO(updatedEmpresa);
        } else {
            return null;
        }
    }

    public boolean deleteEmpresa(Long id) {
        if (empresaRepository.existsById(id)) {
            empresaRepository.deleteById(id);
            return true;
        } else {
            return false;
        }
    }

    private EmpresaDTO convertToDTO(Empresa empresa) {
        EmpresaDTO dto = new EmpresaDTO();
        dto.setId(empresa.getId());
        dto.setNombre(empresa.getNombre());
        dto.setJefeId(empresa.getJefe().getId());
        return dto;
    }
}