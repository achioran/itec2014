class UrlMappings {

	static mappings = {
        "/$controller/$action?/$id?"{
            constraints {
                // apply constraints here
            }
        }

        // main and errors
        "/"(controller: 'main')
        "500"(view:'/error')
        "404"(view:'/404')
	}
}
