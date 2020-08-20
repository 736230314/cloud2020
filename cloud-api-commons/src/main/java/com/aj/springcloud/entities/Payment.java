package com.aj.springcloud.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @Author Aj
 * @Date 2020/8/15 0015 17:19
 * @Version 1.0
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Payment implements Serializable
{
    private Long id;
    private String serial;
}
