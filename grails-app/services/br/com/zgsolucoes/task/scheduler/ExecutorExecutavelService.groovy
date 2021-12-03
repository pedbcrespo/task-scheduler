package br.com.zgsolucoes.task.scheduler

import br.com.zgsolucoes.task.scheduler.executaveis.ClasseExecutavel
import grails.compiler.GrailsCompileStatic
import grails.gorm.transactions.Transactional

@Transactional
@GrailsCompileStatic
class ExecutorExecutavelService {

    ClasseExecutavelFactoryService classeExecutavelFactoryService
//    ExecucaoFactoryService execucaoFactoryService

    boolean executar(String titulo){
        Executavel executavel = Executavel.findByTitulo(titulo)
//        Execucao execucao = execucaoFactoryService.criarExecucao(executavel)
        ClasseExecutavel classeExecutavel = classeExecutavelFactoryService.procurarClasseExecutavel(executavel)
        return classeExecutavel.execute()
    }
}
