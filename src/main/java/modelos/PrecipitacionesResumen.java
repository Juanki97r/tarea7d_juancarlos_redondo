package modelos;

import java.time.LocalDate;

public class PrecipitacionesResumen {
    private LocalDate fecha;
    private String estacionMeteorologica;


    public PrecipitacionesResumen (){
        
    }


    public LocalDate getFecha() {
        return fecha;
    }


    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }


    public String getEstacionMeteorologica() {
        return estacionMeteorologica;
    }


    public void setEstacionMeteorologica(String estacionMeteorologica) {
        this.estacionMeteorologica = estacionMeteorologica;
    }


    @Override
    public String toString() {
        return "PrecipitacionesResumen [fecha=" + fecha + ", estacionMeteorologica=" + estacionMeteorologica + "]";
    }


    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((fecha == null) ? 0 : fecha.hashCode());
        result = prime * result + ((estacionMeteorologica == null) ? 0 : estacionMeteorologica.hashCode());
        return result;
    }


    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        PrecipitacionesResumen other = (PrecipitacionesResumen) obj;
        if (fecha == null) {
            if (other.fecha != null)
                return false;
        } else if (!fecha.equals(other.fecha))
            return false;
        if (estacionMeteorologica == null) {
            if (other.estacionMeteorologica != null)
                return false;
        } else if (!estacionMeteorologica.equals(other.estacionMeteorologica))
            return false;
        return true;
    }
    
}
