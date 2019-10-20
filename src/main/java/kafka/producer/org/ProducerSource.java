package kafka.producer.org;

import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;


/**
 * 
 * 0) Producer interface. 
 * 
 * @author francd
 *
 */
public interface ProducerSource {

	/**
	 * 1)
	 * 
	 * Indicates that an output binding target will be created by the framework.
	 * The value (here "producerOutput"), must be the value of  [cloud -> stream -> bindings]
	 * in the properties file
	 *    
	 * @return
	 */
    @Output("producerOutput")
    MessageChannel producerOutput();    // The name of the method can be anything :)
                                        // Only the value of the output binding matters
}