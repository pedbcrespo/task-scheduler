package br.com.zgsolucoes.task.scheduler

import br.com.zgsolucoes.task.scheduler.executaveis.ClasseExecutavel
import grails.compiler.GrailsCompileStatic
import grails.gorm.transactions.Transactional

@Transactional
@GrailsCompileStatic
class ExecutorExecutavelService {

    ClasseExecutavelFactoryService classeExecutavelFactoryService
    ExecucaoFactoryService execucaoFactoryService

    boolean executar(final String titulo){
        final Executavel executavel = Executavel.findByTitulo(titulo)//Ta aqui o problema, ele nao encontra o executavel
        //ps: titulo correto: Enviar ponto para telegram
        final Execucao execucao = execucaoFactoryService.criarExecucao(executavel)// fonte de possiveis erros
        final ClasseExecutavel classeExecutavel = classeExecutavelFactoryService.procurarClasseExecutavel(executavel)
        return classeExecutavel.execute(execucao)
    }
}
