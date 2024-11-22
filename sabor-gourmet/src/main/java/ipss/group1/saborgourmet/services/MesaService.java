package ipss.group1.saborgourmet.services;

import ipss.group1.saborgourmet.models.Mesa;
import ipss.group1.saborgourmet.repositories.MesaRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MesaService {
    private final MesaRepository mesaRepository;

    public MesaService(MesaRepository mesaRepository) {
        this.mesaRepository = mesaRepository;
    }

    public Optional<Mesa> getMesaById(Long id) {
        return mesaRepository.findById(id);
    }

    public List<Mesa> getAllMesas() {
        return mesaRepository.findAll();
    }

    public Mesa createMesa(Mesa mesa) {
        return mesaRepository.save(mesa);
    }

    public Mesa updateMesa(Long id, Mesa mesa) {
        return mesaRepository.findById(id).map(existingMesa -> {
            existingMesa.setCapacidad(mesa.getCapacidad());
            return mesaRepository.save(existingMesa);
        }).orElseThrow(() -> new RuntimeException("Mesa not found"));
    }

    public void deleteMesa(Long id) {
        mesaRepository.deleteById(id);
    }
}