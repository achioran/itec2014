import grails.plugins.dto.DTO

/**
 * Created with IntelliJ IDEA.
 * User: A.Chioran
 * Date: 12.04.2014
 * Time: 00:57
 * To change this template use File | Settings | File Templates.
 */
class ProductDTO implements DTO {
    private static final long serialVersionUID = 1L;
    String name
    private Integer price
    private Integer acumulatedPoints
    private Category category

    String getName() {
        return name
    }

    void setName(String name) {
        this.name = name
    }

    Integer getPrice() {
        return price
    }

    void setPrice(Integer price) {
        this.price = price
    }

    Category getCategory() {
        return category
    }

    void setCategory(Category category) {
        this.category = category
    }

    Integer getAcumulatedPoints() {
        return acumulatedPoints
    }

    void setAcumulatedPoints(Integer acumulatedPoints) {
        this.acumulatedPoints = acumulatedPoints
    }
}
