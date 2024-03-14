package org.bshg.shopease.entity.core.transaction;
import org.bshg.shopease.zutils.entity.audit.AuditEntity;
import org.bshg.shopease.entity.core.user.User;
import jakarta.persistence.*;
import java.time.*;
import java.util.*;
@Entity
@Table(name="address")
@SequenceGenerator(name = "address_seq", sequenceName = "address_seq", allocationSize = 1)
public class Address extends AuditEntity {
@Id
@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "address_seq")
private Long id;
private String street;
private String city;
private String postalCode;
private String country;
@OneToMany(mappedBy = "address")
private List<User> users;
public Address() {
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
public String getStreet() {
return street;
}
public void setStreet(String value) {
this.street = value;
}
public String getCity() {
return city;
}
public void setCity(String value) {
this.city = value;
}
public String getPostalCode() {
return postalCode;
}
public void setPostalCode(String value) {
this.postalCode = value;
}
public String getCountry() {
return country;
}
public void setCountry(String value) {
this.country = value;
}
public List<User> getUsers() {
return users;
}
public void setUsers(List<User> value) {
this.users = value;
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