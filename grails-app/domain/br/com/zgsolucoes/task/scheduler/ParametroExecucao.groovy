package br.com.zgsolucoes.task.scheduler

import grails.compiler.GrailsCompileStatic

@GrailsCompileStatic
class ParametroExecucao {

//    Execucao execucao //se der problema, comente
    Parametro parametro
    String valor

    static belongsTo = [execucao: Execucao]

    static constraints = {
    }
}
