package org.bshg.shopease.zsecurity.dao;

import org.bshg.shopease.zsecurity.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Set;

@Repository
public interface RoleDao extends JpaRepository<Role,Long> {
    Role findByName(String name);
    int deleteByName(String name);
    Set<Role> findAllByUsersUsername(String username);
}
