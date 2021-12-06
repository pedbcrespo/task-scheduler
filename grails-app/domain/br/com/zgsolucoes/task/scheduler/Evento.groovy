package br.com.zgsolucoes.task.scheduler

import grails.compiler.GrailsCompileStatic

import java.time.LocalDateTime

@GrailsCompileStatic
class Evento {
    String descricao
    StatusEvento status
    LocalDateTime data

    static belongsTo = [execucao: Execucao]
    static constraints = {
    }
}
