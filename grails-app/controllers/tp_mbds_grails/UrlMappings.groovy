package tp_mbds_grails

class UrlMappings {

    static mappings = {
        "/$controller/$action?/$id?(.$format)?"{
            constraints {
                // apply constraints here
            }
        }

        "/"(view:"/index")
        "/index"(view:"/index")
        "/POI/index" (controller:"POI", action:"list" )
        "/POIsGroup/index" (controller:"POIsGroup", action:"list" )
        "500"(view:'/error')
        "404"(view:'/notFound')
    }
}
