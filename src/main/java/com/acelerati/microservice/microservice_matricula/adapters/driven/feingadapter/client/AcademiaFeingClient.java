package com.acelerati.microservice.microservice_matricula.adapters.driven.feingadapter.client;

import com.acelerati.microservice.microservice_matricula.adapters.driven.feingadapter.dto.response.SchoolSubjectDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "microservice-academia",url = "${url.microservice.academia}")
public interface AcademiaFeingClient {

    @GetMapping("/academia/")
    ResponseEntity<SchoolSubjectDTO> getSchoolSubjectById(@RequestParam(name = "idSchoolSubject")Long scholeSubject);
}
