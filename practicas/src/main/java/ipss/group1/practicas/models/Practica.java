package ipss.group1.practicas.models;

import jakarta.persistence.*;

@Entity
public class Practica {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String descripcion;

    @ManyToOne
    @JoinColumn(name = "estudiante_id")
    private Estudiante estudiante;

    @ManyToOne
    @JoinColumn(name = "tutor_id")
    private Tutor tutor;

    @ManyToOne
    @JoinColumn(name = "empresa_id")
    private Empresa empresa;

    public Practica() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Estudiante getEstudiante() {
        return estudiante;
    }

    public void setEstudiante(Estudiante estudiante) {
        this.estudiante = estudiante;
    }

    public Tutor getTutor() {
        return tutor;
    }

    public void setTutor(Tutor tutor) {
        this.tutor = tutor;
    }

    public Empresa getEmpresa() {
        return empresa;
    }

    public void setEmpresa(Empresa empresa) {
        this.empresa = empresa;
    }


    public static final class PracticaBuilder {
        private Long id;
        private String descripcion;
        private Estudiante estudiante;
        private Tutor tutor;
        private Empresa empresa;

        private PracticaBuilder() {
        }

        public static PracticaBuilder aPractica() {
            return new PracticaBuilder();
        }

        public PracticaBuilder withId(Long id) {
            this.id = id;
            return this;
        }

        public PracticaBuilder withDescripcion(String descripcion) {
            this.descripcion = descripcion;
            return this;
        }

        public PracticaBuilder withEstudiante(Estudiante estudiante) {
            this.estudiante = estudiante;
            return this;
        }

        public PracticaBuilder withTutor(Tutor tutor) {
            this.tutor = tutor;
            return this;
        }

        public PracticaBuilder withEmpresa(Empresa empresa) {
            this.empresa = empresa;
            return this;
        }

        public Practica build() {
            Practica practica = new Practica();
            practica.setId(id);
            practica.setDescripcion(descripcion);
            practica.setEstudiante(estudiante);
            practica.setTutor(tutor);
            practica.setEmpresa(empresa);
            return practica;
        }
    }
}