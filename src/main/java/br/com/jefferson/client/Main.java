package br.com.jefferson.client;

import br.com.jefferson.cliente.wsdl.consulta.Certificado;
import br.com.jefferson.cliente.wsdl.consulta.Cliente;
import br.com.jefferson.cliente.wsdl.consulta.ConsultaDFeService;
import br.com.jefferson.cliente.wsdl.consulta.ConsultaDFeServiceImplService;
import br.com.jefferson.cliente.wsdl.consulta.Gerenciamento;
import br.com.jefferson.cliente.wsdl.consulta.UfEnum;

/**
 *
 * @author 88717
 */
public class Main {

    private final static String A1 = "certificado/FISIA COMERCIO DE PRODUTOS ESPORTIVOS LTDA59546515000134.pfx";
    private final static String SENHA = "Fisiapj@2022";
    private final static String CNPJ = "59546515000134";
    private final static String ALIAS = "FISIA COMERCIO DE PRODUTOS ESPORTIVOS LTDA59546515000134";

    public static void main(String args[]) throws Exception {

        Certificado certificado = new Certificado();
        certificado.setAliasCert(ALIAS);
        certificado.setArquivo(A1);
        certificado.setSenha(SENHA);

        Cliente cliente = new Cliente();
        cliente.setCertificado(certificado);
        cliente.setCnpj(CNPJ);
        cliente.setCodUf(UfEnum.SP);
        cliente.setRazaoSocial(ALIAS);

        Gerenciamento ger = new Gerenciamento();
        ger.setMaxNSU(0);
        ger.setProxNSU(0);

        cliente.setGerenciamento(ger);

        ConsultaDFeServiceImplService service = new ConsultaDFeServiceImplService();
        ConsultaDFeService port = service.getConsultaDFeServiceImplPort();
        boolean cad = port.cadastrarCliente(cliente);
        System.out.println(cad);
    }

}
