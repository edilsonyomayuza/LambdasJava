package co.com.semillero.repository;

import co.com.semillero.model.ParameterStoreDto;
import com.amazonaws.client.builder.AwsClientBuilder;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDB;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClient;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapperConfig;

public class DynamoRepository {

    //Confguracion para hacer conexion a la base de datos

    //Consultar guardar todo tipo de informacion
    public DynamoDBMapper build(ParameterStoreDto parameter){
        //Configuracion del nombre de la tabla que se va a consultar  o a la que se va a enviar informacion
        DynamoDBMapperConfig  config = new DynamoDBMapperConfig.Builder()
                .withTableNameOverride(DynamoDBMapperConfig.TableNameOverride.withTableNameReplacement(parameter.getTabla())).build();

        //Conexion Amazon dynamo
        AmazonDynamoDB client= buildClient(parameter.getRegion(), parameter.getUrlDynamo());

        return new DynamoDBMapper(client);
    }

        //Metodo donde se va a ahcerr la conexion a dynamo y al ambiente
    public AmazonDynamoDB buildClient(String region, String url){
        return AmazonDynamoDBClient.builder().withEndpointConfiguration(
                new AwsClientBuilder.EndpointConfiguration(url, region)).build();
    }
}
