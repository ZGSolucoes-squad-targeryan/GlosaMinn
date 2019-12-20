package glosaminn

class FaturamentoService {

	List<Map> obtenhaListaDeMapaDeFaturamento(String convenio, String competencia) {
		List<Node> nosDeFaturamento = obtenhaListaDeNosFaturamento(convenio, competencia)
		nosDeFaturamento.collect { arquivo ->
			arquivo.guiasTISS.guiaResumoInternacao.procedimentosExecutados*.collect { procedimento ->
				[
						lote : arquivo.numeroLote.text(),
						numeroGuiaPrestador : arquivo.guiasTISS.guiaResumoInternacao.numeroGuiaPrestador.text(),
						numeroSolicitacaoInternacao : arquivo.guiasTISS.guiaResumoInternacao.numeroGuiaSolicitacaoInternacao.text(),
						numeroGuiaOperadora : arquivo.guiasTISS.guiaResumoInternacao.numeroGuiaOperadora.text(),
						senha : arquivo.guiasTISS.guiaResumoInternacao.senha.text(),
						matricula : arquivo.guiasTISS.guiaResumoInternacao.dadosBeneficiario.numeroCarteira.text(),
						RN : arquivo.guiasTISS.guiaResumoInternacao.dadosBeneficiario.atendimentoRN.text(),
						nome : arquivo.guiasTISS.guiaResumoInternacao.dadosBeneficiario.nomeBeneficiario.text(),
						dataExecucao: procedimento.dataExecucao.text(),
						horaInicial: procedimento.horaInicial.text(),
						horaFinal: procedimento.horaFinal.text(),
						codigoTabela: procedimento.codigoTabela.text(),
						codigoProcedimento: procedimento.codigoProcedimento.text(),
						descricaoProcedimento: procedimento.descricaoProcedimento.text(),
						quantidadeExecutada: procedimento.quantidadeExecutada.text(),
						reducacaoAcrescimo: procedimento.reducacaoAcrescimo.text(),
						valorUnitario: procedimento.valorUnitario.text(),
						valorTotal: procedimento.valorTotal.text()
				]
			}
		}


	}

	List<Node> obtenhaListaDeNosFaturamento(String convenio, String competencia) {
		XmlParser xmlParser = new XmlParser()
		return obtenhaArquivoFaturamento(convenio, competencia).collect { arquivo -> xmlParser.parse(arquivo)}
	}

	List<File> obtenhaArquivoFaturamento(String convenio, String competencia) {
		List<File> arquivos = new ArrayList<File>()

		new File("/home/zeroglosa/demonstrativos-faturamento/faturamento_${convenio}")
				.eachFileMatch(~/(faturamento)_(${convenio})_(${competencia})_(.*).xml/) { arquivo ->
			arquivos.add(arquivo)
		}

		return arquivos
	}

}


