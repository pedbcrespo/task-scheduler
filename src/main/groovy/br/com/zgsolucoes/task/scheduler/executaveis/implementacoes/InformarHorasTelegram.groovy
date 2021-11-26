package br.com.zgsolucoes.task.scheduler.executaveis.implementacoes

import br.com.zgsolucoes.task.scheduler.executaveis.ClasseExecutavel
import groovyx.net.http.HttpBuilder

class InformarHorasTelegram implements ClasseExecutavel {
    void buscarHorasNoPontoEnviadoParaTelegram() {

    }

    @Override
    boolean execute() {
        Map env = System.getenv()
        final String TELEGRAM_BOT_ID = ['TELEGRAM_BOT_ID']
        final String TELEGRAM_BOT_KEY = ['TELEGRAM_BOT_KEY']
        final String TELEGRAM_CHAT_ID = env['TELEGRAM_CHAT_ID']

        final String encodedMessage
        final String basePath = 'https://api.telegram.org/'
        final String urlPath = "/${TELEGRAM_BOT_ID}:${TELEGRAM_BOT_KEY}/sendMessage"

        final HttpBuilder httpBin = HttpBuilder.configure {
            request.uri = basePath
        }

        def result = httpBin.get {
            request.uri.path = urlPath
        }
        return false
    }
}
