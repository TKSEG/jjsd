package com.nari.jjsd.business.controller;

import com.nari.jjsd.business.service.WorkflowService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by yangbo on 2019/2/25.
 */
@Controller
@RequestMapping("/flow")
public class FlowController {
    private static final Logger logger = LoggerFactory.getLogger(FlowController.class);

    @Autowired
   private WorkflowService workflowService;

}
