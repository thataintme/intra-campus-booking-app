package com.example.demo.Shop;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/api/v1/shops")
public class ShopController {
    private final ShopServices shopServices;

    @Autowired
    public ShopController(ShopServices shopServices) {
        this.shopServices = shopServices;
    }

    @GetMapping
    public List<Shop> getShops(){
        return shopServices.getShops();
    }

    @PostMapping
    public void addNewShop(Shop shop){
        shopServices.addNewShop(shop);
    }

    @DeleteMapping(path = "{shopID}")
    public void deleteShop(@PathVariable("shopID") Long id){
        shopServices.deleteShop(id);
    }

    @PutMapping(path = "{shopID}")
    public void updateShop(
        @PathVariable("shopID") Long id,
        @RequestParam(required = false) String name,
        @RequestParam(required = false) String type,
        @RequestParam(required = false) boolean deliveryAvailable,
        @RequestParam(required = false) String shopCode
    ){
        shopServices.updateShop(id, name, type, deliveryAvailable, shopCode);
    }
}
