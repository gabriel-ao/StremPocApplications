package br.com.stelo.streampoc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.messaging.Processor;
import org.springframework.messaging.handler.annotation.SendTo;

@SpringBootApplication
@EnableBinding(Processor.class)
public class StreampocApplication {

	public static void main(String[] args) {
		SpringApplication.run(StreampocApplication.class, args);
	}

	@StreamListener(Processor.INPUT)
	@SendTo(Processor.OUTPUT)
    public String process(DTO queueData) {
		System.out.println(queueData.getMessage());
		return "Output: " + queueData.getMessage();
	}
}
