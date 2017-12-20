package br.com.stelo.streampoc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.messaging.Source;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@EnableBinding(Source.class)
@RestController
public class StreamPocApplication {

    @Autowired
    private Source source;

	public static void main(String[] args) {
		SpringApplication.run(StreamPocApplication.class, args);
	}

    @PostMapping("/postar")
    public DTO process(@RequestBody DTO request) {
	    source.output().send(MessageBuilder.withPayload(request).build());
        return request;
    }
}
