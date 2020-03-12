package haitang.service.Impl;

import haitang.dao.CommentDao;
import haitang.domain.Comment;
import haitang.dto.CommentDto;
import haitang.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CommentServiceImpl implements CommentService {

    @Autowired
    CommentDao commentDao;
    @Override
    public void add(Comment comment) {
        commentDao.add(comment);

    }

    @Override
    public List<Comment> findByParentId(String parentId) {

        List<Comment> comments = commentDao.selectComment(parentId);
        if (comments.size() == 0){
            return new ArrayList<>();
        }
        return comments;
    }
}
