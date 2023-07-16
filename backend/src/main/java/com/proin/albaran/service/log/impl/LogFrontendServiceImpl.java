package com.proin.albaran.service.log.impl;

import org.springframework.stereotype.Service;

import com.proin.albaran.service.log.LogFrontendService;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class LogFrontendServiceImpl implements LogFrontendService {
    

    @Override
    public void trace(String msg) {
        log.trace("[ FRONTEND - TRACE ]: {}", msg);
    }

    @Override
    public void debug(String msg) {
        log.debug("[ FRONTEND - DEBUG ]: {}", msg);
    }

    @Override
    public void info(String msg) {
        log.debug("[ FRONTEND - INFO ]: {}", msg);
    }

    @Override
    public void warn(String msg) {
        log.warn("[ FRONTEND - WARN ]: {}", msg);
    }

    @Override
    public void error(String msg) {
        log.error("[ FRONTEND - ERROR ]: {}", msg);
    }
}