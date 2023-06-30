package com.acelerati.microservice.microservice_matricula.apadaters.driven.feingadapter.client;

import com.acelerati.microservice.microservice_matricula.apadaters.driven.feingadapter.dto.response.UserResponseDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "UserFeingClient",url = "${url.microservice.user}")
public interface UserFeingClient {

    @GetMapping("/user/")
    ResponseEntity<UserResponseDTO> getUserByIdAndTypeTeacher(@RequestParam Long id, @RequestParam Long typeTeacher);


}
