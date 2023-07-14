# albaran-parent

Proyecto gradle parent que contiene 3 subsproyectos gradle solo ejecuta 2 de ellos.

rootProject.name = 'albaran-parent'
include("frontend")
include("backend")

## Estructura gradle
AlbaranDigitalProin/build.gradle
 - backend/build.gradle (genera un war desplegable y es autorunnable con springboot)
 - frontend/build.gradle (genera un webJar que se incluye en el classpath del backend)
 - backend-thymeleaf/build.gradle (no esta como dependencia del parent simplemente se conserva como antigua versión antes de la migración de thymeleaf a angular)

 ## Comandos gradle/npm

 nunca ejecutar  con gradle el clean y build del front a la vez (como lo delega en npm hay problemas en la transición interna del clean a el build, por separado no hay problema)

  ## Clean

 AlbaranDigitalProin =  ./gradlew clean (ejecutara el clean de los 2 subproyectos)
 - backend =  ./gradlew :backend:clean (ejecutara el clean del subproyecto backend)
 - frontend = ./gradlew :frontend:clean (ejecutara el clean del subproyecto frontend)

 también se puede ejecutar directamente cualquier subproyecto

 cd backend ./gradlew clean
cd frontend ./gradlew clean

  ## build

 AlbaranDigitalProin =  ./gradlew build (ejecutara el build de los 2 subproyectos)
 - backend =  ./gradlew :backend:build (ejecutara el build del subproyecto backend)
 - frontend = ./gradlew :frontend:build (ejecutara el build del subproyecto frontend)

 también se puede ejecutar directamente cualquier subproyecto

cd backend ./gradlew build
cd frontend ./gradlew build


  ## START

 AlbaranDigitalProin =  no tiene arranque
 - backend =  ejecutar el main como un spring boot standar
 - frontend = no es necesario ejecutar ya que lo incluye en un webjar el backend no obstante con "npm run start" en el directorio front arrancamos el front individualmente

   ## Config
 se debe arrancar la aplicación en local con el PROFILE de spring "dev" (esto deshabilita la seguridad de spring de momento no implementada)
 se han configurado los weborigins  (localhost:4200 y localhost:8080) para pruebas en la aplicación backend.