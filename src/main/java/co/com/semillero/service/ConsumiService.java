package co.com.semillero.service;

import co.com.semillero.model.EnrollmentRq;
import co.com.semillero.model.HeadersRq;
import co.com.semillero.model.HttpResponseWrapper;
import co.com.semillero.util.CertificadoUtil;
import co.com.semillero.util.HeaderUtil;
import co.com.semillero.util.Util;
import lombok.extern.slf4j.Slf4j;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.util.EntityUtils;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.security.KeyManagementException;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;

@Slf4j
public class ConsumiService {

    HeaderUtil headerUtil = new HeaderUtil();

    public HttpResponseWrapper enrollmentKeyService (EnrollmentRq req, HeadersRq headers, String uriConnection) throws IOException{
        log.info("Uri de conexion a camara Redeban (Enrollment/Person): {}", uriConnection);

        try (CloseableHttpClient client = CertificadoUtil.buildClient()){
            HttpPost httpPost  = new HttpPost(uriConnection);
            headerUtil.addEnrollmentHeaders(httpPost, headers);
            StringEntity entity = new StringEntity(Util.object2String(req), ContentType.TEXT_PLAIN.withCharset(StandardCharsets.UTF_8));
            httpPost.setEntity(entity);
            try(CloseableHttpResponse closeableHttpResponse = client.execute(httpPost)){
                return new HttpResponseWrapper(EntityUtils.toString(closeableHttpResponse.getEntity()), closeableHttpResponse.getStatusLine().getStatusCode());
            }

        }catch (NoSuchAlgorithmException | KeyStoreException | KeyManagementException conExp){
            throw new RuntimeException();
        }
    }


}
