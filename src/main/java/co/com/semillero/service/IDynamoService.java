package co.com.semillero.service;

import co.com.semillero.model.Usuario;
import co.com.semillero.model.entity.UsuarioEntity;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;

public interface IDynamoService {
    String saveUsuario(DynamoDBMapper mapper, Usuario usuario);

    UsuarioEntity getUsuario(DynamoDBMapper mapper, Usuario usuario);
}
