package ReuseComp.TestUtils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;
import java.util.zip.GZIPOutputStream;
public class Zipping_File {
	
	public static void zipFile(String sourceFilePath, String zipFilePath) {
	    try {
	        FileOutputStream fos = new FileOutputStream(zipFilePath);
	        ZipOutputStream zipOut = new ZipOutputStream(fos);
	        File fileToZip = new File(sourceFilePath);

	        FileInputStream fis = new FileInputStream(fileToZip);
	        ZipEntry zipEntry = new ZipEntry(fileToZip.getName());
	        zipOut.putNextEntry(zipEntry);

	        byte[] bytes = new byte[1024];
	        int length;
	        while ((length = fis.read(bytes)) >= 0) {
	            zipOut.write(bytes, 0, length);
	        }

	        fis.close();
	        zipOut.close();
	        fos.close();
	    } catch (IOException e) {
	        e.printStackTrace();
	    }
	}

}
//public static void zipFile(String sourceFilePath, String zipFilePath) {
//	   {
//
//	        try {
//	            FileInputStream fis = new FileInputStream(sourceFilePath);
//	            FileOutputStream fos = new FileOutputStream(zipFilePath);
//	            GZIPOutputStream gzipOS = new GZIPOutputStream(fos);
//
//	            byte[] buffer = new byte[1024];
//	            int len;
//	            while ((len = fis.read(buffer)) != -1) {
//	                gzipOS.write(buffer, 0, len);
//	            }
//
//	            gzipOS.close();
//	            fos.close();
//	            fis.close();
//
//	            System.out.println("File compressed successfully.");
//	        } catch (IOException e) {
//	            e.printStackTrace();
//	        }
//	    }
//	}