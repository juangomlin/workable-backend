package com.workable_sb.workable.mapper;

import org.springframework.stereotype.Component;

import com.workable_sb.workable.dto.PostulacionDto;
import com.workable_sb.workable.models.Estado;
import com.workable_sb.workable.models.Oferta;
import com.workable_sb.workable.models.Postulacion;
import com.workable_sb.workable.models.Aspirante;
import com.workable_sb.workable.repositories.EstadoRepository;
import com.workable_sb.workable.repositories.OfertaRepository;
import com.workable_sb.workable.repositories.AspiranteRepository;

import jakarta.persistence.EntityNotFoundException;

@Component
public class PostulacionMapperImple implements PostulacionMapper{

  private final EstadoRepository estadoRepository;
  private final OfertaRepository ofertaRepository;
  private final AspiranteRepository usuarioRepository;

  public PostulacionMapperImple(EstadoRepository estadoRepository, OfertaRepository ofertaRepository,
  AspiranteRepository usuarioRepository){
    this.estadoRepository = estadoRepository;
    this.ofertaRepository = ofertaRepository;
    this.usuarioRepository = usuarioRepository;
  }

  @Override
  public Postulacion consult(PostulacionDto postulacionDto){

    Postulacion postulacion = new Postulacion();
    postulacion.setPostuacion_id(postulacionDto.getId());
    postulacion.setFecha(postulacionDto.getFech());

    Estado estado = estadoRepository.findById(postulacionDto.getEstado_Id())
    .orElseThrow(() -> new EntityNotFoundException("Estado no encontrado"));
    postulacion.setEstado(estado);

    Oferta oferta = ofertaRepository.findById(postulacionDto.getOferta_Id())
    .orElseThrow(() -> new EntityNotFoundException("Oferta no encontrada"));
    postulacion.setOferta(oferta);

    Aspirante usuario = usuarioRepository.findById(postulacionDto.getUsuario_Id())
    .orElseThrow(() -> new EntityNotFoundException("Usuario no encontrado"));
    postulacion.setUsuario(usuario);

    return postulacion;

    }

  @Override
  public PostulacionDto consultDto(Postulacion entity){
    return new PostulacionDto(
    entity.getPostuacion_id(),
    entity.getFecha(),
    entity.getEstado().getEstado_id(),
    entity.getEstado().getNombre(),
    entity.getOferta().getOferta_id(),
    entity.getOferta().getTitulo(),
    entity.getUsuario().getUsuario_id(),
    entity.getUsuario().getNombre()
    );
  }

}
