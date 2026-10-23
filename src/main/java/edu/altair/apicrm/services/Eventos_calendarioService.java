package edu.altair.apicrm.services;

import edu.altair.apicrm.dtos.Eventos_calendarioRequestDto;
import edu.altair.apicrm.dtos.Eventos_calendarioResponseDto;
import java.util.List;

public interface Eventos_calendarioService {
    List<Eventos_calendarioResponseDto> obtenerTodos();
    Eventos_calendarioResponseDto obtenerPorId(Long id);
    Eventos_calendarioResponseDto crear(Eventos_calendarioRequestDto requestDto);
    Eventos_calendarioResponseDto actualizar(Long id, Eventos_calendarioRequestDto requestDto);
    void eliminar(Long id);
}

