package com.microservice.currentaccount.error;

import java.util.LinkedHashMap;
import java.util.Map;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class ErrorDetail {

    private Integer code;
    private String message;
    private Map<String, String> details = new LinkedHashMap<String, String>();

}
