package com.haoa193.springbootdemo.model;

import lombok.*;

import java.io.Serializable;

/**
 * test use
 */
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Echo implements Serializable {
    private Long id;
    private String echo;
}
