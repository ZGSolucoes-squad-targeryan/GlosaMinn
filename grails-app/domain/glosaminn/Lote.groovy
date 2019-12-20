package glosaminn

class Lote {

    String numeroLote
    List<Guia> guiasTISS

    Arquivo arquivo

    static constraints = {
    }

    static hasMany = [guiasTISS: Guia]

}
