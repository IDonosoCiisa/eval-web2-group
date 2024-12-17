package ipss.group1.practicas.models;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class Tutor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nombre;

    @OneToMany(mappedBy = "tutor")
    private List<Practica> practicas;

    public Tutor() {
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


    public static final class TutorBuilder {
        private Long id;
        private String nombre;
        private List<Practica> practicas;

        private TutorBuilder() {
        }

        public static TutorBuilder aTutor() {
            return new TutorBuilder();
        }

        public TutorBuilder withId(Long id) {
            this.id = id;
            return this;
        }

        public TutorBuilder withNombre(String nombre) {
            this.nombre = nombre;
            return this;
        }

        public TutorBuilder withPracticas(List<Practica> practicas) {
            this.practicas = practicas;
            return this;
        }

        public Tutor build() {
            Tutor tutor = new Tutor();
            tutor.setId(id);
            tutor.setNombre(nombre);
            tutor.setPracticas(practicas);
            return tutor;
        }
    }
}