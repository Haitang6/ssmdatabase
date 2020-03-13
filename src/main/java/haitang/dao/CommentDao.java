package haitang.dao;

import haitang.domain.Comment;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CommentDao {

    @Insert("insert into COMMENTAA (context,type,parent_id,replayCount,commentator,gmtCreate)" +
            "values (#{context},#{type},#{parentId},#{replayCount},#{commentator},#{gmtCreate})")
    void add(Comment comment);

    @Select("select * from COMMENTAA where parent_id = #{parentId} order")
    List<Comment> selectComment(String parentId);

    @Update("update COMMENTAA set replayCount = replayCount + 1 where id = #{id} ")
    void setReplyCount (String id);
}
