package co.com.semillero.model.entity;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBAttribute;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBHashKey;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBRangeKey;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UsuarioEntity {

    @DynamoDBRangeKey(attributeName = "id")
    protected String id;

    @DynamoDBHashKey(attributeName = "sdk")
    protected String sdk;

    @DynamoDBAttribute(attributeName = "name")
    protected String nombre;

    @DynamoDBAttribute(attributeName = "apellido")
    protected String apellido;

    @DynamoDBAttribute(attributeName = "celular")
    protected String celular;

    @DynamoDBAttribute(attributeName = "correo")
    protected String correo;

    @DynamoDBAttribute(attributeName = "numeroDocumento")
    protected String numeroDocumento;

    @DynamoDBAttribute(attributeName = "tipoDocumento")
    protected String tipoDocumento;

    @DynamoDBAttribute(attributeName = "ubicacion")
    protected UbicacionEntity ubicacion;


}

