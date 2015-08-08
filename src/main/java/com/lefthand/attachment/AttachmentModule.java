package com.lefthand.attachment;

import com.lefthand.comm.exception.MessageProvider;

/**
 * 内容模块消息枚举类
 */
public enum AttachmentModule {

  ERR_DAO_ATTACHMENT_INSERT,
  ERR_DAO_ATTACHMENT_UPDATE,
  ERR_DAO_ATTACHMENT_SAVE,
  ERR_DAO_ATTACHMENT_UPDATE_NEW_NAME,
  ERR_DAO_ATTACHMENT_UPDATE_DELETE_STATUS,
  ERR_DAO_ATTACHMENT_DELETE,
  ERR_DAO_ATTACHMENT_FIND,
  ERR_DAO_ATTACHMENT_FIND_BY_OWNER_ASSOCIATE,
  ERR_DAO_ATTACHMENT_FIND_BY_OWNER_ASSOCIATES,

  ERR_DAO_ATTACHMENT_ASSOCIATE_SAVE,
  ERR_DAO_ATTACHMENT_ASSOCIATE_DELETE,
  ERR_DAO_ATTACHMENT_ASSOCIATE_FIND,

  ERR_SEV_ATTACHMENT_CREATE,
  ERR_SEV_ATTACHMENT_UPDATE,
  ERR_SEV_ATTACHMENT_SAVE,
  ERR_SEV_ATTACHMENT_DELETE,
  ERR_SEV_ATTACHMENT_FIND,
  ERR_SEV_ATTACHMENT_FIND_BY_OWNER_ASSOCIATE_TYPE,
  ERR_SEV_ATTACHMENT_FIND_BY_OWNER_ASSOCIATE_TYPES,

  ERR_CON_ATTACHMENT_UPLOAD,
  ERR_CON_ATTACHMENT_DOWNUPLOAD,
  ERR_CON_ATTACHMENT_DELETE,
  ERR_CON_ATTACHMENT_FIND;

  @Override
  public String toString() {
    return MessageProvider.getResource(AttachmentModule.class).getMessage(this.name());
  }
}
