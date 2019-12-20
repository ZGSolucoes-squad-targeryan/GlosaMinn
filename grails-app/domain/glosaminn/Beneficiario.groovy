package glosaminn

class Beneficiario {

    Long id
    String numeroCarteira
    String atendimentoRN
    String nomeBeneficiario

    Beneficiario() {
    }

    Beneficiario(Long id, String numeroCarteira, String atendimentoRN, String nomeBeneficiario) {
        this.id = id
        this.numeroCarteira = numeroCarteira
        this.atendimentoRN = atendimentoRN
        this.nomeBeneficiario = nomeBeneficiario
    }

    Beneficiario(String numeroCarteira, String atendimentoRN, String nomeBeneficiario) {
        this.numeroCarteira = numeroCarteira
        this.atendimentoRN = atendimentoRN
        this.nomeBeneficiario = nomeBeneficiario
    }

    static constraints = {
    }
}
