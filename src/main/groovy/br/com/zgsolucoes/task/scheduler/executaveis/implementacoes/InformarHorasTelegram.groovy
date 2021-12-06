package br.com.zgsolucoes.task.scheduler.executaveis.implementacoes

import br.com.zgsolucoes.task.scheduler.Evento
import br.com.zgsolucoes.task.scheduler.Execucao
import br.com.zgsolucoes.task.scheduler.StatusEvento
import br.com.zgsolucoes.task.scheduler.StatusExecucao
import br.com.zgsolucoes.task.scheduler.execucao.CriadorEventos
import br.com.zgsolucoes.task.scheduler.execucao.RegistradorEventoExecucao
import br.com.zgsolucoes.task.scheduler.executaveis.ClasseExecutavel
import br.com.zgsolucoes.task.scheduler.executaveis.ObterDadosDoPonto
import groovy.transform.CompileStatic
import groovyx.net.http.HttpBuilder
import groovyx.net.http.UriBuilder
import org.springframework.beans.factory.annotation.Autowired

import javax.inject.Inject
import javax.transaction.Status
import javax.xml.bind.ValidationException

@CompileStatic
class InformarHorasTelegram implements ClasseExecutavel{
    @Inject
    RegistradorEventoExecucao registradorEventoExecucao

    @Inject
    ObterDadosDoPonto obterDadosDoPonto

    @Override
    boolean execute(Execucao execucao) {
        registradorEventoExecucao.registrarEvento(execucao, 'Iniciando execucao', StatusEvento.SUCESSO, 1.0)

        final String TELEGRAM_BOT_ID = '5007214545'
        final String TELEGRAM_BOT_KEY = 'AAGDAsjG8-3YEBQhK4hHTSjoY14WIHhuwDM'
        final String TELEGRAM_CHAT_ID = '-665275070'

        registradorEventoExecucao.registrarEvento(execucao, 'Obtendo dados do ponto', StatusEvento.SUCESSO, 25.0)

        if (registradorEventoExecucao == null) {
            final ObterDadosDoPonto obtemDados = new ObterDadosDoPonto()
            obterDadosDoPonto = obtemDados
        }
        final String encodedMessage = obterDadosDoPonto.obterDadosPonto()

        registradorEventoExecucao.registrarEvento(execucao, 'Enviando mensagem para o telegram', StatusEvento.SUCESSO, 70.0)

        //nada de / no final do basePath
        final String basePath = 'https://api.telegram.org'
        final String uriPath = "/bot${TELEGRAM_BOT_ID}:${TELEGRAM_BOT_KEY}/sendMessage"

        final HttpBuilder httpBin = HttpBuilder.configure {
            request.uri = basePath
        }

        final Map<String, ?> params = [
                chat_id: "${TELEGRAM_CHAT_ID}".toString(),
                text   : encodedMessage,
        ]

        final Map result = httpBin.get {
            final UriBuilder uriBuilder = request.uri
            uriBuilder.path = uriPath
            uriBuilder.query = params
        } as Map
        registradorEventoExecucao.registrarEvento(execucao, 'Execucao finalizada', StatusEvento.SUCESSO, 100.0)

        return result.ok
    }

}
