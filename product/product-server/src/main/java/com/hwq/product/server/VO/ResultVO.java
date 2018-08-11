package com.hwq.product.server.VO;

import lombok.Data;

/**
 * @author hwq
 * @date 2018/08/04
 */
@Data
public class ResultVO<T> {

    /**
     * 错误码
     */
    private Integer code;

    /**
     * 信息
     */
    private String msg;

    /**
     * 返回数据
     */
    private T data;
}
