package com.lefthand.comm.lucene;

import java.io.File;
import java.io.IOException;

import com.lefthand.attachment.domain.entity.Attachment;
import org.apache.lucene.analysis.Analyzer;
import org.apache.lucene.analysis.standard.StandardAnalyzer;
import org.apache.lucene.document.Document;
import org.apache.lucene.index.CorruptIndexException;
import org.apache.lucene.index.IndexWriter;
import org.apache.lucene.index.IndexWriterConfig;
import org.apache.lucene.index.Term;
import org.apache.lucene.store.Directory;
import org.apache.lucene.store.FSDirectory;
import org.apache.lucene.util.Version;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 索引服务
 */
public class IndexService {

  private static Logger logger = LoggerFactory.getLogger(IndexService.class);

  /**
   * 根据附件建立索引
   * 
   * @param attachment
   */
  public void createIndex(Attachment attachment) {

    IndexWriter indexWriter = null;

    try {
      // 创建IndexWriter对象
      indexWriter = LuceneIndexTools.createIndexWriter();

      // 创建Document对象
      Document document = LuceneIndexTools.createDocument(attachment);

      // 通过IndexWriter, 把Document添加到索引中
      indexWriter.addDocument(document);

    } catch (CorruptIndexException e) {
      
    } catch (IOException e) {
      e.printStackTrace();
    } finally {

      // 关闭IndexWriter
      LuceneIndexTools.closeIndexWriter(indexWriter);
    }
  }

  /**
   * 根据附件集合建立索引
   * 
   * @param attachments
   */
  public void createIndexes(Attachment[] attachments) {
    for (Attachment attachment : attachments) {
      createIndex(attachment);
    }
  }

  /**
   * 根据附件更新索引
   * 
   * @param attachment
   */
  public void updateIndex(Attachment attachment) {

    // 存放索引的目录
    String path = null;

    // 分词器, Lucene自带的默认分词器
    Analyzer analyzer = new StandardAnalyzer(Version.LUCENE_36);

    IndexWriter indexWriter = null;

    try {
      // 创建索引的目录对象Directory
      Directory directory = FSDirectory.open(new File(path));

      // 创建IndexWriter对象
      IndexWriterConfig config = new IndexWriterConfig(Version.LUCENE_36, analyzer);
      indexWriter = new IndexWriter(directory, config);

      // 创建Document对象
      Document doc = LuceneIndexTools.createDocument(attachment);

      // 执行索引更新的方法
      indexWriter.updateDocument(new Term("id", attachment.getId()), doc);

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
   * 
   * @param attachments
   */
  public void updateIndexes(Attachment[] attachments) {

  }

  /**
   * 根据附件删除索引
   * 
   * @param attachment
   */
  public void deleteIndex(Attachment attachment) {
    IndexWriter indexWriter = LuceneIndexTools.createIndexWriter();
    try {
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
   * 
   * @param attachments
   */
  public void deleteIndexes(Attachment[] attachments) {

  }

  /**
   * 根据索引路径加载索引
   * 
   * @param path
   */
  public void loadIndex(String path) {

  }

  /**
   * 根据索引路径集合加载索引
   * 
   * @param paths
   */
  public void loadIndexes(String[] paths) {

  }

  /**
   * 根据索引路径加载索引
   * 
   * @param path
   */
  public void unloadIndex(String path) {

  }

  /**
   * 根据索引路径集合加载索引
   * 
   * @param path
   */
  public void unloadIndexes(String[] path) {

  }

}
