package ipss.group1.saborgourmet.controllers;

import ipss.group1.saborgourmet.models.Reserva;
import ipss.group1.saborgourmet.services.ClienteService;
import ipss.group1.saborgourmet.services.MesaService;
import ipss.group1.saborgourmet.services.ReservaService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
//Controlador para la entidad Reserva, maneja las peticiones de la vista y sus operaciones crud.
@Controller
@RequestMapping("/reservas")
public class ReservaController {
    // Servicios para la entidad Reserva, Cliente y Mesa son injectados en el controlador para disponibilizar su uso.
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

        //Obtenemos todos los clientes y mesas, ocupamos stream para iterar sobre la lista, luego map para retornar solo los int de los id y finalmente toList para retornar una lista.
        List<Integer> idActivasClientes = clienteService.getAllClientes().stream().map(cliente -> Math.toIntExact(cliente.getClienteId())).toList();
        List<Integer> idActivasMesa = mesaService.getAllMesas().stream().map(mesa -> Math.toIntExact(mesa.getMesaId())).toList();
        //Agregamos las listas de ids activos al modelo.
        model.addAttribute("idActivasClientes", idActivasClientes);
        model.addAttribute("idActivasMesa", idActivasMesa);
        model.addAttribute("reservas", reservaService.getAllReservas());
        // para creación de una nueva reserva.
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
