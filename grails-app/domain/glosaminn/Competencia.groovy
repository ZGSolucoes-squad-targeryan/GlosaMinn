package glosaminn

class Competencia {

    String descricaoCompetencia
    Convenio convenio

    static constraints = {
        descricaoCompetencia nullable: true
        convenio nullable: true
    }

}
