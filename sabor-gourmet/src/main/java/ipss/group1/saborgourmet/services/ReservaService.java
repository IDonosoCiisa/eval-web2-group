package ipss.group1.saborgourmet.services;

import ipss.group1.saborgourmet.models.Reserva;
import ipss.group1.saborgourmet.repositories.ReservaRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
// Servicio para la entidad Reserva, da uso al repositorio ReservaRepository y sus metodos.
@Service
public class ReservaService {
    // Repositorio para la entidad Reserva es injectado en el servicio para disponibilizar su uso.
    private final ReservaRepository reservaRepository;

    public ReservaService(ReservaRepository reservaRepository) {
        this.reservaRepository = reservaRepository;
    }
    // Metodo para obtener una reserva, si no encuentra resultado arroja error de reserva no encontrada.
    public Reserva getReservaById(Long id) {
        return reservaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Reserva no encontrada con ID: " + id));
    }

    public List<Reserva> getAllReservas() {
        return reservaRepository.findAll();
    }

    public Reserva createReserva(Reserva reserva) {
        try {
            return reservaRepository.save(reserva);
        } catch (Exception e) {
            throw new RuntimeException("Error al crear la reserva: " + e.getMessage());
        }
    }

    public Reserva updateReserva(Long id, Reserva reserva) {
        Reserva reservaToUpdate = getReservaById(id);
        reservaToUpdate.setFechaReserva(reserva.getFechaReserva());
        reservaToUpdate.setHoraReserva(reserva.getHoraReserva());
        reservaToUpdate.setMesa(reserva.getMesa());
        reservaToUpdate.setDuracion(reserva.getDuracion());
        return reservaRepository.save(reservaToUpdate);
    }

    public void deleteReserva(Long id) {
        Optional<Reserva> reserva = reservaRepository.findById(id);
        if (reserva.isPresent()) {
            reservaRepository.deleteById(id);
        } else {
            throw new RuntimeException("Reserva no encontrada para eliminar con ID: " + id);
        }
    }
}
