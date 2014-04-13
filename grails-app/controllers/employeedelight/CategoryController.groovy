package employeedelight

class CategoryController {
    static main = true

    def authenticationService
    def scaffold = Category

    def index() {
        if (!authenticationService.isLoggedIn(request)) {
            redirect controller: "login"
        } else if (User.findByLogin(authenticationService.getSessionUser()?.login)?.permissions == Permissions.ADMINISTRATOR) {

            return [categoryInstanceList: Category.list(), categoryInstanceTotal: Category.count()]
        } else
            response.sendError(403)
    }

    def show() {
        if (!authenticationService.isLoggedIn(request)) {
            redirect controller: "login"
        } else if (User.findByLogin(authenticationService.getSessionUser()?.login)?.permissions == Permissions.ADMINISTRATOR) {
            def category = Category.get(params.id)
            return [categoryInstance: category]
        } else
            response.sendError(403)


    }

    def edit() {
        if (!authenticationService.isLoggedIn(request)) {
            redirect controller: "login"
        } else if (User.findByLogin(authenticationService.getSessionUser()?.login)?.permissions == Permissions.ADMINISTRATOR) {
            def category = Category.get(params.id)
            return [categoryInstance: category]
        } else response.sendError(403)

    }

    def list() {
        if (!authenticationService.isLoggedIn(request)) {
            redirect controller: "login"
        } else if (User.findByLogin(authenticationService.getSessionUser()?.login)?.permissions == Permissions.ADMINISTRATOR) {

            [categoryInstanceList: Category.list(), categoryInstanceTotal: Category.count()]
        } else response.sendError(403)
    }
}
