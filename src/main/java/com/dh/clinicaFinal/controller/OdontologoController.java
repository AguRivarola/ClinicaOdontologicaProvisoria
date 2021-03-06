package com.dh.clinicaFinal.controller;

import com.dh.clinicaFinal.exceptionHandlers.ResourceNotFoundException;
import com.dh.clinicaFinal.model.dto.OdontologoDTO;
import com.dh.clinicaFinal.service.IOdontologoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@RestController
@RequestMapping("/odontologos")
@CrossOrigin(origins = "*")
public class OdontologoController {

    private IOdontologoService odontologoService;

    @Autowired
    public void setService(IOdontologoService odontologoService) {
        this.odontologoService = odontologoService;
    }

    @PostMapping()
    public ResponseEntity<OdontologoDTO> registrarOdontologo(@RequestBody OdontologoDTO odontologoDTO) {
        return ResponseEntity.ok(odontologoService.agregarOdontologo(odontologoDTO));
    }

    @GetMapping("/{id}")
    public ResponseEntity<OdontologoDTO> buscar(@PathVariable Long id) throws ResourceNotFoundException {
        OdontologoDTO odontologoDTO = odontologoService.buscarPorId(id);
        return ResponseEntity.ok(odontologoDTO);
    }

    @PutMapping()
    public ResponseEntity<OdontologoDTO> actualizar(@RequestBody OdontologoDTO odontologoDTO) {
        ResponseEntity<OdontologoDTO> response = null;

        if (odontologoDTO.getId() != null && odontologoService.buscarPorId(odontologoDTO.getId()) != null)
            response = ResponseEntity.ok(odontologoService.actualizarOdontologo(odontologoDTO));
        else
            response = ResponseEntity.status(HttpStatus.NOT_FOUND).build();

        return response;
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> eliminar(@PathVariable Long id) {
        ResponseEntity<String> response = null;

        if (odontologoService.buscarPorId(id) != null) {
            odontologoService.eliminarOdontologo(id);
            response = ResponseEntity.status(HttpStatus.NO_CONTENT).body("Eliminado");
        } else {
            response = ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        return response;
    }

    @GetMapping
    public ResponseEntity<Set<OdontologoDTO>> buscarTodos() {
        return ResponseEntity.ok(odontologoService.buscarTodos());
    }
}
