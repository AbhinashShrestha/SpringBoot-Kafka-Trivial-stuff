package com.watashi.springboot;

import com.watashi.springboot.entity.WikimediaData;
import com.watashi.springboot.repository.WikimediaDataRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class KafkaConsumerDatabase {
    private static final Logger LOGGER = LoggerFactory.getLogger(KafkaConsumerDatabase.class);
    private WikimediaDataRepository dataRepo;

    public KafkaConsumerDatabase(WikimediaDataRepository dataRepo) {
        this.dataRepo = dataRepo;
    }

    @KafkaListener(topics = "wikimedia_recent_changes",groupId = "myGroup")
    public void consume(String eventMessage) {
        LOGGER.info(String.format("Event message received --> %s", eventMessage));

        WikimediaData wikimediaData = new WikimediaData();
        wikimediaData.setWikiEventData(eventMessage);

        dataRepo.save(wikimediaData);
    }
}
