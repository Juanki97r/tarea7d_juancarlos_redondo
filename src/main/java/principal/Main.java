package principal;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import modelos.*;
import servicios.*;

public class Main {
    public static void main(String[] args) {
        LeerJson lector = new LeerJson();
        List <Precipitaciones> lluviasBadajoz = lector.lecturaDeArchivo("precipitacionesBadajoz.json");
        lluviasBadajoz.forEach(System.out::println);

        //1)
        Map<String,Double> acumuladoEstacion = acumuladoEstacion(lluviasBadajoz);
        acumuladoEstacion.forEach((estacion, total) -> System.out.println(estacion + ": " + total));
        //2)
        EscribirJson escritor = new EscribirJson();
        escritor.escrituraDeArchivo("acumuladoEstacion.json", acumuladoEstacion);
         //3)
         System.out.println("Precipitación máxima: " + precipitacionMaxima(lluviasBadajoz));

         //4)
        int cantPrecipLeidasEntre10Y20 = precipitacionesEntreFechas(lluviasBadajoz, LocalDate.of(2017, 10, 10), LocalDate.of(2017, 10, 20));
        System.out.println("Cantidad de precipitaciones entre el 10 y el 20 de octubre: " + cantPrecipLeidasEntre10Y20);

        //5)
        double mediaPrecipitacionesEntre10y20 = mediaPrecipitaciones(lluviasBadajoz, LocalDate.of(2017,10,10), LocalDate.of(2017,10,20));
        System.out.printf("%.2f",mediaPrecipitacionesEntre10y20  );

        List<PrecipitacionesResumen> soloFechasYEstacion = lector.lecturaDeArchivoResumen("precipitacionesBadajoz.json");
        System.out.println("-------------------");
        soloFechasYEstacion.forEach(System.out::println);
        escritor.escrituraDeArchivoDos("precipitacionesResumen.json", soloFechasYEstacion);
    }


    public static Map<String,Double> acumuladoEstacion (List<Precipitaciones> precipitaciones) {
        return precipitaciones.stream().collect(Collectors.groupingBy(Precipitaciones::getEstacionMeteorologica, Collectors.summingDouble(Precipitaciones::getPrecipitacion
        )));
    }

    public static Precipitaciones precipitacionMaxima (List<Precipitaciones> precipitaciones) {
        return precipitaciones.stream().max((p1, p2) -> Double.compare(p1.getPrecipitacion(), p2.getPrecipitacion())).orElse(null);
    }

    public static int precipitacionesEntreFechas (List<Precipitaciones> precipitaciones, LocalDate fechaInicio, LocalDate fechaFin) {
        return (int) precipitaciones.stream().filter(p -> p.getFecha().isAfter(fechaInicio.minusDays(1)) && p.getFecha().isBefore(fechaFin.plusDays(1))).count();
    }

    public static double mediaPrecipitaciones(List<Precipitaciones> precipitaciones, LocalDate fechaInicio, LocalDate fechaFin){
        return precipitaciones.stream().
        filter(p -> p.getFecha().isAfter(fechaInicio.minusDays(1)) && p.getFecha().isBefore(fechaFin.plusDays(1))).
        mapToDouble(Precipitaciones::getPrecipitacion).
        average().orElse(0.0);
    }
}   