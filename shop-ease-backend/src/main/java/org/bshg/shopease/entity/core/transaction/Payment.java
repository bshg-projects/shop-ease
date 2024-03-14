package org.bshg.shopease.entity.core.transaction;
import org.bshg.shopease.zutils.entity.audit.AuditEntity;
import jakarta.persistence.*;
import java.time.*;
import java.util.*;
@Entity
@Table(name="payment")
@SequenceGenerator(name = "payment_seq", sequenceName = "payment_seq", allocationSize = 1)
public class Payment extends AuditEntity {
@Id
@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "payment_seq")
private Long id;
private LocalDateTime paymentDate;
private float amount;
@OneToOne()
private PaymentMethod paymentMethod;
public Payment() {
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
public LocalDateTime getPaymentDate() {
return paymentDate;
}
public void setPaymentDate(LocalDateTime value) {
this.paymentDate = value;
}
public float getAmount() {
return amount;
}
public void setAmount(float value) {
this.amount = value;
}
public PaymentMethod getPaymentMethod() {
return paymentMethod;
}
public void setPaymentMethod(PaymentMethod value) {
this.paymentMethod = value;
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