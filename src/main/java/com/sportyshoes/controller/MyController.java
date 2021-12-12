package com.sportyshoes.controller;


import java.util.Base64;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.sportyshoes.model.MyModel;
import com.sportyshoes.service.MyService;

/**
 *
 * @author Vasu Rajput
 */
@Controller
public class MyController {

    private static final Logger logger = LoggerFactory.getLogger("MyController.class");
    @Autowired
    private MyService myService;
    /*
    @GetMapping("/")
    public String test() {
        return "index";
    }
	*/
    @PostMapping("/fileupload")
    public String fileUpload(@RequestParam("name") String name, @RequestParam("file") MultipartFile file) {
        try {
            logger.info("Name= " + name);
            byte[] image = file.getBytes();
            MyModel model = new MyModel(name, image);
            int saveImage = myService.saveImage(model);
            if (saveImage == 1) {
                return "success";
            } else {
                return "error";
            }
        } catch (Exception e) {
            logger.error("ERROR", e);
            return "error";
        }
    }

    @GetMapping("/getDetail/{id}")
    public String getDbDetils(@PathVariable String id, Model model) {
        try {
            logger.info("Id= " + id);
            MyModel imagesObj = myService.getImages(Long.parseLong(id));
            model.addAttribute("id", imagesObj.getId());
            model.addAttribute("name", imagesObj.getName());
            byte[] encode = java.util.Base64.getEncoder().encode(imagesObj.getImage());
            model.addAttribute("image", new String(encode, "UTF-8"));
            return "imagedetails";
        } catch (Exception e) {
            logger.error("Error", e);
            model.addAttribute("message", "Error in getting image");
            return "redirect:/";
        }
    }
}
