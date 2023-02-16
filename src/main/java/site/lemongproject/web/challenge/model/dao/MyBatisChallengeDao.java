package site.lemongproject.web.challenge.model.dao;

import lombok.RequiredArgsConstructor;
import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import site.lemongproject.common.type.ChallengeStatus;
import site.lemongproject.web.challenge.model.dto.Challenge;
import site.lemongproject.web.challenge.model.dto.ChallengeUser;
import site.lemongproject.web.challenge.model.vo.*;

import java.util.List;

@RequiredArgsConstructor
@Repository
public class MyBatisChallengeDao implements ChallengeDao{
    final private SqlSession session;

    @Override
    public int insertSingle(SingleStartVo startVo) {
        return session.insert("challengeMapper.insertSingle",startVo);
    }

    @Override
    public int insertMulti(MultiCreateVo createVo) {
        return session.insert("challengeMapper.insertMulti",createVo);
    }

    @Override
    public int joinUser(ChallengeUserVo challengeUserVo) {
        return session.insert("challengeMapper.joinUser",challengeUserVo);
    }

    @Override
    public int updateEndDate(EndDateUpdateVo endDateUpdateVo) {
        return session.update("challengeMapper.updateEndDate",endDateUpdateVo);
    }

    @Override
    public int deleteUser(ChallengeUserVo userVo) {
        return 0;
    }

    @Override
    public List<Challenge> selectChallenge(){
        return session.selectList("challengeMapper.selectChallenge");
    }

    @Override
    public List<Challenge> detailChallenge(Challenge c){
        return session.selectList("challengeMapper.detailChallenge" , c);
    }

    @Override
    public int challengeGo(ChallengeUser u){
        return session.insert("challengeMapper.challengeGo" , u);
    }

    @Override
    public Challenge findOne(int challengeNo) {
        return session.selectOne("challengeMapper.findOne" , challengeNo);
    }

    @Override
    public List<ChallengeListVo> findReady(int page, int limit) {
        int offSet=page*limit;
        RowBounds rowBounds=new RowBounds(offSet,limit);
        return session.selectList("challengeMapper.findReady",null,rowBounds);
    }
}
