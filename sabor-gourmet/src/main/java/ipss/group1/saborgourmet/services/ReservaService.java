package ipss.group1.saborgourmet.services;

import ipss.group1.saborgourmet.models.Reserva;
import ipss.group1.saborgourmet.repositories.ReservaRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ReservaService {
    private final ReservaRepository reservaRepository;

    public ReservaService(ReservaRepository reservaRepository) {
        this.reservaRepository = reservaRepository;
    }

    // Método para obtener una reserva por ID
    public Reserva getReservaById(Long id) {
        return reservaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Reserva no encontrada con ID: " + id));
    }

    // Método para obtener todas las reservas
    public List<Reserva> getAllReservas() {
        return reservaRepository.findAll();
    }

    // Método para crear una nueva reserva
    public Reserva createReserva(Reserva reserva) {
        try {
            return reservaRepository.save(reserva);
        } catch (Exception e) {
            throw new RuntimeException("Error al crear la reserva: " + e.getMessage());
        }
    }

    // Método para actualizar una reserva existente
    public Reserva updateReserva(Long id, Reserva reserva) {
        Reserva reservaToUpdate = getReservaById(id);
        reservaToUpdate.setFechaReserva(reserva.getFechaReserva());
        reservaToUpdate.setHoraReserva(reserva.getHoraReserva());
        reservaToUpdate.setMesa(reserva.getMesa());
        reservaToUpdate.setDuracion(reserva.getDuracion());
        return reservaRepository.save(reservaToUpdate);
    }

    // Método para eliminar una reserva
    public void deleteReserva(Long id) {
        Optional<Reserva> reserva = reservaRepository.findById(id);
        if (reserva.isPresent()) {
            reservaRepository.deleteById(id);
        } else {
            throw new RuntimeException("Reserva no encontrada para eliminar con ID: " + id);
        }
    }
}
