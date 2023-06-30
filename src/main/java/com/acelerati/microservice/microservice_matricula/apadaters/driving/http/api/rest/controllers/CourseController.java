package com.acelerati.microservice.microservice_matricula.apadaters.driving.http.api.rest.controllers;

import com.acelerati.microservice.microservice_matricula.apadaters.driving.http.api.rest.dto.request.CourseRequestDTO;
import com.acelerati.microservice.microservice_matricula.apadaters.driving.http.api.rest.dto.request.ScheduleRequestDTO;
import com.acelerati.microservice.microservice_matricula.apadaters.driving.http.api.rest.service.CourseService;
import com.acelerati.microservice.microservice_matricula.exceptionhandler.response.ErrorDetails;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/v1/courses")
public class CourseController {
    private final CourseService courseService;

    public CourseController(CourseService courseService) {
        this.courseService = courseService;
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
    @PostMapping
    public ResponseEntity<Void> createCourse(@Valid @RequestBody CourseRequestDTO courseRequestDTO) {
        this.courseService.createCourse(courseRequestDTO);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @PutMapping
    public ResponseEntity<Void> addSheduleCourse(@RequestParam(name = "courseId") Long courseId, @Valid @RequestBody ScheduleRequestDTO scheduleRequestDTO) {
        this.courseService.addSchedules(courseId,scheduleRequestDTO);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
