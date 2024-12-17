package ipss.group1.practicas.services.dtos;

public class EmpresaDTO {
    private Long id;
    private String nombre;
    private Long jefeId;

    public EmpresaDTO() {
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

    public Long getJefeId() {
        return jefeId;
    }

    public void setJefeId(Long jefeId) {
        this.jefeId = jefeId;
    }

    public static final class EmpresaDTOBuilder {
        private Long id;
        private String nombre;
        private Long jefeId;

        private EmpresaDTOBuilder() {
        }

        public static EmpresaDTOBuilder anEmpresaDTO() {
            return new EmpresaDTOBuilder();
        }

        public EmpresaDTOBuilder withId(Long id) {
            this.id = id;
            return this;
        }

        public EmpresaDTOBuilder withNombre(String nombre) {
            this.nombre = nombre;
            return this;
        }

        public EmpresaDTOBuilder withJefeId(Long jefeId) {
            this.jefeId = jefeId;
            return this;
        }

        public EmpresaDTO build() {
            EmpresaDTO empresaDTO = new EmpresaDTO();
            empresaDTO.setId(id);
            empresaDTO.setNombre(nombre);
            empresaDTO.setJefeId(jefeId);
            return empresaDTO;
        }
    }
}
