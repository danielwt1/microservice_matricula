package com.acelerati.microservice.microservice_matricula.configuration.security.authorization;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class AuthService {
    private static final String DIRECTOR_DE_PROGRAMA="DIRECTOR_DE_PROGRAMA";
    private static final String DECANO="DECANO";
    private static final String PROFESOR="PROFESOR";
    private static final String ALUMNO="ALUMNO";

    public boolean checkDirectorProgramaRole(List<String> roles){
        return roles.contains(DIRECTOR_DE_PROGRAMA);
    }
    public boolean checkDecanoRole(List<String> roles){
        return roles.contains(DECANO);
    }
    public boolean checkProfesorRole(List<String> roles){
        return roles.contains(PROFESOR);
    }
    public boolean checkAlumnoRole(List<String> roles){
        return roles.contains(ALUMNO);
    }
    public List<String> getRolesContext(){
        return SecurityContextHolder.getContext().getAuthentication().getAuthorities().stream()
                .map(GrantedAuthority::getAuthority)
                .map(role->role.substring(5))
                .collect(Collectors.toList());
    }

}
