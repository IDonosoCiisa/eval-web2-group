package ipss.group1.saborgourmet.models;

import jakarta.persistence.*;

import java.util.List;
//Entidad de Jpa para la tabla Cliente, con sus atributos y relaciones.
@Entity
public class Cliente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long clienteId;

    //Relación uno a muchos con la tabla Reserva. De esta manera, al eliminar un cliente, se eliminan todas sus reservas.
    @OneToMany(mappedBy = "cliente", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Reserva> reservas;

    @Column(nullable = false)
    private String nombre;
    @Column(nullable = false)
    private String apellido;

    public Cliente() {
    }

    public List<Reserva> getReservas() {
        return reservas;
    }

    public void setReservas(List<Reserva> reservas) {
        this.reservas = reservas;
    }

    public Long getClienteId() {
        return clienteId;
    }

    public void setClienteId(Long id) {
        this.clienteId = id;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    //Builder para la entidad Cliente (sin lista de reservas)
    public static final class ClientesBuilder {
        private Long id;
        private String nombre;
        private String apellido;

        private ClientesBuilder() {
        }

        public static ClientesBuilder aClientes() {
            return new ClientesBuilder();
        }

        public ClientesBuilder withId(Long id) {
            this.id = id;
            return this;
        }

        public ClientesBuilder withNombre(String nombre) {
            this.nombre = nombre;
            return this;
        }

        public ClientesBuilder withApellido(String apellido) {
            this.apellido = apellido;
            return this;
        }

        public Cliente build() {
            Cliente cliente = new Cliente();
            cliente.clienteId = this.id;
            cliente.nombre = this.nombre;
            cliente.apellido = this.apellido;
            return cliente;
        }
    }
}