package com.company.exception;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.time.LocalDate;
import java.util.UUID;

@RestControllerAdvice
public class CustomizedException extends ResponseEntityExceptionHandler {
    @ExceptionHandler(PayrollException.class)
    public final ErrorDetails handlePayrollError(Exception ex){
        return ErrorDetails.builder()
                .uniqueExceptionId(UUID.randomUUID())
                .message(ex.getMessage())
                .timeStamp(LocalDate.now())
                .build();
    }
    @ExceptionHandler(LeaveReportsNotFoundException.class)
    public final ErrorDetails handleLeaveReportError(Exception ex){
        return ErrorDetails.builder()
                .uniqueExceptionId(UUID.randomUUID())
                .message(ex.getMessage())
                .timeStamp(LocalDate.now())
                .build();
    }

    @ExceptionHandler(UserNotFoundException.class)
    public final ErrorDetails handleUserError(Exception ex){
        return ErrorDetails.builder()
                .uniqueExceptionId(UUID.randomUUID())
                .message(ex.getMessage())
                .timeStamp(LocalDate.now())
                .build();
    }

    @ExceptionHandler(Exception.class)
    public final ErrorDetails handleGlobalError(Exception ex){
        return ErrorDetails.builder()
                .uniqueExceptionId(UUID.randomUUID())
                .message(ex.getMessage())
                .timeStamp(LocalDate.now())
                .build();
    }
}
