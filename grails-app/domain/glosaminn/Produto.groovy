package glosaminn

import java.sql.Time

class Produto {

    String descricao
    BigDecimal valor
    Date dataExecucao
    Time horaInicial
    Time horaFinal
    String codigoTabela
    String codigoProcedimento
    BigDecimal quantidadeExecutada
    BigDecimal reducaoAcrescimo
    BigDecimal valorUnitario
    BigDecimal valorTotal

    String motivoGlosa
    BigDecimal valorApresentado
    BigDecimal valorPago
    BigDecimal valorGlosa

    static constraints = {
        descricao nullable: true
        valor nullable: true
        dataExecucao nullable: true
        horaInicial nullable: true
        horaFinal nullable: true
        codigoTabela nullable: true
        codigoProcedimento nullable: true
        quantidadeExecutada nullable: true
        reducaoAcrescimo nullable: true
        valorUnitario nullable: true
        valorTotal nullable: true
        motivoGlosa nullable: true
        valorApresentado nullable: true
        valorPago nullable: true
        valorGlosa nullable: true
        guia nullable: true
    }

    static belongsTo = [guia: Guia]

}
