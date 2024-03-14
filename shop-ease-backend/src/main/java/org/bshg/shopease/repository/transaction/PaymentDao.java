package org.bshg.shopease.repository.transaction;
import org.bshg.shopease.entity.core.transaction.Payment;
import org.bshg.shopease.entity.core.transaction.PaymentMethod;
import org.bshg.shopease.zutils.repository.Repository;
import org.springframework.data.jpa.repository.Query;
import java.util.List;
public interface PaymentDao extends Repository<Payment, Long> {
int deleteByPaymentMethodId(Long id);
Payment findByPaymentMethodId(Long id);
}