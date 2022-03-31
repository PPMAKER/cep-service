package com.ppmaker.cepservice;

//import javax.enterprise.context.Dependent;
import javax.ws.rs.client.WebTarget;

//@Dependent
public class PostmonCepService extends AbstractCepServiceImpl {

    public PostmonCepService() {
        super("https://api.postmon.com.br");
    }

    @Override
    protected WebTarget buildPath(String cep) {
        return super.buildPath(String.format("v1/cep/%s", cep));
    }
    
}
