package br.com.zgsolucoes.task.scheduler.executaveis

import spock.lang.Specification

class ObterDadosDoPontoSpec extends Specification{
    def "Obter dados ponto"(){
        given:
        ObterDadosDoPonto dadosDoPonto = new ObterDadosDoPonto()

        when:
        final String dadosPonto = dadosDoPonto.obterDadosPonto()

        then:
        dadosPonto != ''
    }
}
