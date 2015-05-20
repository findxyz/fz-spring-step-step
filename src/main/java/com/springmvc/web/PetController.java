package com.springmvc.web;

import com.springmvc.model.Dog;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.WebApplicationContext;

import java.util.Map;

/**
 * Created by fz on 2015-5-18.
 */
@Controller
@RequestMapping("/pets")
@Scope(WebApplicationContext.SCOPE_REQUEST)
public class PetController {

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
        return species + params; // zangao{species=zangao, b=2, a=1}
    }

}
