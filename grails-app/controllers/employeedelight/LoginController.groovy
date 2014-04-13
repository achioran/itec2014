package employeedelight

class LoginController {

    def authenticationService
    def loginService

    def index() {
        if (authenticationService.isLoggedIn(request)) {
            if (User.findByLogin(authenticationService.getSessionUser().login)?.permissions!=Permissions.ADMINISTRATOR ){
                redirect controller: "manager"
            }
            else{

                redirect controller:  "admin"
            }
        }
    }

    def login = {
       def user= authenticationService.login(params.getProperty("username"), params.getProperty("password"))
        redirect view: "index"
    }

    //TODO
    def signup = {
        loginService.signup(params.firstName,params.lastName, params.email, params.login, params.password)
        authenticationService.signup([passwordConfirm:params.passwordConfirm, email:params.email, login:params.login, password:params.password])
        redirect view: "index"
    }

    def logout(){
        if (authenticationService.isLoggedIn(request)) {
            authenticationService.logout(authenticationService.getSessionUser())
        }
        redirect view: "index"
    }
}
