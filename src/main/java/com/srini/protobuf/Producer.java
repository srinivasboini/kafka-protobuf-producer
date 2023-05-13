package com.srini.protobuf;


import lombok.RequiredArgsConstructor;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

@Component
@RequiredArgsConstructor
public class Producer {

    private final KafkaTemplate<String, StockProtos.Stock> kafkaTemplate ;

    public void send(){
        getStocks().stream()
                .map(e -> new ProducerRecord<>("stock-topic-1", e.getName(), e))
                .forEach(kafkaTemplate::send) ;
    }

    List<StockProtos.Stock> getStocks(){
        List<StockProtos.Stock> stocks = new ArrayList<>() ;
        StockProtos.Stock stock = StockProtos.Stock.newBuilder()
                .setName("ICICI")
                .setVolume(20)
                .setIsin(200)
                .build() ;

        stocks.add(stock) ;
        return  stocks ;

    }
}
