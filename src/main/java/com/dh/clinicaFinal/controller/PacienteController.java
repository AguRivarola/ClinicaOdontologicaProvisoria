package com.dh.clinicaFinal.controller;

import com.dh.clinicaFinal.model.dto.PacienteDTO;
import com.dh.clinicaFinal.service.IPacienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@RestController
@RequestMapping("/pacientes")
@CrossOrigin(origins = "*")
public class PacienteController {

    private IPacienteService pacienteService;

    @Autowired
    public PacienteController(IPacienteService pacienteService) {
        this.pacienteService = pacienteService;
    }


    @PostMapping()
    public ResponseEntity<PacienteDTO> registrarPaciente(@RequestBody PacienteDTO pacienteDTO) {
        return ResponseEntity.ok(pacienteService.agregarPaciente(pacienteDTO));
    }

    @GetMapping("/{id}")
    public ResponseEntity<PacienteDTO> buscar(@PathVariable Long id) {
        PacienteDTO pacienteDTO = pacienteService.buscarPorId(id);
        return ResponseEntity.ok(pacienteDTO);
    }

    @PutMapping()
    public ResponseEntity<PacienteDTO> actualizar(@RequestBody PacienteDTO pacienteDTO) {
        ResponseEntity<PacienteDTO> response = null;

        if (pacienteDTO.getId() != null && pacienteService.buscarPorId(pacienteDTO.getId()) != null) {
            response = ResponseEntity.ok(pacienteService.actualizarPaciente(pacienteDTO));
        } else {
            response = ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        return response;
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> eliminar(@PathVariable Long id) {
        ResponseEntity<String> response = null;

        if (pacienteService.buscarPorId(id) != null) {
            pacienteService.eliminarPaciente(id);
            response = ResponseEntity.status(HttpStatus.NO_CONTENT).body("Eliminado");
        } else {
            response = ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }

        return response;
    }

    @GetMapping
    public ResponseEntity<Set<PacienteDTO>> buscarTodos() {
        return ResponseEntity.ok(pacienteService.buscarTodos());
    }
}
