package org.bshg.shopease.zutils.repository;

import org.bshg.shopease.zutils.entity.audit.AuditEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.NoRepositoryBean;

import java.util.List;

@NoRepositoryBean
public interface Repository<T extends AuditEntity, ID> extends JpaRepository<T, ID>, JpaSpecificationExecutor<T> {
    int deleteByIdIn(List<ID> ids);
}
