package com.springmvc.action;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping(value = "/mp")
public class TestMethodMapping {

    @RequestMapping(value = "/t1", method = RequestMethod.GET)
    @ResponseBody
    public String test(@RequestParam(defaultValue = "1") int pageNum, @RequestParam("ps") int pageSize,
                       @RequestParam String rpStr, String tagName, @RequestParam Long userId, @RequestParam int intId) {
        return pageNum + "_" + pageSize + "_" + rpStr + "_" + tagName;
    }
}
