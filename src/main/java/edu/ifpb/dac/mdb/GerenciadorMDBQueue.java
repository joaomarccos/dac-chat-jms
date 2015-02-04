package edu.ifpb.dac.mdb;

import edu.ifpb.dac.mdb.queue.Produtor;
import edu.ifpb.dac.mdb.queue.Consumidor;
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
public class GerenciadorMDBQueue implements Serializable {

    private String mensagem = "";

    @EJB
    private Produtor destino;

    @EJB
    private Consumidor leitor;

    public GerenciadorMDBQueue() {
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
