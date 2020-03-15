package domain;

public class Order {
    private String name;
    private Integer num;
    private String id;
    private String phone;
    private String orderid;
    
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
    
    public String getOrderid() {
		return orderid;
	}
    public void setOrderid(String orderid){
    	this.orderid=orderid;
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
