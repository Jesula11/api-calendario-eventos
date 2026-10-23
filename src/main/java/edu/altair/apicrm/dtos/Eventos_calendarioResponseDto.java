package edu.altair.apicrm.dtos;
import java.time.LocalDate;
public record Eventos_calendarioResponseDto(
        String titulo,
        LocalDate fecha,
        String tipo,
        String descripcion 
) {}

