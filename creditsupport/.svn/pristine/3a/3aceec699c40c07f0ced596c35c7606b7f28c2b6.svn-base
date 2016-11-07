package com.yodata.creditsupport.util;


import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.net.URLEncoder;
import java.nio.charset.Charset;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Image;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.pdf.PdfContentByte;
import com.itextpdf.text.pdf.PdfReader;
import com.itextpdf.text.pdf.PdfStamper;
import com.itextpdf.text.pdf.PdfWriter;
import com.itextpdf.tool.xml.Pipeline;
import com.itextpdf.tool.xml.XMLWorker;
import com.itextpdf.tool.xml.XMLWorkerFontProvider;
import com.itextpdf.tool.xml.XMLWorkerHelper;
import com.itextpdf.tool.xml.css.CssFilesImpl;
import com.itextpdf.tool.xml.css.StyleAttrCSSResolver;
import com.itextpdf.tool.xml.html.CssAppliersImpl;
import com.itextpdf.tool.xml.html.Tags;
import com.itextpdf.tool.xml.parser.XMLParser;
import com.itextpdf.tool.xml.pipeline.css.CssResolverPipeline;
import com.itextpdf.tool.xml.pipeline.end.PdfWriterPipeline;
import com.itextpdf.tool.xml.pipeline.html.HtmlPipeline;
import com.itextpdf.tool.xml.pipeline.html.HtmlPipelineContext;

import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;
public class ReportPdfUtils{
	private final Log log = LogFactory.getLog(ReportPdfUtils.class);
	private final SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
	private String date;				// 文件编号的日期 eg: 20160506
	private String filePath;			// 文件路径
	private String pdfFileNo;			// pdf文件编号
	private Map<String, Object> data;	// 用于填充pdf的数据
	
	private static Configuration configuration;
	static {
		configuration = new Configuration(Configuration.VERSION_2_3_23);
		configuration.setDefaultEncoding("UTF-8");
	}
	
	public ReportPdfUtils(String rootPath){
		this.filePath = rootPath + File.separator + "download" + File.separator;
	}
	
	public ReportPdfUtils(String pdfFileNo, Date date, String rootPath){
		this.pdfFileNo = pdfFileNo;
		this.date = sdf.format(date);
		this.filePath = rootPath + "/download/" + this.date + File.separator;
	}
	public void setPdfData(Map<String, Object> d) {
		this.data = d;
	}
	
	
	public void createPdf(String fileName) {
		File dir = new File(filePath);
		if (!dir.exists()) { // 判断目录是否存在
        	dir.mkdirs(); // 新建多级目录
        }
		String htmlFileName = filePath + pdfFileNo + ".html";
		String pdfFilePath = filePath + pdfFileNo + ".pdf";
		File htmlFile = new File(htmlFileName); // html文件
		File pdfFile = new File(pdfFilePath); // pdf文件
		Writer out = null;
		configuration.setClassForTemplateLoading(this.getClass(), "/");  //FTL文件所存在的位置
		Template t = null;
		try {
        	t = configuration.getTemplate(fileName); //文件名
        	out = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(htmlFile), Charset.forName("UTF-8")));
        	t.process(data, out);	// 填充数据
        	Document doc = new Document(PageSize.A4);
            PdfWriter pdfWriter;
            pdfWriter = PdfWriter.getInstance(doc, new FileOutputStream(pdfFile));
            doc.open();
            transformHtml2Pdf(new FileInputStream(htmlFile), doc, pdfWriter, null);
            doc.close();
            
            String fileNew = waterMark(pdfFilePath);
            
            FTPClientUtil.getInstance().uploadFile("/download/" + date + "/", pdfFileNo + ".pdf", new FileInputStream(fileNew));
		} catch (DocumentException e) {
			log.error(e);
		} catch (TemplateException e) {
        	log.error(e);
        } catch (Exception e) {
			log.error(e);
        } 
		
		finally {
			try {
				if(out != null) {
					out.close();
				}
			} catch (IOException e) {
				log.error(e);
			}
			if(htmlFile.exists()) {
            	htmlFile.delete();	// 删除临时的html文件
            }
		}
	}
	
	public void createScoreReport(Map<String, Object> data, HttpServletResponse response, String tfile, String fileName) throws IOException {
		response.setHeader("Content-disposition","attachment;filename=" + URLEncoder.encode(fileName + ".pdf", "utf-8"));
		ServletOutputStream outputStream = response.getOutputStream();
		File dir = new File(filePath);
		if (!dir.exists()) { // 判断目录是否存在
        	dir.mkdirs(); // 新建多级目录
        }
		String htmlFileName = filePath + System.currentTimeMillis() + "-temp.html";
		File htmlFile = new File(htmlFileName); // html文件
		Writer out = null;
		configuration.setClassForTemplateLoading(this.getClass(), "/");  //FTL文件所存在的位置
		Template t = null;
		try {
        	t = configuration.getTemplate(tfile); //文件名
        	out = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(htmlFile), Charset.forName("UTF-8")));
        	t.process(data, out);	// 填充数据
        	Document doc = new Document(PageSize.A4);
            PdfWriter pdfWriter;
            pdfWriter = PdfWriter.getInstance(doc, outputStream);
            doc.open();
            transformHtml2Pdf(new FileInputStream(htmlFile), doc, pdfWriter, null);
            doc.close();
            outputStream.flush();  
        } catch (DocumentException e) {
        	log.error(e);
		} catch (IOException e) {
			log.error(e);
        } catch (TemplateException e) {
        	log.error(e);
        } catch (InterruptedException e) {
        	log.error(e);
		} finally {
			try {
				if(out != null) {
					out.close();
				}
			} catch (IOException e) {
				log.error(e);
			}
			if(htmlFile.exists()) {
            	htmlFile.delete();	// 删除临时的html文件
            }
		}
	}
	
	private void transformHtml2Pdf(FileInputStream html, Document doc, PdfWriter pdfWriter, InputStream cssFile) throws IOException, DocumentException, InterruptedException {
		CssFilesImpl cssFiles = new CssFilesImpl();
        if (cssFile == null)
            cssFile = ReportPdfUtils.class.getResourceAsStream("/report-default.css");
        cssFiles.add(XMLWorkerHelper.getCSS(cssFile));
        StyleAttrCSSResolver cssResolver = new StyleAttrCSSResolver(cssFiles);
        HtmlPipelineContext hpc = new HtmlPipelineContext(new CssAppliersImpl(new XMLWorkerFontProvider(this.getClass().getResource("/fonts").getPath())));
        hpc.setAcceptUnknown(true).autoBookmark(false).setTagFactory(Tags.getHtmlTagProcessorFactory());
        HtmlPipeline htmlPipeline = new HtmlPipeline(hpc, new PdfWriterPipeline(doc, pdfWriter));
        Pipeline<?> pipeline = new CssResolverPipeline(cssResolver, htmlPipeline);
        XMLWorker worker = new XMLWorker(pipeline, true);
        XMLParser xmlParse = new XMLParser(true, worker, Charset.forName("UTF-8"));
        xmlParse.parse(html, Charset.forName("UTF-8"));
    }
	
	/**
	 * 功能描述：生成PDF征信报告文件编号 
	 * @param regId 企业工商号
	 * @return
	 */
	public String getPdfPath() {
		return "/download/" + date + "/" + pdfFileNo + ".pdf";
	}
	public String getPdfPathNew(){
		return getPdfPath().split(".pdf")[0]+"_mask.pdf";
	}
	
	public String waterMark(String inpath) throws Exception{
		String fileNew = inpath.split(".pdf")[0]+"_mask.pdf";
		PdfReader reader = new PdfReader(inpath);
		PdfStamper stamp = new PdfStamper(reader, new FileOutputStream(fileNew));  
		
		int total = reader.getNumberOfPages() + 1;
		
		Image img = Image.getInstance(ReportPdfUtils.class.getResource("/watermask.png"));  
		img.setAbsolutePosition(120, 300); 
		img.scalePercent(30);//依照比例缩放

		PdfContentByte under = null; 
		for (int i = 1; i < total; i++){
			under = stamp.getUnderContent(i);
			under.addImage(img); 
		}
		stamp.close(); 
		reader.close(); 
		return fileNew;
	}
}
