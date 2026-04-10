package org.unrn.tp1.ejer1;

import java.time.LocalDate;

public class Main {
    static void main(String[] args) {

        //Para no tener que andar borrando la tabla cada vez que se ejecuta el programa,
        // se agrega random para los id, tambien podria capturar el error con un try catch,
        // pero me parecio mas sencillo para el ejercicio agregar un random para
        // evitar el error de clave duplicada.
        int min = 1;
        int max = 100;
        int randomNum = (int) (Math.random() * (max - min + 1)) + min;
        int randomNum2 = (int) (Math.random() * (max - min + 1)) + min;

        // Instanciamos la persistencia (en este caso, JDBC)
        // Si quisieramos cambiar a otra forma de persistencia, como archivos,
        // solo tendriamos que cambiar esta linea y el resto del codigo seguiria funcionando sin cambios.
        RegistroInscripcion persistencia = new JdbcRegistroInscripcion();
        //RegistroInscripcion persistencia = new Files();

        EmailService email = new EmailService();

        // Instanciamos el Concurso inyectando la persistencia
        Concurso avionesAEscalas = new Concurso(
                "Concurso de Aviones a escalas",
                LocalDate.of(2026, 3, 13),
                LocalDate.of(2026, 3, 31),
                randomNum,
                persistencia, email
        );

        // Instanciamos los modelos de datos (Participantes)
        Participante p1 = new Participante("Pepe", randomNum);
        Participante p2 = new Participante("Eze", randomNum2);

        // Ejecutamos la logica de inscripcion
        avionesAEscalas.inscribir(p1, LocalDate.of(2026, 3, 13));
        avionesAEscalas.inscribir(p2, LocalDate.of(2026, 3, 20));

        // Resultados por consola
        avionesAEscalas.obtenerResultados();
    }
}
