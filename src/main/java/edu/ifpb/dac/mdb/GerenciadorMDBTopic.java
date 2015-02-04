package edu.ifpb.dac.mdb;

import edu.ifpb.dac.mdb.topic.ProdutorTopic;
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
        name = "java:global/jms/demoTopic",
        description = "Topic  usada na aula",
        interfaceName = "javax.jms.Topic"
)
@JMSConnectionFactoryDefinition(
        name = "java:global/jms/demoConnectionFactoryTopic",
        description = "ConnectionFactoryTopic usada na aula"
)

@Named(value = "gerenciadorTopic")
@SessionScoped
public class GerenciadorMDBTopic implements Serializable {

    private String mensagem = "";

    @EJB
    private ProdutorTopic destino;

    public GerenciadorMDBTopic() {
    }

    public String enviar() {
        destino.enviarMensagem(mensagem);
        mensagem = "";
        return null;
    }

    public String getMensagem() {
        return mensagem;
    }

    public void setMensagem(String mensagem) {
        this.mensagem = mensagem;
    }

}
