package employeedelight

import grails.transaction.Transactional

@Transactional
class LoginService {
    def  authenticationService

    def signup(String firstName,String lastName,String email,String login,String password) {
        User user= new User(firstName: firstName, lastName:lastName,email: email,login:login)
        User u=user.save()
        authenticationService.signup([passwordConfirm:password, email:email, login:login, password:password])

    }
}
