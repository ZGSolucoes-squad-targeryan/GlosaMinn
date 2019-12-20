package glosaminn

class UrlMappings {

	static mappings = {
		"/$controller/$action?/$id?(.$format)?" {
			constraints {
				// apply constraints here
			}
		}

		"/"(view: "/index")
		"500"(view: '/error')
		"404"(view: '/notFound')

		get "/api/conciliation/showConciliation"(controller: 'conciliationController', action: 'showConciliation', version: '1.0', namespace: 'v1')
	}
}
