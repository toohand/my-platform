package com.lefthand.security.authenticate;

import com.lefthand.comm.exception.ApplicationException;
import gzrd.wsclient.post.PositionWebService;
import gzrd.wsclient.user.UserWebService;
import org.apache.commons.codec.digest.DigestUtils;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

/**
 * 身份认证服务实现类
 */
@Service
public class AuthenticateServiceImpl implements AuthenticateService {

    private static Logger logger = LoggerFactory.getLogger(AuthenticateServiceImpl.class);

    @Autowired
    private UserWebService userWebService;

    @Autowired
    private PositionWebService postWebService;

    @Transactional(readOnly = true)
    public com.lefthand.security.organization.domain.Post authenticateAfter(String loginName, Long postId) {
        com.lefthand.security.organization.domain.Post post = null;
        try {
            if (StringUtils.isNotBlank(loginName)) {
                gzrd.wsclient.post.Position position = postWebService.getPositionById(postId);
                gzrd.wsclient.user.UserInfo userInfo = userWebService.getUserInfoByName(loginName);

                post = this.convertPost(position);
                com.lefthand.security.organization.domain.Department department = this.convertDepartment(position);
                com.lefthand.security.organization.domain.Unit unit = this.convertUnit(position);
                department.setParent(unit);
                post.setParent(department);
                com.lefthand.security.organization.domain.User user = this.convertUser(userInfo);
                post.setUser(user);

//                Area area = null;
//                if(StringUtils.isBlank(post.getUnit().getUasId())){
//                    Area city = new City();
//                    city.setId((long) 1);
//                    area = areaService.getById(city);
//                }else{
//                    area = areaService.getByUasId(post.getUnit().getUasId());
//                }
//
//                post.getUnit().setArea(area);
//                if (ObjectUtils.equals(post.getParent().getName(), Constants.DEPARTMENT_NAME_GRID)) {
//                    post.getUnit().setLevel(new GridLevel());
//                } else {
//                    post.getUnit().setLevel(levelService.getByArea(area));
//                }
            }
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            throw new ApplicationException(e.getMessage(), e);
        }

        return post;
    }

    @Transactional(readOnly = true)
    public List<com.lefthand.security.organization.domain.Post> authenticateAfter(String loginName, String password){
        try {
            gzrd.wsclient.user.UserInfo userInfo = userWebService.getUserInfoByName(loginName);
            if(userInfo!=null && DigestUtils.md5Hex(password).toUpperCase().equals(userInfo.getPassWord())){
                List<gzrd.wsclient.post.Position> positions = postWebService.getPossByUserId(userInfo.getUserId());
                List<com.lefthand.security.organization.domain.Post> posts = new ArrayList<com.lefthand.security.organization.domain.Post>();
                for(gzrd.wsclient.post.Position position : positions){
                    com.lefthand.security.organization.domain.Post post = new com.lefthand.security.organization.domain.PostImpl();
                    post = this.convertPost(position);
                    com.lefthand.security.organization.domain.Department department = this.convertDepartment(position);
                    com.lefthand.security.organization.domain.Unit unit = this.convertUnit(position);
                    department.setParent(unit);
                    post.setParent(department);
                    com.lefthand.security.organization.domain.User user = this.convertUser(userInfo);
                    post.setUser(user);
                    posts.add(post);
                }
                return posts;
            }else{
                return null;
            }
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            throw new ApplicationException(e.getMessage(), e);
        }
    }

    private com.lefthand.security.organization.domain.Post convertPost(gzrd.wsclient.post.Position position) {
        com.lefthand.security.organization.domain.PostImpl post = new com.lefthand.security.organization.domain.PostImpl();
        post.setId(String.valueOf(position.getId()));
        post.setName(position.getPosName());
        return post;
    }

    private com.lefthand.security.organization.domain.Unit convertUnit(gzrd.wsclient.post.Position position) {
        com.lefthand.security.organization.domain.UnitImpl unit = new com.lefthand.security.organization.domain.UnitImpl();
        unit.setId(String.valueOf(position.getOrgId()));
        unit.setName(position.getOrgName());
        return unit;
    }

    private com.lefthand.security.organization.domain.Department convertDepartment(gzrd.wsclient.post.Position position) {
        com.lefthand.security.organization.domain.DepartmentImpl department = new com.lefthand.security.organization.domain.DepartmentImpl();
        department.setId(String.valueOf(position.getDeptId()));
        department.setName(position.getDeptName());
        return department;
    }

    private com.lefthand.security.organization.domain.User convertUser(gzrd.wsclient.user.UserInfo userInfo) {
        com.lefthand.security.organization.domain.UserImpl user = new com.lefthand.security.organization.domain.UserImpl();
        user.setId(String.valueOf(userInfo.getUserId()));
        user.setName(userInfo.getUserName());
        return user;
    }
}
