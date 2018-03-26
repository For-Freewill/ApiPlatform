package cn.springmvc.utils;

import java.io.BufferedInputStream;  
import java.io.BufferedOutputStream;  
import java.io.File;  
import java.io.FileInputStream;  
import java.io.FileOutputStream;  
import java.io.IOException;  
import java.io.InputStream;  
import java.io.OutputStream;  
import java.util.ArrayList;  
import java.util.List;  
  
import org.apache.commons.compress.archivers.ArchiveEntry;  
import org.apache.commons.compress.archivers.zip.Zip64Mode;  
import org.apache.commons.compress.archivers.zip.ZipArchiveEntry;  
import org.apache.commons.compress.archivers.zip.ZipArchiveInputStream;  
import org.apache.commons.compress.archivers.zip.ZipArchiveOutputStream;  
  
public class ZipUtil {  
  
    public static void main(String[] args) {  
  
        String dir = "D:\\data\\datanew2\\apitest\\report-output";  
        String zippath = "D:\\data\\datanew2\\apitest\\report-output\\test2.zip";  
        ZipUtil.zip(dir, zippath);  
//   
//        String unzipdir = "D:\\test2";  
//        String unzipfile = "D:\\test2.zip";  
//        ZipUtil.unzip(unzipfile, unzipdir);  
          
        System.out.println("success!");  
    }   
    /** 
     * zip压缩文件 
     * @param dir 
     * @param zippath 
     */  
    public static void zip(String dir ,String zippath){  
        List<String> paths = getFiles(dir);   
        compressFilesZip(paths.toArray(new String[paths.size()]),zippath,dir);  
    }  
    /** 
     * 递归取到当前目录�?有文�? 
     * @param dir 
     * @return 
     */  
    public static List<String> getFiles(String dir){  
        List<String> lstFiles = null;       
        if(lstFiles == null){  
            lstFiles = new ArrayList<String>();  
        }  
        File file = new File(dir);  
        File [] files = file.listFiles();   
        for(File f : files){  
            if(f.isDirectory()){  
                lstFiles.add(f.getAbsolutePath());  
                lstFiles.addAll(getFiles(f.getAbsolutePath()));  
            }else{   
                String str =f.getAbsolutePath();  
                lstFiles.add(str);  
            }  
        }  
        return lstFiles;  
    }  
      
    /** 
     * 文件名处�? 
     * @param dir 
     * @param path 
     * @return 
     */  
    public static String getFilePathName(String dir,String path){  
        String p = path.replace(dir+File.separator, "");  
        p = p.replace("\\", "/");  
        return p;  
    }  
    /** 
     * 把文件压缩成zip格式 
     * @param files         �?要压缩的文件 
     * @param zipFilePath 压缩后的zip文件路径   ,�?"D:/test/aa.zip"; 
     */  
    public static void compressFilesZip(String[] files,String zipFilePath,String dir) {  
        if(files == null || files.length <= 0) {  
            return ;  
        }  
        ZipArchiveOutputStream zaos = null;  
        try {  
            File zipFile = new File(zipFilePath);  
            zaos = new ZipArchiveOutputStream(zipFile);  
            zaos.setUseZip64(Zip64Mode.AsNeeded);  
            //将每个文件用ZipArchiveEntry封装  
            //再用ZipArchiveOutputStream写到压缩文件�?  
            for(String strfile : files) {  
                File file = new File(strfile);  
                if(file != null) {  
                    String name = getFilePathName(dir,strfile);  
                    ZipArchiveEntry zipArchiveEntry  = new ZipArchiveEntry(file,name);  
                    zaos.putArchiveEntry(zipArchiveEntry);  
                    if(file.isDirectory()){  
                        continue;  
                    }  
                    InputStream is = null;  
                    try {  
                        is = new BufferedInputStream(new FileInputStream(file));  
                        byte[] buffer = new byte[1024 ];   
                        int len = -1;  
                        while((len = is.read(buffer)) != -1) {  
                            //把缓冲区的字节写入到ZipArchiveEntry  
                            zaos.write(buffer, 0, len);  
                        }  
                        zaos.closeArchiveEntry();   
                    }catch(Exception e) {  
                        throw new RuntimeException(e);  
                    }finally {  
                        if(is != null)  
                            is.close();  
                    }  
                       
                }  
            }  
            zaos.finish();  
        }catch(Exception e){  
            throw new RuntimeException(e);  
        }finally {  
                try {  
                    if(zaos != null) {  
                        zaos.close();  
                    }  
                } catch (IOException e) {  
                	e.printStackTrace();
                    throw new RuntimeException(e);  
                }  
        }  
           
    }  
      
     
    /** 
    * 把zip文件解压到指定的文件�? 
    * @param zipFilePath zip文件路径, �? "D:/test/aa.zip" 
    * @param saveFileDir 解压后的文件存放路径, �?"D:/test/" () 
    */  
    public static void unzip(String zipFilePath, String saveFileDir) {  
        if(!saveFileDir.endsWith("\\") && !saveFileDir.endsWith("/") ){  
            saveFileDir += File.separator;  
        }  
        File dir = new File(saveFileDir);  
        if(!dir.exists()){  
            dir.mkdirs();  
        }  
        File file = new File(zipFilePath);  
        if (file.exists()) {  
            InputStream is = null;   
            ZipArchiveInputStream zais = null;  
            try {  
                is = new FileInputStream(file);  
                zais = new ZipArchiveInputStream(is);  
                ArchiveEntry archiveEntry = null;  
                while ((archiveEntry = zais.getNextEntry()) != null) {   
                    // 获取文件�?  
                    String entryFileName = archiveEntry.getName();  
                    // 构�?�解压出来的文件存放路径  
                    String entryFilePath = saveFileDir + entryFileName;  
                    OutputStream os = null;  
                    try {  
                        // 把解压出来的文件写到指定路径  
                        File entryFile = new File(entryFilePath);  
                        if(entryFileName.endsWith("/")){  
                            entryFile.mkdirs();  
                        }else{  
                            os = new BufferedOutputStream(new FileOutputStream(  
                                    entryFile));                              
                            byte[] buffer = new byte[1024 ];   
                            int len = -1;   
                            while((len = zais.read(buffer)) != -1) {  
                                os.write(buffer, 0, len);   
                            }  
                        }  
                    } catch (IOException e) {  
                        throw new IOException(e);  
                    } finally {  
                        if (os != null) {  
                            os.flush();  
                            os.close();  
                        }  
                    }  
  
                }   
            } catch (Exception e) {  
                throw new RuntimeException(e);  
            } finally {  
                try {  
                    if (zais != null) {  
                        zais.close();  
                    }  
                    if (is != null) {  
                        is.close();  
                    }  
                } catch (IOException e) {  
                    throw new RuntimeException(e);  
                }  
            }  
        }  
    }  
}  

