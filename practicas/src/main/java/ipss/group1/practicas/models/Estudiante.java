package ipss.group1.practicas.models;

import jakarta.persistence.*;
import java.util.List;

@Entity
public class Estudiante {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nombre;

    @OneToMany(mappedBy = "estudiante")
    private List<Practica> practicas;

    public Estudiante() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public List<Practica> getPracticas() {
        return practicas;
    }

    public void setPracticas(List<Practica> practicas) {
        this.practicas = practicas;
    }


    public static final class EstudianteBuilder {
        private Long id;
        private String nombre;
        private List<Practica> practicas;

        private EstudianteBuilder() {
        }

        public static EstudianteBuilder anEstudiante() {
            return new EstudianteBuilder();
        }

        public EstudianteBuilder withId(Long id) {
            this.id = id;
            return this;
        }

        public EstudianteBuilder withNombre(String nombre) {
            this.nombre = nombre;
            return this;
        }

        public EstudianteBuilder withPracticas(List<Practica> practicas) {
            this.practicas = practicas;
            return this;
        }

        public Estudiante build() {
            Estudiante estudiante = new Estudiante();
            estudiante.setId(id);
            estudiante.setNombre(nombre);
            estudiante.setPracticas(practicas);
            return estudiante;
        }
    }
}