package br.com.zgsolucoes.task.scheduler

import org.springframework.http.HttpStatus

class ExecutavelController {

    ExecutavelCrudService executavelCrudService

    ExecutorExecutavelService executorExecutavelService

    def criarExecutavel(String titulo, String classeExecutavel) {
        if (!titulo || !classeExecutavel) {
            render (status: HttpStatus.INTERNAL_SERVER_ERROR)
            return
        }

        executavelCrudService.criarExecutavel(titulo, classeExecutavel)
    }

    def executar(final String titulo) {
        if (!titulo || !classeExecutavel) {
            render (status: HttpStatus.INTERNAL_SERVER_ERROR)
            return
        }

        executorExecutavelService.executar(titulo)
    }
}
