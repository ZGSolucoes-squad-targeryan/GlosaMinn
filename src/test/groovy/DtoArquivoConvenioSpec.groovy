import spock.lang.Specification

class DtoArquivoConvenioSpec extends Specification {

    def setup() {
    }

    def cleanup() {
    }


    def "test importa arquivo convenio"() {

        when:
        String jsonConvenio = """[
  {
    "lote": "8541",
    "numeroGuiaPrestador": "173564000000",
    "numeroSolicitacaoInternacao": "201600006696",
    "numeroGuiaOperadora": "201600006696",
    "senha": "201600006696",
    "matricula": "106767054",
    "RN": "N",
    "nome": "ALICE RODRIGUES REGO",
    "dataExecucao": "2016-01-20",
    "horaInicial": "11:40:00",
    "horaFinal": "11:40:00",
    "codigoTabela": "18",
    "codigoProcedimento": "60009900",
    "descricaoProcedimento": "OXIGENIO NO RESPIRADOR/VENTILADOR",
    "quantidadeExecutada": " VAZAO DE 1 LITRO/MIN",
    "valorUnitario": " INSTALACAO / PRIMEIRA HORA",
    "valorApresentado": " NA UTI / SEMI-U",
    "valorPago": "1",
    "valorGlosa": "40",
    "motivoGlosa": "29"
  },
  {
    "lote": "8541",
    "numeroGuiaPrestador": "173564000000",
    "numeroSolicitacaoInternacao": "201600006696",
    "numeroGuiaOperadora": "201600006696",
    "senha": "201600006696",
    "matricula": "106767054",
    "RN": "N",
    "nome": "ALICE RODRIGUES REGO",
    "dataExecucao": "2016-01-20",
    "horaInicial": "11:40:00",
    "horaFinal": "11:40:00",
    "codigoTabela": "18",
    "codigoProcedimento": "60025166",
    "descricaoProcedimento": "ALUGUEL/TAXA DE ASPIRADOR CIRURGICO",
    "quantidadeExecutada": " POR USO",
    "valorUnitario": "1",
    "valorApresentado": "28",
    "valorPago": "6",
    "valorGlosa": "28",
    "motivoGlosa": "6"
  }]"""

        then:
        List<DtoArquivoConvenio> arquivos = Receptor.getJsonConvenio(jsonConvenio)


    }
}
