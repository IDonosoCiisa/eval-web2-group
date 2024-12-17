package ipss.group1.practicas.services.dtos;

public class JefeDTO {
    private Long id;
    private String nombre;

    public JefeDTO() {
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


    public static final class JefeDTOBuilder {
        private Long id;
        private String nombre;

        private JefeDTOBuilder() {
        }

        public static JefeDTOBuilder aJefeDTO() {
            return new JefeDTOBuilder();
        }

        public JefeDTOBuilder withId(Long id) {
            this.id = id;
            return this;
        }

        public JefeDTOBuilder withNombre(String nombre) {
            this.nombre = nombre;
            return this;
        }

        public JefeDTO build() {
            JefeDTO jefeDTO = new JefeDTO();
            jefeDTO.setId(id);
            jefeDTO.setNombre(nombre);
            return jefeDTO;
        }
    }
}
