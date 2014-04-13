package employeedelight

import pl.touk.excel.export.WebXlsxExporter

class AdminController {
    static main = true

    def authenticationService

    def index() {
        if (!authenticationService.isLoggedIn(request)) {
            redirect controller: "login"
        } else if (User.findByLogin(authenticationService.getSessionUser()?.login)?.permissions == Permissions.ADMINISTRATOR) {
            def products = Product.getAll()
            def user = User.findByLogin(authenticationService.sessionUser.login)
            return [userInstance: user]
        } else response.sendError(403)

    }

    def download() {
        if (!authenticationService.isLoggedIn(request)) {
            redirect controller: "login"
        } else if (User.findByLogin(authenticationService.getSessionUser()?.login)?.permissions == Permissions.ADMINISTRATOR) {


            try {
                def headers = ['Name', 'Category', 'Acumulated Points', 'Price','Percentage']
                Float totalPoints = 0
                List<ProductDTO> listDto = []
                Product.getAll().sort {
                    -it.acumulatedPoints
                    totalPoints = totalPoints + it.acumulatedPoints
                } each {
                    listDto.add(new ProductDTO(it.name, it.price, it.acumulatedPoints, it.category, (100 / totalPoints * it.acumulatedPoints).trunc(1)))
                }

                def withProperties = ['name', 'category.name', 'acumulatedPoints', 'price', 'percentage']

                new WebXlsxExporter().with {
                    setResponseHeaders(response)
                    fillHeader(headers)
                    add(listDto, withProperties)
                    save(response.outputStream)
                }
            } catch (Exception e) {
                   e.printStackTrace()
            }
        } else response.sendError(403)

    }
}
