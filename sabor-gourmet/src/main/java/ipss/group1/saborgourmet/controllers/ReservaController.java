package ipss.group1.saborgourmet.controllers;

import ipss.group1.saborgourmet.models.Reserva;
import ipss.group1.saborgourmet.services.ReservaService;
import java.util.List;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/reservas")
public class ReservaController {

    private final ReservaService reservaService;

    public ReservaController(ReservaService reservaService) {
        this.reservaService = reservaService;
    }

    @GetMapping
    public String getAllReservas(Model model) {
        List<Reserva> reservas = reservaService.getallReservas();
        model.addAttribute("reservas", reservas);
        model.addAttribute("reserva", new Reserva());
        return "reservas";
    }

    @PostMapping
    public String createReserva(@ModelAttribute Reserva reserva) {
        reservaService.createReserva(reserva);
        return "redirect:/reservas";
    }

    @PostMapping("/update/{id}")
    public String updateReserva(@PathVariable Long id, @ModelAttribute Reserva reserva) {
        reservaService.updateReserva(id, reserva);
        return "redirect:/reservas";
    }

    @GetMapping("/delete/{id}")
    public String deleteReserva(@PathVariable Long id) {
        reservaService.deleteReserva(id);
        return "redirect:/reservas";
    }
}