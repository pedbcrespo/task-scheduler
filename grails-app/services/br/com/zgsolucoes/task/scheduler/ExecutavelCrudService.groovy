package br.com.zgsolucoes.task.scheduler

import br.com.zgsolucoes.task.scheduler.Executavel
import grails.gorm.transactions.Transactional
import groovy.transform.CompileStatic

/**Essa classe fica responsavel por criar um executavel*/

@Transactional
@CompileStatic
class ExecutavelCrudService {

    void criarExecutavel(final String titulo, final String classeExecutavel) {
        final Executavel executavel = new Executavel(titulo: titulo, classeExecutavel: classeExecutavel)
        executavel.save()
    }
}
