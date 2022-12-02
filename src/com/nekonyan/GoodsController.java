package com.nekonyan;

import com.nekonyan.objects.Camera;
import com.nekonyan.objects.Lens;

public class GoodsController {

  Lens lens = new Lens();
  Camera camera = new Camera();
  Cart cart = new Cart();

  public void setLens(String brand, String model, String price) {
    String trimmedPrice = price.trim();
    lens.setBrand(brand);
    lens.setModel(model);
    lens.setPrice(trimmedPrice);
    addLens();
  }

  public void setCamera(String brand, String model, String price) {
    String trimmedPrice = price.trim();
    camera.setBrand(brand);
    camera.setModel(model);
    camera.setPrice(trimmedPrice);
    addCamera();
  }

  public void addLens() {
    String choosenLens = lens.getBrand() + ":" + lens.getModel() + ":" + lens.getPrice();
    cart.updateCart(choosenLens);
  }

  public void addCamera() {
    String choosenCamera = camera.getBrand() + ":" + camera.getModel() + ":" + camera.getPrice();
    cart.updateCart(choosenCamera);
  }
}
