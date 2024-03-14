package org.bshg.shopease.entity.core.user;
import org.bshg.shopease.zutils.entity.audit.AuditEntity;
import jakarta.persistence.*;
import java.time.*;
import java.util.*;
@Entity
@Table(name="cart")
@SequenceGenerator(name = "cart_seq", sequenceName = "cart_seq", allocationSize = 1)
public class Cart extends AuditEntity {
@Id
@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "cart_seq")
private Long id;
private boolean status;
private LocalDateTime creationDate;
@OneToMany(mappedBy = "cart")
private List<CartItem> cartItem;
@ManyToOne(fetch = FetchType.LAZY)
private User user;
public Cart() {
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
public boolean isStatus() {
return status;
}
public void setStatus(boolean value) {
this.status = value;
}
public LocalDateTime getCreationDate() {
return creationDate;
}
public void setCreationDate(LocalDateTime value) {
this.creationDate = value;
}
public List<CartItem> getCartItem() {
return cartItem;
}
public void setCartItem(List<CartItem> value) {
this.cartItem = value;
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