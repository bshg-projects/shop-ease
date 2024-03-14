package org.bshg.shopease.entity.core.transaction;
import org.bshg.shopease.zutils.entity.audit.AuditEntity;
import jakarta.persistence.*;
import java.time.*;
import java.util.*;
@Entity
@Table(name="paymentmethod")
@SequenceGenerator(name = "paymentmethod_seq", sequenceName = "paymentmethod_seq", allocationSize = 1)
public class PaymentMethod extends AuditEntity {
@Id
@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "paymentmethod_seq")
private Long id;
private String name;
public PaymentMethod() {
super();
}
public PaymentMethod(Long id, String label) {
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
@Override
public boolean equals(Object object) {
return super.equals(object);
}
@Override
public int hashCode() {
return super.hashCode();
}
}