import spock.lang.Specification

class LeitorDeArquivoSpec extends Specification {

    def setup() {
    }

    def cleanup() {
    }


    def "test le arquivo do hospital e retorna json"() {

        when:
        File file = new File("/home/douglas/Documentos/demonstrativos-faturamento/faturamento_glosamaxx/faturamento_glosamaxx_2016-02-01_161526_3.02.00.xml")
        LeitorDeArquivo leitorDeArquivo = new LeitorDeArquivo()

        then:
        String json = leitorDeArquivo.returnJsonArquivoPrestador(file)


    }

}
