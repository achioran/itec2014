package employeedelight

class MainController {
    def authenticationService
    def firstUsageService

    def index() {
        firstUsageService.fill()
        if (!authenticationService.isLoggedIn(request)) {
            redirect controller: "login"
        }
        else if (User.findByLogin(authenticationService.getSessionUser()?.login)?.permissions != Permissions.ADMINISTRATOR) {


            redirect controller: "manager"
        }
        else
            redirect controller:  "admin"

    }
}
