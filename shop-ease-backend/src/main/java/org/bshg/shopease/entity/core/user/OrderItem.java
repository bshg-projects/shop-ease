package org.bshg.shopease.entity.core.user;
import org.bshg.shopease.zutils.entity.audit.AuditEntity;
import org.bshg.shopease.entity.core.product.Product;
import jakarta.persistence.*;
import java.time.*;
import java.util.*;
/**
* This Class is for Association between 'Order' and 'Product'
* It extends AuditEntity to inherit auditing features.
*/
@Entity
@Table(name="orderitem")
@SequenceGenerator(name = "orderitem_seq", sequenceName = "orderitem_seq", allocationSize = 1)
public class OrderItem extends AuditEntity {
@Id
@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "orderitem_seq")
private Long id;
private int quantity;
private float unitPrice;
@ManyToOne(fetch = FetchType.LAZY)
private Order order;
@ManyToOne(fetch = FetchType.LAZY)
private Product product;
public OrderItem() {
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
public int getQuantity() {
return quantity;
}
public void setQuantity(int value) {
this.quantity = value;
}
public float getUnitPrice() {
return unitPrice;
}
public void setUnitPrice(float value) {
this.unitPrice = value;
}
public Order getOrder() {
return order;
}
public void setOrder(Order value) {
this.order = value;
}
public Product getProduct() {
return product;
}
public void setProduct(Product value) {
this.product = value;
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