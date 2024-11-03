package de.lenneflow.lenneflowqmsapi.controller;

import de.lenneflow.lenneflowqmsapi.component.QueueController;
import de.lenneflow.lenneflowqmsapi.dto.FunctionDTO;
import de.lenneflow.lenneflowqmsapi.dto.FunctionPayload;
import de.lenneflow.lenneflowqmsapi.util.Validator;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/qms")
public class ApiController {

    private final QueueController queueController;

    public ApiController(QueueController queueController) {
        this.queueController = queueController;
    }


    @PostMapping("/callback/{executionId}/{stepInstanceId}/{workflowInstanceId}")
    public void workerCallBack(@RequestBody FunctionPayload payload, @PathVariable String executionId, @PathVariable String stepInstanceId, @PathVariable String workflowInstanceId){
        Validator.validate(payload);
        FunctionDTO functionDTO = new FunctionDTO();
        functionDTO.setExecutionId(executionId);
        functionDTO.setStepInstanceId(stepInstanceId);
        functionDTO.setWorkflowInstanceId(workflowInstanceId);
        functionDTO.setOutputData(payload.getOutputData());
        functionDTO.setRunStatus(payload.getRunStatus());
        functionDTO.setInputData(payload.getInputData());
        functionDTO.setCallBackUrl(payload.getCallBackUrl());
        functionDTO.setFailureReason(payload.getFailureReason());
        new Thread(() ->queueController.addFunctionDtoToResultQueue(functionDTO)).start();
    }
}
