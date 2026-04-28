package servicios;

import java.io.IOException;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.io.File;

import javax.swing.JOptionPane;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

import modelos.*;

public class EscribirJson {
    
    public EscribirJson(){

    }

    public void escrituraDeArchivo(String ruta, Map<String, Double> lista) {
        try {
            // Crea un mapeador de objetos a JSON
            ObjectMapper mapeador = new ObjectMapper();
            // Permite a mapeador usar fechas según java time
            mapeador.registerModule(new JavaTimeModule());
            // Escribe el objeto en el fichero JSON
            mapeador.writerWithDefaultPrettyPrinter().writeValue(new File(ruta), lista);
        } catch (IOException e) {
            // Manejo de excepciones: muestra el error si no se puede escribir el archivo
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Nose pudo escribir el archivo JSON");
        }
    }

    public void escrituraDeArchivoDos(String ruta, Collection lista) {
        try {
            // Crea un mapeador de objetos a JSON
            ObjectMapper mapeador = new ObjectMapper();
            // Permite a mapeador usar fechas según java time
            mapeador.registerModule(new JavaTimeModule());
            // Escribe el objeto en el fichero JSON
            mapeador.writerWithDefaultPrettyPrinter().writeValue(new File(ruta), lista);
        } catch (IOException e) {
            // Manejo de excepciones: muestra el error si no se puede escribir el archivo
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Nose pudo escribir el archivo JSON");
        }
    }
}
