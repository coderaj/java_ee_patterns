package com.readlearncode;

import javax.interceptor.ExcludeClassInterceptors;
import javax.interceptor.Interceptors;

@Interceptors(LoggerInterceptor.class)
public class AccountingService {

    public AccountingService(){ }

    @ExcludeClassInterceptors
    public void auditAccount(String accountNumber){

    }
}
