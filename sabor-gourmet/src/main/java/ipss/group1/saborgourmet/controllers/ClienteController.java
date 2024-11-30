package ipss.group1.saborgourmet.controllers;

import ipss.group1.saborgourmet.models.Cliente;
import ipss.group1.saborgourmet.services.ClienteService;
import java.util.List;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

//Controlador para la entidad Cliente, maneja las peticiones de la vista y sus operaciones crud.
@Controller
@RequestMapping("/clientes")
public class ClienteController {
    // Servicio para la entidad Cliente es injectado en el controlador para disponibilizar su uso.
    private final ClienteService clienteService;

    public ClienteController(ClienteService clienteService) {
        this.clienteService = clienteService;
    }


    @GetMapping
    public String getAllClientes(Model model) {
        List<Cliente> clientes = clienteService.getAllClientes();
        model.addAttribute("clientes", clientes);
        // para creación de un nuevo cliente.
        model.addAttribute("cliente", new Cliente());
        return "clientes";
    }

    @PostMapping
    public String createCliente(@ModelAttribute Cliente cliente) {
        clienteService.createCliente(cliente);
        return "redirect:/clientes";
    }

    @PostMapping("/update/{id}")
    public String updateCliente(@PathVariable Long id, @ModelAttribute Cliente cliente) {
        clienteService.updateCliente(id, cliente);
        return "redirect:/clientes";
    }

    @GetMapping("/delete/{id}")
    public String deleteCliente(@PathVariable Long id) {
        clienteService.deleteCliente(id);
        return "redirect:/clientes";
    }
}