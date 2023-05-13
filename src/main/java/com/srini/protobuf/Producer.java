package com.srini.protobuf;


import lombok.RequiredArgsConstructor;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

import java.util.stream.IntStream;

@Component
@RequiredArgsConstructor
public class Producer {

    private final KafkaTemplate<String, StockProtos> kafkaTemplate ;

    public void send(){
        /*IntStream.rangeClosed(1,500)
                .mapToObj(i -> invoiceGenerator.getNextInvoice())
                .map(invoice -> new ProducerRecord<>("invoice-topic-1", invoice.getStoreID().toString(), invoice))
                .forEach(kafkaTemplate::send) ;
*/
    }
}
