package ipss.group1.saborgourmet.controllers;

import ipss.group1.saborgourmet.models.Reserva;
import ipss.group1.saborgourmet.services.ReservaService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/reservas")
public class ReservaController {

    private final ReservaService reservaService;

    public ReservaController(ReservaService reservaService) {
        this.reservaService = reservaService;
    }

    @GetMapping("/{id}")
    public Reserva getOneReserva(@PathVariable Long id) {
        return reservaService.getReservaById(id);
    }

    @GetMapping
    public List<Reserva> getAllReservas() {
        return reservaService.getallReservas();
    }

    @PostMapping
    public Reserva createReserva(@RequestBody Reserva reserva) {
        return reservaService.createReserva(reserva);
    }

    @PutMapping("/{id}")
    public Reserva updateReserva(@PathVariable Long id, @RequestBody Reserva reserva) {
        return reservaService.updateReserva(id, reserva);
    }

    @DeleteMapping("/{id}")
    public void deleteReserva(@PathVariable Long id) {
        reservaService.deleteReserva(id);
    }
}