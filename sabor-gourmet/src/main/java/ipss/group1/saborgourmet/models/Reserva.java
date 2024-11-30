package ipss.group1.saborgourmet.models;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;
//Entidad de Jpa para la tabla Reserva, con sus atributos y relaciones.
@Entity
public class Reserva {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    //Relación muchos a uno con la tabla Cliente. De esta manera, al eliminar una reserva, no se elimina el cliente.
    @ManyToOne(cascade = CascadeType.REMOVE)
    @JoinColumn(name = "clienteId", nullable = false)
    private Cliente cliente;
    //Relación muchos a uno con la tabla Mesa. De esta manera, al eliminar una reserva, no se elimina la mesa.
    @ManyToOne(cascade = CascadeType.REMOVE)
    @JoinColumn(name = "mesaId", nullable = false)
    private Mesa mesa;
    //Atributo Fecha de la tabla reserva, con formato yyyy-MM-dd y su mapeo al json con el mismo formato.
    @Column(nullable = false)
    @Temporal(TemporalType.DATE)
    @DateTimeFormat(pattern = "yyyy-MM-dd") // Coincide con el input de HTML
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date fechaReserva;
    //Atributo Hora de la tabla reserva, con formato HH:mm y su mapeo al json con el mismo formato.
    @Column(nullable = false)
    @Temporal(TemporalType.TIME)
    @DateTimeFormat(pattern = "HH:mm")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "HH:mm")
    private Date horaReserva;

    @Column(nullable = false, columnDefinition = "int default 60")
    private int duracion; // Duración en minutos



    public Reserva() {
    }

    public int getDuracion() {
        return duracion;
    }

    public void setDuracion(int duracion) {
        this.duracion = duracion;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Mesa getMesa() {
        return mesa;
    }

    public void setMesa(Mesa mesa) {
        this.mesa = mesa;
    }

    public Date getFechaReserva() {
        return fechaReserva;
    }

    public void setFechaReserva(Date fechaReserva) {
        this.fechaReserva = fechaReserva;
    }

    public Date getHoraReserva() {
        return horaReserva;
    }

    public void setHoraReserva(Date horaReserva) {
        this.horaReserva = horaReserva;
    }

    public static final class ReservaBuilder {
        private Long id;
        private Cliente cliente;
        private Mesa mesa;
        private Date fechaReserva;
        private Date horaReserva;

        private ReservaBuilder() {
        }

        public static ReservaBuilder aReserva() {
            return new ReservaBuilder();
        }

        public ReservaBuilder withId(Long id) {
            this.id = id;
            return this;
        }

        public ReservaBuilder withCliente(Cliente cliente) {
            this.cliente = cliente;
            return this;
        }

        public ReservaBuilder withMesa(Mesa mesa) {
            this.mesa = mesa;
            return this;
        }

        public ReservaBuilder withFechaReserva(Date fechaReserva) {
            this.fechaReserva = fechaReserva;
            return this;
        }

        public ReservaBuilder withHoraReserva(Date horaReserva) {
            this.horaReserva = horaReserva;
            return this;
        }

        public Reserva build() {
            Reserva reserva = new Reserva();
            reserva.setId(id);
            reserva.setCliente(cliente);
            reserva.setMesa(mesa);
            reserva.setFechaReserva(fechaReserva);
            reserva.setHoraReserva(horaReserva);
            return reserva;
        }
    }
}