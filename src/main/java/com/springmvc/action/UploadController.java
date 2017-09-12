package com.springmvc.action;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

@Controller
public class UploadController {

    @RequestMapping(value = "/file", method = RequestMethod.POST)
    @ResponseBody
    public Object uploadFile(@RequestParam(value = "file") MultipartFile file) {
        if (null == file) {
            return "file is null";
        }

        return null;
    }
}
