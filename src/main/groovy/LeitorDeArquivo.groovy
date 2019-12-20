import groovy.transform.CompileStatic

@CompileStatic
class LeitorDeArquivo {

    String returnJsonArquivoPrestador(File file) {

        StringBuilder sb = new StringBuilder()

        sb.append('[')

        String protocolo = file.text.find(/(?<=<numeroLote>)\d+/)
        List<String> guias = file.text.findAll(/(?s)<guiaResumoInternacao>.+?<\/guiaResumoInternacao>/)

        for (String guia in guias) {

            String numeroGuiaPrestador = guia.find(/(?<=<numeroGuiaPrestador>)[^<]+/)
            String numeroGuiaSolicitacaoInternacao = guia.find(/(?<=<numeroGuiaSolicitacaoInternacao>)[^<]+/)
            String numeroGuiaOperadora = guia.find(/(?<=<numeroGuiaOperadora>)[^<]+/)
            String senha = guia.find(/(?<=<senha>)[^<]+/)

            String numeroCarteira = guia.find(/(?<=<numeroCarteira>)[^<]+/)
            String atendimentoRN = guia.find(/(?<=<atendimentoRN>)[^<]+/)
            String nomeBeneficiario = guia.find(/(?<=<nomeBeneficiario>)[^<]+/)

            String valorProcedimentos = guia.find(/(?<=<valorProcedimentos>)[^<]+/)
            String valorDiarias = guia.find(/(?<=<valorProcedimentos>)[^<]+/)
            String valorTaxasAlugueis = guia.find(/(?<=<valorTaxasAlugueis>)[^<]+/)
            String valorMateriais = guia.find(/(?<=<valorMateriais>)[^<]+/)
            String valorMedicamentos = guia.find(/(?<=<valorMedicamentos>)[^<]+/)
            String valorOPME = guia.find(/(?<=<valorOPME>)[^<]+/)
            String valorGasesMedicinais = guia.find(/(?<=<valorGasesMedicinais>)[^<]+/)
            String valorTotalGeral = guia.find(/(?<=<valorTotalGeral>)[^<]+/)

            List<String> produtos = guia.findAll(/(?s)<procedimentoExecutado>.+?<\/procedimentoExecutado>/)

            for (String produto in produtos) {
                String dataExecucao = produto.find(/(?<=<dataExecucao>)[^<]+/)
                String horaInicial = produto.find(/(?<=<horaInicial>)[^<]+/)
                String horaFinal = produto.find(/(?<=<horaFinal>)[^<]+/)
                String codigoTabela = produto.find(/(?<=<codigoTabela>)[^<]+/)
                String codigoProcedimento = produto.find(/(?<=<codigoProcedimento>)[^<]+/)
                String quantidadeExecutada = produto.find(/(?<=<quantidadeExecutada>)[^<]+/)
                String unidadeMedida = produto.find(/(?<=<unidadeMedida>)[^<]+/)
                String reducaoAcrescimo = produto.find(/(?<=<reducaoAcrescimo>)[^<]+/)
                String valorUnitario = produto.find(/(?<=<valorUnitario>)[^<]+/)
                String valorTotal = produto.find(/(?<=<valorTotal>)[^<]+/)
                String descricaoProcedimento = produto.find(/(?<=<descricaoProcedimento>)[^<]+/)

                String json = """
                                {\"lote\":"${protocolo}",
                                \"numeroGuiaPrestador\":"${numeroGuiaPrestador}",
                                \"numeroSolicitacaoInternacao\":"${numeroGuiaSolicitacaoInternacao}",
                                \"numeroGuiaOperadora\":"${numeroGuiaOperadora}",
                                \"senha\":"${senha}",
                                \"matricula\":"${numeroCarteira}",
                                \"RN\":"${atendimentoRN}",
                                \"nome\":"${nomeBeneficiario}",
                                \"dataExecucao\":"${dataExecucao}",
                                \"horaInicial\":"${horaInicial}",
                                \"horaFinal\":"${horaFinal}",
                                \"codigoTabela\":"${codigoTabela}",
                                \"codigoProcedimento\":"${codigoProcedimento}",
                                \"descricaoProcedimento\":"${descricaoProcedimento}",
                                \"quantidadeExecutada\":"${quantidadeExecutada}",
                                \"valorUnitario\":"${valorUnitario}",
                                \"unidadeMedida\":"${unidadeMedida}",
                                \"reducaoAcrescimo\":"${reducaoAcrescimo}",
                                \"valorTotal\":"${valorTotal}",
                                \"valorProcedimentos\":"${valorProcedimentos}",
                                \"valorDiarias\":"${valorDiarias}",
                                \"valorTaxasAlugueis\":"${valorTaxasAlugueis}",
                                \"valorMateriais\":"${valorMateriais}",
                                \"valorMedicamentos\":"${valorMedicamentos}",
                                \"valorOPME\":"${valorOPME}",
                                \"valorGasesMedicinais\":"${valorGasesMedicinais}",
                                \"valorTotalGeral\":"${valorTotalGeral}"
                                },
                                """
                sb.append(json)
            }
        }

        sb.append(']')

        return sb.toString()
    }
}
