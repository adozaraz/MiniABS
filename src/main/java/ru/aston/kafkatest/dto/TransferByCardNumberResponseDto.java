package ru.aston.kafkatest.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TransferByCardNumberResponseDto {
    private UUID transactionId;

    private boolean isSucceed;

    public String errors;
}
