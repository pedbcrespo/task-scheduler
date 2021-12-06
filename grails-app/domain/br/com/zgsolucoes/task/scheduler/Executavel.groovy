package br.com.zgsolucoes.task.scheduler

import grails.compiler.GrailsCompileStatic

@GrailsCompileStatic
class Executavel {
    String titulo
    String classeExecutavel
    List<Parametro> parametros

    static constraints = {
        titulo unique: true
    }
}
