package com.example.demo.controller;

import org.springframework.http.ResponseEntity;

import com.example.demo.bo.ApiResponse;

public class BaseController {

  protected <T> ResponseEntity<ApiResponse<T>> createSuccessResponse(T data) {
    return ResponseEntity.ok(ApiResponse.success(data));
  }

  protected ResponseEntity<ApiResponse<Void>> createErrorResponse(String message) {
    return ResponseEntity.status(500).body(ApiResponse.error(message));
  }
}
