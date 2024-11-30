package ipss.group1.saborgourmet.controllers;

import ipss.group1.saborgourmet.models.Mesa;
import ipss.group1.saborgourmet.services.MesaService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
//Controlador para la entidad Mesa, maneja las peticiones de la vista y sus operaciones crud.
// Intentamos manejar los errores que puedan surgir en la vista con try catch.
@Controller
@RequestMapping("/mesas")
public class MesaController {
    // Servicio para la entidad Mesa es injectado en el controlador para disponibilizar su uso.
    private final MesaService mesaService;

    public MesaController(MesaService mesaService) {
        this.mesaService = mesaService;
    }

    @GetMapping
    public String getAllMesas(Model model) {
        try {
            model.addAttribute("mesas", mesaService.getAllMesas());
            // para creación de una nueva mesa.
            model.addAttribute("mesa", new Mesa());
            return "mesas";
        } catch (Exception e) {
            model.addAttribute("errorMessage", "Error al cargar las mesas: " + e.getMessage());
            return "mesas";  // Se redirige a la misma vista con el mensaje de error
        }
    }

    @PostMapping
    public String createMesa(@ModelAttribute Mesa mesa, Model model) {
        try {
            mesaService.createMesa(mesa);
            return "redirect:/mesas";
        } catch (Exception e) {
            model.addAttribute("errorMessage", "Error al crear la mesa: " + e.getMessage());
            return "mesas";  // Se redirige a la vista mesas con el mensaje de error
        }
    }

    @PostMapping("/update/{id}")
    public String updateMesa(@PathVariable Long id, @ModelAttribute Mesa mesa, Model model) {
        try {
            mesaService.updateMesa(id, mesa);
            return "redirect:/mesas";
        } catch (Exception e) {
            model.addAttribute("errorMessage", "Error al actualizar la mesa: " + e.getMessage());
            return "mesas";  // Se redirige a la vista mesas con el mensaje de error
        }
    }

    @GetMapping("/delete/{id}")
    public String deleteMesa(@PathVariable Long id, Model model) {
        try {
            mesaService.deleteMesa(id);
            return "redirect:/mesas";
        } catch (Exception e) {
            model.addAttribute("errorMessage", "Error al eliminar la mesa: " + e.getMessage());
            return "mesas";  // Se redirige a la vista mesas con el mensaje de error
        }
    }
}
