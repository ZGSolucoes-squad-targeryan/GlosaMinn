package glosaminn

import javassist.NotFoundException

import javax.validation.constraints.NotNull

import static org.springframework.http.HttpStatus.OK

class ConciliationController {

	def showConciliation(@NotNull final String convenioNome, final String competencia) {
		final Convenio convenio = Convenio.findByNome(convenioNome)
		if (!convenio) {
			throw new NotFoundException('Convênio não encontrado')
		}

		respond status: OK

		//call respond service(convenio, competencia)
	}
}
