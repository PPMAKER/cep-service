
package com.ppmaker.cepservice;

import com.ppmaker.cepsercice.model.Endereco;
import java.util.logging.Logger;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;


public abstract class AbstractCepServiceImpl implements CepService {

    private static final Logger LOG = Logger.getLogger(AbstractCepServiceImpl.class.getName());
    
    private final String dominio;
    private final WebTarget target;

    public AbstractCepServiceImpl(String dominio) {
        this.dominio = insertTrailingSlash(dominio);
        Client client = ClientBuilder.newClient();
        this.target = client.target(dominio);
    }
    
    protected final String insertTrailingSlash(String path){
        return path.endsWith("/") ? path : path + "/";
    }
    
    protected WebTarget buildPath(String cep){
        Client client = ClientBuilder.newClient();
        return client.target(dominio + cep);
    }
    
    protected String getFullPath(String cep){
        return this.dominio + buildPath(cep);
    }

    @Override
    public Endereco buscaEndereco(String cep) {
        LOG.info(
                String.format("Buscando endereço para o CEP %s usando serviço %s", 
                        cep, dominio)
        );
        return buildPath(cep).request().get(Endereco.class);
        
    }
    
}
