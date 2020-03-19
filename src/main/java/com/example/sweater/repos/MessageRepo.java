package com.example.sweater.repos;

import com.example.sweater.domain.Message;
import com.example.sweater.domain.User;
import com.example.sweater.domain.dto.MessageDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface MessageRepo extends CrudRepository<Message, Long> {

    @Query("select new com.example.sweater.domain.dto.MessageDto(" +
            "m, " +
            "count(ml), " +
            "sum(case when ml = :user then 1 else 0 end) > 0 ) " +
            "from Message m left join m.likes ml " +
            "group by m")
    Page<MessageDto> findAll(Pageable pageable, @Param("user") User user);

    @Query("select new com.example.sweater.domain.dto.MessageDto(" +
            "m, " +
            "count(ml), " +
            "sum(case when ml = :user then 1 else 0 end) > 0 ) " +
            "from Message m left join m.likes ml " +
            "where m.tag = :tag " +
            "group by m")
    Page<MessageDto> findByTag(Pageable pageable, @Param("tag") String tag, @Param("user") User user);

    @Query("select new com.example.sweater.domain.dto.MessageDto(" +
            "m, " +
            "count(ml), " +
            "sum(case when ml = :user then 1 else 0 end) > 0 ) " +
            "from Message m left join m.likes ml " +
            "where m.text like CONCAT('%',:text, '%') " +
            "group by m")
    Page<MessageDto> findByTextContainingIgnoreCase(Pageable pageable, @Param("text") String text, @Param("user") User user);

    @Query("select new com.example.sweater.domain.dto.MessageDto(" +
            "m, " +
            "count(ml), " +
            "sum(case when ml = :user then 1 else 0 end) > 0 ) " +
            "from Message m left join m.likes ml " +
            "where m.text like CONCAT('%',:text, '%') and m.tag = :tag " +
            "group by m")
    Page<MessageDto> findByTextContainingIgnoreCaseAndTag(Pageable pageable, @Param("text") String text, @Param("tag") String tag, @Param("user") User user);

    @Query("select new com.example.sweater.domain.dto.MessageDto(" +
            "m, " +
            "count(ml), " +
            "sum(case when ml = :user then 1 else 0 end) > 0 ) " +
            "from Message m left join m.likes ml " +
            "where m.author = :author and m.tag = :tag " +
            "group by m")
    Page<MessageDto> findByAuthorAndTag(Pageable pageable, @Param("author") User author, @Param("tag") String tag, @Param("user") User user);

    @Query("select new com.example.sweater.domain.dto.MessageDto(" +
            "m, " +
            "count(ml), " +
            "sum(case when ml = :user then 1 else 0 end) > 0 ) " +
            "from Message m left join m.likes ml " +
            "where m.author = :author and m.text like CONCAT('%',:text, '%') " +
            "group by m")
    Page<MessageDto> findByAuthorAndTextContainingIgnoreCase(Pageable pageable, @Param("author") User author, @Param("text") String text, @Param("user") User user);

    @Query("select new com.example.sweater.domain.dto.MessageDto(" +
            "m, " +
            "count(ml), " +
            "sum(case when ml = :user then 1 else 0 end) > 0 ) " +
            "from Message m left join m.likes ml " +
            "where m.author = :author and m.text like CONCAT('%',:text, '%') and m.tag = :tag " +
            "group by m")
    Page<MessageDto> findByAuthorAndTextContainingIgnoreCaseAndTag(Pageable pageable, @Param("author") User author, @Param("text") String text, @Param("tag") String tag, @Param("user") User user);

    @Query("select new com.example.sweater.domain.dto.MessageDto(" +
            "m, " +
            "count(ml), " +
            "sum(case when ml = :user then 1 else 0 end) > 0 ) " +
            "from Message m left join m.likes ml " +
            "where m.author = :author " +
            "group by m")
    Page<MessageDto> findByUser(Pageable pageable, @Param("author") User author, @Param("user") User user);

    Page<Message> findByAuthor(User user, Pageable pageable);
}
