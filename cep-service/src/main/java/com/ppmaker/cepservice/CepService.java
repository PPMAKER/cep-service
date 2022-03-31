
package com.ppmaker.cepservice;

import com.ppmaker.cepsercice.model.Endereco;

public interface CepService {
    Endereco buscaEndereco(String cep);
}
