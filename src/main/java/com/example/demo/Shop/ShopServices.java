package com.example.demo.Shop;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ShopServices {
    private ShopRepository shopRepository;

    @Autowired
    public ShopServices(ShopRepository shopRepository) {
        this.shopRepository = shopRepository;
    }


    public List<Shop> getShops(){
        return shopRepository.findAll();
    }
    public void addNewShop(Shop shop){
        Optional<Shop> shopByCode = shopRepository.findByCode(shop.getShopCode());
        if(shopByCode.isPresent()){
            throw new IllegalStateException("Shop Code "+shop.getShopCode()+" is used by an existing shop ");
        }
        shopRepository.save(shop);

        System.out.println("Added shop "+shop);    
    }

    public void deleteShop(Long id){
        if(!shopRepository.existsById(id)){
            throw new IllegalStateException("Shop with id "+id+" does not exist");
        }
        shopRepository.deleteById(id);
    }

    public void updateShop(Long id, String name, String type, Boolean deliveryAvailable, String shopCode){
        Shop selectedShop = shopRepository.findById(id).orElseThrow(() -> new IllegalStateException("Shop with id "+id+" does not exist"));
        if(shopRepository.findByCode(shopCode).isPresent()){
            throw new IllegalStateException("Code already taken by existing shop");
        }

        if(name!=null){
            selectedShop.setName(name);
        }
        if(type!=null){
            selectedShop.setType(type);
        }
        if(deliveryAvailable!=null){
            selectedShop.setDeliveryAvailable(deliveryAvailable);
        }
        if(shopCode!=null){
            selectedShop.setShopCode(shopCode);
        }
        shopRepository.save(selectedShop);
    }

}
