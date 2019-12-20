package glosaminn

class Arquivo {

	String fileName

	static constraints = {
		fileName unique: true
	}

	static hasOne = [lote: Lote]
}
