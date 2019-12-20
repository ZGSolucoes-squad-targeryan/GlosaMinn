package glosaminn

class GuiaConvenio extends Guia {

	static mapping = {
		discriminator value: "CONVENIO", column: 'discriminator'
	}
}
