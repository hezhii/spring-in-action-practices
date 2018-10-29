package orders;

/**
 * 没有必要为 Item 添加 @Document 注解，也没有必要为它的域指定 @Id。
 * 因为不会单独将 Item 持久化为文档，它始终会是 Order 文档中 Item 列表的一个成员，并且会作为文件中的嵌入元素。
 * <p>
 * 如果想指定 Item 中的某个域如何持久化到文档中，可以为对应的 Item 属性添加 @Field 注解。
 */
public class Item {

    private Long id;

    private Order order;

    private String product;

    private double price;

    private int quantity;

    public Order getOrder() {
        return order;
    }

    public String getProduct() {
        return product;
    }

    public void setProduct(String product) {
        this.product = product;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public Long getId() {
        return id;
    }

}
