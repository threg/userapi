package com.testetecnico.userapi.exception;

import org.springframework.dao.DataIntegrityViolationException; // 1. IMPORTAR
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.Map;

@ControllerAdvice
public class GlobalExceptionHandler {

    /**
     * Este handler você já tinha. Ele trata o 404 Not Found.
     * Perfeito, não mude nada aqui.
     */
    @ExceptionHandler(UserNotFoundException.class)
    public ResponseEntity<?> handleUserNotFound(UserNotFoundException ex) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body(Map.of("error", ex.getMessage()));
    }

    /**
     * 2. ADICIONE ESTE NOVO MÉTODO
     * Este handler vai capturar o erro de email duplicado (409 Conflict)
     */
    @ExceptionHandler(DataIntegrityViolationException.class)
    public ResponseEntity<?> handleDataIntegrityViolation(DataIntegrityViolationException ex) {
        String message = "Erro de integridade dos dados.";
        
        // Verificação específica para o seu erro de email único
        // (Peguei o nome da constraint do seu erro anterior)
        if (ex.getMessage().contains("UK6DOTKOTT2KJSP8VW4D0M25FB7_INDEX_4")) {
            message = "Erro: O email fornecido já está em uso.";
        }

        return ResponseEntity.status(HttpStatus.CONFLICT) // Retorna 409
                .body(Map.of("error", message));
    }


    /**
     * Este handler você já tinha. Ele trata erros genéricos 500.
     * É uma boa prática, mantenha ele no final.
     */
    @ExceptionHandler(Exception.class)
    public ResponseEntity<?> handleGeneralError(Exception ex) {
        // É bom logar o erro original no console para debug
        ex.printStackTrace(); 
        
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body(Map.of("error", "Erro interno do servidor."));
    }
}