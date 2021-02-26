package lk.navishka.loginWithSecuruty.util;

import lombok.*;

import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class ErrorDetails {
    private Date timestamp;
    private String message;
    private String details;
}
