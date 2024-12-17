package ipss.group1.practicas.models;

import jakarta.persistence.*;

@Entity
public class Jefe {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nombre;

    @OneToOne(mappedBy = "jefe")
    private Empresa empresa;

    public Jefe() {
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

    public Empresa getEmpresa() {
        return empresa;
    }

    public void setEmpresa(Empresa empresa) {
        this.empresa = empresa;
    }

    public static final class JefeBuilder {
        private Long id;
        private String nombre;
        private Empresa empresa;

        private JefeBuilder() {
        }

        public static JefeBuilder aJefe() {
            return new JefeBuilder();
        }

        public JefeBuilder withId(Long id) {
            this.id = id;
            return this;
        }

        public JefeBuilder withNombre(String nombre) {
            this.nombre = nombre;
            return this;
        }

        public JefeBuilder withEmpresa(Empresa empresa) {
            this.empresa = empresa;
            return this;
        }

        public Jefe build() {
            Jefe jefe = new Jefe();
            jefe.setId(id);
            jefe.setNombre(nombre);
            jefe.setEmpresa(empresa);
            return jefe;
        }
    }
}