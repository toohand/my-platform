package com.lefthand.comm.lucene;

import java.io.IOException;

import com.lefthand.attachment.domain.entity.Attachment;
import org.apache.lucene.document.Document;
import org.apache.lucene.index.CorruptIndexException;
import org.apache.lucene.index.IndexWriter;
import org.apache.lucene.index.Term;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


/**
 * Lucene索引更新
 */
public class LuceneIndexUpgrader {

  private static Logger logger = LoggerFactory.getLogger(LuceneIndexUpgrader.class);

  private LuceneIndexUpgrader() {}

  /**
   * 根据附件更新索引
   */
  public void update(Attachment attachment) {
    IndexWriter indexWriter = null;
    try {
      // 创建IndexWriter对象
      indexWriter = LuceneIndexTools.createIndexWriter();

      // 创建Document对象
      Document document = LuceneIndexTools.createDocument(attachment);

      // 执行索引更新的方法
      indexWriter.updateDocument(new Term("id", attachment.getId()), document);

    } catch (CorruptIndexException e) {
      logger.debug(e.getMessage(), e);
      // TODO 待完成异常处理
    } catch (IOException e) {
      logger.debug(e.getMessage(), e);
      // TODO 待完成异常处理
    } finally {

      // 关闭IndexWriter
      LuceneIndexTools.closeIndexWriter(indexWriter);
    }
  }

  /**
   * 根据附件集合更新索引
   */
  public void update(Attachment[] attachments) {
    for (Attachment attachment : attachments) {
      update(attachment);
    }
  }

}
