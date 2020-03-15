package service;

import dao.OrderDataDaoImp;

public class MaskSumService {
    OrderDataDaoImp orderDataDaoImp = new OrderDataDaoImp();
    public void updateMaskSum(int sum){
        orderDataDaoImp.updateSum(sum);
    }
}
