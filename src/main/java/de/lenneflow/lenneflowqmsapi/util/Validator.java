package de.lenneflow.lenneflowqmsapi.util;

import de.lenneflow.lenneflowqmsapi.dto.FunctionPayload;
import de.lenneflow.lenneflowqmsapi.exception.PayloadNotValidException;

public class Validator {
    public static void validate(FunctionPayload payload) {
        if(payload == null) {
            throw new PayloadNotValidException("Payload is null");
        }
        if(payload.getOutputData() == null || payload.getOutputData().isEmpty()) {
            throw new PayloadNotValidException("Output data is null or empty");
        }
        if (payload.getRunStatus() == null){
            throw new PayloadNotValidException("Run Status is null");
        }
    }
}
