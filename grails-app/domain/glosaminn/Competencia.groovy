package glosaminn

class Competencia {

    Convenio convenio
    String descricaoCompetencia

    static constraints = {
    }

    static hasOne = [convenio: Convenio]
}
