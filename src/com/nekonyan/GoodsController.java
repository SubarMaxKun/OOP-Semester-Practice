package com.nekonyan;

import com.nekonyan.objects.Camera;
import com.nekonyan.objects.Lens;

public class GoodsController {
  Lens lens = new Lens();
  Camera camera = new Camera();
  Cart cart = new Cart();

  public void setLens(String brand, String model, String price){
    lens.setBrand(brand);
    lens.setModel(model);
    lens.setPrice(price);
    addLens();
  }

  public void setCamera(String brand, String model, String price){
    camera.setBrand(brand);
    camera.setModel(model);
    camera.setPrice(price);
    addCamera();
  }

  public void addLens(){
    String choosenLens = lens.getBrand() + ":" + lens.getModel() + ":" + lens.getPrice();
    cart.updateCart(choosenLens);
  }

  public void addCamera(){
    String choosenCamera = camera.getBrand() + ":" + camera.getModel() + ":" + camera.getPrice();
    cart.updateCart(choosenCamera);
  }
}
