package com.lefthand.comm.lucene;


import java.io.IOException;

import com.lefthand.attachment.domain.entity.Attachment;
import org.apache.lucene.index.CorruptIndexException;
import org.apache.lucene.index.IndexWriter;
import org.apache.lucene.index.Term;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Lucene索引删除
 */
public class LuceneIndexDeleter {

  private static Logger logger = LoggerFactory.getLogger(LuceneIndexDeleter.class);

  private LuceneIndexDeleter() {}

  /**
   * 根据附件删除索引
   */
  public void delete(Attachment attachment) {
    IndexWriter indexWriter = null;
    try {

      // 创建IndexWriter对象
      indexWriter = LuceneIndexTools.createIndexWriter();

      // 根据附件流水号删除索引
      // 索引并没有完全删除, 可以进行恢复, 除非再执行强制删除才会完全删除.
      indexWriter.deleteDocuments(new Term("id", attachment.getId()));

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
   * 根据附件集合删除索引
   */
  public void delete(Attachment[] attachments) {
    for (Attachment attachment : attachments) {
      delete(attachment);
    }
  }

}
