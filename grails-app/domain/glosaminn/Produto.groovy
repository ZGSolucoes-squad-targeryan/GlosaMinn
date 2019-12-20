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
    String descricaoProcedimento
    BigDecimal quantidadeExecutada
    BigDecimal reducaoAcrescimo
    BigDecimal valorUnitario
    BigDecimal valorTotal

    static constraints = {
    }
}
