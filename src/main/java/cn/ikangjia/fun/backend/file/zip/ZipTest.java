package cn.ikangjia.fun.backend.file.zip;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

/**
 * @author kangJia
 * @email ikangjia.cn@outlook.com
 * @since 2022/9/20 14:47
 */
public class ZipTest {
    public static void main(String[] args) throws IOException {
        // 假设这是一堆要打包成 zip 的文件
        List<File> fileList = new ArrayList<>();

        File zipFile = new File("demo.zip");

        try (ZipOutputStream zos = new ZipOutputStream(new FileOutputStream(zipFile))){
            for (File file : fileList) {
                if (!file.exists()) {
                    continue;
                }
                zos.putNextEntry(new ZipEntry(file.getName()));
                InputStream fis = new FileInputStream(file);
                int length;
                byte[] b = new byte[1024];
                while ((length = fis.read(b)) != -1) {
                    zos.write(b, 0, length);
                }
                fis.close();
                zos.closeEntry();
            }
        }
    }
}
