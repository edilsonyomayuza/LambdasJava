package co.com.semillero.repository;

import co.com.semillero.model.ParameterStoreDto;
import co.com.semillero.util.ParameterStoreUtil;

import java.util.Map;

public class ParameterStoreRepository {
    public ParameterStoreDto  getParameter(){
        ParameterStoreDto parameter = new ParameterStoreDto();

        Map<String, String> parameterSemillero = ParameterStoreUtil.getParameters("/Semillero/capacitacion-semillero/");

        parameter.setTabla(parameterSemillero.get("/Semillero/capacitacion-semillero/nombreTabla"));
        parameter.setRegion(parameterSemillero.get("/Semillero/capacitacion-semillero/region"));
        parameter.setUrlDynamo(parameterSemillero.get("/Semillero/capacitacion-semillero/dynamoEnpoint"));
        parameter.setArnSecre(parameterSemillero.get("/Semillero/capacitacion-semillero/arnSecre"));

        return parameter;

    }
}
