package com.demo.project103.repository;

import java.util.List;

import com.demo.project103.domain.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {

    @Query(value = """
            select * from customer where
            tsv @@ websearch_to_tsquery(:search);
            """, nativeQuery = true)
    List<Customer> searchByText(@Param("search") String search);

    @Query(value = """
            select *, ts_rank(tsv, websearch_to_tsquery(:search)) as rank
            from customer
            where tsv @@ websearch_to_tsquery(:search)
            order by rank desc;
            """, nativeQuery = true)
    List<Customer> rankSearchByText(@Param("search") String search);
}
