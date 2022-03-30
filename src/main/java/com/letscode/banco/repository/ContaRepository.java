package com.letscode.banco.repository;

import com.letscode.banco.model.Conta;
import com.letscode.banco.model.TipoConta;
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

    @Query("select c from Conta c "+
            "where (c.tipoConta = :tipoConta and c.agencia = :agencia)" +
            "or (c.tipoConta = :tipoConta or c.saldo = :saldo)")
    List<Conta> findByTipoContaAndCpfOrTipoContaAndSaldo(
            @Param("tipoConta") TipoConta tipoConta,
            @Param("agencia") String agencia,
            @Param("saldo") BigDecimal saldo);

}
