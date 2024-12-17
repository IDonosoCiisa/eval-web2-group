package ipss.group1.practicas.controllers.mantainer;

import ipss.group1.practicas.services.dtos.EmpresaDTO;
import ipss.group1.practicas.models.Empresa;
import ipss.group1.practicas.services.EmpresaService;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/admin/empresas")
public class EmpresaController {
    private final EmpresaService empresaService;

    public EmpresaController(EmpresaService empresaService) {
        this.empresaService = empresaService;
    }

    @GetMapping
    public List<EmpresaDTO> getAllEmpresas() {
        return empresaService.getAllEmpresas();
    }

    @GetMapping("/{id}")
    public ResponseEntity<EmpresaDTO> getEmpresaById(@PathVariable Long id) {
        EmpresaDTO empresaDTO = empresaService.getEmpresaById(id);
        if (empresaDTO != null) {
            return ResponseEntity.ok(empresaDTO);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public EmpresaDTO createEmpresa(@RequestBody Empresa empresa) {
        return empresaService.createEmpresa(empresa);
    }

    @PutMapping("/{id}")
    public ResponseEntity<EmpresaDTO> updateEmpresa(@PathVariable Long id, @RequestBody Empresa empresa) {
        EmpresaDTO empresaDTO = empresaService.updateEmpresa(id, empresa);
        if (empresaDTO != null) {
            return ResponseEntity.ok(empresaDTO);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteEmpresa(@PathVariable Long id) {
        if (empresaService.deleteEmpresa(id)) {
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}