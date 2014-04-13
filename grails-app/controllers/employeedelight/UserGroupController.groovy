package employeedelight

class UserGroupController {
    static main = true

    def authenticationService
    static navigation = true

    def scaffold = UserGroup

    def index() {
        if (!authenticationService.isLoggedIn(request)) {
            redirect controller: "login"
        } else if (User.findByLogin(authenticationService.getSessionUser()?.login)?.permissions == Permissions.ADMINISTRATOR) {

            return [userGroupInstanceList: UserGroup.list(), userGroupInstanceTotal: UserGroup.count()]
        } else response.sendError(403)
    }

    def show() {
        if (!authenticationService.isLoggedIn(request)) {
            redirect controller: "login"
        } else if (User.findByLogin(authenticationService.getSessionUser()?.login)?.permissions == Permissions.ADMINISTRATOR) {

            def userGroup = UserGroup.get(params.id)
            return [userGroupInstance: userGroup]
        } else response.sendError(403)
    }

    def edit() {
        if (!authenticationService.isLoggedIn(request)) {
            redirect controller: "login"
        } else if (User.findByLogin(authenticationService.getSessionUser()?.login)?.permissions == Permissions.ADMINISTRATOR) {

            def userGroup = UserGroup.get(params.id)
            return [userGroupInstance: userGroup]
        } else response.sendError(403)
    }

    def list() {
        if (!authenticationService.isLoggedIn(request)) {
            redirect controller: "login"
        } else if (User.findByLogin(authenticationService.getSessionUser()?.login)?.permissions == Permissions.ADMINISTRATOR) {

            return [userGroupInstanceList: UserGroup.list(), userGroupInstanceTotal: UserGroup.count()]
        } else response.sendError(403)
    }

    def distributePoints() {
        if (!authenticationService.isLoggedIn(request)) {
            redirect controller: "login"
        } else if (User.findByLogin(authenticationService.getSessionUser()?.login)?.permissions == Permissions.ADMINISTRATOR) {
            def userGroup = UserGroup.findById(params.userGroupInstance)
            def users = User.findAllByUserGroup(params.userGroup)

            if (Integer.parseInt(params.newValue) < 0) {
                response.sendError(403, "Cannot assign negative points")

            } else {
                users.each {
                    it.assignedPoints = Integer.parseInt(params.newValue)
                }
                render template: '/user/userRow', model: [userGroupInstance: userGroup]
            }
        } else response.sendError(403)

    }

    def getGroups() {
        if (!authenticationService.isLoggedIn(request)) {
            redirect controller: "login"
        } else if (User.findByLogin(authenticationService.getSessionUser()?.login)?.permissions == Permissions.ADMINISTRATOR) {
            def userGroup = UserGroup.findAll()
            render template: "listBody", model: [userGroupInstanceList: userGroup, userGroupInstanceTotal: userGroup.size()]
        } else response.sendError(403)
    }
}
