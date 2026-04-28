package servicios;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

import modelos.*;

public class LeerJson {

    public LeerJson(){

    }
    
    public List<Precipitaciones> lecturaDeArchivo(String ruta){
       List<Precipitaciones> catalogo = new ArrayList<>();
        try{ // Crea un mapeador de objetos a JSON
        ObjectMapper mapeador = new ObjectMapper();
        // Permite a mapeador usar fechas según java time
        mapeador.registerModule(new JavaTimeModule());
        // Lee el catálogo de vehículos desde el fichero JSON y lo guarda en una lista de objetos de tipo Vehiculo
            catalogo = mapeador.readValue(new File(ruta),
                    mapeador.getTypeFactory().constructCollectionType(List.class, Precipitaciones.class));

        } catch (IOException e) {
            // Manejo de excepciones: muestra el error si no se puede leer el archivo
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Nose pudo leer el archivo JSON");
        }         
        return catalogo;
        
    }

     public List<PrecipitacionesResumen> lecturaDeArchivoResumen(String ruta){
       List<PrecipitacionesResumen> catalogo = new ArrayList<>();
        try{ // Crea un mapeador de objetos a JSON
        ObjectMapper mapeador = new ObjectMapper();
        // Permite a mapeador usar fechas según java time
        mapeador.registerModule(new JavaTimeModule());
        mapeador.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        // Lee el catálogo de vehículos desde el fichero JSON y lo guarda en una lista de objetos de tipo Vehiculo
            catalogo = mapeador.readValue(new File(ruta),
            mapeador.getTypeFactory().constructCollectionType(List.class, PrecipitacionesResumen.class));

        } catch (IOException e) {
            // Manejo de excepciones: muestra el error si no se puede leer el archivo
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Nose pudo leer el archivo JSON");
        }         
        return catalogo;
        
     }
}
