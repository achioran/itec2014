package employeedelight

class UserGroup {
    String name
    static hasMany = [users: User]
    static belongsTo = User
    static constraints = {
        name nullable: false
    }
    String toString() {name}
}
