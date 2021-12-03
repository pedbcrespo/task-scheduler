package br.com.zgsolucoes.task.scheduler

import br.com.zgsolucoes.task.scheduler.executaveis.ClasseExecutavel
import br.com.zgsolucoes.task.scheduler.executaveis.implementacoes.InformarHorasTelegram
import grails.testing.gorm.DomainUnitTest
import grails.testing.services.ServiceUnitTest
import org.springframework.context.ApplicationContext
import spock.lang.Specification

class ClasseExecutavelFactoryServiceSpec extends Specification implements
        ServiceUnitTest<ClasseExecutavelFactoryService>, DomainUnitTest<Executavel>{

    void "procurarClasseExecutavel retorna instancia de InformarHorasTelegram"(){
        given:
        Executavel executavel = new Executavel(classeExecutavel: classe)
        ApplicationContext applicationContext = Mock(ApplicationContext)
        applicationContext.getBean('InformarHorasTelegram', _) >> {
            new InformarHorasTelegram()
        }
        service.applicationContext = applicationContext
        when:
        ClasseExecutavel classeExecutavel = service.procurarClasseExecutavel(executavel)

        then:
        classeExecutavel.class.simpleName == classe

        where:
        classe                  | _
        'InformarHorasTelegram' | _
    }
}
