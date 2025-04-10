package co.com.semillero.model;


import com.google.gson.annotations.SerializedName;
import lombok.Getter;
import lombok.Setter;
@Getter
@Setter
public class HeadersRq {

    @SerializedName("Content-Length")
    private String contentLength;

    @SerializedName("Content_Type")
    private String contentType;

    @SerializedName("Accept")
    private String accept;

}
