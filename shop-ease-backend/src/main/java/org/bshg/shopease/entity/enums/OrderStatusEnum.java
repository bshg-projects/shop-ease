package org.bshg.shopease.entity.enums;
public enum OrderStatusEnum {
PENDING("PENDING"),
SHIPPED("SHIPPED"),
DELIVERED("DELIVERED"),
;
private final String value;
OrderStatusEnum(String value) {
this.value = value;
}
public String value() {
return value;
}
}