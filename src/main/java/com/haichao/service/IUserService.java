package com.haichao.service;

/**
 * <p>
 *
 * @Desc </p>
 * @Author yusj
 * @Date 2019/3/11
 * @Version 1.0
 */
public interface IUserService {
    boolean login(String username,String passwd);
    boolean register(String username,String passwd);
    void batchAdd(String username,String passwd);
}
