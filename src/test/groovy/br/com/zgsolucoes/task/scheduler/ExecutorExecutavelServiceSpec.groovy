package br.com.zgsolucoes.task.scheduler

import br.com.zgsolucoes.task.scheduler.executaveis.ClasseExecutavel
import grails.testing.gorm.DomainUnitTest
import grails.testing.services.ServiceUnitTest
import spock.lang.Specification

class ExecutorExecutavelServiceSpec extends Specification implements ServiceUnitTest<ExecutorExecutavelService>,
        DomainUnitTest<Executavel>{

//        void "Testa executavel com sucesso"(){
//            given:
//
//            ClasseExecutavelFactoryService mock = Mock(ClasseExecutavelFactoryService)
//            ClasseExecutavel classeExecutavelMock = Mock(ClasseExecutavel)
//            classeExecutavelMock.execute() >> true
//
//            mock.procurarClasseExecutavel(_) >> classeExecutavelMock
//            service.classeExecutavelFactoryService = mock
//
//            and:
//            String titulo = 'Informar horas Telegram'
//            Executavel executavel = new Executavel(titulo: titulo, classeExecutavel: 'br.com.zgsolucoes.task.scheduler.executaveis.implementacoes.InformarHorasTelegram')
//            executavel.save()
//
//            when:
//            boolean sucesso = service.executar(titulo)
//
//            then:
//            sucesso
//
//        }
//
//        void "Testa executavel com falha"(){
//            given:
//            ClasseExecutavelFactoryService mock = Mock(ClasseExecutavelFactoryService)
//            ClasseExecutavel classeExecutavelMock = Mock(ClasseExecutavel)
//            classeExecutavelMock.execute(null) >> false
//            mock.procurarClasseExecutavel(_) >> classeExecutavelMock
//            service.classeExecutavelFactoryService = mock
//
//            and:
//            String titulo = 'Informar horas Telegram'
//            Executavel executavel = new Executavel(titulo: titulo, classeExecutavel: 'br.com.zgsolucoes.task.scheduler.executaveis.implementacoes.InformarHorasTelegram')
//            executavel.save()
//
//            when:
//            boolean sucesso = service.executar(titulo)
//
//            then:
//            !sucesso
//
//        }

    /**Tenho que descobrir por que nao esta bscando a classeExecutavel pelo titulo*/
    def "tentar executar uma execucao"() {
        given:
        final String titulo = 'Enviar ponto para telegram'
        final Executavel executavel = new Executavel(titulo: titulo, classeExecutavel: 'InformarHorasTelegram')
        executavel.save()

        and:
        final Execucao execucao = new Execucao()

        final ExecucaoFactoryService mockExecucaoFactory = Mock(ExecucaoFactoryService)
        mockExecucaoFactory.criarExecucao(executavel) >> { execucao }

        final ClasseExecutavelFactoryService mock = Mock(ClasseExecutavelFactoryService)

        final ClasseExecutavel classeExecutavelMock = Mock(ClasseExecutavel)
        classeExecutavelMock.execute(execucao) >> true
        mock.procurarClasseExecutavel(executavel) >> classeExecutavelMock
        service.classeExecutavelFactoryService = mock
        service.execucaoFactoryService = mockExecucaoFactory

        when:
        //o problema esta dentro do metodo executar()
        boolean sucesso = service.executar(titulo)

        then:
        sucesso
    }
    def "tentar executar uma execucao falhando"() {
        given:
        final String titulo = 'Enviar ponto para telegram'
        final Executavel executavel = new Executavel(titulo: titulo, classeExecutavel: 'InformarHorasTelegram')
        executavel.save()

        and:
        final Execucao execucao = new Execucao()

        final ExecucaoFactoryService mockExecucaoFactory = Mock(ExecucaoFactoryService)
        mockExecucaoFactory.criarExecucao(executavel) >> { execucao }

        final ClasseExecutavelFactoryService mock = Mock(ClasseExecutavelFactoryService)

        final ClasseExecutavel classeExecutavelMock = Mock(ClasseExecutavel)
        classeExecutavelMock.execute(execucao) >> false
        mock.procurarClasseExecutavel(executavel) >> classeExecutavelMock
        service.classeExecutavelFactoryService = mock
        service.execucaoFactoryService = mockExecucaoFactory

        when:
        boolean sucesso = service.executar(titulo)

        then:
        !sucesso
    }
        def cleanup(){}
}
