package employeedelight

import grails.transaction.Transactional

@Transactional
class FirstUsageService {
    def loginService

    def fill() {
        if (User.list().size() < 2) {
            UserGroup userGroup1 = new UserGroup(name: "Facebook")
            userGroup1.save()
            UserGroup userGroup2 = new UserGroup(name: "Google")
            userGroup2.save()




            loginService.signup("Chioran", "Adrian", "ady_92c@yahoo.com", "adrianChioran", "password")
            User user1 = User.findByLogin("adrianChioran")
            user1.permissions = Permissions.ADMINISTRATOR
            user1.userGroup = userGroup1
            user1.save()


            loginService.signup("Chioran", "Bogdan", "bobo_chio@yahoo.com", "boby_non", "password")
            User user2 = User.findByLogin("boby_non")
            user2.userGroup = userGroup2
            user2.save()


            loginService.signup("Toth", "Laura", "totlaura@yahoo.com", "laurica", "password")
            User user3 = User.findByLogin("laurica")
            user3.userGroup = userGroup2
            user3.save()

            loginService.signup("Mihnea", "George", "mihnea@yahoo.com", "mihnea", "password")

            Category category1 = new Category(name: "fruits");
            category1.save()
            Category category2 = new Category(name: "vegetables");
            category2.save()

            Product product1 = new Product(name: "Banana", price: 1,acumulatedPoints: 0, category: category1)
            product1.save()

            Product product2 = new Product(name: "Orange", price: 3,acumulatedPoints: 0, category: category1)
            product2.save()

            Product product3 = new Product(name: "Potato", price: 2,acumulatedPoints: 0, category: category2)
            product3.save()

            Product product4 = new Product(name: "Apple", price: 1,acumulatedPoints: 0, category: category1)
            product4.save()
        }
    }
}
