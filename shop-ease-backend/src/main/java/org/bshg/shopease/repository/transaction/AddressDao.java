package org.bshg.shopease.repository.transaction;
import org.bshg.shopease.entity.core.transaction.Address;
import org.bshg.shopease.entity.core.user.User;
import org.bshg.shopease.zutils.repository.Repository;
import org.springframework.data.jpa.repository.Query;
import java.util.List;
public interface AddressDao extends Repository<Address, Long> {
}