package com.letscode.banco.repository;

import com.letscode.banco.dto.ContaResponse;
import com.letscode.banco.model.Conta;
import com.letscode.banco.model.TipoConta;
import com.letscode.banco.projection.ContaAgenciaView;
import com.letscode.banco.projection.ContaView;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import java.math.BigDecimal;
import java.util.List;

@Repository
public interface ContaRepository extends JpaRepository<Conta, Integer> {
  List<Conta> findBySaldoLessThan(BigDecimal saldo);

  List<Conta> findBySaldoLessThanEqual(BigDecimal saldo);

  List<Conta> findBySaldoGreaterThan(BigDecimal saldo);

  List<Conta> findBySaldoGreaterThanEqual(BigDecimal saldo);

  List<Conta> findBySaldoBetween(BigDecimal saldoInicial, BigDecimal saldoFinal);

  List<Conta> findBySaldoIn(List<BigDecimal> saldos);

  List<ContaView> findAllByTipoConta(TipoConta tipoConta);

  @Query(
      "select new com.letscode.banco.dto.ContaResponse(c.id, c.numero, c.agencia, c.tipoConta, c.saldo, " +
              "c.dataCriacao, c.dataAtualizacao, c.usuario) " +
              "from Conta c where c.agencia = :agencia")
  Page<ContaAgenciaView> findByAgencia(@Param("agencia") Integer agencia, Pageable pageable);
}
