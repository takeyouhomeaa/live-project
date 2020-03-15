package domain;

public class Order {
    private String name;
    private Integer num;
    private String id;
    private Integer phone;

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

    public Integer getPhone() {
        return phone;
    }

    public void setPhone(Integer phone) {
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
