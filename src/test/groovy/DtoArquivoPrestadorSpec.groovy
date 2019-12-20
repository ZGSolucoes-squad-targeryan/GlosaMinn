import spock.lang.Specification

class DtoArquivoPrestadorSpec extends Specification {

    def setup() {
    }

    def cleanup() {
    }


    def "test importa arquivo convenio"() {

        when:
        String jsonConvenio = """[ 
   { 
      "lote":"8551",
      "numeroGuiaPrestador":"173763000000",
      "numeroSolicitacaoInternacao":"201600024210",
      "numeroGuiaOperadora":"201600024210",
      "senha":"201600024210",
      "matricula":"100222064",
      "RN":"N",
      "nome":"EVANDRO LUIZ SANTIAGO VIDIGAL",
      "dataExecucao":"2016-01-21",
      "horaInicial":"10:41:00",
      "horaFinal":"10:41:00",
      "codigoTabela":"22",
      "codigoProcedimento":"40805026",
      "descricaoProcedimento":"RX - Torax - 2 incidencias",
      "quantidadeExecutada":"1",
      "valorUnitario":"26.06",
      "unidadeMedida":"null",
      "reducaoAcrescimo":"1.00",
      "valorTotal":"26.06",
      "valorProcedimentos":"201.86",
      "valorDiarias":"201.86",
      "valorTaxasAlugueis":"54.00",
      "valorMateriais":"86.89",
      "valorMedicamentos":"0.41",
      "valorOPME":"0.00",
      "valorGasesMedicinais":"0.00",
      "valorTotalGeral":"567.80"
   },
   { 
      "lote":"8551",
      "numeroGuiaPrestador":"173763000000",
      "numeroSolicitacaoInternacao":"201600024210",
      "numeroGuiaOperadora":"201600024210",
      "senha":"201600024210",
      "matricula":"100222064",
      "RN":"N",
      "nome":"EVANDRO LUIZ SANTIAGO VIDIGAL",
      "dataExecucao":"2016-01-21",
      "horaInicial":"16:01:00",
      "horaFinal":"16:01:00",
      "codigoTabela":"22",
      "codigoProcedimento":"10102019",
      "descricaoProcedimento":"Visita hospitalar (paciente internado)",
      "quantidadeExecutada":"1",
      "valorUnitario":"100.80",
      "unidadeMedida":"null",
      "reducaoAcrescimo":"1.00",
      "valorTotal":"100.80",
      "valorProcedimentos":"201.86",
      "valorDiarias":"201.86",
      "valorTaxasAlugueis":"54.00",
      "valorMateriais":"86.89",
      "valorMedicamentos":"0.41",
      "valorOPME":"0.00",
      "valorGasesMedicinais":"0.00",
      "valorTotalGeral":"567.80"
   }]"""

        then:
        List<DtoArquivoConvenio> arquivos = Receptor.getJsonHospital(jsonConvenio)


    }
}
