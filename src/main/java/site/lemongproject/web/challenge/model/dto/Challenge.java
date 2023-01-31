package site.lemongproject.web.challenge.model.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.apache.ibatis.type.Alias;
import site.lemongproject.common.type.ChallengeStatus;
import site.lemongproject.web.member.model.vo.Profile;
import site.lemongproject.web.template.model.dto.Template;

import java.sql.Date;
import java.time.LocalDate;

@Getter
@Setter
@ToString
@Alias("Challenge")
public class Challenge {
    int challengeNo;
    Profile createUser;
    Template templateNo;
    String ChallengeTitle;
    String ChallengeInfo;
    LocalDate StartDate;
    LocalDate endDate;
    String ChallengeOption;
    ChallengeStatus status;
}
