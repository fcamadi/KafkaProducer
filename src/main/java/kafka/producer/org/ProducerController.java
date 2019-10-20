package kafka.producer.org;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 
 * 3) In the controller we autowire the producer source, so it can send as messages what is received 
 *    through the endpoint
 * 
 * @author francd
 *
 */
@RestController
public class ProducerController {

	
	private ProducerSource producerSource;

	
    public ProducerController(ProducerSource producerSource) {
        this.producerSource = producerSource;
    }


    @PostMapping("/message/{msg}")
    public ResponseEntity<HttpStatus> produce(@PathVariable String msg) {
    	
    	Message<String> m = MessageBuilder.withPayload("Content: " + msg).build();
        producerSource.producerOutput().send(m);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
}
