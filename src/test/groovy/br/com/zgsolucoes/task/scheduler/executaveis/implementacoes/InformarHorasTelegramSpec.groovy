package br.com.zgsolucoes.task.scheduler.executaveis.implementacoes

import br.com.zgsolucoes.task.scheduler.executaveis.ObterDadosDoPonto
import spock.lang.Specification

class InformarHorasTelegramSpec extends Specification{
    //Em caso de erro, descomentar o codigo abaixo e apagar o que foi feito
    def "enviar ponto telegram"(){
        given:
        ObterDadosDoPonto obterDadosDoPontoMock = Mock(ObterDadosDoPonto)
        obterDadosDoPontoMock.obterDadosPonto() >> "teste"
        InformarHorasTelegram informarHorasTelegram = new InformarHorasTelegram()
        when:
        boolean result = informarHorasTelegram.execute(null)

        then:
        result
    }


}
