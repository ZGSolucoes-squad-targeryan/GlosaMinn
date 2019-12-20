package glosaminn

import javassist.NotFoundException
import org.hibernate.validator.constraints.NotBlank

class ConciliationController {

	ConciliationService conciliationService

	def showConciliation(@NotBlank final String convenioNome, final String competencia) {
		final Convenio convenio = Convenio.findByNome(convenioNome)
		if (!convenio) {
			throw new NotFoundException('Convênio não encontrado')
		}

		respond conciliationService.doConciliation(convenio, competencia)
	}
}
