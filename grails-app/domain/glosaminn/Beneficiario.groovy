package glosaminn

import glosaminn.enums.RNSimNao

class Beneficiario {

    String numeroCarteira
    RNSimNao atendimentoRN
    String nomeBeneficiario

    static constraints = {
        numeroCarteira unique: true
    }

    static belongsTo = [guia: Guia]
}
