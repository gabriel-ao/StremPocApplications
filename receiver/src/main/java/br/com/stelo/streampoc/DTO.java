package br.com.stelo.streampoc;

import lombok.Data;

import java.io.Serializable;

@Data
public class DTO implements Serializable {
    private String message;
}
