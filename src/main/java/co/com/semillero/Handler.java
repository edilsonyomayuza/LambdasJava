package co.com.semillero;

import co.com.semillero.model.ParameterStoreDto;
import co.com.semillero.model.Usuario;
import co.com.semillero.repository.DynamoRepository;
import co.com.semillero.repository.ParameterStoreRepository;
import co.com.semillero.service.DynamoService;
import co.com.semillero.util.BuildResponseUtil;
import co.com.semillero.util.Util;
import com.amazonaws.HttpMethod;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import com.amazonaws.services.lambda.runtime.events.APIGatewayProxyRequestEvent;
import com.amazonaws.services.lambda.runtime.events.APIGatewayProxyResponseEvent;

public class Handler implements RequestHandler<APIGatewayProxyRequestEvent, APIGatewayProxyResponseEvent> {

    ParameterStoreRepository parameterRepository = new ParameterStoreRepository();
    ParameterStoreDto parameterDto = parameterRepository.getParameter();
    DynamoRepository dynamoRepository = new DynamoRepository();
    DynamoDBMapper dynamoDBMapper = dynamoRepository.build(parameterDto);
    DynamoService dynamoService = new DynamoService();

    @Override
    public APIGatewayProxyResponseEvent handleRequest(APIGatewayProxyRequestEvent input, Context context) {
        return BuildResponseUtil.buildSuccess(redirect(input));
    }

    //Validacion y llamar los diferentes tipos de servicios
    public Object redirect(APIGatewayProxyRequestEvent input) {
        try {
            if (input.getBody() != null) {
                if (input.getHeaders().get("servicio").equals("guardar") && input.getHttpMethod().equals(HttpMethod.POST)) {
                    Usuario usuario = (Usuario) Util.string2object(input.getBody(), Usuario.class);
                    return dynamoService.saveUsuario(dynamoDBMapper, usuario);
                } else if (input.getHeaders().get("servicio").equals("consultar") && input.getHttpMethod().equals(HttpMethod.GET)) {
                    Usuario usuario = (Usuario) Util.string2object(input.getBody(), Usuario.class);
                    return dynamoService.saveUsuario(dynamoDBMapper, usuario);
                } else {
                    return "Servicio no disponible";
                }
            } else {
                return "No tiene información";
            }
        } catch (Exception e) {
            return e;
        }
    }
}
