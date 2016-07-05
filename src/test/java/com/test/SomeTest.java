package com.test;

import com.utils.security.RSAUtil;
import org.apache.commons.codec.binary.Base64;

/**
 * Created by fz on 2016/7/4.
 */
public class SomeTest {

    private static final String pubKey = "MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQC2itOch1JPLwPt/qY90LZ4FaG9/iq5Ioch5SVgogOCIsFN3B1BWXbKuAThs/O6QEOp6zFfqilZCum8+q2RmQwaDZ0tZnuTsyI/7okpmfh1KnqIbOAAmCylFvYhSQ0pKm24LQqFnaq3yvySAptLFxLkoBGrFuFiFwf9Uvk+caviHQIDAQAB";

    private static final String priKey = "MIICdQIBADANBgkqhkiG9w0BAQEFAASCAl8wggJbAgEAAoGBALaK05yHUk8vA+3+pj3QtngVob3+KrkihyHlJWCiA4IiwU3cHUFZdsq4BOGz87pAQ6nrMV+qKVkK6bz6rZGZDBoNnS1me5OzIj/uiSmZ+HUqeohs4ACYLKUW9iFJDSkqbbgtCoWdqrfK/JICm0sXEuSgEasW4WIXB/1S+T5xq+IdAgMBAAECgYAuh2pzDqczWdeVlYBIZ2frahAlPqEjOaLaR+9kF0fvpu5A62dlnelCuO89nMH2aqUUrceTC+uoL7jum7McVreXigh9A4q5FEkKcVO54TEzUO6lbLHhfMd4TPWmR88VAODT7StmymMDb0yNCPJKvLO/xgNp57Mk1w4gWnjrPpOW3QJBAOb+iOpvpRXr1+9GYhie2qq60bvBCneSKwnSsvrujs1XpYDyrD2NxJGWzqQMolhLzMG5uesaYrC0/iGI0prjjxsCQQDKTY77xGL5jsHyoXPVWAB/oHnweALCmh+Bj7JTIAvf6o265FAF3l3VbzK2Hi4poTfuekVRRrigf1sSN+xYQ48nAj83Cm+VbQTpNEk/uoWlWDTCecF/+3+C/lFDBfGf2TgttbS6BRkFkcJE7qpObLRCVc10W8zxOFhLwtTLKM8GGTMCQQCk+gzhim0AgQfvWvUAhayaZ/8pOGVf15pb6RiOq3Kjnz8Hq0sLDiVNekpLtF8G+f+HzlSbDGZiFJnrSInIDQg/AkAb6fBVMkVdkjE14jQZhkI+ULeoHc0U7wZvRHSYoCnRR79DquNlMK7WrK7N0x7s0FMTD+vkcdawea6G0rp/RziI";

    public static void main(String[] args) throws Exception {

        String originData = "原始数据";

        // 签名验证
        String sign = RSAUtil.sign(originData.getBytes("utf-8"), priKey);
        System.out.println(RSAUtil.verify(originData.getBytes("utf-8"), pubKey, sign));

        String base64PriEncryptData = Base64.encodeBase64String(RSAUtil.encryptByPrivateKey(originData.getBytes("utf-8"), priKey));
        // 私匙加密
        System.out.println(base64PriEncryptData);
        // 公匙解密
        System.out.println(new String(RSAUtil.decryptByPublicKey(Base64.decodeBase64(base64PriEncryptData), pubKey), "utf-8"));

        String base64PubEncryptData = Base64.encodeBase64String(RSAUtil.encryptByPublicKey(originData.getBytes("utf-8"), pubKey));
        // 公匙加密
        System.out.println(base64PubEncryptData);
        // 私匙解密
        System.out.println(new String(RSAUtil.decryptByPrivateKey(Base64.decodeBase64(base64PubEncryptData), priKey), "utf-8"));
    }
}
