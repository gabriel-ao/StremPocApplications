package br.com.stelo.streampoc;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
public class DTO implements Serializable {
    private String message;
}
