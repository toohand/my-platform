package com.lefthand.security.organization.data;

import com.lefthand.security.organization.domain.Unit;

/**
 * 单位测试数据提供类
 */
public class UnitDataProvider {

    private UnitDataProvider() {}

    public static Unit unit1() {
        com.lefthand.security.organization.domain.UnitImpl unit = new com.lefthand.security.organization.domain.UnitImpl();
        unit.setId("UTU_001");
        unit.setName("测试单位_001");
        return unit;
    }

    public static Unit unit2() {
        com.lefthand.security.organization.domain.UnitImpl unit = new com.lefthand.security.organization.domain.UnitImpl();
        unit.setId("UTU_002");
        unit.setName("测试单位_002");
        return unit;
    }

    public static Unit unit3() {
        com.lefthand.security.organization.domain.UnitImpl unit = new com.lefthand.security.organization.domain.UnitImpl();
        unit.setId("UTU_003");
        unit.setName("测试单位_003");
        return unit;
    }
}
