package glosaminn

import java.sql.Time

class Produto {

    Long id
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

    Produto() {

    }

    Produto(Long id, String descricao, BigDecimal valor, Date dataExecucao, Time horaInicial, Time horaFinal, String codigoTabela, String codigoProcedimento, String descricaoProcedimento, BigDecimal quantidadeExecutada, BigDecimal reducaoAcrescimo, BigDecimal valorUnitario, BigDecimal valorTotal) {
        this.id = id
        this.descricao = descricao
        this.valor = valor
        this.dataExecucao = dataExecucao
        this.horaInicial = horaInicial
        this.horaFinal = horaFinal
        this.codigoTabela = codigoTabela
        this.codigoProcedimento = codigoProcedimento
        this.descricaoProcedimento = descricaoProcedimento
        this.quantidadeExecutada = quantidadeExecutada
        this.reducaoAcrescimo = reducaoAcrescimo
        this.valorUnitario = valorUnitario
        this.valorTotal = valorTotal
    }

    Produto(String descricao, BigDecimal valor, Date dataExecucao, Time horaInicial, Time horaFinal, String codigoTabela, String codigoProcedimento, String descricaoProcedimento, BigDecimal quantidadeExecutada, BigDecimal reducaoAcrescimo, BigDecimal valorUnitario, BigDecimal valorTotal) {
        this.descricao = descricao
        this.valor = valor
        this.dataExecucao = dataExecucao
        this.horaInicial = horaInicial
        this.horaFinal = horaFinal
        this.codigoTabela = codigoTabela
        this.codigoProcedimento = codigoProcedimento
        this.descricaoProcedimento = descricaoProcedimento
        this.quantidadeExecutada = quantidadeExecutada
        this.reducaoAcrescimo = reducaoAcrescimo
        this.valorUnitario = valorUnitario
        this.valorTotal = valorTotal
    }

    static constraints = {
    }
}
