package glosaminn

class Guia {

    Long id
    String numeroGuiaPrestador
    String numeroGuiaSolicitacaoInternacao
    String numeroGuiaOperadora
    String senha
    Beneficiario dadosBeneficiario
    List<Produto> procedimentosExecutados
    BigDecimal valorProcedimentos
    BigDecimal valorDiarias
    BigDecimal valorTaxasAlugueis
    BigDecimal valorMateriais
    BigDecimal valorMedicamentos
    BigDecimal valorOPME
    BigDecimal valorGasesMedicinais
    BigDecimal valorTotalGeral

    Guia() {
    }

    Guia(Long id, String numeroGuiaPrestador, String numeroGuiaSolicitacaoInternacao, String numeroGuiaOperadora, String senha, Beneficiario dadosBeneficiario, List<Produto> procedimentosExecutados, BigDecimal valorProcedimentos, BigDecimal valorDiarias, BigDecimal valorTaxasAlugueis, BigDecimal valorMateriais, BigDecimal valorMedicamentos, BigDecimal valorProcedimentos1, BigDecimal valorOPME, BigDecimal valorGasesMedicinais, BigDecimal valorTotalGeral) {
        this.id = id
        this.numeroGuiaPrestador = numeroGuiaPrestador
        this.numeroGuiaSolicitacaoInternacao = numeroGuiaSolicitacaoInternacao
        this.numeroGuiaOperadora = numeroGuiaOperadora
        this.senha = senha
        this.dadosBeneficiario = dadosBeneficiario
        this.procedimentosExecutados = procedimentosExecutados
        this.valorProcedimentos = valorProcedimentos
        this.valorDiarias = valorDiarias
        this.valorTaxasAlugueis = valorTaxasAlugueis
        this.valorMateriais = valorMateriais
        this.valorMedicamentos = valorMedicamentos
        this.valorProcedimentos = valorProcedimentos1
        this.valorOPME = valorOPME
        this.valorGasesMedicinais = valorGasesMedicinais
        this.valorTotalGeral = valorTotalGeral
    }

    Guia(String numeroGuiaPrestador, String numeroGuiaSolicitacaoInternacao, String numeroGuiaOperadora, String senha, Beneficiario dadosBeneficiario, List<Produto> procedimentosExecutados, BigDecimal valorProcedimentos, BigDecimal valorDiarias, BigDecimal valorTaxasAlugueis, BigDecimal valorMateriais, BigDecimal valorMedicamentos, BigDecimal valorProcedimentos1, BigDecimal valorOPME, BigDecimal valorGasesMedicinais, BigDecimal valorTotalGeral) {
        this.numeroGuiaPrestador = numeroGuiaPrestador
        this.numeroGuiaSolicitacaoInternacao = numeroGuiaSolicitacaoInternacao
        this.numeroGuiaOperadora = numeroGuiaOperadora
        this.senha = senha
        this.dadosBeneficiario = dadosBeneficiario
        this.procedimentosExecutados = procedimentosExecutados
        this.valorProcedimentos = valorProcedimentos
        this.valorDiarias = valorDiarias
        this.valorTaxasAlugueis = valorTaxasAlugueis
        this.valorMateriais = valorMateriais
        this.valorMedicamentos = valorMedicamentos
        this.valorProcedimentos = valorProcedimentos1
        this.valorOPME = valorOPME
        this.valorGasesMedicinais = valorGasesMedicinais
        this.valorTotalGeral = valorTotalGeral
    }

    static constraints = {
    }
}
