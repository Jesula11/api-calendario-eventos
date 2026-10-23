package edu.altair.apicrm.dtos;
import java.time.LocalDate;
public record Eventos_calendarioRequestDto(
        String titulo,
        LocalDate fecha,
        String tipo,
        String descripcion    
) {}

