package br.com.zgsolucoes.task.scheduler.execucao

import br.com.zgsolucoes.task.scheduler.Evento
import br.com.zgsolucoes.task.scheduler.StatusEvento
import groovy.transform.CompileStatic

import javax.inject.Singleton

@Singleton
@CompileStatic
class CriadorEventos {
    Evento criarEvento(String descricao, StatusEvento statusEvento){
        return new Evento(descricao: descricao, status: statusEvento)
    }
}
