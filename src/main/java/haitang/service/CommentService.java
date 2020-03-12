package haitang.service;

import haitang.domain.Comment;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface CommentService {
    public void add (Comment comment);
    public List<Comment>findByParentId(String parentId);
}
