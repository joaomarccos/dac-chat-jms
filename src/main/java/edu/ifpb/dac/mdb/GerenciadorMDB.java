package edu.ifpb.dac.mdb;

import edu.ifpb.dac.Enviar;
import edu.ifpb.dac.Receber;
import java.io.Serializable;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import javax.jms.JMSConnectionFactoryDefinition;
import javax.jms.JMSDestinationDefinition;

/**
 *
 * @author Ricardo Job
 */
@JMSDestinationDefinition(
        name = "java:global/jms/demoQueue",
        description = "Queue  usada na aula",
        interfaceName = "javax.jms.Queue"
)
@JMSConnectionFactoryDefinition(
        name = "java:global/jms/demoConnectionFactory",
        description = "ConnectionFactory usada na aula"
)

@Named(value = "gerenciador")
@SessionScoped
public class GerenciadorMDB implements Serializable {

    private String mensagem = "";

    @EJB
    private Enviar destino;

    @EJB
    private Receber leitor;

    public GerenciadorMDB() {
    }

    public String enviar() {
        destino.enviarMensagem(mensagem);
        mensagem = "";
        return null;
    }

    public String recebendoMensagem() {
        return leitor.receberMensagem();
    }

    public String getMensagem() {
        return mensagem;
    }

    public void setMensagem(String mensagem) {
        this.mensagem = mensagem;
    }

}
