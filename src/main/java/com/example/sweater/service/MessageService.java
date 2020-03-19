package com.example.sweater.service;

import com.example.sweater.domain.User;
import com.example.sweater.domain.dto.MessageDto;
import com.example.sweater.repos.MessageRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class MessageService {

    @Autowired
    private MessageRepo messageRepo;

    public Page<MessageDto> messageList(Pageable pageable,
                                        String filterText,
                                        String filterTag,
                                        String filterOwnMess,
                                        User user
    ) {
        Page<MessageDto> page;

        String CODE = "";
        CODE += filterText.isEmpty() ? "0" : "1";
        CODE += filterTag.isEmpty() ? "0" : "1";
        CODE += filterOwnMess.isEmpty() ? "0" : "1";

        switch (CODE) {
            case "110":
                page = messageRepo.findByTextContainingIgnoreCaseAndTag(pageable, filterText, filterTag, user);
                break;
            case "100":
                page = messageRepo.findByTextContainingIgnoreCase(pageable, filterText, user);
                break;
            case "010":
                page = messageRepo.findByTag(pageable, filterTag, user);
                break;
            case "001":
                page = messageRepo.findByUser(pageable, user, user);
                break;
            case "011":
                page = messageRepo.findByAuthorAndTag(pageable, user, filterTag, user);
                break;
            case "101":
                page = messageRepo.findByAuthorAndTextContainingIgnoreCase(pageable, user, filterText, user);
                break;
            case "111":
                page = messageRepo.findByAuthorAndTextContainingIgnoreCaseAndTag(pageable, user, filterText, filterTag, user);
                break;
            default:
                page = messageRepo.findAll(pageable, user);
        }

        return page;
    }

    public Page<MessageDto> messageListForUser(Pageable pageable, User author, User currentUser) {
        return messageRepo.findByUser(pageable, author, currentUser);
    }
}
