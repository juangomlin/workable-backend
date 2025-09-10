package com.workable_sb.workable.mapper;

import org.springframework.stereotype.Component;


import com.workable_sb.workable.dto.InfoPersonalDto;
import com.workable_sb.workable.models.Genero;
import com.workable_sb.workable.models.InfoPersonal;
import com.workable_sb.workable.models.Usuario;
import com.workable_sb.workable.repositories.GeneroRepository;
import com.workable_sb.workable.repositories.InfoPersonalRepository;
import com.workable_sb.workable.repositories.UsuarioRepository;


@Component
public class InfoPersonalMapperImple implements InfoPersonalMapper {


    private final GeneroRepository generoRepository;
    private final UsuarioRepository usuarioRepository;


    public InfoPersonalMapperImple(GeneroRepository generoRepository, UsuarioRepository usuarioRepository, InfoPersonalRepository infoPersonalRepository) {
        this.generoRepository = generoRepository;
        this.usuarioRepository = usuarioRepository;
    }

    @Override
    public InfoPersonal consult(InfoPersonalDto infoPersonalDto) {
        InfoPersonal infoPersonal = new InfoPersonal();
        infoPersonal.setInfoPersonal_id(infoPersonalDto.getInfPerson_id());
        infoPersonal.setUbicacion(infoPersonalDto.getUbic());
        infoPersonal.setTelefono(infoPersonalDto.getTelef());
        infoPersonal.setFechaNacimiento(infoPersonalDto.getFechnac());
        infoPersonal.setFotoPerfil(infoPersonalDto.getFotperfil());

        Genero genero = generoRepository.findById(infoPersonalDto.getGenero_id()).orElseThrow(() -> new RuntimeException("Genero no encontrado"));
        infoPersonal.setGenero(genero);

        
        Usuario usuario = usuarioRepository.findById(infoPersonalDto.getUsuario_id()).orElseThrow(() -> new RuntimeException("Usuario no encontrado"));
        infoPersonal.setUsuario(usuario);

        return infoPersonal;

    }

    @Override
    public InfoPersonalDto consultDto(InfoPersonal infoPersonalDto) {
        return new InfoPersonalDto(
            infoPersonalDto.getInfoPersonal_id(),
            infoPersonalDto.getUbicacion(),
            infoPersonalDto.getTelefono(),
            infoPersonalDto.getFechaNacimiento(),
            infoPersonalDto.getFotoPerfil(),
            infoPersonalDto.getGenero().getGenero_id(),
            infoPersonalDto.getGenero().getNombre(),
            infoPersonalDto.getUsuario().getUsuario_id(),
            infoPersonalDto.getUsuario().getNombre()); 
  }

}
