package com.letscode.banco.service;

import com.letscode.banco.dto.UsuarioRequest;
import com.letscode.banco.dto.UsuarioResponse;
import com.letscode.banco.model.Usuario;
import java.util.List;

public interface UsuarioService {
    List<Usuario> getAll(String nome);

    UsuarioResponse create(UsuarioRequest usuarioRequest);

    Usuario getById(Integer id);

    Usuario update(UsuarioRequest usuarioRequest, Integer id);

    void delete(Integer id);

}
