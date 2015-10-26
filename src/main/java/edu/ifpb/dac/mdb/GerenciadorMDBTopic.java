package edu.ifpb.dac.mdb;

import edu.ifpb.dac.listener.MensagemListener;
import edu.ifpb.dac.mdb.topic.ConsumidorTopicAsync;
import edu.ifpb.dac.mdb.topic.ProdutorTopic;
import java.io.Serializable;
import java.util.List;
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
public class GerenciadorMDBTopic implements Serializable, MensagemListener {

    private String mensagem = "";
    private String user = "";

    @EJB
    private ProdutorTopic destino;
    
    @EJB
    private ConsumidorTopicAsync consumidor;
    
    private List<String> mensagensRecebidas;

    public GerenciadorMDBTopic() {
        consumidor.setListener(this);
    }

    public String enviar() {
        destino.enviarMensagem(mensagem);
        mensagem = "";
        return null;
    }
    
    public String entrar(){
        return "chat";
    }

    public String getMensagem() {
        return mensagem;
    }

    public void setMensagem(String mensagem) {
        this.mensagem = mensagem;
    }
    
    public List<String> getMensagensRecebidas (){
        this.mensagensRecebidas = consumidor.getMensagens();
        return mensagensRecebidas;
    }

    @Override
    public void avisar(String msg) {
        this.mensagensRecebidas.add(msg);
    }

}
