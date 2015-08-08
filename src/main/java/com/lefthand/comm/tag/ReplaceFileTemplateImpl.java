/*
 * 创建日期 2009-11-23
 *
 * TODO 要更改此生成的文件的模板，请转至
 * 窗口 － 首选项 － Java － 代码样式 － 代码模板
 */
package com.lefthand.comm.tag;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.io.IOException;
import java.io.FileInputStream;
import java.io.ByteArrayOutputStream;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;


/**
 * @author Administrator
 *
 * TODO 要更改此生成的类型注释的模板，请转至
 * 窗口 － 首选项 － Java － 代码样式 － 代码模板
 */
public class ReplaceFileTemplateImpl implements IreplaceFileTemplate {
	public static final String B =  "<!-- (";
	public static final String E =  ") -->";
	
	public static final String ONE = "one";			//只替换一次的标记 <!-- (one) -->
	public static final String ONE_END = "<!-- (one_end) -->";	//只替换一次的结束的标记 <!-- (one_end) -->
	public static final String FOR = "for";			//替换多次的标记 <!-- (for) -->
	public static final String FOR_END = "<!-- (for_end) -->";	//替换多次的结束的标记 <!-- (for_end) -->
	public static final String IF = "<!-- (if";			//根据条件是否需要一段内容的标记
	public static final String IF2 = ") -->";			//根据条件是否需要一段内容的标记 <!-- (if 0|true) -->
	public static final String IF_END = "<!-- (if_end) -->";	//根据条件是否需要一段内容的结束的标记 <!-- (if_end) -->


	private List dataList = null;	//数据,List里的存放的对象是Map,Map的key是字段名用于替换模板中的相同文字的地方,value是写进文件的值
	private String templateFilePath = "";//模板路径
	private String outFilePath = "";	//生成文件存放路径
	private OutputStream outStream;	//生成文件的流
	private PrintWriter pw = null;		//写文件对象
	private IencodeData encodeData = null; //转换数据
	private String sysEncoding = "";//操作系统编码
	
	public ReplaceFileTemplateImpl(){}
	
	public ReplaceFileTemplateImpl(List dataList, String templateFilePath, String outFilePath, String encodeType){
		this.setVal(dataList, templateFilePath, null,  outFilePath,encodeType);	
	}
	
	public ReplaceFileTemplateImpl(List dataList, String templateFilePath, OutputStream outStream, String encodeType){
		
		this.setVal(dataList, templateFilePath, outStream,  "",encodeType);		
	}
	
	private void setVal(List dataList, String templateFilePath, OutputStream outStream, String outFilePath, String encodeType){
		this.dataList = dataList;
		this.templateFilePath = templateFilePath;
		this.outFilePath = outFilePath;
		this.outStream = outStream;
		this.sysEncoding = "GBK";//System.getProperty("file.encoding");
		if(encodeType.equals("base64") || templateFilePath.toLowerCase().indexOf(".mht") != -1){
			encodeData = new EncodeDataImpl();
		}else{
			encodeData = new NoEncodeDataImpl();
		}		
	}
	
	private OutputStream getTargetOutputStream() throws FileNotFoundException{
		OutputStream os = null;
		if(this.outFilePath != null && !this.outFilePath.equals("")){
			File file1= new File(outFilePath);				
			if(file1.exists()){
				file1.delete();
			}
	
			File tempFile1=new File(outFilePath);
			os = new FileOutputStream(tempFile1);
		}else{
			os = this.outStream;
		}
		return os;
	}
	
	/**
	* 读取文件内容
	* @param filepath
	* @return
	*/  
	private String readFileContent(String filepath){
		StringBuffer filetext = new StringBuffer();
		try {
			File tempFile=new File(filepath);
			//FileReader infile=new FileReader(tempFile);
			BufferedReader inbuffer=new BufferedReader(new InputStreamReader(new FileInputStream(tempFile), this.sysEncoding));
			String tempString="";
			
			while((tempString=inbuffer.readLine())!=null){
				filetext.append(tempString +"\r\n");
			}                					
			inbuffer.close();
			//infile.close();	
		} catch (IOException e) {
			//TODO 自动生成 catch 块
			e.printStackTrace();
		}
		return filetext.toString();
	
	}
	
	private byte[] readFileContentToByte(String filepath) throws IOException{
		
		FileInputStream fis = new FileInputStream(filepath);
		//创建一个长度为1024的“竹筒”
		byte[] buf = new byte[1024];
		ByteArrayOutputStream out = new ByteArrayOutputStream(1024);   
		//用于保存实际读取的字节数
		int hasRead = 0;
		//使用循环来重复“取水”过程
		while ((hasRead = fis.read(buf)) > 0 )
		{
			//取出“竹筒”中水滴（字节），将字节数组转换成字符串输入！
			out.write(buf , 0 , hasRead );
		}
		fis.close();
		return out.toByteArray();
	}

	  
	/**
	   * 用于读取模板文件内容,就把内容中的一个标记替换成相应的内容
	   * @return 返回替换后文档的所有内容
	   * @throws java.sql.SQLException
	   * @throws java.io.IOException
	   */
	public String ReplaceFileTemplate() throws SQLException, IOException {
		
		//java.io.PrintWriter pw = null;
		StringBuffer allContent = new StringBuffer();
		String templateFileContent = "";
		StringBuffer alltable = new StringBuffer();
		try {
		    
		   /* File file1= new File(outFilePath);				
			if(file1.exists()){
				file1.delete();
			}

			File tempFile1=new File(outFilePath);*/
			//FileWriter fw = new FileWriter(tempFile1);
			pw = new PrintWriter(new BufferedWriter(new OutputStreamWriter(this.getTargetOutputStream(), this.sysEncoding)));

		    if(dataList != null){
		        System.out.println("模板文件路径: " + templateFilePath);
				
				templateFileContent = readFileContent(templateFilePath);//读取模板文件内容
				//System.out.println("filetext: "+filetext); <!-- (one) --><!-- (for) --> 
				//System.out.println("HTMLStr1: "+HTMLStr.substring(pos, delPos));
				//System.out.println("HTMLStr2: "+HTMLStr.substring(delPos2+2));
				//System.out.println("HTMLStr3: "+HTMLStr.substring(delPos+2,delPos2));
				//substring(第一个参数是指定到字符的下标上, 最后一个参数是指定到要截到的字符的下标加1)重点是记住它是从0开始的
				//int pos = 0;
				if(!templateFileContent.equals("")){
					String tmpContent = "";
					String tag = "";
					while(true){
						int pos = 0;
						if(templateFileContent.indexOf(B) != -1){//找"<!-- ("							
							//读出开始标记以前的字符
							tmpContent = templateFileContent.substring(pos, templateFileContent.indexOf(B) );
							allContent.append( PrintWriterFile(tmpContent, "") );
							//System.out.println("1:" + tmpContent);
							
							pos = templateFileContent.indexOf(B) + B.length();
							//取标记中间的内容,如<!-- (one) -->中的one
							tag = templateFileContent.substring(pos, templateFileContent.indexOf(E));
							//System.out.println("2 tag:" + tag);
							//定位到开始标志结束后的位置,即<!-- (one) -->后
							pos = templateFileContent.indexOf(E) + E.length();
							
							if(tag.equals(ONE)){
								
								//下面是读标记的之间的内容
								tmpContent = templateFileContent.substring(pos, templateFileContent.indexOf(ONE_END));
								//System.out.println("3 tmpContent:" + tmpContent);

								allContent.append( PrintWriterFile(tmpContent, ONE));
								pos = templateFileContent.indexOf(ONE_END) + ONE_END.length();
								templateFileContent = templateFileContent.substring(pos);
								
							}else if(tag.equals(FOR)){
								//下面是读标记的之间的内容
								tmpContent = templateFileContent.substring(pos, templateFileContent.indexOf(FOR_END));
								//System.out.println("3-2 tmpContent:" + tmpContent);

								allContent.append( PrintWriterFile(tmpContent, FOR));
								pos = templateFileContent.indexOf(FOR_END) + FOR_END.length();
								templateFileContent = templateFileContent.substring(pos);
								
							}else if(templateFileContent.indexOf(IF) != -1){
								//下面是读标记的之间的内容
								tmpContent = templateFileContent.substring(templateFileContent.indexOf(B), templateFileContent.indexOf(IF_END) + IF_END.length());
								//System.out.println("3-2 tmpContent:" + tmpContent);

								allContent.append( PrintWriterFile(tmpContent, ONE));
								pos = templateFileContent.indexOf(IF_END) + IF_END.length();
								templateFileContent = templateFileContent.substring(pos);
							}				
						}else{
							break;
						}
					}
					
					allContent.append( PrintWriterFile(templateFileContent, ""));

				}

		    }/*else{
		      //System.out.println("***********************2 "+isnothing);
		        if(!isnothing.equals("")){//当同时生成列表和详细页面最好不要用这一步,除非空内容模板本身的做法和非空内容模板一样
	  		        String s = templateFilePath.substring(0,templateFilePath.lastIndexOf("."));
	  		        s = s + "NOTHING#" + templateFilePath.substring(templateFilePath.lastIndexOf("."));
	  		        //System.out.println("s: *******: " + s);
	  		        filetextall = readFileContent(s);
					//System.out.println("filetext: "+filetext);
					if(!filetextall.equals("")){						    
					    PrintWriterFile(dataList,templateFilePath,filetextall,outFilePath,"",pw);
					}
		        }
		    }*/		   
		    
		    System.out.println("生成文件路径: "+outFilePath);

		}catch (Exception sqle) {
			sqle.printStackTrace();
			System.out.println("ReplaceFileTemplateImpl ReplaceFileTemplate() :"+sqle.getMessage());
		}finally{
			pw.close();
		    //fw.close();		
		}
		return allContent.toString();
	}
	
	private void replaceDOCtemplates() throws Exception, IOException{
		//ocollection infoResult 详细页面的sql结果集,action filenamepath 详细页面的模板路径,style targetFilepath生成文件路径,
		//classname listResult 列表页面的sql结果集,condition sourceFilepath列表页面的模板路径,fields是当没记录时读另一个空内容模板
	    //if(ocollection.equals("") && classname.equals("")){  
	    //    replaceDOCtemplatesImp((List)request.getAttribute(infoResult),this.filenamepath,this.targetFilepath,(List)request.getAttribute(this.listResult),this.sourceFilepath,this.fields);
	    //}else{
	    //    replaceDOCtemplatesImp((List)request.getAttribute(ocollection),this.action,this.style,(List)request.getAttribute(this.classname),this.condition,this.fields);
	    //}
	}
	
	private String PrintWriterFile(String content,String isReplace) throws SQLException, IOException{
		
		StringBuffer returnStr = new StringBuffer();
		String filetext = content;
		List list = this.dataList;
		if(!isReplace.equals("")){		   
			String tmp = "";
			String tmpvalue = "";
			String checked = encodeData.encode2HtmlUnicode("√"), nochecked = encodeData.encode2HtmlUnicode("□");
			for(int i=0;i<list.size();i++){
			    Map filed= (Map)list.get(i);
			    Set f = filed.keySet();
			    Iterator it= f.iterator();
			    while(it.hasNext()){
			        tmp = it.next()+"";       
			        if(filed.get(tmp) == null){
			            tmpvalue = "";
			        }else{
				        if(filed.get(tmp) instanceof Date){
				            tmpvalue = new SimpleDateFormat("yyyy-MM-dd").format(filed.get(tmp));
				        }else if(filed.get(tmp) instanceof byte[]){
				            tmpvalue = encodeData.base64Encode( (byte[]) filed.get(tmp) );
				        }else if(filed.get(tmp) instanceof String && ((String)filed.get(tmp)).indexOf("file//") != -1){
				            String tmpStr = (String)filed.get(tmp);
				        	tmpvalue = encodeData.base64Encode( readFileContentToByte(tmpStr.substring("file//".length())) );
				        }else{	
					        tmpvalue = (String)filed.get(tmp);						        
				            //把回车空格转换成HTML方式
				            if((templateFilePath.toLowerCase().indexOf(".htm") != -1 || templateFilePath.toLowerCase().indexOf(".mht") != -1) && (tmpvalue.indexOf("\r\n") !=-1 || tmpvalue.indexOf(" ") !=-1)){
				                tmpvalue = tmpvalue.replaceAll("\r\n","<br/>");//.replaceAll(" ","&nbsp;");
				            }
				            tmpvalue = encodeData.encode2HtmlUnicode(tmpvalue);
				        }
			        }
			        
			        //System.out.println("it.next()"+tmp + "#: " + tmpvalue);
			        //filetext = filetext.replaceAll("SN",String.valueOf(i+1));
			        if(tmp.toUpperCase().indexOf("_CHECK") == -1){
			            filetext = filetext.replaceAll(tmp+"#",tmpvalue);
			        }else{
			            if(!tmpvalue.equals("") && tmpvalue.indexOf(",") ==-1){
			                filetext = filetext.replaceAll(tmp+"#", checked);
			                //System.out.println("filetext.replaceAll("+tmp+"#,\"√\")");
			            }else if(tmpvalue.equals("") && tmpvalue.indexOf(",") ==-1){
			                if(tmp.toUpperCase().indexOf("_CHECKNO") != -1){
			                    filetext = filetext.replaceAll(tmp+"#","");
			                }else{
			                    filetext = filetext.replaceAll(tmp+"#",nochecked);
			                }
			                //System.out.println("filetext.replaceAll("+tmp+"#,\"□\")");
			            }else{
			                tmpvalue = tmpvalue.replaceAll(","," , ");
			                String s[] = tmpvalue.split(",");
			                for(int j=0;j<s.length;j++){
			                    if(s[j].equals(" ") || s[j].equals("  ")){
			                        if(tmp.toUpperCase().indexOf("_CHECKNO") != -1){
			                            filetext = filetext.replaceAll(tmp+(j+1)+"#","");
					                }else{
					                    filetext = filetext.replaceAll(tmp+(j+1)+"#",nochecked);
					                }				                        
			                        //System.out.println(tmp+(j+1)+"# s["+j+"] :"+s[j] +"filetext.replaceAll("+tmp+(j+1)+"#,\"□\")");
			                    }else{	
			                        filetext = filetext.replaceAll(tmp+(j+1)+"#",checked);
			                        //System.out.println(tmp+(j+1)+"# s["+j+"]no :"+s[j] +"filetext.replaceAll("+tmp+(j+1)+"#,\"√\")");
			                    }				                    				                    
			                }
			            }
			        }
			    }
			    
			    filetext = ifTag(filetext);
			    pw.write(filetext);
				pw.flush();
			    returnStr.append(filetext);
			    filetext = content;
			    if(isReplace.equals(ONE)) break;
			}
	    }else{	    	
			pw.write(filetext);
			pw.flush();
			returnStr.append(filetext);
	    }
		return returnStr.toString();
	}
	
	/*
	//相同标签不能嵌套
	private String findTag(String content) throws SQLException, IOException{
		String rStr = content;
		String tmpContent = "";
		int pos = 0;
		if(rStr.indexOf(ONE) != -1){
			
			tmpContent = rStr.substring(pos, rStr.indexOf(ONE));
			PrintWriterFile(tmpContent, "");
			pos = rStr.indexOf(ONE + ONE.length());
			rStr = rStr.substring(pos);
			//上面读出开始标记以前的字符
			
			//下面是读标记的之间的内容
			tmpContent = rStr.substring(pos, rStr.indexOf(ONE_END));
			tmpContent = findTag(tmpContent);
			PrintWriterFile(tmpContent, "head");										
			pos = rStr.indexOf(ONE_END + ONE_END.length());
			rStr = rStr.substring(pos);
			
		}else if(rStr.indexOf(FOR) != -1){
			
		}else if(rStr.indexOf(IF) != -1){
			tmpContent = rStr.substring(pos, rStr.indexOf(IF));
			pos = rStr.indexOf(IF + IF.length());
			rStr = rStr.substring(pos);
			
			tmpContent = rStr.substring(pos, rStr.indexOf(IF_END));
			tmpContent = findTag(tmpContent);
			//PrintWriterFile(tmpContent, "head");										
			pos = rStr.indexOf(IF_END + IF_END.length());
			rStr = rStr.substring(pos);
		}
		
		return rStr;
	}*/
	
	/**
	 * 处理IF标记,分析已经替换过(指被PrintWriterFile方法处理过)的内容,处理里面的有带IF标记的地方,处理方式是如<!-- (if IF#) -->已经替换
	 * 成<!-- (if 1) -->或<!-- (if true) -->,那就拆分出里面的1或true,如查拆分出的不是1或true那表示不要IF标记开始和结束之间的内容
	 * @param content
	 * @return
	 * @throws java.sql.SQLException
	 * @throws java.io.IOException
	 */
	private String ifTag(String content) throws SQLException, IOException{
		StringBuffer rStr = new StringBuffer();
		String tmpContent = content;
		
		while(true){
			String condition = "";
			int pos = 0;
			if(tmpContent.indexOf(IF) == -1){
				break;
			}
			//<!-- (if IF#) -->
			//public static final String IF = "<!-- (if";			//根据条件是否需要一段内容的标记
			//public static final String IF2 = ") -->";			//根据条件是否需要一段内容的标记 <!-- (if) -->
			rStr.append( tmpContent.substring(pos, tmpContent.indexOf(IF)) );//读出开始标记以前的字符
			
			pos = tmpContent.indexOf(IF) + IF.length();//下标移到<!-- (if的后面
			condition = tmpContent.substring( pos, tmpContent.indexOf(IF2) );//截取IF标记中间的内容,指要找出1或true之类的内容
			
			if(condition.trim().equals("1") || condition.trim().equals("true") ){
				//读标记的之间的内容
				rStr.append( tmpContent.substring(tmpContent.indexOf(IF2) + IF2.length(), tmpContent.indexOf(IF_END)) );
			}
			
			pos = tmpContent.indexOf(IF_END) + IF_END.length();//指向IF结束标记") -->"之后位置
							
			tmpContent = tmpContent.substring(pos);//截取IF结束标记") -->"之后的内容
		}
		rStr.append(tmpContent);//添加剩下的内容(这些都是没有IF标记的最后面的内容)
		return rStr.toString();
	}

	private String test(String content) throws SQLException, IOException{
		StringBuffer rStr = new StringBuffer();
		String templateFileContent = content;
		String tmpContent = "";
		String tag = "";
		while(true){
			int pos = 0;
			if(templateFileContent.indexOf(B) != -1){//找"<!-- ("							
				//读出开始标记以前的字符
				tmpContent = templateFileContent.substring(pos, templateFileContent.indexOf(B) );
				//PrintWriterFile(tmpContent, "");
				rStr.append(tmpContent);
				System.out.println("1:" + tmpContent);
				
				pos = templateFileContent.indexOf(B) + B.length();
				//取标记中间的内容,如<!-- (one) -->中的one
				tag = templateFileContent.substring(pos, templateFileContent.indexOf(E));
				System.out.println("2 tag:" + tag);
				//定位到开始标志结束后的位置,即<!-- (one) -->后
				pos = templateFileContent.indexOf(E) + E.length();
				
				if(tag.equals(ONE)){
					
					//下面是读标记的之间的内容
					tmpContent = templateFileContent.substring(pos, templateFileContent.indexOf(ONE_END));
					System.out.println("3 tmpContent:" + tmpContent);
					rStr.append(tmpContent);
					//PrintWriterFile(tmpContent, ONE);
					pos = templateFileContent.indexOf(ONE_END) + ONE_END.length();
					templateFileContent = templateFileContent.substring(pos);
					
				}else if(tag.equals(FOR)){
					//下面是读标记的之间的内容
					tmpContent = templateFileContent.substring(pos, templateFileContent.indexOf(FOR_END));
					System.out.println("3-2 tmpContent:" + tmpContent);
					rStr.append(tmpContent);
					//PrintWriterFile(tmpContent, FOR);
					pos = templateFileContent.indexOf(FOR_END) + FOR_END.length();
					templateFileContent = templateFileContent.substring(pos);
					
				}else if(templateFileContent.indexOf(IF) != -1){
					//下面是读标记的之间的内容
					tmpContent = templateFileContent.substring(templateFileContent.indexOf(B), templateFileContent.indexOf(IF_END) + IF_END.length());
					System.out.println("3-2 tmpContent:" + tmpContent);
					rStr.append(tmpContent);
					//PrintWriterFile(tmpContent, ONE);
					pos = templateFileContent.indexOf(IF_END) + IF_END.length();
					templateFileContent = templateFileContent.substring(pos);
				}				
			}else{
				break;
			}
		}
		System.out.println("4 templateFileContent:" + templateFileContent);
		rStr.append(templateFileContent);//添加剩下的内容(这些都是没有IF标记的最后面的内容)
		return rStr.toString();
	}
		
	public static void main(String[] args){
		List<Map> infoResult = new java.util.ArrayList<Map>();
		Map<String, String> a= new java.util.HashMap<String, String>();
		String text = "";
		text += "<br><b>【2014-01-15】无处副处长 XXX  意见：</b><br>"
				+ "      发第三方斯蒂芬阿萨德发第三方斯蒂芬阿萨德发第三方斯蒂芬阿萨德发第三方斯蒂芬阿萨德发第三方斯蒂芬阿"
				+ "萨德发第三方斯蒂芬阿萨德发第三方斯蒂芬阿萨德发第三方斯蒂芬阿萨德发第三方斯蒂芬阿萨德发第三方斯蒂芬阿萨德发第三方斯蒂芬阿萨德发"
				+ "<br><b>【2014-01-15】无处副处长 XXX  意见：</b><br>"
				+ "      发第三方斯蒂芬阿萨德发第三方斯蒂芬阿萨德发第三方斯蒂芬阿萨德发第三方斯蒂芬阿萨德发第三方斯蒂芬阿"
				+ "萨德发第三方斯蒂芬阿萨德发第三方斯蒂芬阿萨德发第三方斯蒂芬阿萨德发第三方斯蒂芬阿萨德发第三方斯蒂芬阿萨德发第三方斯蒂芬阿萨德发"
				+ "<br><b>【2014-01-15】无处副处长 XXX  意见：</b><br>"
				+ "      发第三方斯蒂芬阿萨德发第三方斯蒂芬阿萨德发第三方斯蒂芬阿萨德发第三方斯蒂芬阿萨德发第三方斯蒂芬阿"
				+ "萨德发第三方斯蒂芬阿萨德发第三方斯蒂芬阿萨德发第三方斯蒂芬阿萨德发第三方斯蒂芬阿萨德发第三方斯蒂芬阿萨德发第三方斯蒂芬阿萨德发"
				+ "<br><b>【2014-01-15】无处副处长 XXX  意见：</b><br>"
				+ "      发第三方斯蒂芬阿萨德发第三方斯蒂芬阿萨德发第三方斯蒂芬阿萨德发第三方斯蒂芬阿萨德发第三方斯蒂芬阿"
				+ "萨德发第三方斯蒂芬阿萨德发第三方斯蒂芬阿萨德发第三方斯蒂芬阿萨德发第三方斯蒂芬阿萨德发第三方斯蒂芬阿萨德发第三方斯蒂芬阿萨德发"
				+ "<br><b>【2014-01-15】无处副处长 XXX  意见：</b><br>"
				+ "      发第三方斯蒂芬阿萨德发第三方斯蒂芬阿萨德发第三方斯蒂芬阿萨德发第三方斯蒂芬阿萨德发第三方斯蒂芬阿"
				+ "萨德发第三方斯蒂芬阿萨德发第三方斯蒂芬阿萨德发第三方斯蒂芬阿萨德发第三方斯蒂芬阿萨德发第三方斯蒂芬阿萨德发第三方斯蒂芬阿萨德发"
				+ "<br><b>【2014-01-15】无处副处长 XXX  意见：</b><br>"
				+ "      发第三方斯蒂芬阿萨德发第三方斯蒂芬阿萨德发第三方斯蒂芬阿萨德发第三方斯蒂芬阿萨德发第三方斯蒂芬阿"
				+ "萨德发第三方斯蒂芬阿萨德发第三方斯蒂芬阿萨德发第三方斯蒂芬阿萨德发第三方斯蒂芬阿萨德发第三方斯蒂芬阿萨德发第三方斯蒂芬阿萨德发"
				+ "<br><b>【2014-01-15】无处副处长 XXX  意见：</b><br>"
				+ "      发第三方斯蒂芬阿萨德发第三方斯蒂芬阿萨德发第三方斯蒂芬阿萨德发第三方斯蒂芬阿萨德发第三方斯蒂芬阿"
				+ "萨德发第三方斯蒂芬阿萨德发第三方斯蒂芬阿萨德发第三方斯蒂芬阿萨德发第三方斯蒂芬阿萨德发第三方斯蒂芬阿萨德发第三方斯蒂芬阿萨德发"
				+ "<br><b>【2014-01-15】无处副处长 XXX  意见：</b><br>"
				+ "      发第三方斯蒂芬阿萨德发第三方斯蒂芬阿萨德发第三方斯蒂芬阿萨德发第三方斯蒂芬阿萨德发第三方斯蒂芬阿"
				+ "萨德发第三方斯蒂芬阿萨德发第三方斯蒂芬阿萨德发第三方斯蒂芬阿萨德发第三方斯蒂芬阿萨德发第三方斯蒂芬阿萨德发第三方斯蒂芬阿萨德发";
		a.put("A1", text);
		a.put("A2", "你好2");
		a.put("A3", "你好1");
		infoResult.add(a);
		File tempFile1=new File("D:/test2.doc");
		FileOutputStream os = null;
		try {
			os = new FileOutputStream(tempFile1);
		} catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		ByteArrayOutputStream as = new ByteArrayOutputStream();
		IreplaceFileTemplate app = 
				new ReplaceFileTemplateImpl(infoResult, "D:/test.htm", as, "");
		try {
			System.out.println("test: " + app.ReplaceFileTemplate());
			
			File tempFile2=new File("D:/test2.doc");
			FileOutputStream os2 = null;
			try {
				os2 = new FileOutputStream(tempFile2);
				System.out.println("test: " + as.size());
				os2.write(as.toByteArray());
			} catch (FileNotFoundException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		/*
		ReplaceFileTemplateImpl app = new ReplaceFileTemplateImpl();
		String testStr = 
				//" 中国共产党<!-- (if false) --> \r\n" +
				//" <!-- (if false) --> \r\n" +
				" <!-- (if false) -->中国共产党2<!-- (if_end) --> \r\n"// +
				//" <!-- (if_end) --> \r\n" +
				//" 中国共产党3 \r\n"
				;
		
		String testStr2 = 
			" 中国共产党<!-- (if false) --> \r\n" +
			//" <!-- (if false) --> \r\n" +
			" 中国共产党2<!-- (if_end) --> \r\n" +
			//" <!-- (if_end) --> \r\n" +
			" 中国共产党3 \r\n";
		
		try {
			System.out.println(app.ifTag(testStr));
			System.out.println(app.test(testStr2));
		} catch (SQLException e) {
			// TODO 自动生成 catch 块
			e.printStackTrace();
		} catch (IOException e) {
			// TODO 自动生成 catch 块
			e.printStackTrace();
		}
		
		//System.out.println(app.encode2HtmlUnicode(testStr2));
		/1*
		 te
		2 = 14
		st
		 *1/
		String templateFileContent = "te<!-- (one) -->st";
		int pos =0;
		
		System.out.println(templateFileContent.substring(pos, templateFileContent.indexOf(ONE)));
		
		pos = templateFileContent.indexOf(ONE);
		
		System.out.println(pos + " = " + ONE.length());
		templateFileContent = templateFileContent.substring(pos + ONE.length());
		System.out.println(templateFileContent);*/
	}
}
