package co.com.semillero.mapper;

import co.com.semillero.model.Usuario;
import co.com.semillero.model.entity.UbicacionEntity;
import co.com.semillero.model.entity.UsuarioEntity;

public class UsuarioMapper {

    public UsuarioEntity mappingUser (Usuario usuario){
        UsuarioEntity usuarioEntity = new UsuarioEntity();
        UbicacionEntity ubicacion = new UbicacionEntity();

        String id = usuario.getTipoDocumento()+"-"+usuario.getNumeroDocumento();
        usuarioEntity.setId(id);
        usuarioEntity.setSdk(id);
        usuarioEntity.setApellido((usuario.getApellido()));

        ubicacion.setCiudad(usuario.getCiudad());
        ubicacion.setDireccion(usuario.getDireccion());
        usuarioEntity.setUbicacion(ubicacion);
        return usuarioEntity;

     }
}