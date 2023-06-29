package com.acelerati.microservice.microservice_matricula.domain.util;

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.temporal.ChronoUnit;

public class DomainUtilsMethods {

    public static  boolean validateHours(LocalTime init, LocalTime end, Long minHour, Long maxHour){
        //Puedo guardar la diferencia
        Duration difference =  Duration.between(init,end);
        return difference.toHours() >=minHour && difference.toHours() <= maxHour;
    }
    public static  boolean validateDates(LocalDate init, LocalDate end, Long minWeeks){
        long weeks = ChronoUnit.WEEKS.between(init,end);
        return weeks >=minWeeks &&  weeks <= 20;
    }

}
