package br.com.zgsolucoes.task.scheduler.execucao

import br.com.zgsolucoes.task.scheduler.Evento
import br.com.zgsolucoes.task.scheduler.Execucao
import br.com.zgsolucoes.task.scheduler.StatusEvento
import groovy.transform.CompileStatic
import io.micronaut.context.annotation.Prototype

import javax.inject.Inject

@Prototype
@CompileStatic
class RegistradorEventoExecucao {

    @Inject
    CriadorEventos criadorEventos

    void registrarEvento(Execucao execucao, String descricao, StatusEvento statusEvento, BigDecimal progresso=null) {
        final Evento evento = criadorEventos.criarEvento(descricao,statusEvento)
        if(progresso){
            execucao.progresso = progresso
        }

        execucao.addToEventos(evento)
        evento.save()
    }

}
