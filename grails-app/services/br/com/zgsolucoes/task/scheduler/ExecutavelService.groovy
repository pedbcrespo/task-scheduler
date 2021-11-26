package br.com.zgsolucoes.task.scheduler

import grails.gorm.transactions.Transactional

@Transactional
interface ExecutavelService {
    Executavel get(Serializable id)

    List<Executavel> list(Map args)

    Long count()

    void delete(Serializable id)

    Executavel save(Executavel executavel)
}
