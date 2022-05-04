package com.dh.clinicaFinal.service.implementation;

import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class TurnoServiceTest {
//
//    @Autowired
//    private TurnoService testSubjtect;
//    @Autowired
//    private PacienteService pacienteService;
//    @Autowired
//    private OdontologoService odontologoService;
//
//    @Autowired
//    private ObjectMapper mapper;
//    @Test
//    void createOdontologoTest(){
//        //Having
////        DomicilioDTO domicilioDTO = new DomicilioDTO();
////        domicilioDTO.setCalle("asd");
////        domicilioDTO.setLocalidad("asd");
////        domicilioDTO.setNumero("asd");
////        domicilioDTO.setProvincia("asd");
//
//
//        PacienteDTO pacienteDTO = new PacienteDTO();
//        pacienteDTO.setNombre("José");
//        pacienteDTO.setApellido("Hernandez");
//        pacienteDTO.setDni("45265447");
//        pacienteDTO.setFechaIngreso(LocalDate.now());
//        pacienteDTO.setDomicilio(new Domicilio());
//        pacienteService.agregarPaciente(pacienteDTO);
//
//        OdontologoDTO odontologoDTO = new OdontologoDTO();
//        odontologoDTO.setApellido("Perez");
//        odontologoDTO.setNombre("Ramon");
//        odontologoDTO.setMatricula("RP01");
//        odontologoService.agregarOdontologo(odontologoDTO);
//
//        TurnoDTO turnoDTO = new TurnoDTO();
////        turnoDTO.setOdontologo(mapper.convertValue(odontologoService.buscarPorId(1L),Odontologo.class));
//        turnoDTO.setOdontologo(mapper.convertValue(odontologoDTO,Odontologo.class));
////        turnoDTO.setPaciente(mapper.convertValue(pacienteService.buscarPorId(1L),Paciente.class));
//        odontologoDTO = odontologoService.buscarPorId(1L);
//        turnoDTO.setPaciente(mapper.convertValue(odontologoDTO,Paciente.class));
//        turnoDTO.setFechaIngreso(LocalDate.now());
//
//
//        //When
//        testSubjtect.agregarTurno(turnoDTO);
//        TurnoDTO turnoDTO1 = testSubjtect.buscarPorId(1L);
//        //Then
//        assertEquals(turnoDTO.getOdontologo().getNombre(),turnoDTO1.getOdontologo().getNombre());
//    }
}