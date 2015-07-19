package com.springmvc.web;

import com.springmvc.model.Dog;
import com.springmvc.utils.Const;
import com.springmvc.utils.MyProgressListener;
import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.request.async.DeferredResult;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.method.annotation.MvcUriComponentsBuilder;
import org.springframework.web.util.UriComponents;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.io.Writer;
import java.net.URI;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Callable;

/**
 * Created by fz on 2015-5-18.
 */
@Controller
@RequestMapping("/pets")
@Scope(WebApplicationContext.SCOPE_REQUEST)
public class PetController {

    private static final Logger logger = Logger.getLogger(PetController.class);

    /*
    * http://localhost:8080/pets/testDogs/1
    * */
    @RequestMapping(value="/testDogs/{dogId}", method=RequestMethod.GET)
    @ResponseBody
    public String findDog(@PathVariable String dogId) {
        UriComponents uriComponents = MvcUriComponentsBuilder
                .fromMethodName(PetController.class, "findDog", "21").buildAndExpand();
        URI uri = uriComponents.encode().toUri();

        logger.info(uri);
        String result = "<h1 style='color: red;'>" + dogId + "</h1>";
        System.out.println(result); // <h1 style='color: red;'>1</h1>
        return result;
    }

    /*
    * http://localhost:8080/pets/dogs/1;species=hashiqi
    * */
    @RequestMapping(value="/dogs/{dogId}", method=RequestMethod.GET)
    @ResponseBody
    public String findDog(@PathVariable String dogId,
                        @MatrixVariable(
                            required = false,
                            defaultValue = "dog",
                            value = "species",
                            pathVar = "dogId"
                        ) String species) {
        String result = "<h1 style='color: red;'>" + dogId + "," + species + "</h1>";
        System.out.println(result); // <h1 style='color: red;'>1,hashiqi</h1>
        return result;
    }

    /*
        $.ajax({
            method: "POST",
            url: "http://localhost:8080/pets/dogs/species/jinba?a=1&b=2",
            data: JSON.stringify({ name: "qiuqiu", species: "jinba" }),
            data: { name: "qiuqiu", species: "jinba" },
            contentType: "application/json; charset=UTF-8",
            success: function(data) {
                console.log(data);
            }
        });
    */
    @RequestMapping(value="/dogs/species/*", method=RequestMethod.POST, consumes="application/json; charset=UTF-8")
    @ResponseBody
    public Dog findDog(/* @RequestBody String dogJson */
                        @RequestBody Dog dog, @RequestParam Map params){
        System.out.println(dog.getId() + "," + dog.getName() + "," + dog.getSpecies());
        System.out.println(params);
        return dog;
    }

    @RequestMapping(value="/dogs2/species/*", method=RequestMethod.POST, consumes="application/json; charset=UTF-8")
    @ResponseBody
    public Map findDog2(@RequestBody Map dog, @RequestParam Map params){
        System.out.println(dog.get("id") + "," + dog.get("name") + "," + dog.get("species"));
        System.out.println(params);
        return dog;
    }

    @RequestMapping(value="/dogs3/species/*", method=RequestMethod.POST, consumes="application/json; charset=UTF-8")
    @ResponseBody
    public String findDog3(@RequestBody String dogJson, @RequestParam Map params, HttpServletRequest request){
        System.out.println(dogJson);
        System.out.println(params);
        System.out.println(params.get("name"));
        System.out.println(request.getParameter("name"));
        return dogJson;
    }

    /*
        contentType
            1.application/json; charset=UTF-8
                ���������json�ַ���{a=1, b=2}����@RequestBody����ͨ��spring mvc��convertת������Ӧ�Ķ������Map��@RequestParam��HttpServletRequest�޷���ȡ����
                ��������ǲ�����a=1&b=2������޷�ͨ��convertת��Ϊ�����Map����ת������ͬ����@RequestParam��HttpServletRequest�޷���ȡ����
            2.application/x-www-form-urlencoded;charset=UTF-8
                ��������ǲ�����a=1&b=2����@RequestBody����֧��ת��Ϊ�����Map��������@RequestParam��HttpServletRequest������ȷ��ȡ���������Ĳ���
            ע��1��2�����@RequestBody��������String����Գɹ�ת��������������ַ�����û�н��н��������ַ�����������ʹ�ã���������ʹ�÷������岻��
            3.multipart/form-data
                ��������ǲ�����a=1&b=2������Ϊ����û���ļ����Ͷ��⵽�ܾ�
    */
    @RequestMapping(value="/dogs4/species/*", method=RequestMethod.POST)
    @ResponseBody
    public String findDog4(@RequestBody String dog, @RequestParam Map params, HttpServletRequest request){
        System.out.println(dog);
        System.out.println(params);
        System.out.println(request.getParameterMap());
        return dog;
    }

    /*
        $.ajax({
          method: 'POST',
          url: 'http://localhost:8080/pets/dogs/species/zangao?species=zangao&a=1&b=2',
          data: JSON.stringify({
            name: 'aoao',
            species: 'zangao'
          }),
          contentType: 'application/json; charset=UTF-8',
          success: function (data) {
            console.log(data);
          }
        });
    */
    @RequestMapping(value="/dogs/species/zangao", method=RequestMethod.POST, params="species=zangao")
    @ResponseBody
    public String findZangao(@RequestParam(value="species") String species, @RequestParam Map params){
        return species + params; // zangao{species=zangao, b=2, a=1}
    }

    /*
        $.ajax({
          method: 'POST',
          url: 'http://localhost:8080/pets/dogs/species/muyangquan?species=muyangquan&a=1&b=2',
          data: JSON.stringify({
            name: 'mumu',
            species: 'muyangquan'
          }),
          contentType: 'application/json; charset=UTF-8',
          success: function (data) {
            console.log(data);
          }
        });
    */
    @RequestMapping(value="/dogs/species/muyangquan", method=RequestMethod.POST, params={"species=muyangquan", "b", "a"})
    @ResponseBody
    public String findMuyangquan(@RequestParam(value="species") String species, @RequestParam Map params){
        return species + params; // muyangquan{species=muyangquan, b=2, a=1}
    }

    @RequestMapping(value="/tomcat", method=RequestMethod.PUT)
    public void handle(@RequestBody String body, Writer writer) throws IOException {
        writer.write(body);
    }

    @RequestMapping(value="/tomdog", method=RequestMethod.GET)
    @ResponseBody
    public Map helloWorld() {
        Map message = new HashMap();
        message.put("HelloWorld", "�й�");
        return message;
    }

    @RequestMapping(value="/tomerror")
    @ResponseBody
    public Map tomerror() {
        int i = 1/0;
        Map message = new HashMap();
        message.put("HelloWorld", "�й�");
        return message;
    }

    @RequestMapping("/tomjsonp")
    @ResponseBody
    public Map jsonp(@RequestParam Map params, @RequestBody Map paramsBody){
        Map map = new HashMap();
        map.put("a", 1);
        map.put("b", 2);
        logger.info(params);
        logger.info(paramsBody);
        map.putAll(params);
        return map;
    }

    /*
        If returnType is String , jsonp will return string directly , not wrap to jsonp
        In this example , the result is ```Hello{callback=giveme5}```
    */
    @RequestMapping("/tomjsonp2")
    @ResponseBody
    public String callback(@RequestParam Map params){
        String data = "Hello" + params.toString();
        return data;
    }

    @RequestMapping(value="/tomcallable", method=RequestMethod.POST)
    @ResponseBody
    public Callable<String> processUpload(final MultipartFile file) throws IOException {

        return new Callable<String>() {
            public String call() throws Exception {
                String fileName = file.getOriginalFilename();
                String fileSuffix = fileName.substring(fileName.lastIndexOf("."));
                FileUtils.writeByteArrayToFile(new File(Const.uploadPath + System.currentTimeMillis() + fileSuffix), file.getBytes());
                return "upload success";
            }
        };
    }

    @RequestMapping(value="/tomdeferredResult")
    @ResponseBody
    public DeferredResult getMessages(){
        String message = "The message";
        final DeferredResult deferredResult = new DeferredResult();
        deferredResult.setResult(message);
        deferredResult.onCompletion(new Runnable() {
            @Override
            public void run() {
                logger.info(deferredResult.getResult());
            }
        });
        return deferredResult;
    }

    @RequestMapping(value="/tomupload", method=RequestMethod.POST)
    @ResponseBody
    public Callable<String> uploadWithProgressBar(@RequestParam("files") final MultipartFile[] files, HttpServletRequest request){

        return new Callable<String>() {
            @Override
            public String call() throws Exception {
                for(MultipartFile file : files){
                    String fileName = file.getOriginalFilename();
                    String fileSuffix = fileName.substring(fileName.lastIndexOf("."));
                    FileUtils.writeByteArrayToFile(new File(Const.uploadPath + System.currentTimeMillis() + fileSuffix), file.getBytes());
                }
                return "upload success";
            }
        };
    }

    @RequestMapping(value="/tomupload/progress")
    @ResponseBody
    public Map getUploadProgress(HttpServletRequest request){
        Map result = new HashMap();
        MyProgressListener myProgressListener = (MyProgressListener)request.getSession().getAttribute("ProgressListener_" + request.getParameter("upload_key"));
        result.put("percentDone", myProgressListener.getPercentDone());
        result.put("doneFlag", false);
        result.put("itemsIndex", myProgressListener.getItems());
        if(myProgressListener.isFinished()){
            request.getSession().removeAttribute("ProgressListener_" + request.getParameter("upload_key"));
            result.put("doneFlag", true);
        }
        return result;
    }

    @RequestMapping("/upload")
    public String uploadJsp(){
        return "jsp/upload/CallableUpload";
    }

}
