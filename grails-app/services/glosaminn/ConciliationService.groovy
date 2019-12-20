package glosaminn

import DTOs.DtoArquivoConvenio
import Receptors.Receptor
import grails.gorm.transactions.Transactional

import java.text.SimpleDateFormat
import java.util.stream.Collectors

@Transactional
class ConciliationService {

	final static String FILES_ETL_BASE_URL = 'http://172.22.1.0:9000'
	final static String ANALYTIC_DEMONSTRATIVE = FILES_ETL_BASE_URL + '/analytic-demonstrative'

	void doConciliation(final Convenio convenio, final String competencia) {
		final String convenioParam = '?convenio=' + convenio.nome
		final String jsonResponse = new URL(ANALYTIC_DEMONSTRATIVE + convenioParam).text

		List<DtoArquivoConvenio> dtoArquivoConvenios = Receptor.getJsonConvenio(jsonResponse)
		List<DtoArquivoConvenio> nonSavedFiles = dtoArquivoConvenios.stream().filter { final DtoArquivoConvenio dtoArquivoConvenio ->
			final Guia guiaOnDatabase = Guia.findByNumeroGuiaOperadora(dtoArquivoConvenio.numeroGuiaOperadora)
			return !guiaOnDatabase
		}.collect(Collectors.toList())

		saveConvenioEntities(nonSavedFiles)
	}

	private void saveConvenioEntities(List<DtoArquivoConvenio> conveniosDtos) {
		Map<String, List<DtoArquivoConvenio>> groupedDtos = conveniosDtos.groupBy { DtoArquivoConvenio dto -> dto.numeroGuiaOperadora }
		for (Map.Entry<String, List<DtoArquivoConvenio>> actualGroup : groupedDtos.entrySet()) {
			List<DtoArquivoConvenio> actualGuia = actualGroup.value
			GuiaConvenio guia = new GuiaConvenio(procedimentosExecutados: [])
			fillBeneficiarioGuia(actualGuia.first(), guia)
			Lote lote = new Lote(numeroLote: actualGuia.first().lote).save()
			guia.lote = lote
			fillProductsOnGuia(guia, actualGuia)
		}
	}

	void fillProductsOnGuia(GuiaConvenio guiaConvenio, List<DtoArquivoConvenio> dtos) {
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd")
		for (DtoArquivoConvenio dto : dtos) {
			if (!dto.numeroGuiaOperadora) {
				continue
			}
			try {
				Produto product = new Produto(
						descricao: dto.descricaoProcedimento,
						valorApresentado: new BigDecimal(formatNumber(dto.valorApresentado)),
						valorPago: new BigDecimal(formatNumber(dto.valorPago)),
						valorGlosa: new BigDecimal(formatNumber(dto.valorGlosa)),
						valorUnitario: new BigDecimal(formatNumber(dto.valorUnitario)),
						quantidadeExecutada: new BigDecimal(formatNumber(dto.quantidadeExecutada)),
						dataExecucao: df.parse(dto.dataExecucao),
						codigoTabela: dto.codigoTabela,
						codigoProcedimento: dto.codigoProcedimento,
						motivoGlosa: dto.motivoGlosa
				)

				guiaConvenio.procedimentosExecutados.add(product)
				guiaConvenio.save(failOnError: true, flush: true)
				product.guia = guiaConvenio
				product.save(failOnError: true, flush: true)
			} catch (Exception e) {
				e.message
			}
		}
	}

	void fillBeneficiarioGuia(DtoArquivoConvenio dtoArquivoConvenio, Guia guia) {
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

	private static String formatNumber(final String numberToFormat) {
		return numberToFormat ? numberToFormat.replaceAll(/,/, '.') : '0'
	}


}
