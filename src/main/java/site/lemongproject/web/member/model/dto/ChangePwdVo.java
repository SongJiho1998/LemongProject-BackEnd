package site.lemongproject.web.member.model.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@AllArgsConstructor
public class ChangePwdVo {
    int userNo;
    String Password;
}
