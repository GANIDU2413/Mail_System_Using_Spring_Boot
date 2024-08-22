package com.example.mail_system;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MailDetailsDTO {
    private String toMail;
    private String subject;
    private String message;
    private String fromMail;


}
