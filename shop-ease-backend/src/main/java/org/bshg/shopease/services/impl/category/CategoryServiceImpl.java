
package org.bshg.shopease.services.impl.category;
import org.bshg.shopease.entity.core.category.Category;
import org.bshg.shopease.repository.category.CategoryDao;
import org.bshg.shopease.services.facade.category.CategoryService;
import org.bshg.shopease.entity.core.product.Product;
import org.bshg.shopease.services.facade.product.ProductService;
import org.bshg.shopease.zutils.service.ServiceImpl;
import org.bshg.shopease.zutils.service.ServiceHelper;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;
@Service
public class CategoryServiceImpl extends ServiceImpl<Category, CategoryDao> implements CategoryService {
public CategoryServiceImpl(CategoryDao dao) {
super(dao);
}
@Override
public List<Category> findAllOptimized() {
return dao.findAllOptimized();
}
@Override
public void deleteAssociatedList(Category item) {
if (item == null || item.getId() == null) return;
productService.deleteByCategoryId(item.getId());
}
@Override
public void createAssociatedList(Category item) {
if (item == null || item.getId() == null) return;
ServiceHelper.createList(item, Category::getProducts, Product::setCategory, productService);
}
@Override
public void updateAssociatedList(Category item) {
if (item == null || item.getId() == null) return;
ServiceHelper.updateList(item,productService::findByCategoryId,Category::getProducts,Product::setCategory,productService);
}
@Lazy @Autowired private ProductService productService;
}