package ipss.group1.saborgourmet.controllers.mesas;

import ipss.group1.saborgourmet.models.Mesa;
import ipss.group1.saborgourmet.services.MesaService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/mesas")
public class MesaController {

    private final MesaService mesaService;

    public MesaController(MesaService mesaService) {
        this.mesaService = mesaService;
    }

    @GetMapping("/{id}")
    public Mesa getOneMesa(@PathVariable Long id) {
        return mesaService.getMesaById(id);
    }

    @GetMapping
    public List<Mesa> getAllMesas() {
        return mesaService.getAllMesas();
    }

    @PostMapping
    public Mesa createMesa(@RequestBody Mesa mesa) {
        return mesaService.createMesa(mesa);
    }

    @PutMapping("/{id}")
    public Mesa updateMesa(@PathVariable Long id, @RequestBody Mesa mesa) {
        return mesaService.updateMesa(id, mesa);
    }

    @DeleteMapping("/{id}")
    public void deleteMesa(@PathVariable Long id) {
        mesaService.deleteMesa(id);
    }
}