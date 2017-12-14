package com.luxoft.mapetrenko.sboot.controller;

import com.luxoft.mapetrenko.sboot.service.DataService;
import com.luxoft.mapetrenko.sboot.utils.Ajax;
import com.luxoft.mapetrenko.sboot.utils.RestException;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Map;
import java.util.Set;

@Controller
public class DataController {
    public static final Logger LOG = Logger.getLogger(DataController.class);

    @Autowired
    @Qualifier("dataService")
    private DataService dataService;

    @RequestMapping(value = "/data", method = RequestMethod.GET)
    public @ResponseBody
    Map<String, Object> getRandomData() throws RestException {
        try {
            Set<String> result = dataService.getRandomData();
            return Ajax.successResponse(result);
        } catch(Exception e) {
            throw new RestException(e);
        }
    }

    @RequestMapping(value = "/data", method = RequestMethod.POST)
    public @ResponseBody
    Map<String, Object> persist(@RequestParam("data") String data) throws RestException {
        if (data == null || data.equals("")) {
            return Ajax.emptyResponse();
        }

        try {
            dataService.persist(data);
            return Ajax.emptyResponse();
        } catch (Exception e) {
            throw new RestException(e);
        }
    }
}
