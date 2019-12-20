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
    }

    static belongsTo = [guia: Guia]

}
