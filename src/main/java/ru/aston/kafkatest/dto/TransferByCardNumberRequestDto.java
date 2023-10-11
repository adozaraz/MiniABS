package ru.aston.kafkatest.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.math.BigDecimal;
import java.time.ZonedDateTime;
import java.util.UUID;

@Data
@AllArgsConstructor
public class TransferByCardNumberRequestDto {
    private UUID transactionId;

    private String senderCardNumber;

    private String recipientCardNumber;

    private String transactionComment;

    private String currencyCode;

    private String rnn;

    private String authCode;

    private BigDecimal amountTransfer;

    private BigDecimal amountCommission;

    private BigDecimal amountWithdrawal;

    private ZonedDateTime transactionDate;
}
