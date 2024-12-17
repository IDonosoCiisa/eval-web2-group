package ipss.group1.practicas.services.dtos;

public class PracticaDTO {
    private Long id;
    private String descripcion;
    private Long estudianteId;
    private Long tutorId;
    private Long empresaId;

    public PracticaDTO() {
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

    public Long getEstudianteId() {
        return estudianteId;
    }

    public void setEstudianteId(Long estudianteId) {
        this.estudianteId = estudianteId;
    }

    public Long getTutorId() {
        return tutorId;
    }

    public void setTutorId(Long tutorId) {
        this.tutorId = tutorId;
    }

    public Long getEmpresaId() {
        return empresaId;
    }

    public void setEmpresaId(Long empresaId) {
        this.empresaId = empresaId;
    }

    public static final class PracticaDTOBuilder {
        private Long id;
        private String descripcion;
        private Long estudianteId;
        private Long tutorId;
        private Long empresaId;

        private PracticaDTOBuilder() {
        }

        public static PracticaDTOBuilder aPracticaDTO() {
            return new PracticaDTOBuilder();
        }

        public PracticaDTOBuilder withId(Long id) {
            this.id = id;
            return this;
        }

        public PracticaDTOBuilder withDescripcion(String descripcion) {
            this.descripcion = descripcion;
            return this;
        }

        public PracticaDTOBuilder withEstudianteId(Long estudianteId) {
            this.estudianteId = estudianteId;
            return this;
        }

        public PracticaDTOBuilder withTutorId(Long tutorId) {
            this.tutorId = tutorId;
            return this;
        }

        public PracticaDTOBuilder withEmpresaId(Long empresaId) {
            this.empresaId = empresaId;
            return this;
        }

        public PracticaDTO build() {
            PracticaDTO practicaDTO = new PracticaDTO();
            practicaDTO.setId(id);
            practicaDTO.setDescripcion(descripcion);
            practicaDTO.setEstudianteId(estudianteId);
            practicaDTO.setTutorId(tutorId);
            practicaDTO.setEmpresaId(empresaId);
            return practicaDTO;
        }
    }
}