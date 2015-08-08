package com.lefthand.security.organization.data;

import com.lefthand.security.organization.domain.Department;
import com.lefthand.security.organization.domain.DepartmentImpl;

/**
 * 部门测试数据提供类
 */
public class DepartmentDataProvider {

    private DepartmentDataProvider() {}

    public static Department department1() {
        DepartmentImpl department = new DepartmentImpl();
        department.setId("UTD_001");
        department.setName("测试部门_001");
        department.setParent(UnitDataProvider.unit1());
        return department;
    }

    public static Department department2() {
        DepartmentImpl department = new DepartmentImpl();
        department.setId("UTD_002");
        department.setName("测试部门_002");
        department.setParent(UnitDataProvider.unit2());
        return department;
    }

    public static Department department3() {
        DepartmentImpl department = new DepartmentImpl();
        department.setId("UTD_003");
        department.setName("测试部门_003");
        department.setParent(UnitDataProvider.unit3());
        return department;
    }
}
