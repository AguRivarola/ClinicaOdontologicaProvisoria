package com.dh.clinicaFinal.service.implementation;

import com.dh.clinicaFinal.model.dto.OdontologoDTO;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class OdontologoServiceTest {

    @Autowired
    private OdontologoService testSubjtect;
    @Test
    void createOdontologoTest(){
        //Having
        OdontologoDTO odontologoDTO = new OdontologoDTO();
        odontologoDTO.setApellido("Perez");
        odontologoDTO.setNombre("Ramon");
        odontologoDTO.setMatricula("RP01");
        //When
        testSubjtect.agregarOdontologo(odontologoDTO);
        OdontologoDTO odontologoDTO1 = testSubjtect.buscarPorId(1L);

        //Then
        assertEquals(odontologoDTO1.getMatricula(),odontologoDTO.getMatricula());
    }
}