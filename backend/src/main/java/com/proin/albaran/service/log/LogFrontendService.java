package com.proin.albaran.service.log;

public interface LogFrontendService {

    public void trace(String msg);
    public void debug(String msg);
    public void info(String msg);
    public void warn(String msg);
    public void error(String msg);
}