package org.bshg.shopease.webservice.converter.category;
import org.bshg.shopease.entity.core.category.Category;
import org.bshg.shopease.webservice.dto.category.CategoryDto;
import org.bshg.shopease.webservice.converter.product.ProductConverter;
import org.bshg.shopease.zutils.webservice.converter.AbstractConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
@Component
public class CategoryConverter extends AbstractConverter<Category, CategoryDto> {
@Autowired private ProductConverter productConverter;
private boolean products = true;
@Override
protected void config() {
config(Category.class, CategoryDto.class);
}
@Override
protected void convertersConfig(boolean value) {
this.productConverter.setCategory(value);
}
@Override
protected Category convertToItem(CategoryDto dto) {
var item = new Category();
item.setId(dto.getId());
item.setName(dto.getName());
item.setDescription(dto.getDescription());
item.setProducts(productConverter.toItem(dto.getProducts()));
return item;
}
@Override
protected CategoryDto convertToDto(Category item) {
var dto = new CategoryDto();
dto.setId(item.getId());
dto.setName(item.getName());
dto.setDescription(item.getDescription());
dto.setProducts(products? productConverter.toDto(item.getProducts()): null);
return dto;
}
public void setProducts(boolean value) {
this.products = value;
}
public void setProductConverter(ProductConverter value) {
this.productConverter = value;
}
public ProductConverter getProductConverter() {
return productConverter;
}
}