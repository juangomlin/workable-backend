package com.workable_sb.workable.mapper;

import org.springframework.stereotype.Component;

import com.workable_sb.workable.dto.AspiranteDto;
import com.workable_sb.workable.models.Genero;
import com.workable_sb.workable.models.Municipio;
import com.workable_sb.workable.models.TipDocumento;
import com.workable_sb.workable.models.Aspirante;
import com.workable_sb.workable.repositories.GeneroRepository;
import com.workable_sb.workable.repositories.MunicipioRepository;
import com.workable_sb.workable.repositories.TipDocumentoRepository;

import jakarta.persistence.EntityNotFoundException;

@Component
public class AspiranteMapperImple implements AspiranteMapper{

  private final MunicipioRepository municipioRepository;
  private final TipDocumentoRepository tipDocumentoRepository;
  private final GeneroRepository generoRepository;

  public AspiranteMapperImple(MunicipioRepository municipioRepository,
  TipDocumentoRepository tipDocumentoRepository, GeneroRepository generoRepository){
    this.municipioRepository = municipioRepository;
    this.tipDocumentoRepository = tipDocumentoRepository;
    this.generoRepository = generoRepository;
  }

  @Override
  public Aspirante consult(AspiranteDto aspiranteDto){

    Aspirante aspirante = new Aspirante();

    if(aspiranteDto == null)
    return null;
    aspirante.setUsuario_id(aspiranteDto.getId());
    aspirante.setNombre(aspiranteDto.getNom());
    aspirante.setApellido(aspiranteDto.getApe());
    aspirante.setCorreo(aspiranteDto.getCorr());
    aspirante.setUbicacion(aspiranteDto.getUbi());
    aspirante.setTelefono(aspiranteDto.getTel());
    aspirante.setFecha_Nacimiento(aspiranteDto.getFeNa());
    aspirante.setFoto(aspiranteDto.getFoto());
    aspirante.setClave(aspiranteDto.getCla());


    
    Municipio municipio = municipioRepository.findById(aspiranteDto.getMunici_id())
    .orElseThrow(() -> new EntityNotFoundException("municipio no encontrado"));
    aspirante.setMunicipio(municipio);


    TipDocumento tipDocumento = tipDocumentoRepository.findById(aspiranteDto.getTipDoc_id())
    .orElseThrow(() -> new EntityNotFoundException("Documento no encontrado"));
    aspirante.setTipDocumento(tipDocumento);

    Genero genero = generoRepository.findById(aspiranteDto.getGenero_id())
    .orElseThrow(() -> new EntityNotFoundException("Genero no encontrado"));
    aspirante.setGenero(genero);
    
    return aspirante;
  }

  @Override
  public AspiranteDto consultDto(Aspirante entity){
    return new AspiranteDto(
      entity.getUsuario_id(),
      entity.getNombre(),
      entity.getApellido(),
      entity.getClave(),
      entity.getCorreo(),
      entity.getMunicipio().getMunicipio_id(),
      entity.getMunicipio().getNombre(),
      entity.getTipDocumento().getTipoDocumento_id(),
      entity.getTipDocumento().getNombre(),
      entity.getGenero().getGenero_id(),
      entity.getGenero().getNombre());
  }
}
