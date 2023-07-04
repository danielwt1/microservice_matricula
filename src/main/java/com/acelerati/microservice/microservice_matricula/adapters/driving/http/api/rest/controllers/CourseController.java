package com.acelerati.microservice.microservice_matricula.adapters.driving.http.api.rest.controllers;

import com.acelerati.microservice.microservice_matricula.adapters.driving.http.api.rest.dto.request.CourseRequestDTO;
import com.acelerati.microservice.microservice_matricula.adapters.driving.http.api.rest.dto.request.HomeWorkRequestDTO;
import com.acelerati.microservice.microservice_matricula.adapters.driving.http.api.rest.dto.request.ScheduleRequestDTO;
import com.acelerati.microservice.microservice_matricula.adapters.driving.http.api.rest.dto.response.CourseResponseDTO;
import com.acelerati.microservice.microservice_matricula.adapters.driving.http.api.rest.dto.response.PaginationResponseDTO;
import com.acelerati.microservice.microservice_matricula.adapters.driving.http.api.rest.service.CourseService;
import com.acelerati.microservice.microservice_matricula.exceptionhandler.response.ErrorDetails;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/v1/courses")
@Tag(name = "Course", description = "Reresenta los endpoint para manejar los cursos")
public class CourseController {
    private final CourseService courseService;

    public CourseController(CourseService courseService) {
        this.courseService = courseService;
    }

    @Operation(summary = "Permiste lsitar los cursos paginados",
            responses = {
                    @ApiResponse(responseCode = "200", description = "Lista los cursos Paginados",
                            content = @Content(mediaType = "application/json",
                                    schema = @Schema(type = "object", implementation = PaginationResponseDTO.class))),
                    @ApiResponse(responseCode = "400", description = "Hay un error en el request de la solicitud",
                            content = @Content(mediaType = "application/json",
                                    schema = @Schema(type = "object", implementation = ErrorDetails.class))),
                    @ApiResponse(responseCode = "500", description = "A business logic error occurred",
                            content = @Content(mediaType = "application/json",
                                    schema = @Schema(type = "object", implementation = ErrorDetails.class))),
                    @ApiResponse(responseCode = "401", description = "El usario no esta authenticado, o el token esta incorrecto ",
                            content = @Content(mediaType = "application/json",
                                    schema = @Schema(type = "object", implementation = ErrorDetails.class)))
            }
    )
    @PreAuthorize("@authService.checkProfesorRole(@authService.rolesContext)")
    @GetMapping
    public ResponseEntity<PaginationResponseDTO<List<CourseResponseDTO>>> getCoursesByTeacher(@Parameter(description = "Id del profesor", required = true)
                                                                                              @RequestParam(name = "idTeacher") Long idTeacher,
                                                                                              @Parameter(description = "Numero de pagina", required = false)
                                                                                              @RequestParam(name = "page", defaultValue = "0") Integer page,
                                                                                              @Parameter(description = "Tamaño de la pagina", required = false)
                                                                                              @RequestParam(name = "size", defaultValue = "10") Integer size,
                                                                                              @Parameter(description = "Ordenamiento de la pagina", required = false)
                                                                                              @RequestParam(name = "sort", defaultValue = "ASC") String sort) {
        PaginationResponseDTO<List<CourseResponseDTO>> response = this.courseService.getcourses(idTeacher, page, size, sort);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @Operation(summary = "Permite crear un curso en estado EN CURSO",
            responses = {
                    @ApiResponse(responseCode = "201", description = "Se creo un curso correctamente"),
                    @ApiResponse(responseCode = "400", description = "Hay un error en el request de la solicitud",
                            content = @Content(mediaType = "application/json",
                                    schema = @Schema(type = "object", implementation = ErrorDetails.class))),
                    @ApiResponse(responseCode = "500", description = "A business logic error occurred",
                            content = @Content(mediaType = "application/json",
                                    schema = @Schema(type = "object", implementation = ErrorDetails.class))),
                    @ApiResponse(responseCode = "401", description = "El usario no esta authenticado, o el token esta incorrecto ",
                            content = @Content(mediaType = "application/json",
                                    schema = @Schema(type = "object", implementation = ErrorDetails.class)))
            }
    )
    @PreAuthorize("authService.checkDirectorProgramaRole(@authService.rolesContext)")
    @PostMapping
    public ResponseEntity<Void> createCourse(@Valid @RequestBody CourseRequestDTO courseRequestDTO) {
        this.courseService.createCourse(courseRequestDTO);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @Operation(summary = "Permite crear una tarea a un curso en estado EN CURSO",
            responses = {
                    @ApiResponse(responseCode = "201", description = "Se creo una tarea a un  curso correctamente"),
                    @ApiResponse(responseCode = "400", description = "Hay un error en el request de la solicitud",
                            content = @Content(mediaType = "application/json",
                                    schema = @Schema(type = "object", implementation = ErrorDetails.class))),
                    @ApiResponse(responseCode = "500", description = "A business logic error occurred",
                            content = @Content(mediaType = "application/json",
                                    schema = @Schema(type = "object", implementation = ErrorDetails.class))),
                    @ApiResponse(responseCode = "401", description = "El usario no esta authenticado, o el token esta incorrecto ",
                            content = @Content(mediaType = "application/json",
                                    schema = @Schema(type = "object", implementation = ErrorDetails.class)))
            }
    )
    @PreAuthorize("@authService.checkProfesorRole(@authService.rolesContext)")
    @PostMapping("/create/homework")
    public ResponseEntity<Void> addHomeWorkCourse(@Parameter(description = "Id del curso")
                                                 @RequestParam(name = "courseId") Long courseId, @Valid @RequestBody HomeWorkRequestDTO homework) {
        this.courseService.addHomeworkToCourse(courseId, homework);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @Operation(summary = "Permite Agregar un horario al curso ",
            responses = {
                    @ApiResponse(responseCode = "200", description = "Se Agrego el horario a  un curso correctamente"),
                    @ApiResponse(responseCode = "400", description = "Hay un error en el request de la solicitud",
                            content = @Content(mediaType = "application/json",
                                    schema = @Schema(type = "object", implementation = ErrorDetails.class))),
                    @ApiResponse(responseCode = "500", description = "A business logic error occurred",
                            content = @Content(mediaType = "application/json",
                                    schema = @Schema(type = "object", implementation = ErrorDetails.class))),
                    @ApiResponse(responseCode = "401", description = "El usario no esta authenticado, o el token esta incorrecto ",
                            content = @Content(mediaType = "application/json",
                                    schema = @Schema(type = "object", implementation = ErrorDetails.class)))
            }
    )
    @PreAuthorize("@authService.checkDirectorProgramaRole(@authService.rolesContext)")
    @PutMapping
    public ResponseEntity<Void> addSheduleCourse(@Parameter(description = "Id del curso")
                                                 @RequestParam(name = "courseId") Long courseId, @Valid @RequestBody ScheduleRequestDTO scheduleRequestDTO) {
        this.courseService.addSchedules(courseId, scheduleRequestDTO);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @Operation(summary = "Permite asignar un Profesor a un curso",
            responses = {
                    @ApiResponse(responseCode = "200", description = "Se asigno profesor al curso"),
                    @ApiResponse(responseCode = "400", description = "Hay un error en el request de la solicitud",
                            content = @Content(mediaType = "application/json",
                                    schema = @Schema(type = "object", implementation = ErrorDetails.class))),
                    @ApiResponse(responseCode = "500", description = "A business logic error occurred",
                            content = @Content(mediaType = "application/json",
                                    schema = @Schema(type = "object", implementation = ErrorDetails.class))),
                    @ApiResponse(responseCode = "401", description = "El usario no esta authenticado, o el token esta incorrecto ",
                            content = @Content(mediaType = "application/json",
                                    schema = @Schema(type = "object", implementation = ErrorDetails.class)))
            }
    )
    @PreAuthorize("@authService.checkDirectorProgramaRole(@authService.rolesContext)")
    @PutMapping("/Teacher/asignar/")
    public ResponseEntity<Void> assingTeacherToCourse(@Parameter(description = "Id del curso")
                                                      @RequestParam(name = "courseId") Long courseId,
                                                      @Parameter(description = "Id del profesor")
                                                      @RequestParam(name = "teacherId") Long teacherId) {
        this.courseService.addTeacherToCourse(courseId, teacherId);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
