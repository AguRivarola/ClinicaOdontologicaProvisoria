package com.dh.clinicaFinal.service;

import com.dh.clinicaFinal.model.dto.OdontologoDTO;

import java.util.Set;


public interface IOdontologoService {
    OdontologoDTO buscarPorId(Long id);

    Set<OdontologoDTO> buscarTodos();

    void eliminarOdontologo(Long id);

    OdontologoDTO actualizarOdontologo(OdontologoDTO odontologoDTO);

    OdontologoDTO agregarOdontologo(OdontologoDTO odontologoDTO);
}
