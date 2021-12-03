package br.com.zgsolucoes.task.scheduler

import grails.compiler.GrailsCompileStatic

import java.time.LocalDateTime

@GrailsCompileStatic
class Execucao {

//    Executavel executavel
    List<ParametroExecucao> parametros
//    List<Evento> eventos
    BigDecimal progresso
    StatusExecucao status
    LocalDateTime data

    static hasMany = [eventos: Evento]
    static belongsTo = [executavel: Executavel]

    static constraints = {
    }
}
