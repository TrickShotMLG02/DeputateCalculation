package deputatecalculation

class UrlMappings {

    static mappings = {
        "/$controller/$action?/$id?(.$format)?"{
            constraints {
                // apply constraints here
            }
        }

        //"/"(controller:'login', action:'auth')
        "/"(view: "/index")
        "500"(view:'/error')
        "404"(view:'/notFound')
    }
}
