package principal;

import java.util.List;
import modelos.*;
import servicios.*;

public class Main {
    public static void main(String[] args) {
        LeerJson lector = new LeerJson();
        List <Precipitaciones> lluviasBadajoz = lector.lecturaDeArchivo("precipitacionesBadajoz.json");

        lluviasBadajoz.forEach(System.out::println);
    }
}