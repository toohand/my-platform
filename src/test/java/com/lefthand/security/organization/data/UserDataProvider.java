package com.lefthand.security.organization.data;

/**
 * 用户测试数据提供类
 */
public class UserDataProvider {

    private UserDataProvider() {}

    public static com.lefthand.security.organization.domain.User user1() {
        com.lefthand.security.organization.domain.UserImpl user = new com.lefthand.security.organization.domain.UserImpl();
        user.setId("UTU_001");
        user.setName("测试用户_001");
        user.setParent(DepartmentDataProvider.department1());
        return user;
    }

    public static com.lefthand.security.organization.domain.User user2() {
        com.lefthand.security.organization.domain.UserImpl user = new com.lefthand.security.organization.domain.UserImpl();
        user.setId("UTU_002");
        user.setName("测试用户_002");
        user.setParent(DepartmentDataProvider.department2());
        return user;
    }

    public static com.lefthand.security.organization.domain.User user3() {
        com.lefthand.security.organization.domain.UserImpl user = new com.lefthand.security.organization.domain.UserImpl();
        user.setId("UTU_003");
        user.setName("测试用户_003");
        user.setParent(DepartmentDataProvider.department3());
        return user;
    }
}
