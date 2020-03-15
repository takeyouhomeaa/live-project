package domain;

public class Yes {
    private String orderid;
    private String id;
    private String name;
    private Integer num;
    private Integer comfired;

    public String getOrderid() {
        return orderid;
    }

    public void setOrderid(String orderid) {
        this.orderid = orderid;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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

    public Integer getComfired() {
        return comfired;
    }

    public void setComfired(Integer comfired) {
        this.comfired = comfired;
    }

    @Override
    public String toString() {
        return "Yes{" +
                "orderid='" + orderid + '\'' +
                ", id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", num=" + num +
                ", comfired=" + comfired +
                '}';
    }
}
