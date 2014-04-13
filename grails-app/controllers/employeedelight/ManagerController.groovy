package employeedelight

class ManagerController {

    static main = true
    def authenticationService

    def index() {
        if (!authenticationService.isLoggedIn(request)) {
            redirect controller: "login"
        } else {
            def products = Product.getAll()
            def user = User.findByLogin(authenticationService.sessionUser.login)
            return [productInstanceList: products, productInstanceTotal: products.size(), userInstance: user]
        }
    }
}
