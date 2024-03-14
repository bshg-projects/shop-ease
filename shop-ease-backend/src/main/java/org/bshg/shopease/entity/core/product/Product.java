package org.bshg.shopease.entity.core.product;
import org.bshg.shopease.zutils.entity.audit.AuditEntity;
import org.bshg.shopease.entity.core.category.Category;
import org.bshg.shopease.entity.core.user.OrderItem;
import org.bshg.shopease.entity.core.user.CartItem;
import jakarta.persistence.*;
import java.time.*;
import java.util.*;
@Entity
@Table(name="product")
@SequenceGenerator(name = "product_seq", sequenceName = "product_seq", allocationSize = 1)
public class Product extends AuditEntity {
@Id
@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "product_seq")
private Long id;
private String name;
@Lob
private String description;
private float price;
private int quantityInStock;
@OneToMany(mappedBy = "product")
private List<Image> images;
@OneToMany(mappedBy = "product")
private List<CartItem> cartItem;
@OneToMany(mappedBy = "product")
private List<OrderItem> orderItem;
@ManyToOne(fetch = FetchType.LAZY)
private Category category;
public Product() {
super();
}
public Product(Long id, String label) {
// constructor to get optimized fields
this.id = id;
this.name = label;
}
@Override
public Long getId() {
return id;
}
@Override
public void setId(Long id) {
this.id = id;
}
public String getName() {
return name;
}
public void setName(String value) {
this.name = value;
}
public String getDescription() {
return description;
}
public void setDescription(String value) {
this.description = value;
}
public float getPrice() {
return price;
}
public void setPrice(float value) {
this.price = value;
}
public int getQuantityInStock() {
return quantityInStock;
}
public void setQuantityInStock(int value) {
this.quantityInStock = value;
}
public List<Image> getImages() {
return images;
}
public void setImages(List<Image> value) {
this.images = value;
}
public List<CartItem> getCartItem() {
return cartItem;
}
public void setCartItem(List<CartItem> value) {
this.cartItem = value;
}
public List<OrderItem> getOrderItem() {
return orderItem;
}
public void setOrderItem(List<OrderItem> value) {
this.orderItem = value;
}
public Category getCategory() {
return category;
}
public void setCategory(Category value) {
this.category = value;
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