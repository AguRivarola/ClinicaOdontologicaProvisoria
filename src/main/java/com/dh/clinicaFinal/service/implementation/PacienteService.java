package com.dh.clinicaFinal.service.implementation;


import com.dh.clinicaFinal.model.dto.PacienteDTO;
import com.dh.clinicaFinal.service.IPacienteService;
import com.dh.clinicaFinal.model.entities.Paciente;
import com.dh.clinicaFinal.repository.IPacienteRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.Set;
@Service
public class PacienteService implements IPacienteService {
    private ObjectMapper mapper;
    private IPacienteRepository repository;

    @Autowired
    public void setMapper(ObjectMapper mapper) {
        this.mapper = mapper;
    }

    @Autowired
    public void setRepository(IPacienteRepository repository) {
        this.repository = repository;
    }

    @Override
    public PacienteDTO buscarPorId(Long id) {
        Optional<Paciente> paciente = repository.findById(id);
        PacienteDTO pacienteDTO = null;
        if (paciente.isPresent())
            pacienteDTO = mapper.convertValue(paciente,PacienteDTO.class);
        return pacienteDTO;
    }

    @Override
    public Set<PacienteDTO> buscarTodos() {
        Set<PacienteDTO> pacientes = new HashSet<>();
        for (Paciente paciente: repository.findAll())
            pacientes.add(mapper.convertValue(paciente,PacienteDTO.class));
        return pacientes;
    }

    @Override
    public void eliminarPaciente(Long id) {
        Optional<Paciente> paciente = repository.findById(id);
        if (paciente.isPresent())
            repository.deleteById(id);
        else throw new NoSuchElementException();
    }

    @Override
    public PacienteDTO actualizarPaciente(PacienteDTO pacienteDTO) {
        Paciente paciente = mapper.convertValue(pacienteDTO,Paciente.class);
        return mapper.convertValue(repository.save(paciente),PacienteDTO.class);
    }

    @Override
    public PacienteDTO agregarPaciente(PacienteDTO pacienteDTO) {
        Paciente paciente = mapper.convertValue(pacienteDTO,Paciente.class);
        return mapper.convertValue(repository.save(paciente),PacienteDTO.class);
    }

}
