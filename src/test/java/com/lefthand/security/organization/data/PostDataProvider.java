package com.lefthand.security.organization.data;

import com.lefthand.security.organization.domain.Post;

/**
 * 岗位测试数据提供类
 */
public class PostDataProvider {

    private PostDataProvider() {}

    public static Post post1() {
        com.lefthand.security.organization.domain.PostImpl post = new com.lefthand.security.organization.domain.PostImpl();
        post.setId("UTP_001");
        post.setName("测试岗位_001");
        post.setUser(UserDataProvider.user1());
        post.setParent(DepartmentDataProvider.department1());
        return post;
    }

    public static Post post2() {
        com.lefthand.security.organization.domain.PostImpl post = new com.lefthand.security.organization.domain.PostImpl();
        post.setId("UTP_002");
        post.setName("测试岗位_002");
        post.setUser(UserDataProvider.user2());
        post.setParent(DepartmentDataProvider.department2());
        return post;
    }

    public static Post post3() {
        com.lefthand.security.organization.domain.PostImpl post = new com.lefthand.security.organization.domain.PostImpl();
        post.setId("UTP_003");
        post.setName("测试岗位_003");
        post.setUser(UserDataProvider.user3());
        post.setParent(DepartmentDataProvider.department3());
        return post;
    }
}
