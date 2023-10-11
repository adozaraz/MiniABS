package ru.aston.kafkatest.service;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;
import ru.aston.kafkatest.dto.TransferByCardNumberRequestDto;
import ru.aston.kafkatest.dto.TransferByCardNumberResponseDto;

@Service
@RequiredArgsConstructor
public class KafkaConsumerService {

    private final KafkaProducerService kafkaProducerService;

    @KafkaListener(topics = "payment_to_master_transfer_by_card_number_key", groupId = "group_id")
    public void consumer(TransferByCardNumberRequestDto data) {
        TransferByCardNumberResponseDto msg = new TransferByCardNumberResponseDto();
        msg.setTransactionId(data.getTransactionId());
        msg.setErrors("");
        msg.setSucceed(true);
        kafkaProducerService.sendMessageToTopic(msg);
    }
}
