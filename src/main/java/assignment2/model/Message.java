package assignment2.model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Message {
    private String username;
    private String text;
}
