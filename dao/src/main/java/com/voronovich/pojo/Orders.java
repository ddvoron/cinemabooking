package com.voronovich.pojo;

import javax.xml.bind.annotation.*;
import java.util.List;

@XmlRootElement(name = "orders")
@XmlAccessorType(XmlAccessType.FIELD)
public class Orders {

    @XmlElement(name = "order")
    private List<Order> orders = null;

    public Orders() {
    }

    public Orders(List<Order> orders) {
        this.orders = orders;
    }

    public List<Order> getOrders() {
        return orders;
    }

    public void setOrders(List<Order> orders) {
        this.orders = orders;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Orders orders1 = (Orders) o;

        return orders != null ? orders.equals(orders1.orders) : orders1.orders == null;
    }

    @Override
    public int hashCode() {
        return orders != null ? orders.hashCode() : 0;
    }

    @Override
    public String toString() {
        return "Orders{" +
                "orders=" + orders +
                '}';
    }
}
