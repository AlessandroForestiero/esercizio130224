package it.epicode.esercizio130224.repository;

import it.epicode.esercizio130224.model.BlogPost;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface BlogPostRepository extends JpaRepository<BlogPost,Integer>, PagingAndSortingRepository<BlogPost,Integer> {
}
