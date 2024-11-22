package ipss.group1.saborgourmet.controllers;

import ipss.group1.saborgourmet.models.Mesa;
import ipss.group1.saborgourmet.services.MesaService;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


@Controller
@RequestMapping("/mesas")
public class MesaController {

    private final MesaService mesaService;

    public MesaController(MesaService mesaService) {
        this.mesaService = mesaService;
    }

    @GetMapping
    public String getAllMesas(Model model) {
        List<Mesa> mesas = mesaService.getAllMesas();
        model.addAttribute("mesas", mesas);
        model.addAttribute("mesa", new Mesa());
        return "mesas";
    }

    @PostMapping
    public String createMesa(@ModelAttribute Mesa mesa) {
        mesaService.createMesa(mesa);
        return "redirect:/mesas";
    }

    @PostMapping("/update/{id}")
    public String updateMesa(@PathVariable Long id, @ModelAttribute Mesa mesa) {
        try {
            mesaService.updateMesa(id, mesa);
            return "redirect:/mesas";
        } catch (RuntimeException e) {
            return "error";
        }
    }

    @GetMapping("/delete/{id}")
    public String deleteMesa(@PathVariable Long id) {
        mesaService.deleteMesa(id);
        return "redirect:/mesas";
    }
}