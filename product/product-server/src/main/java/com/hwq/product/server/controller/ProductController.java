package com.hwq.product.server.controller;

import com.hwq.product.server.VO.ProductInfoVO;
import com.hwq.product.server.VO.ProductVO;
import com.hwq.product.server.VO.ResultVO;
import com.hwq.product.server.dataobject.ProductCategory;
import com.hwq.product.server.dataobject.ProductInfo;
import com.hwq.product.server.dto.CarDTO;
import com.hwq.product.server.server.ProductCategoryServer;
import com.hwq.product.server.server.ProductServer;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author hwq
 * @date 2018/08/02
 */
@RestController
@RequestMapping("/product")
public class ProductController {

    @Autowired
    private ProductServer productServer;

    @Autowired
    private ProductCategoryServer productCategoryServer;

    /**
     * 1. 查询所有在架的商品
     * 2. 获取类目type列表
     * 3. 查询类目
     * 4. 构造数据
     */
    @GetMapping("/list")
    public ResultVO list() {
        //1. 查询所有在架的商品
        List<ProductInfo> productInfoList = productServer.findUp();
        //2. 获取类目type列表
        List<Integer> categoryList = productInfoList.stream().map(ProductInfo::getCategoryType).collect(Collectors.toList());
        //3. 查询类目
        List<ProductCategory> productCategoryList = productCategoryServer.findByCategoryTypeIn(categoryList);
        //4. 构造数据
        List<ProductVO> productVOList = new ArrayList<>();
        for (ProductCategory productCategory : productCategoryList) {
            ProductVO productVO = new ProductVO();
            productVO.setCategoryName(productCategory.getCategoryName());
            productVO.setCategoryType(productCategory.getCategoryType());

            List<ProductInfoVO> productInfoVOList = new ArrayList<>();
            for (ProductInfo productInfo : productInfoList) {
                if (productCategory.getCategoryType().equals(productInfo.getCategoryType())) {
                    ProductInfoVO productInfoVO = new ProductInfoVO();
                    //把productInfo里面的属性copy到productInfoVO中
                    BeanUtils.copyProperties(productInfo, productInfoVO);
                    productInfoVOList.add(productInfoVO);
                }
                productVO.setProductInfoVOList(productInfoVOList);
                productVOList.add(productVO);
            }
        }
        ResultVO resultVO = new ResultVO();
        resultVO.setCode(0);
        resultVO.setMsg("成功");
        resultVO.setData(productVOList);
        return resultVO;
    }

    /**
     * 获取商品列表(给订单服务用的)
     *
     * @param productList
     * @return
     */
    @PostMapping("/listForOrder")
    public List<ProductInfo> listForOrder(@RequestBody List<String> productList) {

        return productServer.findByProductIdIn(productList);
    }

    /**
     * 扣减库存
     *
     * @param carDTOList
     */
    @PostMapping("/decreaseStock")
    public void decreaseStock(@RequestBody List<CarDTO> carDTOList) {
        productServer.decreaseStock(carDTOList);
    }
}
