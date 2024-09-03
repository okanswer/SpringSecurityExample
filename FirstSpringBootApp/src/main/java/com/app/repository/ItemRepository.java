package com.app.repository;

import com.app.entity.Item;
import com.app.entity.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ItemRepository extends JpaRepository<Item,Long> {
    @Query("select i from Item i where i.person.id=:personId")
    public List<Item> findItemByPersonId(@Param("personId") Long personId);
}
