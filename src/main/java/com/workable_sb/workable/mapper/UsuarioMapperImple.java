package com.workable_sb.workable.mapper;

import org.springframework.stereotype.Component;

import com.workable_sb.workable.dto.UsuarioDto;
import com.workable_sb.workable.models.Empresa;
import com.workable_sb.workable.models.Municipio;
import com.workable_sb.workable.models.Rol;
import com.workable_sb.workable.models.TipDocumento;
import com.workable_sb.workable.models.Usuario;
import com.workable_sb.workable.repositories.EmpresaRepository;
import com.workable_sb.workable.repositories.MunicipioRepository;
import com.workable_sb.workable.repositories.RolRepository;
import com.workable_sb.workable.repositories.TipDocumentoRepository;

import jakarta.persistence.EntityNotFoundException;

@Component
public class UsuarioMapperImple implements UsuarioMapper{

  private final MunicipioRepository municipioRepository;
  private final EmpresaRepository empresaRepository;
  private final TipDocumentoRepository tipDocumentoRepository;
  private final RolRepository rolRepository;

  public UsuarioMapperImple(MunicipioRepository municipioRepository, EmpresaRepository empresaRepository,
  TipDocumentoRepository tipDocumentoRepository, RolRepository rolRepository){
    this.municipioRepository = municipioRepository;
    this.empresaRepository = empresaRepository;
    this.tipDocumentoRepository = tipDocumentoRepository;
    this.rolRepository = rolRepository;
  }

  @Override
  public Usuario consult(UsuarioDto usuarioDto){

    Usuario usuario = new Usuario();
    usuario.setUsuario_id(usuarioDto.getId());
    usuario.setNombre(usuarioDto.getNom());
    usuario.setApellido(usuarioDto.getApe());
    usuario.setClave(usuarioDto.getCla());
    usuario.setCorreo(usuarioDto.getCorr());

    
    Municipio municipio = municipioRepository.findById(usuarioDto.getMunici_id())
    .orElseThrow(() -> new EntityNotFoundException("municipio no encontrado"));
    usuario.setMunicipio(municipio);

    Empresa empresa = empresaRepository.findById(usuarioDto.getEmpre_id())
    .orElseThrow(() -> new EntityNotFoundException("Empresa no encontrada"));
    usuario.setEmpresa(empresa);

    TipDocumento tipDocumento = tipDocumentoRepository.findById(usuarioDto.getTipDoc_id())
    .orElseThrow(() -> new EntityNotFoundException("Documento no encontrado"));
    usuario.setTipDocumento(tipDocumento);

    Rol rol = rolRepository.findById(usuarioDto.getRol())
    .orElseThrow(() -> new EntityNotFoundException("Rol no encontrado"));
    usuario.setRol(rol);
    
    return usuario;
  }

  @Override
  public UsuarioDto consultDto(Usuario entity){
    return new UsuarioDto(
      entity.getUsuario_id(),
      entity.getNombre(),
      entity.getApellido(),
      entity.getClave(),
      entity.getCorreo(),
      entity.getMunicipio().getMunicipio_id(),
      entity.getMunicipio().getNombre(),
      entity.getEmpresa().getEmpresa_id(),
      entity.getEmpresa().getNombre(),
      entity.getTipDocumento().getTipoDocumento_id(),
      entity.getTipDocumento().getNombre(),
      entity.getRol().getRol_id(),
      entity.getRol().getNombre());
  }
}
