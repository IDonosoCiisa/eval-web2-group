package ipss.group1.saborgourmet.services;

import ipss.group1.saborgourmet.models.Cliente;
import ipss.group1.saborgourmet.repositories.ClienteRepository;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ClienteService {
    private final ClienteRepository clienteRepository;

    public ClienteService(ClienteRepository clienteRepository) {
        this.clienteRepository = clienteRepository;
    }

    public Cliente getOneCliente(Long id) {
        return clienteRepository.findById(id).orElseThrow(() -> new RuntimeException("Cliente not found"));
    }
    public List<Cliente> getAllClientes() {
        return clienteRepository.findAll();
    }
    public Cliente createCliente(Cliente cliente) {
        return clienteRepository.save(cliente);
    }
    public Cliente updateCliente(Long id, Cliente cliente) {
        Cliente clienteToUpdate = getOneCliente(id);
        clienteToUpdate.setNombre(cliente.getNombre());
        clienteToUpdate.setApellido(cliente.getApellido());
        return clienteRepository.save(clienteToUpdate);
    }
    public void deleteCliente(Long id) {
        clienteRepository.deleteById(id);
    }
}
