package com.letscode.banco.repository;

import com.letscode.banco.dto.UsuarioResponse;
import com.letscode.banco.model.Usuario;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Integer> {
  Page<Usuario> findByNome(String nome, Pageable pageable);

  @Query(
      "select new com.letscode.banco.dto.UsuarioResponse(u.id, u.cpf, u.nome, u.dataCriacao," +
              " u.dataAtualizacao) from Usuario u " +
              "where u.cpf = :cpf")
  Page<UsuarioResponse> findByCpf(@Param("cpf") String cpf, Pageable pageable);

  List<Usuario> findByNomeAndCpf(String nome, String cpf);

  List<Usuario> findByNomeIs(String nome);

  List<Usuario> findByNomeIsNot(String nome);
}
