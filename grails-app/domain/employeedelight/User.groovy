package employeedelight

class User{
    String email
    String login
    String firstName
    String lastName
    Permissions permissions= Permissions.USER
    Integer assignedPoints =0
    static hasOne = [userGroup: UserGroup]
    static mapping = {
        permissions enumType: 'ordinal'
    }
    static constraints = {
        firstName nullable: false
        lastName nullable: false
        login nullable: false
        userGroup nullable: true
        assignedPoints min: 0
    }
}