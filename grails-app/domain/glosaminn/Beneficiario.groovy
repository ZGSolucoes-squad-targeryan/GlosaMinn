package glosaminn

import glosaminn.enums.RNSimNao

class Beneficiario {

    String numeroCarteira
    RNSimNao atendimentoRN
    String nomeBeneficiario

    Guia guia

    static constraints = {
		numeroCarteira nullable: true
		atendimentoRN nullable: true
		nomeBeneficiario nullable: true
    }

	static mapping = {
		atendimentoRN enumType: 'string'
	}

}
