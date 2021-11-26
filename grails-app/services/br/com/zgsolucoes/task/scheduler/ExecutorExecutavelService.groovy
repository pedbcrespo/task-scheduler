package br.com.zgsolucoes.task.scheduler

import br.com.zgsolucoes.task.scheduler.executaveis.ClasseExecutavel
import grails.compiler.GrailsCompileStatic
import grails.gorm.transactions.Transactional


@Transactional
@GrailsCompileStatic
class ExecutorExecutavelService {

    ClasseExecutavelFactoyService classeExecutavelFactoyService

    boolean executar(final String titulo){
        final Executavel executavel =  Executavel.findByTitulo(titulo)
        final ClasseExecutavel classeExecutavel = classeExecutavelFactoyService.procurarClasseExecutavel(executavel)
        classeExecutavel.execute()
    }
}
