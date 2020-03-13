package haitang.controller;


import haitang.dao.UserDao;
import haitang.domain.Comment;
import haitang.domain.UserInfo;
import haitang.dto.CommentDto;
import haitang.dto.ResultDto;
import haitang.service.CommentService;
import haitang.service.UserServer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
public class CommentController {

    @Autowired
    UserDao userDao;

    @Autowired
    CommentService commentService;

    @ResponseBody
    @RequestMapping("/comment")
    public ResultDto comment(@RequestBody CommentDto commentDto, HttpServletRequest request){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String name = authentication.getName();
        UserInfo userInfo = userDao.findByusername(name);
        Comment comment=new Comment();
        comment.setCommentator(userInfo.getId());
        comment.setContext(commentDto.getContext());
        comment.setGmtCreate(System.currentTimeMillis());
        comment.setParentId(commentDto.getParentId());
        comment.setType(commentDto.getType());
        comment.setReplayCount(0);
        commentService.add(comment);
        return ResultDto.success();
    }

    @ResponseBody
    @GetMapping("/comment/{id}")
    public Object showDoubleComment(@PathVariable(name="id") String id){
        List<Comment> comments = commentService.findByParentId(id);
        return ResultDto.successWithData(comments);
    }
}
