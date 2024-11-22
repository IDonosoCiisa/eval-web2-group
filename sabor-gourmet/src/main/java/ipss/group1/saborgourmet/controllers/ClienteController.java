package ipss.group1.saborgourmet.controllers;

import ipss.group1.saborgourmet.models.Cliente;
import ipss.group1.saborgourmet.services.ClienteService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/clientes")
public class ClienteController {

    private final ClienteService clienteService;

    public ClienteController(ClienteService clienteService) {
        this.clienteService = clienteService;
    }
    @GetMapping("/{id}")
    public Cliente getOneCliente(@PathVariable Long id) {
        return clienteService.getOneCliente(id);
    }
    @GetMapping
    public List<Cliente> getAllClientes() {
        return clienteService.getAllClientes();
    }
    @PostMapping
    public Cliente createCliente(@RequestBody Cliente cliente) {
        return clienteService.createCliente(cliente);
    }
    @PutMapping("/{id}")
    public Cliente updateCliente(@PathVariable Long id, @RequestBody Cliente cliente) {
        return clienteService.updateCliente(id, cliente);
    }
    @DeleteMapping("/{id}")
    public void deleteCliente(@PathVariable Long id) {
        clienteService.deleteCliente(id);
    }
}
