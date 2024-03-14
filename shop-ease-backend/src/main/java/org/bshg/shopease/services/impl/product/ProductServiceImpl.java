
package org.bshg.shopease.services.impl.product;
import org.bshg.shopease.entity.core.product.Product;
import org.bshg.shopease.repository.product.ProductDao;
import org.bshg.shopease.services.facade.product.ProductService;
import org.bshg.shopease.entity.core.product.Image;
import org.bshg.shopease.services.facade.product.ImageService;
import org.bshg.shopease.entity.core.user.CartItem;
import org.bshg.shopease.services.facade.user.CartItemService;
import org.bshg.shopease.entity.core.user.OrderItem;
import org.bshg.shopease.services.facade.user.OrderItemService;
import org.bshg.shopease.entity.core.category.Category;
import org.bshg.shopease.services.facade.category.CategoryService;
import org.bshg.shopease.zutils.service.ServiceImpl;
import org.bshg.shopease.zutils.service.ServiceHelper;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;
@Service
public class ProductServiceImpl extends ServiceImpl<Product, ProductDao> implements ProductService {
public ProductServiceImpl(ProductDao dao) {
super(dao);
}
@Override
public List<Product> findAllOptimized() {
return dao.findAllOptimized();
}
@Override
public void deleteAssociatedList(Product item) {
if (item == null || item.getId() == null) return;
imageService.deleteByProductId(item.getId());
cartItemService.deleteByProductId(item.getId());
orderItemService.deleteByProductId(item.getId());
}
@Override
@Transactional(rollbackFor = Exception.class)
public int deleteByCategoryId(Long id){
if (id == null) return 0;
List<Product> found = findByCategoryId(id);
if (found == null) return 0;
found.forEach(this::deleteAssociated);
return dao.deleteByCategoryId(id);
}
@Override
public List<Product> findByCategoryId(Long id){
return dao.findByCategoryId(id);
}
@Override
public void createAssociatedList(Product item) {
if (item == null || item.getId() == null) return;
ServiceHelper.createList(item, Product::getImages, Image::setProduct, imageService);
ServiceHelper.createList(item, Product::getCartItem, CartItem::setProduct, cartItemService);
ServiceHelper.createList(item, Product::getOrderItem, OrderItem::setProduct, orderItemService);
}
@Override
public void updateAssociatedList(Product item) {
if (item == null || item.getId() == null) return;
ServiceHelper.updateList(item,imageService::findByProductId,Product::getImages,Image::setProduct,imageService);
ServiceHelper.updateList(item,cartItemService::findByProductId,Product::getCartItem,CartItem::setProduct,cartItemService);
ServiceHelper.updateList(item,orderItemService::findByProductId,Product::getOrderItem,OrderItem::setProduct,orderItemService);
}
@Lazy @Autowired private ImageService imageService;
@Lazy @Autowired private CartItemService cartItemService;
@Lazy @Autowired private OrderItemService orderItemService;
@Lazy @Autowired private CategoryService categoryService;
}