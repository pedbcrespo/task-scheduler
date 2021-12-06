package br.com.zgsolucoes.task.scheduler

class ParametroAgendamento {

//    Agendamento agendamento
    Parametro parametro
    String valor

    static belongsTo = [agendamento: Agendamento]

    static constraints = {
    }
}
