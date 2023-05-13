package com.srini.protobuf;

import io.confluent.kafka.serializers.protobuf.KafkaProtobufSerializer;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class KafkaProtobufProducerApplication {



	public static void main(String[] args) {
		SpringApplication.run(KafkaProtobufProducerApplication.class, args);
	}

}
