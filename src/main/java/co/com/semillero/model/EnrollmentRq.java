package co.com.semillero.model;

import com.google.gson.annotations.SerializedName;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class EnrollmentRq {

    //Primer nombre del cliente
    @SerializedName("nombre")
    private String nombre;
    //Primer apellido del cliente
    @SerializedName("apellido")
    private String apellido;

    //Tipo de llave seleccionada por el cliente para identificarse en el spbvi
    @SerializedName("numeroDocumento")
    private String numeroDocumento;

    //Llave utilizada para identificar a la persona o comercio
    @SerializedName("tipoDocumento")
    private String tipoDocumento;


}
