package ipss.group1.saborgourmet.controllers;

import ipss.group1.saborgourmet.models.Reserva;
import ipss.group1.saborgourmet.services.ClienteService;
import ipss.group1.saborgourmet.services.MesaService;
import ipss.group1.saborgourmet.services.ClienteService;
import ipss.group1.saborgourmet.services.MesaService;
import ipss.group1.saborgourmet.services.ReservaService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/reservas")
public class ReservaController {

    private final MesaService mesaService;
    private final ClienteService clienteService;
    private final ReservaService reservaService;

    public ReservaController(ReservaService reservaService, MesaService mesaService, ClienteService clienteService) {
        this.reservaService = reservaService;
        this.mesaService = mesaService;
        this.clienteService = clienteService;
    }

    @GetMapping
    public String getAllReservas(Model model) {
        List<Integer> idActivasClientes = clienteService.getAllClientes().stream().map(cliente -> Math.toIntExact(cliente.getClienteId())).toList();
        List<Integer> idActivasMesa = mesaService.getAllMesas().stream().map(mesa -> Math.toIntExact(mesa.getMesaId())).toList();
        model.addAttribute("idActivasClientes", idActivasClientes);
        model.addAttribute("idActivasMesa", idActivasMesa);
        model.addAttribute("reservas", reservaService.getAllReservas());
        model.addAttribute("reserva", new Reserva());
        return "reservas";
    }

    @PostMapping
    public String createReserva(@ModelAttribute Reserva reserva, Model model) {
        try {
            reservaService.createReserva(reserva);
            model.addAttribute("successMessage", "Reserva creada exitosamente.");
            return "redirect:/reservas";
        } catch (Exception e) {
            model.addAttribute("errorMessage", "Error al crear la reserva: " + e.getMessage());
            return "reservas";
        }
    }

    @PostMapping("/update")
    public String updateReserva(@RequestParam Long id, @ModelAttribute Reserva reserva, Model model) {
        try {
            reservaService.updateReserva(id, reserva);
            model.addAttribute("successMessage", "Reserva actualizada exitosamente.");
            return "redirect:/reservas";
        } catch (Exception e) {
            model.addAttribute("errorMessage", "Error al actualizar la reserva: " + e.getMessage());
            return "reservas";
        }
    }

    @PostMapping("/delete")
    public String deleteReserva(@RequestParam Long id, Model model) {
        try {
            reservaService.deleteReserva(id);
            model.addAttribute("successMessage", "Reserva eliminada exitosamente.");
            return "redirect:/reservas";
        } catch (Exception e) {
            model.addAttribute("errorMessage", "Error al eliminar la reserva: " + e.getMessage());
            return "reservas";
        }
    }
}
