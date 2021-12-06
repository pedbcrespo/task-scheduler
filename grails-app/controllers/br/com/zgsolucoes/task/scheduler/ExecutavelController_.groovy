package br.com.zgsolucoes.task.scheduler

import grails.converters.JSON
import grails.validation.ValidationException
import org.springframework.http.HttpStatus

import static org.springframework.http.HttpStatus.*

class ExecutavelController_ {

    ExecutorExecutavelService executorExecutavelService
    ExecutavelCrudService executavelCrudService

    def criaExecutavel(String titulo, String classeExecutave){
        if(!titulo || !classeExecutavel){
            render (status: HttpStatus.INTERNAL_SERVER_ERROR)
            return
        }
        executavelCrudService.criarExecutavel(titulo, classeExecutavel)
    }

    def executar(String titulo){
        if(!titulo || !classeExecutavel) {
            render (status: HttpStatus.INTERNAL_SERVER_ERROR)
            return
        }
        executorExecutavelService.executar(titulo)
        render(titulo as JSON)
    }
}
