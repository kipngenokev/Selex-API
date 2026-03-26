package com.selex.bigOne;

import java.time.LocalDateTime;

public record APIError(LocalDateTime timestamp, int status, String errorMessage, String message, String path) {
}
