package cn.ikangjia.fun.backend.file.download;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.nio.charset.StandardCharsets;

/**
 * @author kangJia
 * @email ikangjia.cn@outlook.com
 * @since 2022/9/20 11:08
 */
@Controller
public class DownController {

    @PostMapping("/download")
    public void download(String xxx, HttpServletResponse response) throws IOException {
        // 业务操作 xxx
        // 一通操作，最后要下载的文件为 demo.zip
        String fileName = "demo.zip";
        File file = new File(fileName);

        // 设置 response 的一些参数
        response.setCharacterEncoding("utf-8");
        response.setContentType("multipart/form-data");
        response.setHeader("Content-Disposition", "attachment;fileName=" + fileName);
        // 使用输出流
        try (OutputStream os = response.getOutputStream();
             InputStream is = new FileInputStream(file)) {
            byte[] b = new byte[1024];
            int length;
            while ((length = is.read(b)) > 0) {
                os.write(b, 0, length);
            }
        }

    }
}
