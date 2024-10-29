package de.lenneflow.lenneflowqmsapi.dto;

import de.lenneflow.lenneflowqmsapi.enums.RunStatus;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.HashMap;
import java.util.Map;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class FunctionPayload {

    private RunStatus runStatus;

    private String callBackUrl;

    private String failureReason;

    private Map<String, Object> inputData = new HashMap<>();

    private Map<String, Object> outputData = new HashMap<>();
}
