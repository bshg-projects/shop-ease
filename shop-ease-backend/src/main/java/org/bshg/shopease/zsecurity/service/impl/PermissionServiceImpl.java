package org.bshg.shopease.zsecurity.service.impl;

import org.bshg.shopease.zsecurity.entity.Permission;
import org.bshg.shopease.zsecurity.dao.PermissionDao;
import org.bshg.shopease.zsecurity.service.facade.PermissionService;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class PermissionServiceImpl implements PermissionService {
    private final PermissionDao permissionDao;

    public PermissionServiceImpl(PermissionDao permissionDao) {
        this.permissionDao = permissionDao;
    }

    @Override
    public Permission save(Permission permission) {
        Permission perm = permissionDao.findByName(permission.getName());
        return perm == null ? permissionDao.save(permission) : perm;
    }
}