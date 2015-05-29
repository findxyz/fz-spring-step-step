package com.commonio;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.IOUtils;
import org.apache.log4j.Logger;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;

/**
 * Created by Administrator on 2015-5-29.
 */
public class CommonIoMain {

    private static final Logger logger = Logger.getLogger(CommonIoMain.class);

    public static void main(String[] args) throws IOException {
        FileUtils.writeStringToFile(new File("commonio-test.txt"), "I am ≤‚ ‘ txt, Œ“µƒ encoding  « utf-8", "utf-8");
        String content = FileUtils.readFileToString(new File("commonio-test.txt"), "utf-8");
        logger.info(content);

        String baiduHtml;
        InputStream in = null;
        try {
            in = new URL("http://www.baidu.com").openStream();
            baiduHtml = IOUtils.toString(in, "utf-8");
            logger.info(baiduHtml);
            FileUtils.writeStringToFile(new File("baiduHtml.html"), baiduHtml, "utf-8");
        } finally {
            if(in != null){
                IOUtils.closeQuietly(in);
            }
        }
    }
}
