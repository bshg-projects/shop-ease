package org.bshg.shopease.entity.core.user;
import org.bshg.shopease.zutils.entity.audit.AuditEntity;
import org.bshg.shopease.entity.core.product.Product;
import jakarta.persistence.*;
import java.time.*;
import java.util.*;
/**
* This Class is for Association between 'Product' and 'Cart'
* It extends AuditEntity to inherit auditing features.
*/
@Entity
@Table(name="cartitem")
@SequenceGenerator(name = "cartitem_seq", sequenceName = "cartitem_seq", allocationSize = 1)
public class CartItem extends AuditEntity {
@Id
@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "cartitem_seq")
private Long id;
private int quantity;
@ManyToOne(fetch = FetchType.LAZY)
private Cart cart;
@ManyToOne(fetch = FetchType.LAZY)
private Product product;
public CartItem() {
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
public Cart getCart() {
return cart;
}
public void setCart(Cart value) {
this.cart = value;
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