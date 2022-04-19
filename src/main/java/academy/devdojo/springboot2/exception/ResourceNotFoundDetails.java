package academy.devdojo.springboot2.exception;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Builder
public class ResourceNotFoundDetails {
    private String title;
    private int status;
    private String detail;
    private LocalDateTime timestamp;
    private String developerMessage;
}
