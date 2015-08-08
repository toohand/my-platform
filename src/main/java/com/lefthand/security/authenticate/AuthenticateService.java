package com.lefthand.security.authenticate;

import com.lefthand.security.organization.domain.Post;

import java.util.List;

/**
 * 身份认证服务接口
 */
public interface AuthenticateService {

    Post authenticateAfter(String loginName, Long postId);

    List<Post> authenticateAfter(String loginName, String password);
}
