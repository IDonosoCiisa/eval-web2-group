package ipss.group1.practicas.services.dtos;

public class EstudianteDTO {
    private Long id;
    private String nombre;

    public EstudianteDTO() {
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


    public static final class EstudianteDTOBuilder {
        private Long id;
        private String nombre;

        private EstudianteDTOBuilder() {
        }

        public static EstudianteDTOBuilder anEstudianteDTO() {
            return new EstudianteDTOBuilder();
        }

        public EstudianteDTOBuilder withId(Long id) {
            this.id = id;
            return this;
        }

        public EstudianteDTOBuilder withNombre(String nombre) {
            this.nombre = nombre;
            return this;
        }

        public EstudianteDTO build() {
            EstudianteDTO estudianteDTO = new EstudianteDTO();
            estudianteDTO.setId(id);
            estudianteDTO.setNombre(nombre);
            return estudianteDTO;
        }
    }
}