package edu.altair.apicrm.services.impl;

import edu.altair.apicrm.dtos.Eventos_calendarioRequestDto;
import edu.altair.apicrm.dtos.Eventos_calendarioResponseDto;
import edu.altair.apicrm.entities.Eventos_calendario;
import edu.altair.apicrm.exceptions.AlumnoNotFoundException;
import edu.altair.apicrm.exceptions.DniAlreadyExistsException;
import edu.altair.apicrm.repositories.Eventos_calendarioRepository;
import edu.altair.apicrm.services.Eventos_calendarioService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class Eventos_calendarioServiceImpl implements Eventos_calendarioService {

    private final Eventos_calendarioRepository alumnoRepository;

    // Inyección de dependencias por constructor
    public Eventos_calendarioServiceImpl(Eventos_calendarioRepository alumnoRepository) {
        this.alumnoRepository = alumnoRepository;
    }

    @Override
    @Transactional(readOnly = true)
    public List<Eventos_calendarioResponseDto> obtenerTodos() {
        return alumnoRepository.findAll()
                .stream()
                .map(this::mapToResponseDto)
                .toList(); // Método toList() optimizado en Java 25
    }

    @Override
    @Transactional(readOnly = true)
    public Eventos_calendarioResponseDto obtenerPorId(Long id) {
        Eventos_calendario evento = alumnoRepository.findById(id)
                .orElseThrow(() -> new AlumnoNotFoundException("Alumno no encontrado con el ID: " + id));
        return mapToResponseDto(evento);
    }

    @Override
    @Transactional
    public Eventos_calendarioResponseDto crear(Eventos_calendarioRequestDto dto) {
 

        Eventos_calendario nuevoEvento = new Eventos_calendario(
                null,
                dto.titulo(),
                dto.fecha(),
                dto.tipo(),
                dto.descripcion()
        );

        Eventos_calendario guardado = alumnoRepository.save(nuevoEvento);
        return mapToResponseDto(guardado);
    }

    @Override
    @Transactional
    public Eventos_calendarioResponseDto actualizar(Long id, Eventos_calendarioRequestDto dto) {
        Eventos_calendario alumnoExistente = alumnoRepository.findById(id)
                .orElseThrow(() -> new AlumnoNotFoundException("Alumno no encontrado con el ID: " + id));


        alumnoExistente.setTitulo(dto.titulo());
        alumnoExistente.setFecha(dto.fecha());
        alumnoExistente.setTipo(dto.tipo());
        alumnoExistente.setDescripcion(dto.descripcion());


        Eventos_calendario actualizado = alumnoRepository.save(alumnoExistente);
        return mapToResponseDto(actualizado);
    }

    @Override
    @Transactional
    public void eliminar(Long id) {
        if (!alumnoRepository.existsById(id)) {
            throw new AlumnoNotFoundException("Imposible eliminar. Alumno no encontrado con el ID: " + id);
        }
        alumnoRepository.deleteById(id);
    }

    // Método auxiliar de mapeo de Entidad a DTO
    private Eventos_calendarioResponseDto mapToResponseDto(Eventos_calendario alumno) {
        return new Eventos_calendarioResponseDto(
                alumno.getTitulo(),
                alumno.getFecha(),
                alumno.getTipo(),
                alumno.getDescripcion()
        );
    }
}

