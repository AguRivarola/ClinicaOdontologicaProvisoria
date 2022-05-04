package com.dh.clinicaFinal.service;


import com.dh.clinicaFinal.model.dto.TurnoDTO;

import java.util.Set;


public interface ITurnoService {
    TurnoDTO buscarPorId(Long id);

    Set<TurnoDTO> buscarTodos();

    void eliminarTurno(Long id);

    TurnoDTO actualizarTurno(TurnoDTO turnoDTO);

    TurnoDTO agregarTurno(TurnoDTO turnoDTO);
}
