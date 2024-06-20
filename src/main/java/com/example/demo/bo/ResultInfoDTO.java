package com.example.demo.bo;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.annotation.JsonInclude;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import lombok.Data;

/**
 * 
 * @ClassName: ResultInfoDTO
 * @Description: 这里用一句话描述这个类的作用
 * @author wangguiyu
 * @date Apr 2, 2020 7:59:26 PM
 *
 * @param <T>
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@Component
@Scope("prototype")
@Data
@OpenAPIDefinition(info = @Info(title = "返回", version = "1.0.0", description = "返回code正常为了0，异常为异常code编码"))
public class ResultInfoDTO<T> {
	public static final String OK = "0";
	public static final String FAILED = "-1";
	public static final String LOGIN_SUCCESS = "1";
	public static final String ERROR = "999";

	private String code;

	private String message;

	private T data;

}
