package co.com.semillero.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class HttpResponseWrapper {

    private String responseBody;
    private int statusCode;
}