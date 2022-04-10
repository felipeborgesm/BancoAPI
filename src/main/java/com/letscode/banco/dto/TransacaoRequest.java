package com.letscode.banco.dto;

import com.letscode.banco.model.TipoTransacao;
import lombok.Getter;
import lombok.Setter;
import java.math.BigDecimal;

@Getter @Setter
public class TransacaoRequest {
    private BigDecimal valor;
    private Integer numero;
    private Integer agencia;
    private TipoTransacao tipoTransacao;
}
