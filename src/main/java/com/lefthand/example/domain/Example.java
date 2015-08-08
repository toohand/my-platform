package com.lefthand.example.domain;

import com.lefthand.comm.domain.AbstractIdEntity;

/**
 * 框架使用例子, 实体
 */
public class Example extends AbstractIdEntity {

  private static final long serialVersionUID = 1L;

  /**
   * 构造函数, 建议保留
   */
  public Example() {
  }

  /**
   * 构造函数
   * 
   * @param id
   *          主键
   * @param name
   *          姓名
   * @param gender
   *          性别
   */
  public Example(String id, String name, Boolean gender) {
    this.id = id;
    this.name = name;
    this.gender = gender;
  }

  /**
   * 实体主键
   */
  private String id;

  /**
   * 姓名
   */
  private String name;

  /**
   * 性别
   */
  private Boolean gender;

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public Boolean getGender() {
    return gender;
  }

  public void setGender(Boolean gender) {
    this.gender = gender;
  }

}
