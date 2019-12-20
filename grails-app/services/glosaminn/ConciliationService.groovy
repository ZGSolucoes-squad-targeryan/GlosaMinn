package glosaminn

import DTOs.DtoArquivoConvenio
import Receptors.Receptor
import grails.gorm.transactions.Transactional

import java.text.SimpleDateFormat

@Transactional
class ConciliationService {

    final static String FILES_ETL_BASE_URL = 'http://172.22.1.0:9000'
    final static String ANALYTIC_DEMONSTRATIVE = FILES_ETL_BASE_URL + '/analytic-demonstrative'

    void doConciliation(final Convenio convenio, final String competencia) {
        final String convenioParam = '?convenio=' + convenio.nome
        final String jsonResponse = new URL(ANALYTIC_DEMONSTRATIVE + convenioParam).text

        List<DtoArquivoConvenio> dtosConvenio = Receptor.getJsonConvenio(jsonResponse)
        saveConvenioEntities(dtosConvenio)
    }

	private void saveConvenioEntities(List<DtoArquivoConvenio> conveniosDtos) {
		Map<String, List<DtoArquivoConvenio>> groupedDtos = conveniosDtos.groupBy { DtoArquivoConvenio dto -> dto.numeroGuiaOperadora }
		for (Map.Entry<String, List<DtoArquivoConvenio>> actualGroup : groupedDtos.entrySet()) {
			List<DtoArquivoConvenio> actualGuia = actualGroup.value
			GuiaConvenio guia = new GuiaConvenio()
			fillBeneficiarioGuia(actualGuia.first(), guia)
			fillProductsOnGuia(guia, actualGuia)
		}
	}

	void fillProductsOnGuia(GuiaConvenio guiaConvenio, List<DtoArquivoConvenio> dtos) {
		SimpleDateFormat df= new SimpleDateFormat("dd/MM/yyyy 00:00:00")
		for (DtoArquivoConvenio dto : dtos) {
			Produto product = new Produto(
					descricao: dto.descricaoProcedimento,
					valorApresentado: new BigDecimal(dto.valorApresentado),
					valorPago: new BigDecimal(dto.valorPago),
					valorGlosa: new BigDecimal(dto.valorGlosa),
					valorUnitario: new BigDecimal(dto.valorUnitario),
					quantidadeExecutada: new BigDecimal(dto.quantidadeExecutada),
					dataExecucao: df.parse(dto.dataExecucao),
					codigoTabela: dto.codigoTabela,
					codigoProcedimento: dto.codigoProcedimento,
					motivoGlosa: dto.motivoGlosa
			)
			guiaConvenio.procedimentosExecutados.add(product)
			product.guia = guiaConvenio
			product.save()
		}
		guiaConvenio.save()
	}

	void fillBeneficiarioGuia(DtoArquivoConvenio dtoArquivoConvenio,Guia guia) {
		String matricula = dtoArquivoConvenio.matricula
		String nome = dtoArquivoConvenio.nome

		Beneficiario existentBeneficiario = Beneficiario.findByNomeBeneficiarioAndNumeroCarteira(nome, matricula)
		if (existentBeneficiario) {
			guia.dadosBeneficiario = existentBeneficiario
			return
		}

		Beneficiario newBeneficiario = new Beneficiario(
				nome: nome,
				numeroCarteira: matricula,
				atendimentoRN: dtoArquivoConvenio.RN
		)

		guia.dadosBeneficiario = newBeneficiario
	}


}
