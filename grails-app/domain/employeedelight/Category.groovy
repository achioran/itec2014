package employeedelight

class Category {
    String name
    static  hasMany = [products: Product]
    static belongsTo = Product
    static constraints = {
        name nullable: false
    }
    String toString() { name}
}
