package co.com.semillero.mapper;

import co.com.semillero.model.Usuario;
import co.com.semillero.model.entity.*;

public class UsuarioMapper {

    public UsuarioEntity mappingUser (Usuario usuario){
        UsuarioEntity usuarioEntity = new UsuarioEntity();
        //UbicacionEntity ubicacion = new UbicacionEntity();
        IdentificacionEntity identificacionEntity = new IdentificacionEntity();
        LlaveEntity llaveEntity = new LlaveEntity();
        PersonaEntity personaEntity = new PersonaEntity();

        identificacionEntity.setTipoI(usuario.getTipI());
        identificacionEntity.setNumero(usuario.getNumero());
        // tipoCorreo + cedula
        //String id = usuario.getTipoDocumento()+"-"+usuario.getNumeroDocumento();
        String id = identificacionEntity.getTipoI() + "_" + identificacionEntity.getNumero();


        usuarioEntity.setId(id);
        usuarioEntity.setSdk(id);

        llaveEntity.setTipoL(usuario.getTipoL());
        llaveEntity.setValor(usuario.getValor());
        llaveEntity.setFechaHoraCreacion(usuario.getFechaHoraCreacion());

        personaEntity.setTipoP(usuario.getTipoP());
        personaEntity.setNombre(usuario.getNombre());
        personaEntity.setApellido(usuario.getApellido());
        personaEntity.setEmail(usuario.getEmail());
        personaEntity.setTelefono(usuario.getTelefono());

        usuarioEntity.setLlave(llaveEntity);
        usuarioEntity.setIdentificacion(identificacionEntity);
        usuarioEntity.setPersona(personaEntity);

        return usuarioEntity;

     }
}