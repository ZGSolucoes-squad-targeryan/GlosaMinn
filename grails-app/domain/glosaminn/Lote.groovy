package glosaminn

class Lote {

	String numeroLote
	List<Guia> guiasTISS

	Arquivo arquivo

	static constraints = {
		guiasTISS nullable: true
		numeroLote nullable: true
	}

	static hasMany = [guiasTISS: Guia]

}
