package ipss.group1.practicas.models;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class Empresa {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nombre;

    @OneToMany(mappedBy = "empresa")
    private List<Practica> practicas;

    @OneToOne
    @JoinColumn(name = "jefe_id")
    private Jefe jefe;

    public Empresa() {
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

    public Jefe getJefe() {
        return jefe;
    }

    public void setJefe(Jefe jefe) {
        this.jefe = jefe;
    }


    public static final class EmpresaBuilder {
        private Long id;
        private String nombre;
        private List<Practica> practicas;
        private Jefe jefe;

        private EmpresaBuilder() {
        }

        public static EmpresaBuilder anEmpresa() {
            return new EmpresaBuilder();
        }

        public EmpresaBuilder withId(Long id) {
            this.id = id;
            return this;
        }

        public EmpresaBuilder withNombre(String nombre) {
            this.nombre = nombre;
            return this;
        }

        public EmpresaBuilder withPracticas(List<Practica> practicas) {
            this.practicas = practicas;
            return this;
        }

        public EmpresaBuilder withJefe(Jefe jefe) {
            this.jefe = jefe;
            return this;
        }

        public Empresa build() {
            Empresa empresa = new Empresa();
            empresa.setId(id);
            empresa.setNombre(nombre);
            empresa.setPracticas(practicas);
            empresa.setJefe(jefe);
            return empresa;
        }
    }
}