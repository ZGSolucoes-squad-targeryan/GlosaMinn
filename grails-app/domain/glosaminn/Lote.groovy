package glosaminn

class Lote {

    String numeroLote
    List<Guia> guiasTISS

    static constraints = {
    }

    static belongsTo = [arquivo: Arquivo]
}
