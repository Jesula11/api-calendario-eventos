package edu.altair.apicrm.controllers;

import edu.altair.apicrm.dtos.Eventos_calendarioRequestDto;
import edu.altair.apicrm.dtos.Eventos_calendarioResponseDto;
import edu.altair.apicrm.services.Eventos_calendarioService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api/eventos_calendario")
public class AlumnoController {

    private final Eventos_calendarioService EventoService;

    public AlumnoController(Eventos_calendarioService alumnoService) {
        this.EventoService = alumnoService;
    }

    // 1. READ ALL - GET /api/alumnos
    @GetMapping
    public ResponseEntity<List<Eventos_calendarioResponseDto>> obtenerTodos() {
        return ResponseEntity.ok(EventoService.obtenerTodos()); // HTTP 200 OK
    }

    // 2. READ BY ID - GET /api/alumnos/{id}
    @GetMapping("/{id}")
    public ResponseEntity<Eventos_calendarioResponseDto> obtenerPorId(@PathVariable Long id) {
        return ResponseEntity.ok(EventoService.obtenerPorId(id)); // HTTP 200 OK
    }

    // 3. CREATE - POST /api/alumnos
    @PostMapping
    public ResponseEntity<Eventos_calendarioResponseDto> crear(@RequestBody Eventos_calendarioRequestDto requestDto) {
        Eventos_calendarioResponseDto creado = EventoService.crear(requestDto);
        return ResponseEntity
                .status(HttpStatus.CREATED) // HTTP 201 Created
                .body(creado);
    }

    // 4. UPDATE - PUT /api/alumnos/{id}
    @PutMapping("/{id}")
    public ResponseEntity<Eventos_calendarioResponseDto> actualizar(
            @PathVariable Long id,
            @RequestBody Eventos_calendarioRequestDto requestDto) {
        Eventos_calendarioResponseDto actualizado = EventoService.actualizar(id, requestDto);
        return ResponseEntity.ok(actualizado); // HTTP 200 OK
    }

    // 5. DELETE - DELETE /api/alumnos/{id}
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Long id) {
        EventoService.eliminar(id);
        return ResponseEntity.noContent().build(); // HTTP 204 No Content
    }
}

