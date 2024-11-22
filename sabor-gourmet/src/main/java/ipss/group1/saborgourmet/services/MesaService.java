package ipss.group1.saborgourmet.services;

import ipss.group1.saborgourmet.models.Mesa;
import ipss.group1.saborgourmet.repositories.MesaRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MesaService {
    private final MesaRepository mesaRepository;

    public MesaService(MesaRepository mesaRepository) {
        this.mesaRepository = mesaRepository;
    }

    public Mesa getMesaById(Long id) {
        return mesaRepository.findById(id).orElseThrow(() -> new RuntimeException("Mesa not found"));
    }
    public List<Mesa> getAllMesas() {
        return mesaRepository.findAll();
    }
    public Mesa createMesa(Mesa mesa) {
        return mesaRepository.save(mesa);
    }
    public Mesa updateMesa(Long id, Mesa mesa) {
        Mesa mesaToUpdate = getMesaById(id);
        mesaToUpdate.setCapacidad(mesa.getCapacidad());
        return mesaRepository.save(mesaToUpdate);
    }

    public void deleteMesa(Long id) {
        mesaRepository.deleteById(id);
    }

}
