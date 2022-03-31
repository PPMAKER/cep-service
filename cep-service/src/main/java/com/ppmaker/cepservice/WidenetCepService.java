package com.ppmaker.cepservice;

import javax.enterprise.context.Dependent;
import javax.ws.rs.client.WebTarget;

@Dependent
public class WidenetCepService extends AbstractCepServiceImpl {

    public WidenetCepService() {
        super("https://apps.widenet.com.br/");
    }

    @Override
    protected WebTarget buildPath(String cep) {
        return super.buildPath(
                String.format("busca-cep/api/cep.json?code=%s", cep)
        );
    }
    
}
