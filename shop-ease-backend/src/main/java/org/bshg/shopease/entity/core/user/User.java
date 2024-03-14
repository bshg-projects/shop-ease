package org.bshg.shopease.entity.core.user;
import org.bshg.shopease.zsecurity.entity.AppUser;
import org.bshg.shopease.zutils.entity.audit.AuditEntity;
import org.bshg.shopease.entity.core.transaction.Address;
import jakarta.persistence.*;
import java.time.*;
import java.util.*;
@Entity
@Table(name="user")
public class User extends AppUser {
private String phone;
private String firstName;
private String lastName;
@OneToMany(mappedBy = "user")
private List<Order> orders;
@OneToMany(mappedBy = "user")
private List<Cart> carts;
@ManyToOne(fetch = FetchType.LAZY)
private Address address;
public User() {
super();
}
public String getPhone() {
return phone;
}
public void setPhone(String value) {
this.phone = value;
}
public String getFirstName() {
return firstName;
}
public void setFirstName(String value) {
this.firstName = value;
}
public String getLastName() {
return lastName;
}
public void setLastName(String value) {
this.lastName = value;
}
public List<Order> getOrders() {
return orders;
}
public void setOrders(List<Order> value) {
this.orders = value;
}
public List<Cart> getCarts() {
return carts;
}
public void setCarts(List<Cart> value) {
this.carts = value;
}
public Address getAddress() {
return address;
}
public void setAddress(Address value) {
this.address = value;
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