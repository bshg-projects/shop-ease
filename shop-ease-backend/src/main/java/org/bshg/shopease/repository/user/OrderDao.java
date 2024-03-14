package org.bshg.shopease.repository.user;
import org.bshg.shopease.entity.core.user.Order;
import org.bshg.shopease.entity.core.user.User;
import org.bshg.shopease.entity.core.user.OrderItem;
import org.bshg.shopease.zutils.repository.Repository;
import org.springframework.data.jpa.repository.Query;
import java.util.List;
public interface OrderDao extends Repository<Order, Long> {
int deleteByUserId(Long id);
List<Order> findByUserId(Long id);
}