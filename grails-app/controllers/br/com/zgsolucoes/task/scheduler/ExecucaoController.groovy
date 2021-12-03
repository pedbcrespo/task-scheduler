package br.com.zgsolucoes.task.scheduler

import grails.compiler.GrailsCompileStatic
import grails.validation.ValidationException

import static org.springframework.http.HttpStatus.*

@GrailsCompileStatic
class ExecucaoController {
    //Caso de erro, apague essa classe e reveja as video-aulas

    ExecucaoService execucaoService
    ExecucaoFactoryService execucaoFactoryService
    ExecutorExecutavelService executorExecutavelService

    def show(Long id) {
        respond execucaoService.get(id)
    }

    def list(final Integer max){
        params.max = Math.min(max ?: 10, 100)
        respond execucaoService.list(params)
    }

    def adicionar(final Executavel executavel){
        if(executavel == null){
            respond([status: NOT_FOUND])
            return
        }
        try{
            final Execucao execucao = execucaoFactoryService.criarExecucao(executavel)
            execucaoService.save(execucao)
        }
        catch (ValidationException e){
               respond([status: INTERNAL_SERVER_ERROR])
            return
        }

        respond([status: OK])
    }

    def parar(final Execucao execucao){
        if(execucao == null){
            respond([status: NOT_FOUND])
        }
        try{
            execucao.status = StatusExecucao.CONCLUIDO
            execucao.progresso = 100.0
            execucaoService.save(execucao)
        }
        catch (ValidationException e){
            respond([status: INTERNAL_SERVER_ERROR])
            return
        }
        respond([status: OK])
    }

    def reexecutar(final Execucao execucao){
        if(execucao == null){
            respond([status: NOT_FOUND])
        }
        try{
//            executorExecutavelService.executar()
        }
        catch (ValidationException e){
            respond([status: INTERNAL_SERVER_ERROR])
            return
        }
        respond([status: OK])
    }
}
