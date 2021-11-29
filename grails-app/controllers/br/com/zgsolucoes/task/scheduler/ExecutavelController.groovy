package br.com.zgsolucoes.task.scheduler

import org.springframework.http.HttpStatus
/**Aqui ficam as operações e validaçoes do programa.
 * Os detalhes sao ajeitados de forma mais generica, isto é, os detalhes de instanciamento, busca em banco de dados
 * inserção... ou seja, atividade mais relacionadas ás regras de negocios sao abstraidas para a pasta service*/
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
