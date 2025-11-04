package com.testetecnico.userapi.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class StandardError implements Serializable {
    private static final long serialVersionUID = 1L;

    private Long timestamp;
    private Integer status; // O código HTTP (ex: 404)
    private String error;   // A descrição do HTTP (ex: "Not Found")
    private String message; // A mensagem que nós definimos (ex: "Usuário não encontrado")
    private String path;    // A URL que foi chamada
}