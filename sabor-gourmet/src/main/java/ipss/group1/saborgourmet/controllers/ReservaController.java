package ipss.group1.saborgourmet.controllers;

import ipss.group1.saborgourmet.models.Reserva;
import ipss.group1.saborgourmet.services.ClienteService;
import ipss.group1.saborgourmet.services.MesaService;
import ipss.group1.saborgourmet.services.ReservaService;
import java.util.List;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/reservas")
public class ReservaController {

    private final ReservaService reservaService;
    private final MesaService mesaService;
    private final ClienteService clienteService;

    public ReservaController(ReservaService reservaService, MesaService mesaService, ClienteService clienteService) {
        this.reservaService = reservaService;
        this.mesaService = mesaService;
        this.clienteService = clienteService;
    }

    @GetMapping
    public String getAllReservas(Model model) {
        List<Reserva> reservas = reservaService.getallReservas();
        List<Integer> idActivasClientes = clienteService.getAllClientes().stream().map(cliente -> Math.toIntExact(cliente.getClienteId())).toList();
        List<Integer> idActivasMesa = mesaService.getAllMesas().stream().map(mesa -> Math.toIntExact(mesa.getMesaId())).toList();
        model.addAttribute("idActivasClientes", idActivasClientes);
        model.addAttribute("idActivasMesa", idActivasMesa);
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