package com.utils;

import org.apache.log4j.Logger;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.math.BigInteger;

/**
 * Created by Administrator on 2015-3-31.
 */
public class HtmlDecode {

    private static Logger logger = Logger.getLogger(HtmlDecode.class);

    public static String hexStr4Xml(String s) throws UnsupportedEncodingException {
        StringBuffer sb = new StringBuffer();
        String[] sp = s.split("");
        for(int i=1; i<sp.length; i++){
            String hexS = String.format("%x", new BigInteger(1, sp[i].getBytes("utf-8")));
            String[] hexSp = hexS.split("");
            for(int j=1; j<hexSp.length; j+=2){
                sb.append("&#x").append(hexSp[j]).append(hexSp[j+1]).append(";");
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) throws UnsupportedEncodingException {
        /*
            js encodeURIComponent || java.net.URLEncoder.encode(s, enc)
            &#x3c;&#x73;&#x63;&#x72;&#x69;&#x70;&#x74;&#x3e;&#x61;&#x6c;&#x65;&#x72;&#x74;&#x28;&#x31;&#x29;&#x3c;&#x2f;&#x73;&#x63;&#x72;&#x69;&#x70;&#x74;&#x3e;
            ->
            %26%23x3c%3B%26%23x73%3B%26%23x63%3B%26%23x72%3B%26%23x69%3B%26%23x70%3B%26%23x74%3B%26%23x3e%3B%26%23x61%3B%26%23x6c%3B%26%23x65%3B%26%23x72%3B%26%23x74%3B%26%23x28%3B%26%23x31%3B%26%23x29%3B%26%23x3c%3B%26%23x2f%3B%26%23x73%3B%26%23x63%3B%26%23x72%3B%26%23x69%3B%26%23x70%3B%26%23x74%3B%26%23x3e%3B
        */
        logger.info("===== js encodeURIComponent || java.net.URLEncoder.encode(s, enc) =====");
        String s = "&#x3c;&#x73;&#x63;&#x72;&#x69;&#x70;&#x74;&#x3e;&#x61;&#x6c;&#x65;&#x72;&#x74;&#x28;&#x31;&#x29;&#x3c;&#x2f;&#x73;&#x63;&#x72;&#x69;&#x70;&#x74;&#x3e;";
        logger.info(java.net.URLEncoder.encode(s, "UTF-8"));
        logger.info("===== =====");

        /*
            js decodeURIComponent || java.net.URLDecoder.decode(s, enc)
            %26%23x3c%3B%26%23x73%3B%26%23x63%3B%26%23x72%3B%26%23x69%3B%26%23x70%3B%26%23x74%3B%26%23x3e%3B%26%23x61%3B%26%23x6c%3B%26%23x65%3B%26%23x72%3B%26%23x74%3B%26%23x28%3B%26%23x31%3B%26%23x29%3B%26%23x3c%3B%26%23x2f%3B%26%23x73%3B%26%23x63%3B%26%23x72%3B%26%23x69%3B%26%23x70%3B%26%23x74%3B%26%23x3e%3B
            ->
            &#x3c;&#x73;&#x63;&#x72;&#x69;&#x70;&#x74;&#x3e;&#x61;&#x6c;&#x65;&#x72;&#x74;&#x28;&#x31;&#x29;&#x3c;&#x2f;&#x73;&#x63;&#x72;&#x69;&#x70;&#x74;&#x3e;
        */
        logger.info("===== js decodeURIComponent || java.net.URLDecoder.decode(s, enc) =====");
        String s2 = "%26%23x3c%3B%26%23x73%3B%26%23x63%3B%26%23x72%3B%26%23x69%3B%26%23x70%3B%26%23x74%3B%26%23x3e%3B%26%23x61%3B%26%23x6c%3B%26%23x65%3B%26%23x72%3B%26%23x74%3B%26%23x28%3B%26%23x31%3B%26%23x29%3B%26%23x3c%3B%26%23x2f%3B%26%23x73%3B%26%23x63%3B%26%23x72%3B%26%23x69%3B%26%23x70%3B%26%23x74%3B%26%23x3e%3B";
        logger.info(java.net.URLDecoder.decode(s2, "UTF-8"));
        logger.info("===== =====");

        /*
            js encodeURI || java.net.URLEncoder.encode(s, enc)
            aaa中国 -> aaa%E4%B8%AD%E5%9B%BD
        */
        logger.info("===== js encodeURI || java.net.URLEncoder.encode(s, enc) =====");
        logger.info(java.net.URLEncoder.encode("aaa中国", "UTF-8"));
        logger.info("===== =====");

        /*
            java.net.URLDecoder.decode(s, enc) || js decodeURI
            aaa%E4%B8%AD%E5%9B%BD -> aaa中国
        */
        logger.info("===== java.net.URLDecoder.decode(s, enc) || js decodeURI =====");
        logger.info(java.net.URLDecoder.decode("aaa%E4%B8%AD%E5%9B%BD", "UTF-8"));
        logger.info("===== =====");

        // xml encode 4 unicode
        String s3 = "<script>alert(1)</script>";
        logger.info(s3.getBytes("utf-8"));
        logger.info(new BigInteger(1, s3.getBytes("utf-8")));
        // hex str
        logger.info(String.format("%x", new BigInteger(1, s3.getBytes("utf-8"))));
        logger.info(String.format("&#x%x;", new BigInteger(1, s3.getBytes("utf-8"))));

        String[] sp = s3.split("");
        /*
        for(int m=1; m<sp.length; m++){
            logger.info(sp[m]);
        }
        */
        StringBuffer sb = new StringBuffer();
        for(int i=1; i<sp.length; i++){
            String hexS = String.format("%x", new BigInteger(1, sp[i].getBytes("utf-8")));
            String[] hexSp = hexS.split("");
            for(int j=1; j<hexSp.length; j+=2){
                sb.append("&#x").append(hexSp[j]).append(hexSp[j+1]).append(";");
            }
        }
        logger.info(sb.toString());

        hexStr4Xml("<script>alert(1)</script>");

        logger.info(String.format("%x", new BigInteger(1, "aaa中国".getBytes("latin1"))).toUpperCase());
    }
}
