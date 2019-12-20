package glosaminn


import grails.testing.services.ServiceUnitTest
import spock.lang.Specification


class FaturamentoServiceSpec extends Specification implements ServiceUnitTest<FaturamentoService>{

    def setup() {
    }

    def cleanup() {
    }

    void "busqueArquivosDeUmaCompetencia"() {
        setup:
        FaturamentoService faturamentoService = new FaturamentoService()

        when:
        List<File> arquivos = faturamentoService.obtenhaArquivoFaturamento('glosamaxx', '2016-02-29')

		then:
		!arquivos.isEmpty()

    }

	void "obtenhaListaDeNosDeFaturamento"() {
		setup:
		FaturamentoService faturamentoService = new FaturamentoService()

		when:
		List<Node> arquivos = faturamentoService.obtenhaListaDeNosFaturamento('glosamaxx', '2016-02-29')

		then:
		!arquivos.isEmpty()

	}

	void "obtenhaListaDeJsonDeFaturamento"() {
		setup:
		FaturamentoService faturamentoService = new FaturamentoService()

		when:
		List<Map> arquivos = faturamentoService.obtenhaListaDeMapaDeFaturamento('glosamaxx', '2016-02-29')

		then:
		!arquivos.isEmpty()

	}

}
