package com.example.mycamunda;

import lombok.extern.slf4j.Slf4j;
import org.camunda.bpm.engine.ProcessEngine;
import org.camunda.bpm.engine.RepositoryService;
import org.camunda.bpm.engine.repository.DeploymentWithDefinitions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import javax.sql.DataSource;

@Slf4j
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.NONE)
class MyCamundaApplicationTests {

    @Resource
    private DataSource dataSource;

    @Resource
    private RepositoryService repositoryService;

    @Resource
    private ProcessEngine processEngine;

    @Test
    void contextLoads() {
        /*DeploymentWithDefinitions deploymentWithDefinitions = processEngine.getRepositoryService()
                .createDeployment()
                .addClasspathResource("static/diagram_2.bpmn")
                .name("lgh2")
                .deployWithResult();*/
        processEngine.getRepositoryService().createDeploymentQuery().list().forEach(e->{
            log.info(e.);
        });
        log.info(processEngine.getHistoryService().getClass().getName());
        log.info(repositoryService.getClass().getName());
    }
}
