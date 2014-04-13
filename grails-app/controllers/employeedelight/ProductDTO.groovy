package employeedelight

/**
 * Created with IntelliJ IDEA.
 * User: A.Chioran
 * Date: 13.04.2014
 * Time: 03:01
 * To change this template use File | Settings | File Templates.
 */
class ProductDTO {
    String name
    Integer price
    Integer acumulatedPoints
    Category category
    Double percentage

    ProductDTO(String name, Integer price, Integer acumulatedPoints, Category category, Double percentage) {
        this.name = name
        this.price = price
        this.acumulatedPoints = acumulatedPoints
        this.category = category
        this.percentage = percentage
    }
}
