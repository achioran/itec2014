package employeedelight

class Product {
    String name
    Integer price
    Integer acumulatedPoints
    static hasOne = [category:Category]
    static constraints = {
        price nullable: false, min: 0
        acumulatedPoints min: 0
        name nullable: false
    }
}
