package com.chori.springbootbatch;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobParameter;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.time.ZonedDateTime;
import java.util.HashMap;
import java.util.Map;

@Controller
public class JobLauncherController {

    @Autowired
    JobLauncher jobLauncher;

    @Autowired
    Job job;

    @RequestMapping("/jobLauncher.html")
    public void handle() throws Exception{
        Map<String, JobParameter> parameter = new HashMap<>();
        parameter.put("time", new JobParameter(ZonedDateTime.now().toString()));
        jobLauncher.run(job, new JobParameters(parameter));
    }
}