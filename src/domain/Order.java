package domain;

public class Order {
    private String name;
    private Integer num;
    private String id;
    private String phone;
    private String orderid;

    public Order() {
    }

    public Order(String name, Integer num, String id, String phone, String orderid) {
        this.name = name;
        this.num = num;
        this.id = id;
        this.phone = phone;
        this.orderid = orderid;
    }

    public String getOrderid() {
        return orderid;
    }

    public void setOrderid(String orderid) {
        this.orderid = orderid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getNum() {
        return num;
    }

    public void setNum(Integer num) {
        this.num = num;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    @Override
    public String toString() {
        return "Order{" +
                "name='" + name + '\'' +
                ", num=" + num +
                ", id='" + id + '\'' +
                ", phone=" + phone +
                '}';
    }
}
