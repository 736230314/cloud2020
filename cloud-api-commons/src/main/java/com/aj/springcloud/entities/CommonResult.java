package com.aj.springcloud.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Author Aj
 * @Date 2020/8/15 0015 17:19
 * @Version 1.0
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CommonResult<T>
{
    private Integer code;
    private String message;
    private T   data;

    public CommonResult(Integer code, String message)
    {
        this(code,message,null);
    }

}