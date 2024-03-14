package org.bshg.shopease.entity.core.product;
import org.bshg.shopease.zutils.entity.audit.AuditEntity;
import jakarta.persistence.*;
import java.time.*;
import java.util.*;
@Entity
@Table(name="image")
@SequenceGenerator(name = "image_seq", sequenceName = "image_seq", allocationSize = 1)
public class Image extends AuditEntity {
@Id
@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "image_seq")
private Long id;
private String url;
@ManyToOne(fetch = FetchType.LAZY)
private Product product;
public Image() {
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
public String getUrl() {
return url;
}
public void setUrl(String value) {
this.url = value;
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