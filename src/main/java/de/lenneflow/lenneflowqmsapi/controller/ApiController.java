package de.lenneflow.lenneflowqmsapi.controller;

import de.lenneflow.lenneflowqmsapi.component.QueueController;
import de.lenneflow.lenneflowqmsapi.dto.FunctionDTO;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api/qms")
@EnableAsync
public class ApiController {

    private final QueueController queueController;

    public ApiController(QueueController queueController) {
        this.queueController = queueController;
    }


    @PostMapping("/callback/{executionId}/{stepInstanceId}/{workflowInstanceId}")
    @Async
    public void workerCallBack(@RequestBody Map<String, Object> payload, @PathVariable String executionId, @PathVariable String stepInstanceId, @PathVariable String workflowInstanceId){
        FunctionDTO functionDTO = new FunctionDTO();
        functionDTO.setExecutionId(executionId);
        functionDTO.setStepInstanceId(stepInstanceId);
        functionDTO.setWorkflowInstanceId(workflowInstanceId);
        functionDTO.setOutputData(payload);
        queueController.addFunctionDtoToResultQueue(functionDTO);

    }
}
