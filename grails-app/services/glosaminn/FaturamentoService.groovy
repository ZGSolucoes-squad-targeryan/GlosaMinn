package glosaminn

import static groovy.json.JsonOutput.*

class FaturamentoService {

	List<String> obtenhaJsonFaturamento(String convenio, String competencia) {
		List<Node> nosDeFaturamento = obtenhaListaDeNosFaturamento(convenio, competencia)
		List<String> resultado = nosDeFaturamento.collect { campo ->
			toJson(
				[
						lote: 1

				]
			)
		}

		return resultado
	}

	List<Node> obtenhaListaDeNosFaturamento(String convenio, String competencia) {
		XmlParser xmlParser = new XmlParser()
		return obtenhaArquivoFaturamento(convenio, competencia).collect { arquivo -> xmlParser.parse(arquivo)}
	}

	List<File> obtenhaArquivoFaturamento(String convenio, String competencia) {
		List<File> arquivos = new ArrayList<File>()

		new File("/home/zeroglosa/demonstrativos-faturamento/faturamento_${convenio}")
				.eachFileMatch(~/(faturamento)_(${convenio})_(${competencia})_(.*).xml/) { arquivo ->
			println arquivo.getName()
			arquivos.add(arquivo)
		}

		return arquivos
	}

}


