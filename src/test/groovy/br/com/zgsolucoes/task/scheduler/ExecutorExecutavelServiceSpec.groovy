package br.com.zgsolucoes.task.scheduler

import br.com.zgsolucoes.task.scheduler.executaveis.ClasseExecutavel
import grails.testing.gorm.DomainUnitTest
import grails.testing.services.ServiceUnitTest
import spock.lang.Specification

class ExecutorExecutavelServiceSpec extends
        Specification implements
        ServiceUnitTest<ExecutorExecutavelService>,
        DomainUnitTest<Executavel> {


    void "Executa executavel com sucesso"(){
        given:
        final ClasseExecutavelFactoyService mock = Mock(ClasseExecutavelFactoyService)
        final ClasseExecutavel classeExecutavelMock = Mock(ClasseExecutavel)
        classeExecutavelMock.execute() >> true
        mock.procurarClasseExecutavel(_) >> classeExecutavelMock

        service.classeExecutavelFactoyService = mock

        and:
        final String titulo = 'Informar horas telegram'
        final Executavel executavel = new Executavel(titulo: titulo, classeExecutavel: 'InformarHorasTelegram')
        executavel.save()

        when:
        boolean sucesso = service.executar(titulo)

        then:
        sucesso
    }

    void "Executar executavel sem sucesso"(){
        given:
        final ClasseExecutavelFactoyService mock = Mock(ClasseExecutavelFactoyService)
        final ClasseExecutavel classeExecutavelMock = Mock(ClasseExecutavel)
        classeExecutavelMock.execute() >> false
        mock.procurarClasseExecutavel(_) >> classeExecutavelMock

        service.classeExecutavelFactoyService = mock

        and:
        final String titulo = 'Informar horas telegram'
        final Executavel executavel = new Executavel(titulo: titulo, classeExecutavel: 'InformarHorasTelegram')
        executavel.save()

        when:
        boolean sucesso = service.executar(titulo)

        then:
        !sucesso
    }

    def cleanup(){
    }
}
