package br.com.zgsolucoes.task.scheduler

import br.com.zgsolucoes.task.scheduler.executaveis.ClasseExecutavel
import grails.testing.gorm.DomainUnitTest
import grails.testing.services.ServiceUnitTest
import spock.lang.Specification

class ExecutorExecutavelServiceSpec extends Specification implements ServiceUnitTest<ExecutorExecutavelService>,
        DomainUnitTest<Executavel>{

        void "Testa executavel com sucesso"(){
            given:
            ClasseExecutavelFactoryService mock = Mock(ClasseExecutavelFactoryService)
            ClasseExecutavel classeExecutavelMock = Mock(ClasseExecutavel)
            classeExecutavelMock.execute() >> true
            mock.procurarClasseExecutavel(_) >> classeExecutavelMock
            service.classeExecutavelFactoryService = mock

            and:
            String titulo = 'Informar horas Telegram'
            Executavel executavel = new Executavel(titulo: titulo, classeExecutavel: 'br.com.zgsolucoes.task.scheduler.executaveis.implementacoes.InformarHorasTelegram')
            executavel.save()

            when:
            boolean sucesso = service.executar(titulo)

            then:
            sucesso

        }

        void "Testa executavel com falha"(){
            given:
            ClasseExecutavelFactoryService mock = Mock(ClasseExecutavelFactoryService)
            ClasseExecutavel classeExecutavelMock = Mock(ClasseExecutavel)
            classeExecutavelMock.execute() >> false
            mock.procurarClasseExecutavel(_) >> classeExecutavelMock
            service.classeExecutavelFactoryService = mock

            and:
            String titulo = 'Informar horas Telegram'
            Executavel executavel = new Executavel(titulo: titulo, classeExecutavel: 'br.com.zgsolucoes.task.scheduler.executaveis.implementacoes.InformarHorasTelegram')
            executavel.save()

            when:
            boolean sucesso = service.executar(titulo)

            then:
            !sucesso

        }

        def cleanup(){}
}
