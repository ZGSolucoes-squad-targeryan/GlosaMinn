package glosaminn

class Guia {

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
	Boolean associate = false

    static constraints = {
		associate nullable: false
    }

	static hasOne = [beneficiario: Beneficiario]

	static hasMany = [produtos: Produto]
}
