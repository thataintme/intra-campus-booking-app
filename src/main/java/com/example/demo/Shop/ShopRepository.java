package com.example.demo.Shop;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface ShopRepository extends JpaRepository<Shop,Long>{
    @Query("SELECT s FROM SHOP WHERE s.shopcode = ?1")
    Optional<Shop> findByCode(String shopCode);
    
}
