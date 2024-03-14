package org.bshg.shopease.repository.user;
import org.bshg.shopease.entity.core.user.User;
import org.bshg.shopease.entity.core.user.Order;
import org.bshg.shopease.entity.core.transaction.Address;
import org.bshg.shopease.entity.core.user.Cart;
import org.bshg.shopease.zutils.repository.Repository;
import org.springframework.data.jpa.repository.Query;
import java.util.List;
public interface UserDao extends Repository<User, Long> {
int deleteByAddressId(Long id);
List<User> findByAddressId(Long id);
}