package com.yodata.creditsupport.util;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

public class FileToZipUtil {

	/**
	 * 将多个文件打包成以第一个文件名命名的zip文件
	 * @param filePaths 文件路径字符串，中间以spit分割
	 * @param spit 分割字符，可以是","，";"等
	 * @param targetFilePath 压缩后的文件路径及文件名
	 * @return
	 */
    public static boolean filesToZip(String filePaths, String spit, String targetFilePath){
    	boolean flag = false;  
    	if(filePaths != null && !"".equals(filePaths.trim())){
            FileInputStream fis = null;  
            BufferedInputStream bis = null;  
            FileOutputStream fos = null;  
            ZipOutputStream zos = null;
            try {
            	
	            //文件名数组
	    		String[] filePathArr = filePaths.split(spit);
	    		//压缩后的文件，并判断是否已存在
	    		File targetFile = new File(targetFilePath);

				fos = new FileOutputStream(targetFile);
				zos = new ZipOutputStream(new BufferedOutputStream(fos));
				byte[] bufs = new byte[1024 * 10];
				int length = filePathArr.length;
				File sourceFile = null;
				for (int i = 0; i < length; i++) {
					String filepath = filePathArr[i];
					sourceFile = new File(filepath);
					if (sourceFile.exists()) {
						// 创建ZIP实体，并添加进压缩包
						ZipEntry zipEntry = new ZipEntry(sourceFile.getName());
						zos.putNextEntry(zipEntry);
						// 读取待压缩的文件并写进压缩包里
						fis = new FileInputStream(sourceFile);
						bis = new BufferedInputStream(fis, 1024 * 10);
						int read = 0;
						while ((read = bis.read(bufs, 0, 1024 * 10)) != -1) {
							zos.write(bufs, 0, read);
						}
					}
				}
				flag = true;
	    	} catch (FileNotFoundException e) {  
	            e.printStackTrace();  
	            throw new RuntimeException(e);  
	        } catch (IOException e) {  
	            e.printStackTrace();  
	            throw new RuntimeException(e);  
	        } finally{  
	            //关闭流  
	            try {  
	                if(null != bis) bis.close();  
	                if(null != zos) zos.close();  
	            } catch (IOException e) {  
	                e.printStackTrace();  
	                throw new RuntimeException(e);  
	            }  
	        }  
	    }  
        return flag;  
    }
    
    /**
	 * 将多个文件打包成以第一个文件名命名的zip文件
	 * @param filePathArr 文件路径字符数组
	 * @param targetFilePath 压缩后的文件路径及文件名
	 * @return
	 */
    public static boolean filesToZip(String[] filePathArr, String targetFilePath){
    	boolean flag = false;  
    	if(filePathArr != null && filePathArr.length > 0){
            FileInputStream fis = null;  
            BufferedInputStream bis = null;  
            FileOutputStream fos = null;  
            ZipOutputStream zos = null;
            try {
	    		//压缩后的文件，并判断是否已存在
	    		File targetFile = new File(targetFilePath);
	    		
	            fos = new FileOutputStream(targetFile);  
	            zos = new ZipOutputStream(new BufferedOutputStream(fos));  
				byte[] bufs = new byte[1024 * 10];
				int length = filePathArr.length;
				File sourceFile = null;
				for (int i = 0; i < length; i++) {
					String filepath = filePathArr[i];
					sourceFile = new File(filepath);
					if (sourceFile.exists()) {
						// 创建ZIP实体，并添加进压缩包
						ZipEntry zipEntry = new ZipEntry(sourceFile.getName());
						zos.putNextEntry(zipEntry);
						// 读取待压缩的文件并写进压缩包里
						fis = new FileInputStream(sourceFile);
						bis = new BufferedInputStream(fis, 1024 * 10);
						int read = 0;
						while ((read = bis.read(bufs, 0, 1024 * 10)) != -1) {
							zos.write(bufs, 0, read);
						}
					}
				}
				flag = true;
	    	} catch (FileNotFoundException e) {  
	            e.printStackTrace();  
	            throw new RuntimeException(e);  
	        } catch (IOException e) {  
	            e.printStackTrace();  
	            throw new RuntimeException(e);  
	        } finally{  
	            //关闭流  
	            try {  
	                if(null != bis) bis.close();  
	                if(null != zos) zos.close();  
	            } catch (IOException e) {  
	                e.printStackTrace();  
	                throw new RuntimeException(e);  
	            }  
	        }  
	    }  
        return flag;  
    }
    
    /**
	 * 将多个文件打包成以第一个文件名命名的zip文件
	 * @param filePaths 文件路径字符串，中间以spit分割
	 * @param spit 分割字符，可以是","，";"等
	 * @param targetFilePath 压缩后的文件路径及文件名
	 * @return
	 */
    public static boolean filesToZip(List<String> filePathList, String targetFilePath){
    	boolean flag = false;  
    	if(filePathList != null && !filePathList.isEmpty()){
            FileInputStream fis = null;  
            BufferedInputStream bis = null;  
            FileOutputStream fos = null;  
            ZipOutputStream zos = null;
            try {
	    		//压缩后的文件，如果文件不存在则新建，存在则覆盖
	    		File targetFile = new File(targetFilePath);
            	fos = new FileOutputStream(targetFile);  
                zos = new ZipOutputStream(new BufferedOutputStream(fos));  
                byte[] bufs = new byte[1024*10];  
            	File sourceFile = null;
            	for(String filepath : filePathList){
            		sourceFile = new File(filepath);
            		if(sourceFile.exists()){
            			//创建ZIP实体，并添加进压缩包  
            			ZipEntry zipEntry = new ZipEntry(sourceFile.getName());  
            			zos.putNextEntry(zipEntry);  
            			//读取待压缩的文件并写进压缩包里  
            			fis = new FileInputStream(sourceFile);  
            			bis = new BufferedInputStream(fis, 1024*10);  
            			int read = 0;  
            			while((read=bis.read(bufs, 0, 1024*10)) != -1){  
            				zos.write(bufs,0,read);  
            			}  
            		}
            	}
            	flag = true;
            } catch (FileNotFoundException e) {  
	            e.printStackTrace();  
	            throw new RuntimeException(e);  
	        } catch (IOException e) {  
	            e.printStackTrace();  
	            throw new RuntimeException(e);  
	        } finally{  
	            //关闭流  
	            try {  
	                if(null != bis) bis.close();  
	                if(null != zos) zos.close();  
	            } catch (IOException e) {  
	                e.printStackTrace();  
	                throw new RuntimeException(e);  
	            }  
	        }  
	    }  
        return flag;  
    }
    
//    public static void main(String[] args){
//    	filesToZip("D:/zjnote/11月考勤报表.xls,D:/zjnote/CIMC_News.txt,D:/zjnote/file-analysis.jsp",
//    			",", "D:/zjnote/test160107002.zip");
//    	
//    	filesToZip(new String[]{"D:/zjnote/11月考勤报表.xls","D:/zjnote/CIMC_News.txt","D:/zjnote/file-analysis.jsp"},
//    			"D:/zjnote/test160107004.zip");
//    	List<String> list = new ArrayList<String>();
//    	list.add("D:/zjnote/11月考勤报表.xls");
//    	list.add("D:/zjnote/CIMC_News.txt");
//    	list.add("D:/zjnote/file-analysis.jsp");
//    	filesToZip(list, "D:/zjnote/test160107005.zip");
//    }
    
}
