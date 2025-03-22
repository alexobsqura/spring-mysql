package com.obsqura.example.exception;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;

import java.time.LocalDateTime;

@AllArgsConstructor
@Data
@Getter
public class ExceptionDetail {

    private LocalDateTime timestamp;
    private String message;
    private String details;
}
