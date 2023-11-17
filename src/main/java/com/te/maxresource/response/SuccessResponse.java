package com.te.maxresource.response;

import java.time.LocalDateTime;

import lombok.Builder;

@Builder
public record SuccessResponse(String message, Object data, LocalDateTime timestamp) {

}
