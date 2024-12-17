package ipss.group1.practicas.services.dtos;

public class TutorDTO {
    private Long id;
    private String nombre;

    public TutorDTO() {
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


    public static final class TutorDTOBuilder {
        private Long id;
        private String nombre;

        private TutorDTOBuilder() {
        }

        public static TutorDTOBuilder aTutorDTO() {
            return new TutorDTOBuilder();
        }

        public TutorDTOBuilder withId(Long id) {
            this.id = id;
            return this;
        }

        public TutorDTOBuilder withNombre(String nombre) {
            this.nombre = nombre;
            return this;
        }

        public TutorDTO build() {
            TutorDTO tutorDTO = new TutorDTO();
            tutorDTO.setId(id);
            tutorDTO.setNombre(nombre);
            return tutorDTO;
        }
    }
}
