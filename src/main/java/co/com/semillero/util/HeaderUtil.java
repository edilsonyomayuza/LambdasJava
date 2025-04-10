package co.com.semillero.util;

import co.com.semillero.model.HeadersRq;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.ContentType;


@NoArgsConstructor
@Slf4j
public class HeaderUtil {

    public void addEnrollmentHeaders(HttpPost httpPost, HeadersRq headers){
        httpPost.setHeader("Content-Type", headers.getContentType());
        httpPost.setHeader("Content-Length", headers.getContentLength());

    }
}