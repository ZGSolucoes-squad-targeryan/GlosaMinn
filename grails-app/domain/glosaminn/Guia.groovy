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
		numeroGuiaPrestador nullable: true
		numeroGuiaSolicitacaoInternacao nullable: true
		numeroGuiaOperadora nullable: true
		senha nullable: true
		dadosBeneficiario nullable: true
		procedimentosExecutados nullable: true
		valorProcedimentos nullable: true
		valorDiarias nullable: true
		valorTaxasAlugueis nullable: true
		valorMateriais nullable: true
		valorMedicamentos nullable: true
		valorOPME nullable: true
		valorGasesMedicinais nullable: true
		valorTotalGeral nullable: true
		lote nullable: true
    }

	static hasOne = [dadosBeneficiario: Beneficiario]

	static hasMany = [procedimentosExecutados: Produto]

	static belongsTo = [lote: Lote]
}
