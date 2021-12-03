package br.com.zgsolucoes.task.scheduler

import br.com.zgsolucoes.task.scheduler.executaveis.ClasseExecutavel
import grails.gorm.transactions.Transactional
import groovy.transform.CompileStatic
import io.micronaut.context.ApplicationContext
import io.micronaut.context.Qualifier


/**Classe responsabel por procurar a classe que implelemnta a açao da tarefa escolhida*/
@Transactional
@CompileStatic
class ClasseExecutavelFactoyService {

    ApplicationContext applicationContext

    ClasseExecutavel procurarClasseExecutavel(final Executavel executavel){
        final Class clss = Class.forName("br.com.zgsolucoes.task.scheduler.executaveis.implementacoes.${ executavel.classeExecutavel }")
        //Ficar de olho na linha abaixo
        final ClasseExecutavel classeExecutavel = (ClasseExecutavel) applicationContext.getBean(executavel.classeExecutavel as Class<Object>, clss as Qualifier<Object>)
        return classeExecutavel
    }
}
