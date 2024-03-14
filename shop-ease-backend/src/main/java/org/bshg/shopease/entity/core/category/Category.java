package org.bshg.shopease.entity.core.category;
import org.bshg.shopease.zutils.entity.audit.AuditEntity;
import org.bshg.shopease.entity.core.product.Product;
import jakarta.persistence.*;
import java.time.*;
import java.util.*;
@Entity
@Table(name="category")
@SequenceGenerator(name = "category_seq", sequenceName = "category_seq", allocationSize = 1)
public class Category extends AuditEntity {
@Id
@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "category_seq")
private Long id;
private String name;
private String description;
@OneToMany(mappedBy = "category")
private List<Product> products;
public Category() {
super();
}
public Category(Long id, String label) {
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
public List<Product> getProducts() {
return products;
}
public void setProducts(List<Product> value) {
this.products = value;
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