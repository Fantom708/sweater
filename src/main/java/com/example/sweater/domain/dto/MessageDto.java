package com.example.sweater.domain.dto;

import com.example.sweater.domain.Message;
import com.example.sweater.domain.User;
import com.example.sweater.domain.util.MessageHelper;

import java.util.HashSet;
import java.util.Set;

public class MessageDto {
    private Long id;
    private String text;
    private String tag;
    private User author;
    private String filename;
    private Long likes;
    private boolean meLiked;

    public MessageDto(Message message, Long likes, boolean meLiked) {
        this.id = message.getId();
        this.text = message.getText();
        this.tag = message.getTag();
        this.author = message.getAuthor();
        this.filename = message.getFilename();
        this.likes = likes;
        this.meLiked = meLiked;
    }

    public Long getId() {
        return id;
    }

    public String getText() {
        return text;
    }

    public String getTag() {
        return tag;
    }

    public User getAuthor() {
        return author;
    }

    public String getFilename() {
        return filename;
    }

    public Long getLikes() {
        return likes;
    }

    public boolean isMeLiked() {
        return meLiked;
    }

    public String getAuthorName() {
        return MessageHelper.getAuthorName(author);
    }

    @Override
    public String toString() {
        return "MessageDto{" +
                "id=" + id +
                ", author=" + author +
                ", likes=" + likes +
                ", meLiked=" + meLiked +
                '}';
    }
}