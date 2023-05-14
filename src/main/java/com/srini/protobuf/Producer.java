package com.srini.protobuf;


import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.commons.lang3.RandomUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * The type Producer.
 */
@Component
@RequiredArgsConstructor
@Slf4j
public class Producer {

    private final KafkaTemplate<String, Stock> kafkaTemplate ;

    /**
     * Send.
     */
    public void send(){
        getStocks().stream()
                .peek(e -> log.info("{}", e))
                .map(e -> new ProducerRecord<>("stock-topic-1", e.getName(), e))
                .forEach(kafkaTemplate::send) ;
    }

    /**
     * Get stocks list.
     *
     * @return the list
     */
    List<Stock> getStocks(){

        return IntStream.rangeClosed(1,5000).mapToObj(i -> Stock.newBuilder()
                .setName(RandomStringUtils.randomAlphabetic(5).toUpperCase())
                .setVolume(RandomUtils.nextInt())
                .setIsin(RandomUtils.nextInt(100,500))
                .build()).collect(Collectors.toList());


    }
}
