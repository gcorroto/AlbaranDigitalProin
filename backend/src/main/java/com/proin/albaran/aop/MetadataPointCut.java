package com.proin.albaran.aop;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.util.List;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestParam;

import com.proin.albaran.constantes.MetadataAlbaranEnum;
import com.proin.albaran.dto.AlbaranDto;
import com.proin.albaran.dto.generic.ResponseMetadata;

@Aspect
@Component
public class MetadataPointCut {

    @Around("@annotation(ResponseMetadataBody)")
    public ResponseEntity<?> buildMetadata(ProceedingJoinPoint joinPoint) throws Throwable {
        
        Object requestParamMeta = this.getRequestParam(joinPoint);
        Object responseMethod = joinPoint.proceed();
        ResponseEntity<?> responseAop = (ResponseEntity<?>)responseMethod;

        if((Boolean) requestParamMeta) { // parametro que habilita los metadatos
            if(responseMethod instanceof ResponseEntity<?>) {
                ResponseEntity<?> response =  (ResponseEntity<?>)responseMethod;
                if(response.getBody() instanceof AlbaranDto) {
                    List<MetadataAlbaranEnum> metas = MetadataAlbaranEnum.findByClass(response.getBody());
                    ResponseMetadata<AlbaranDto,MetadataAlbaranEnum> data = ResponseMetadata.<AlbaranDto,MetadataAlbaranEnum>builder()
                                                                            .data((AlbaranDto)response.getBody())
                                                                            .metadata(metas)
                                                                            .build();
                    responseAop = new ResponseEntity<>(data, HttpStatus.OK);
                
                }
            }
        }

        return responseAop;
    }

    private Object getRequestParam(ProceedingJoinPoint joinPoint){
        Object result = null;
         Object[] args = joinPoint.getArgs();
        MethodSignature methodSignature = (MethodSignature) joinPoint.getStaticPart().getSignature();
        Method method = methodSignature.getMethod();
        Annotation[][] parameterAnnotations = method.getParameterAnnotations();
        assert args.length == parameterAnnotations.length;
        for (int argIndex = 0; argIndex < args.length; argIndex++) {
            for (Annotation annotation : parameterAnnotations[argIndex]) {
                if (!(annotation instanceof RequestParam))
                    continue;
                RequestParam requestParam = (RequestParam) annotation;
                if (! "meta".equals(requestParam.value()))
                    continue;
                System.out.println("  " + requestParam.value() + " = " + args[argIndex]);
                result = args[argIndex];
            }
        }
        return result;
    }

}