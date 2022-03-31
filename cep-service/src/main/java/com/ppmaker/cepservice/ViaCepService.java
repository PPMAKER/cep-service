
package com.ppmaker.cepservice;

//import javax.enterprise.context.Dependent;
import javax.ws.rs.client.WebTarget;

//@Dependent
public final class ViaCepService extends AbstractCepServiceImpl {

    public ViaCepService() {
        super("https://viacep.com.br");
    }

    @Override
    protected WebTarget buildPath(String cep) {
        return super.buildPath(String.format("ws/%s/json", cep));
    }
    
}
