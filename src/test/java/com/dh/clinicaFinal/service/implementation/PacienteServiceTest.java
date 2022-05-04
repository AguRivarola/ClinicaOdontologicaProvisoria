package com.dh.clinicaFinal.service.implementation;

import com.dh.clinicaFinal.model.dto.PacienteDTO;
import com.dh.clinicaFinal.model.entities.Domicilio;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class PacienteServiceTest {

    @Autowired
    private PacienteService testSubjtect;
    @Test
    void createPacienteTest(){
        //Having
        PacienteDTO pacienteDTO = new PacienteDTO();
        pacienteDTO.setNombre("José");
        pacienteDTO.setApellido("Hernandez");
        pacienteDTO.setDni("45265447");
        pacienteDTO.setFechaIngreso(LocalDate.now());
        pacienteDTO.setDomicilio(new Domicilio());

        //When
        testSubjtect.agregarPaciente(pacienteDTO);
        PacienteDTO pacienteDTO1 = testSubjtect.buscarPorId(1L);
        //Then
        assertEquals(pacienteDTO.getDni(),pacienteDTO1.getDni());
    }
}