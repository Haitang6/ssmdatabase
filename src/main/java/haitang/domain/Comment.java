package haitang.domain;

public class Comment {
    private String id;
    private String context;
    private String type;
    private String parentId;
    private Integer replayCount;
    private String commentator;
    private Long gmtCreate;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getContext() {
        return context;
    }

    public void setContext(String context) {
        this.context = context;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getParentId() {
        return parentId;
    }

    public void setParentId(String parentId) {
        this.parentId = parentId;
    }

    public Integer getReplayCount() {
        return replayCount;
    }

    public void setReplayCount(int replayCount) {
        this.replayCount = replayCount;
    }

    public String getCommentator() {
        return commentator;
    }

    public void setCommentator(String commentator) {
        this.commentator = commentator;
    }

    public Long getGmtCreate() {
        return gmtCreate;
    }

    public void setGmtCreate(long gmtCreate) {
        this.gmtCreate = gmtCreate;
    }

    @Override
    public String toString() {
        return "Comment{" +
                "id='" + id + '\'' +
                ", context='" + context + '\'' +
                ", type='" + type + '\'' +
                ", parentId='" + parentId + '\'' +
                ", replayCount='" + replayCount + '\'' +
                ", commentator='" + commentator + '\'' +
                ", gmtCreate='" + gmtCreate + '\'' +
                '}';
    }
}
