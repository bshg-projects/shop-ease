package org.bshg.shopease.repository.category;
import org.bshg.shopease.entity.core.category.Category;
import org.bshg.shopease.entity.core.product.Product;
import org.bshg.shopease.zutils.repository.Repository;
import org.springframework.data.jpa.repository.Query;
import java.util.List;
public interface CategoryDao extends Repository<Category, Long> {
@Query("SELECT NEW Category(item.id,item.name) FROM Category item")
List<Category> findAllOptimized();
}