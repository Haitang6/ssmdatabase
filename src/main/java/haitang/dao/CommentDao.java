package haitang.dao;

import haitang.domain.Comment;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CommentDao {

    @Insert("insert into COMMENTAA (context,type,parent_id,replayCount,commentator,gmtCreate)" +
            "values (#{context},#{type},#{parentId},#{replayCount},#{commentator},#{gmtCreate})")
    void add(Comment comment);

    @Select("select * from COMMENTAA where parent_id = #{parentId}")
    List<Comment> selectComment(String parentId);
}
