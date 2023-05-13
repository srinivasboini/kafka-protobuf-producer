package com.srini.protobuf;

import io.confluent.kafka.serializers.protobuf.KafkaProtobufSerializer;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@RequiredArgsConstructor
public class KafkaProtobufProducerApplication implements CommandLineRunner {

	private final Producer producer ;

	public static void main(String[] args) {
		SpringApplication.run(KafkaProtobufProducerApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		producer.send();
	}
}
