package com.hwq.order.server.utils;


import com.hwq.order.server.VO.ResultVO;

/**
 * @author hwq
 * @date 2018/08/05
 */
public class ResultVOUtil {

    public static ResultVO success(Object object) {
        ResultVO resultVO = new ResultVO();
        resultVO.setCode(0);
        resultVO.setMsg("成功");
        resultVO.setData(object);
        return resultVO;
    }
}
