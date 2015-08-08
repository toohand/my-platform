package com.lefthand.comm.lucene;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import com.lefthand.attachment.domain.entity.Attachment;
import org.apache.lucene.analysis.Analyzer;
import org.apache.lucene.analysis.standard.StandardAnalyzer;
import org.apache.lucene.document.Document;
import org.apache.lucene.document.Field;
import org.apache.lucene.index.CorruptIndexException;
import org.apache.lucene.index.IndexReader;
import org.apache.lucene.index.IndexWriter;
import org.apache.lucene.index.IndexWriterConfig;
import org.apache.lucene.store.Directory;
import org.apache.lucene.store.FSDirectory;
import org.apache.lucene.util.Version;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Lucene工具类
 */
public class LuceneIndexTools {

  private static Logger logger = LoggerFactory.getLogger(LuceneIndexTools.class);

  private LuceneIndexTools() {}

  /**
   * 创建IndexWriter对象
   */
  public static IndexWriter createIndexWriter() {

    // 存放索引的目录
    String path = null;

    // 分词器, Lucene自带的默认分词器
    Analyzer analyzer = new StandardAnalyzer(Version.LUCENE_36);

    IndexWriter indexWriter = null;

    try {
      // 创建Directory目录, 声明索引存放的位置

      // 把索引存放在内存中
      // Directory directory = new RAMDirectory();

      // 把索引存放在硬盘上的指定位置
      Directory directory = FSDirectory.open(new File(path));

      // 创建IIndexWriterConfig对象，来配置IndexWriter
      IndexWriterConfig config = new IndexWriterConfig(Version.LUCENE_36, analyzer);

      // 创建IndexWriter对象
      indexWriter = new IndexWriter(directory, config);

    } catch (IOException e) {
      logger.debug(e.getMessage(), e);
      // TODO 待完成异常处理
    }

    return indexWriter;
  }

  /**
   * 关闭IndexWriter对象
   */
  public static void closeIndexWriter(IndexWriter indexWriter) {
    if (null != indexWriter) {
      try {
        indexWriter.close();
      } catch (CorruptIndexException e) {
        logger.debug(e.getMessage(), e);
        // TODO 待完成异常处理
      } catch (IOException e) {
        logger.debug(e.getMessage(), e);
        // TODO 待完成异常处理
      }
    }
  }

  /**
   * 创建IndexReader对象
   */
  public static IndexReader createIndexReader() {

    // 存放索引的目录
    String path = null;

    IndexReader indexReader = null;

    try {
      // 创建Directory目录, 声明索引存放的位置

      // 把索引存放在内存中
      // Directory directory = new RAMDirectory();

      // 把索引存放在硬盘上的指定位置
      Directory directory = FSDirectory.open(new File(path));

      // 创建IndexWriter对象
      indexReader = IndexReader.open(directory);

    } catch (IOException e) {
      logger.debug(e.getMessage(), e);
      // TODO 待完成异常处理
    }

    return indexReader;
  }

  /**
   * 关闭IndexReader对象
   */
  public static void closeIndexReader(IndexReader indexReader) {
    if (null != indexReader) {
      try {
        indexReader.close();
      } catch (CorruptIndexException e) {
        logger.debug(e.getMessage(), e);
        // TODO 待完成异常处理
      } catch (IOException e) {
        logger.debug(e.getMessage(), e);
        // TODO 待完成异常处理
      }
    }
  }

  /**
   * 根据附件创建Lucene文档对象
   */
  public static Document createDocument(Attachment attachment) {
    Document document = null;

    try {
      document = new Document();
  
      // 附件属性, 所属公文流水号
      document.add(new Field("form", null, Field.Store.YES, Field.Index.NOT_ANALYZED));
  
      // 附件属性, 附件文件名称
      document.add(new Field("name", attachment.getName(), Field.Store.YES, Field.Index.NOT_ANALYZED));
  
      // 附件属性, 附件流水号
      document.add(new Field("id", attachment.getId(), Field.Store.YES, Field.Index.NOT_ANALYZED));
  
      // 附件属性, 附件内容, 需要分词
      // TODO 待完成, 与HDFS结合
      document.add(new Field("content", new FileReader("")));
  
      // 附件属性, 附件存储实际路径
      document.add(new Field("path", attachment.getPath(), Field.Store.YES, Field.Index.NOT_ANALYZED));
  
      // 权限属性, 岗位
      document.add(new Field("post", null, Field.Store.YES, Field.Index.NOT_ANALYZED));
  
      // 权限属性, 部门
      document.add(new Field("dept", null, Field.Store.YES, Field.Index.NOT_ANALYZED));
  
      // 权限属性, 单位
      document.add(new Field("unit", null, Field.Store.YES, Field.Index.NOT_ANALYZED));

    } catch (FileNotFoundException e) {
      logger.debug(e.getMessage(), e);
      // TODO 待完成异常处理
    }

    // 返回Document对象
    return document;
  }

}
