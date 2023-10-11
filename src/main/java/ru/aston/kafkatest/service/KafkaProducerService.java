package ru.aston.kafkatest.service;

import lombok.RequiredArgsConstructor;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Service;
import org.springframework.util.concurrent.ListenableFuture;
import org.springframework.util.concurrent.ListenableFutureCallback;
import ru.aston.kafkatest.dto.TransferByCardNumberResponseDto;

@Service
@RequiredArgsConstructor
public class KafkaProducerService {
    private final KafkaTemplate<String, TransferByCardNumberResponseDto> template;

    public void sendMessageToTopic(TransferByCardNumberResponseDto msg) {
        ListenableFuture<SendResult<String, TransferByCardNumberResponseDto>> future = template.send("master_to_payment_from_card_transfer_by_card_number_key", msg);

        future.addCallback(new ListenableFutureCallback<SendResult<String, TransferByCardNumberResponseDto>>() {
            @Override
            public void onFailure(Throwable ex) {
                System.out.println(ex.getMessage());
            }

            @Override
            public void onSuccess(SendResult<String, TransferByCardNumberResponseDto> result) {
                System.out.println("Message successfully sent to payment service");
            }
        });
    }
}
