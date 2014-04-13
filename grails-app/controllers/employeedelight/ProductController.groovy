package employeedelight

class ProductController {
    static main = true

    def authenticationService
    def scaffold = Product

    def index() {
        if (!authenticationService.isLoggedIn(request)) {
            redirect controller: "login"
        } else if (User.findByLogin(authenticationService.getSessionUser()?.login)?.permissions == Permissions.ADMINISTRATOR) {

            return [productInstanceList: Product.list(), productInstanceTotal: Product.count()]
        } else
            response.sendError(403)
    }

    def show() {
        if (!authenticationService.isLoggedIn(request)) {
            redirect controller: "login"
        } else if (User.findByLogin(authenticationService.getSessionUser()?.login)?.permissions == Permissions.ADMINISTRATOR) {

            def product = Product.get(params.id)
            return [productInstance: product]
        } else response.sendError(403)
    }

    def edit() {
        if (!authenticationService.isLoggedIn(request)) {
            redirect controller: "login"
        } else if (User.findByLogin(authenticationService.getSessionUser()?.login)?.permissions == Permissions.ADMINISTRATOR) {

            def product = Product.get(params.id)
            return [productInstance: product]
        } else response.sendError(403)

    }

    def list() {
        if (!authenticationService.isLoggedIn(request)) {
            redirect controller: "login"
        } else if (User.findByLogin(authenticationService.getSessionUser()?.login)?.permissions == Permissions.ADMINISTRATOR) {

            return [productInstanceList: Product.findAll().collect(), productInstanceTotal: Product.count()]
        } else response.sendError(403)
    }

    def updateScore() {
        if (!authenticationService.isLoggedIn(request)) {
            redirect controller: "login"
        } else {
            println params
            def product = Product.findById(params.productInstance)
            def user = User.findByLogin(authenticationService.getSessionUser()?.login)
            if (Integer.parseInt(params.newValue) < 0) {
                response.sendError(403, "Cannot assign negative points")

            } else if (user.assignedPoints >= Integer.parseInt(params.newValue)) {
                product.setAcumulatedPoints(product.getAcumulatedPoints() + Integer.parseInt(params.newValue))
                product.save()
                user.assignedPoints = user.assignedPoints - Integer.parseInt(params.newValue)
                user.save()
                render template: 'productRow', model: [productInstance: product, userInstance: user]
                return
            } else {
                response.sendError(403, "Insuficient points")
            }
        }
    }


    def listCatedory() {
        if (!authenticationService.isLoggedIn(request)) {
            redirect controller: "login"
        } else {
            def user = User.findByLogin(authenticationService.getSessionUser()?.login)
            def products
            if (params.categoryId != null) {
                def category = Category.findById(params.categoryId)
                products = Product.findAllByCategory(category);
            } else{
                products = Product.getAll().sort{
                    -it.acumulatedPoints
                };
            }
            Float totalPoints=0
            products.each {
                totalPoints= totalPoints+it.acumulatedPoints
            }
            render template: 'listBody', model: [productInstanceList: products, productInstanceTotal: products.size(), userInstance: user, totalPoints: totalPoints]
        }
    }
}
