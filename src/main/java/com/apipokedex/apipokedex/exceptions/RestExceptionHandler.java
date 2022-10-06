package com.apipokedex.apipokedex.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.servlet.http.HttpServletRequest;
import java.time.LocalDateTime;

@RestControllerAdvice
public class RestExceptionHandler {


    @ExceptionHandler(TreinadorServiceException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ResponseBody
    public RespostaErro erroTreinadorService(
            TreinadorServiceException treinadorServiceException,
            HttpServletRequest request) {
        return RespostaErro.builder()
                .timestamp(LocalDateTime.now())
                .status(HttpStatus.BAD_REQUEST.value())
                .error(HttpStatus.BAD_REQUEST.getReasonPhrase())
                .message(treinadorServiceException.getMessage())
                .path(request.getContextPath() + request.getServletPath())
                .build();
    }

    @ExceptionHandler(NotfoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ResponseBody
    public RespostaErro erroNotFound(
            NotfoundException notfoundException,
            HttpServletRequest request) {
        return RespostaErro.builder()
                .timestamp(LocalDateTime.now())
                .status(HttpStatus.NOT_FOUND.value())
                .error(HttpStatus.NOT_FOUND.getReasonPhrase())
                .message(notfoundException.getMessage())
                .path(request.getContextPath() + request.getServletPath())
                .build();
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(HttpStatus.UNPROCESSABLE_ENTITY)
    @ResponseBody
    public RespostaErro erroPayload(
            MethodArgumentNotValidException exception,
            HttpServletRequest request) {

        BindingResult result = exception.getBindingResult();
        return RespostaErro.builder()
                .timestamp(LocalDateTime.now())
                .status(HttpStatus.UNPROCESSABLE_ENTITY.value())
                .error(HttpStatus.UNPROCESSABLE_ENTITY.getReasonPhrase())
                .message(result.getFieldErrors().get(0).getDefaultMessage())
                .path(request.getContextPath() + request.getServletPath())
                .build();

    }
}














