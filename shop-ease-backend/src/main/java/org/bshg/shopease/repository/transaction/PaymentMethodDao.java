package org.bshg.shopease.repository.transaction;
import org.bshg.shopease.entity.core.transaction.PaymentMethod;
import org.bshg.shopease.zutils.repository.Repository;
import org.springframework.data.jpa.repository.Query;
import java.util.List;
public interface PaymentMethodDao extends Repository<PaymentMethod, Long> {
@Query("SELECT NEW PaymentMethod(item.id,item.name) FROM PaymentMethod item")
List<PaymentMethod> findAllOptimized();
}