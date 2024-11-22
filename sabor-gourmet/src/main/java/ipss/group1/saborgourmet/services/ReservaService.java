package ipss.group1.saborgourmet.services;

import ipss.group1.saborgourmet.models.Reserva;
import ipss.group1.saborgourmet.repositories.ReservaRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReservaService {
    public final ReservaRepository reservaRepository;

    public ReservaService(ReservaRepository reservaRepository) {
        this.reservaRepository = reservaRepository;
    }

    public Reserva getReservaById(Long id) {
        return reservaRepository.findById(id).orElseThrow(() -> new RuntimeException("Reserva not found"));
    }
    public List<Reserva> getallReservas() {
        return reservaRepository.findAll();
    }
    public Reserva createReserva(Reserva reserva) {
        try {
            return reservaRepository.save(reserva);
        } catch (Exception e) {
            throw new RuntimeException("Error al crear la reserva");
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
        reservaRepository.deleteById(id);
    }
}
