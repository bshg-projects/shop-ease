package org.bshg.shopease.entity.core.user;
import org.bshg.shopease.zutils.entity.audit.AuditEntity;
import org.bshg.shopease.entity.enums.OrderStatusEnum;
import jakarta.persistence.*;
import java.time.*;
import java.util.*;
@Entity
@Table(name="order")
@SequenceGenerator(name = "order_seq", sequenceName = "order_seq", allocationSize = 1)
public class Order extends AuditEntity {
@Id
@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "order_seq")
private Long id;
private float totalAmount;
@Enumerated(EnumType.STRING)
private OrderStatusEnum status;
private LocalDateTime orderDate;
@OneToMany(mappedBy = "order")
private List<OrderItem> orderItem;
@ManyToOne(fetch = FetchType.LAZY)
private User user;
public Order() {
super();
}
@Override
public Long getId() {
return id;
}
@Override
public void setId(Long id) {
this.id = id;
}
public float getTotalAmount() {
return totalAmount;
}
public void setTotalAmount(float value) {
this.totalAmount = value;
}
public OrderStatusEnum getStatus() {
return status;
}
public void setStatus(OrderStatusEnum value) {
this.status = value;
}
public LocalDateTime getOrderDate() {
return orderDate;
}
public void setOrderDate(LocalDateTime value) {
this.orderDate = value;
}
public List<OrderItem> getOrderItem() {
return orderItem;
}
public void setOrderItem(List<OrderItem> value) {
this.orderItem = value;
}
public User getUser() {
return user;
}
public void setUser(User value) {
this.user = value;
}
@Override
public boolean equals(Object object) {
return super.equals(object);
}
@Override
public int hashCode() {
return super.hashCode();
}
}