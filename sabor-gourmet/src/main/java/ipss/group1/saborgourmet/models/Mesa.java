package ipss.group1.saborgourmet.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Mesa {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long mesaId;

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