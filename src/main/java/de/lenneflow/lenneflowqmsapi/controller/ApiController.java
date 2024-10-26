package de.lenneflow.lenneflowqmsapi.controller;

import de.lenneflow.lenneflowqmsapi.component.QueueController;
import de.lenneflow.lenneflowqmsapi.dto.FunctionDTO;
import de.lenneflow.lenneflowqmsapi.dto.FunctionPayload;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.web.bind.annotation.*;

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
    public void workerCallBack(@RequestBody FunctionPayload payload, @PathVariable String executionId, @PathVariable String stepInstanceId, @PathVariable String workflowInstanceId){
        FunctionDTO functionDTO = new FunctionDTO();
        functionDTO.setExecutionId(executionId);
        functionDTO.setStepInstanceId(stepInstanceId);
        functionDTO.setWorkflowInstanceId(workflowInstanceId);
        functionDTO.setOutputData(payload.getOutputData());
        queueController.addFunctionDtoToResultQueue(functionDTO);
    }
}
