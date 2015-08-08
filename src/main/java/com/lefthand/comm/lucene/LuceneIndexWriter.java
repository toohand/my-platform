package com.lefthand.comm.lucene;

import java.io.IOException;

import com.lefthand.attachment.domain.entity.Attachment;
import org.apache.lucene.document.Document;
import org.apache.lucene.index.CorruptIndexException;
import org.apache.lucene.index.IndexWriter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


/**
 * Lucene索引写入
 */
public class LuceneIndexWriter {

  private static Logger logger = LoggerFactory.getLogger(LuceneIndexWriter.class);

  private LuceneIndexWriter() {}

  /**
   * 根据附件建立索引
   */
  public void add(Attachment attachment) {
    IndexWriter indexWriter = null;
    try {
      // 创建IndexWriter对象
      indexWriter = LuceneIndexTools.createIndexWriter();

      // 创建Document对象
      Document document = LuceneIndexTools.createDocument(attachment);

      // 通过IndexWriter, 把Document添加到索引中
      indexWriter.addDocument(document);

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
   * 根据附件集合建立索引
   */
  public void add(Attachment[] attachments) {
    for (Attachment attachment : attachments) {
      add(attachment);
    }
  }

}
