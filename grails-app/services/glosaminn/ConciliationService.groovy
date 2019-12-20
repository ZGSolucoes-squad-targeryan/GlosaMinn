package glosaminn

import Receptors.Receptor
import grails.gorm.transactions.Transactional

@Transactional
class ConciliationService {

	final static String FILES_ETL_BASE_URL = 'http://172.22.1.0:9000'
	final static String ANALYTIC_DEMONSTRATIVE = FILES_ETL_BASE_URL + '/analytic-demonstrative'

	void doConciliation(final Convenio convenio, final String competencia) {
		final String convenioParam = '?convenio=' + convenio.nome
		final String jsonResponse = new URL(ANALYTIC_DEMONSTRATIVE + convenioParam).text

		Receptor.getJsonConvenio(jsonResponse)
	}
}
