package com.example.demo.bo;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.annotation.JsonInclude;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import lombok.Data;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Component
@Scope("prototype")
@Data
@OpenAPIDefinition(info = @Info(title = "返回", version = "1.0.0", description = "返回code正常为了0，异常为异常code编码"))
public class ApiResponse<T> {
  public static final String SUCCESS = "200";
  public static final String ERROR = "500";
  public static final String SUCCESS_MSG = "Success";

  private int status;

  private String message;

  private T data;

  public ApiResponse() {
  }

  public ApiResponse(int status, String message, T data) {
    this.status = status;
    this.message = message;
    this.data = data;
  }

  public static <T> ApiResponse<T> success(T data) {
    return new ApiResponse<>(Integer.parseInt(SUCCESS), SUCCESS_MSG, data);
  }

  public static <T> ApiResponse<T> error(String message) {
    return new ApiResponse<>(Integer.parseInt(ERROR), message, null);
  }
}
