package com.dh.clinicaFinal.service.implementation;


import com.dh.clinicaFinal.model.dto.OdontologoDTO;
import com.dh.clinicaFinal.model.entities.Odontologo;
import com.dh.clinicaFinal.repository.IOdontologoRepository;
import com.dh.clinicaFinal.service.IOdontologoService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.Set;

@Service
public class OdontologoService implements IOdontologoService {
    private ObjectMapper mapper;
    private IOdontologoRepository repository;

    @Autowired
    public OdontologoService(ObjectMapper mapper, IOdontologoRepository repository) {
        this.mapper = mapper;
        this.repository = repository;
    }


    @Override
    public OdontologoDTO buscarPorId(Long id) {
        Optional<Odontologo> odontologo = repository.findById(id);
        OdontologoDTO odontologoDTO = null;

        if (odontologo.isPresent()) {
            odontologoDTO = mapper.convertValue(odontologo, OdontologoDTO.class);
        }
        return odontologoDTO;
    }

    @Override
    public Set<OdontologoDTO> buscarTodos() {
        Set<OdontologoDTO> odontologoDTOSet = new HashSet<>();
        for (Odontologo odontologo : repository.findAll()) {
            odontologoDTOSet.add(mapper.convertValue(odontologo, OdontologoDTO.class));
        }
        return odontologoDTOSet;
    }

    @Override
    public void eliminarOdontologo(Long id) {
        Optional<Odontologo> odontologo = repository.findById(id);
        if (odontologo.isPresent())
            repository.deleteById(id);
        else
            throw new NoSuchElementException();
    }

    @Override
    public OdontologoDTO actualizarOdontologo(OdontologoDTO odontologoDTO) {
        Odontologo odontologo = mapper.convertValue(odontologoDTO, Odontologo.class);
        return mapper.convertValue(repository.save(odontologo), OdontologoDTO.class);
    }

    @Override
    public OdontologoDTO agregarOdontologo(OdontologoDTO odontologoDTO) {
        Odontologo odontologo = mapper.convertValue(odontologoDTO, Odontologo.class);
        return mapper.convertValue(repository.save(odontologo), OdontologoDTO.class);
    }
}
