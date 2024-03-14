package org.bshg.shopease.webservice.dto.category;
import com.fasterxml.jackson.annotation.JsonInclude;
import org.bshg.shopease.zutils.webservice.dto.AuditBaseDto;
import org.bshg.shopease.webservice.dto.product.ProductDto;
import java.time.LocalDateTime;
import java.time.LocalDate;
import java.util.List;
@JsonInclude(JsonInclude.Include.NON_NULL)
public class CategoryDto extends AuditBaseDto {
public CategoryDto() {
super();
}
private String name;
private String description;
private List<ProductDto> products;
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
public List<ProductDto> getProducts() {
return products;
}
public void setProducts(List<ProductDto> value) {
this.products = value;
}
}