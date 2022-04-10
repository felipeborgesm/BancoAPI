package com.letscode.banco.dto;

import com.letscode.banco.model.Conta;
import com.letscode.banco.model.TipoTransacao;
import com.letscode.banco.model.Transacao;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
public class TransacaoResponse {
    private Integer id;
    private BigDecimal valor;
    private TipoTransacao tipoTransacao;
    private Integer agencia;
    private LocalDateTime dataCriacao;
    private LocalDateTime dataAtualizacao;
    private Conta conta;

    public TransacaoResponse(Transacao transacao) {
        this.id = transacao.getId();
        this.valor = transacao.getValor();
        this.tipoTransacao = transacao.getTipoTransacao();
        this.agencia = transacao.getAgencia();
        this.dataCriacao = transacao.getDataCriacao();
        this.dataAtualizacao = transacao.getDataAtualizacao();
        this.conta = transacao.getConta();
    }

}
