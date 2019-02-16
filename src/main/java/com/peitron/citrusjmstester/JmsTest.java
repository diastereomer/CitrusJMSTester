package com.peitron.citrusjmstester;

import com.consol.citrus.annotations.CitrusTest;
import com.consol.citrus.dsl.junit.JUnit4CitrusTestDesigner;
import com.consol.citrus.jms.endpoint.JmsEndpoint;
import com.consol.citrus.jms.endpoint.JmsEndpointConfiguration;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;

import javax.jms.ConnectionFactory;
import java.util.ArrayList;

public class JmsTest extends JUnit4CitrusTestDesigner {

    @Autowired
    private ConnectionFactory connectionFactory;

    @Test
    @CitrusTest
    public void smoke() {
        send(jmsEndpoint("inbound"))
                .payload(new ClassPathResource("payload"));
               // .header("ReplyTo", "test");
//        receive(jmsEndpoint("test")).payload("rtste");;


        ArrayList<String> strings = new ArrayList<String>();
        for (String string : strings) {

        }

    }

    public JmsEndpoint jmsEndpoint(String name) {
        JmsEndpointConfiguration configuration = new JmsEndpointConfiguration();
        configuration.setConnectionFactory(connectionFactory);
        configuration.setDestinationName(name);
        return new JmsEndpoint(configuration);
    }

}
