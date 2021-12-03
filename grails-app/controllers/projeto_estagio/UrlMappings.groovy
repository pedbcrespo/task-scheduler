package projeto_estagio

class UrlMappings {

    static mappings = {
        "/$controller/$action?/$id?(.$format)?"{
            constraints {
                // apply constraints here
            }
        }

        "/"(view:"/index")
        "500"(view:'/error')
        "404"(view:'/notFound')
        //comentar a logica disso aqui dps
        "/Executavel/list"(controller: "executavel", action: "executar", method:"POST", format:"json")
    }
}
