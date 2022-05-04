package com.dh.clinicaFinal.service.implementation;



import com.dh.clinicaFinal.model.dto.TurnoDTO;
import com.dh.clinicaFinal.model.entities.Turno;
import com.dh.clinicaFinal.repository.ITurnoRepository;
import com.dh.clinicaFinal.service.ITurnoService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.Set;

@Service
public class TurnoService implements ITurnoService {
    private ObjectMapper mapper;
    private ITurnoRepository repository;

    @Autowired
    public TurnoService(ObjectMapper mapper, ITurnoRepository repository) {
        this.mapper = mapper;
        this.repository = repository;
    }

    @Override
    public TurnoDTO buscarPorId(Long id) {
        Optional<Turno> turno = repository.findById(id);
        TurnoDTO turnoDTO = null;
        if (turno.isPresent()) {
            turnoDTO = mapper.convertValue(turno, TurnoDTO.class);
        }
        return turnoDTO;
    }

    @Override
    public Set<TurnoDTO> buscarTodos() {
        Set<TurnoDTO> turnoDTOS = new HashSet<>();
        for (Turno turno:repository.findAll())
            turnoDTOS.add(mapper.convertValue(turno,TurnoDTO.class));
        return turnoDTOS;
    }

    @Override
    public void eliminarTurno(Long id) {
        Optional<Turno> turno = repository.findById(id);
        if (turno.isPresent())
            repository.deleteById(id);
        else throw new NoSuchElementException();
    }

    @Override
    public TurnoDTO actualizarTurno(TurnoDTO turnoDTO) {
        Turno turno = mapper.convertValue(turnoDTO,Turno.class);
        return mapper.convertValue(repository.save(turno),TurnoDTO.class);
    }

    @Override
    public TurnoDTO agregarTurno(TurnoDTO turnoDTO) {
        Turno turno = mapper.convertValue(turnoDTO,Turno.class);
        return mapper.convertValue(repository.save(turno),TurnoDTO.class);
    }
}
