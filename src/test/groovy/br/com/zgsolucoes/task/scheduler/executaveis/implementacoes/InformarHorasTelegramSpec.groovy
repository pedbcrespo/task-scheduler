package br.com.zgsolucoes.task.scheduler.executaveis.implementacoes

import br.com.zgsolucoes.task.scheduler.Execucao
import br.com.zgsolucoes.task.scheduler.execucao.CriadorEventos
import br.com.zgsolucoes.task.scheduler.execucao.RegistradorEventoExecucao
import br.com.zgsolucoes.task.scheduler.executaveis.ObterDadosDoPonto
import spock.lang.Specification

class InformarHorasTelegramSpec extends Specification{
    def "enviar ponto telegram"(){

        given:
        InformarHorasTelegram informarHorasTelegram = new InformarHorasTelegram()

        and:
        Execucao execucao = Mock(Execucao)
        RegistradorEventoExecucao registradorEventoExecucao = Mock(RegistradorEventoExecucao)
        ObterDadosDoPonto obterDadosDoPonto = Mock(ObterDadosDoPonto)
        obterDadosDoPonto.obterDadosPonto() >> "Testando"
        informarHorasTelegram.obterDadosDoPonto = obterDadosDoPonto
        informarHorasTelegram.registradorEventoExecucao = registradorEventoExecucao

        when:
        boolean result = informarHorasTelegram.execute(execucao)

        then:
        result
    }


}
