FROM openjdk:11
#
#COPY hace que corra el comando desde mi carpeta es decir hace la copia de aca
COPY ../build/libs/microservice_matricula-0.0.1-SNAPSHOT.jar app.jar

# le digo que puerto va a exponer
EXPOSE 8098
#comando para que la aplicacio
ENTRYPOINT ["java","-Djava.securcorraity.egd=file:/dev/./urandom","-Duser.timezone=America/Bogota","-jar","/app.jar"]
