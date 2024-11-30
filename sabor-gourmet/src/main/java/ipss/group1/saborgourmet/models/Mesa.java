package ipss.group1.saborgourmet.models;

import jakarta.persistence.*;

import java.util.List;
//Entidad de Jpa para la tabla Mesa, con sus atributos y relaciones.
@Entity
public class Mesa {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long mesaId;
    //Relación uno a muchos con la tabla Reserva. De esta manera, al eliminar una mesa, se eliminan todas sus reservas.
    @OneToMany(mappedBy = "mesa", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Reserva> reservas;

    private int capacidad;

    public Mesa() {
    }

    public int getCapacidad() {
        return capacidad;
    }

    public void setCapacidad(int capacidad) {
        this.capacidad = capacidad;
    }

    public void setMesaId(Long id) {
        this.mesaId = id;
    }

    public Long getMesaId() {
        return mesaId;
    }

    public List<Reserva> getReservas() {
        return reservas;
    }

    public void setReservas(List<Reserva> reservas) {
        this.reservas = reservas;
    }
    //Builder para la entidad Mesa (sin lista de reservas)
    public static final class MesaBuilder {
        private Long mesaId;
        private int capacidad;

        private MesaBuilder() {
        }

        public static MesaBuilder aMesa() {
            return new MesaBuilder();
        }

        public MesaBuilder withMesaId(Long mesaId) {
            this.mesaId = mesaId;
            return this;
        }

        public MesaBuilder withCapacidad(int capacidad) {
            this.capacidad = capacidad;
            return this;
        }

        public Mesa build() {
            Mesa mesa = new Mesa();
            mesa.setMesaId(mesaId);
            mesa.setCapacidad(capacidad);
            return mesa;
        }
    }
}