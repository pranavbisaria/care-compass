package com.carecompass.Repository;

import com.carecompass.models.Comments;
import com.carecompass.models.Post;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CommentRepo extends JpaRepository<Comments, Long> {
    Page<Comments> findAllByPost(Post post, Pageable pageable);
}
