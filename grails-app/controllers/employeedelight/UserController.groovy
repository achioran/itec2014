package employeedelight

class UserController {

    def authenticationService
    static main = true
    def scaffold = User

    def index() {
        if (!authenticationService.isLoggedIn(request)) {
            redirect controller: "login"
        } else if (User.findByLogin(authenticationService.getSessionUser()?.login)?.permissions == Permissions.ADMINISTRATOR) {

            return [userInstanceList: User.list(), userInstanceTotal: User.count()]
        } else response.sendError(403)
    }

    def show() {
        if (!authenticationService.isLoggedIn(request)) {
            redirect controller: "login"
        } else if (User.findByLogin(authenticationService.getSessionUser()?.login)?.permissions == Permissions.ADMINISTRATOR) {

            def user = User.get(params.id)
            return [userInstance: user]
        } else response.sendError(403)

    }

    def edit() {
        if (!authenticationService.isLoggedIn(request)) {
            redirect controller: "login"
        } else if (User.findByLogin(authenticationService.getSessionUser()?.login)?.permissions == Permissions.ADMINISTRATOR) {

            def user = User.get(params.id)
            return [userInstance: user]
        } else response.sendError(403)
    }

    def list() {
        if (!authenticationService.isLoggedIn(request)) {
            redirect controller: "login"
        } else if (User.findByLogin(authenticationService.getSessionUser()?.login)?.permissions == Permissions.ADMINISTRATOR) {

            return [userInstanceList: User.list(), userInstanceTotal: User.count()]
        } else response.sendError(403)
    }

    def getPoints(){
        if (!authenticationService.isLoggedIn(request)) {
            redirect controller: "login"
        } else{
            def user=User.findByLogin(authenticationService.getSessionUser()?.login)
            render "<b>AvailablePoints:</b>"+user.getAssignedPoints()
        }
    }
}
