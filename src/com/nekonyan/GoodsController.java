package com.nekonyan;

import com.nekonyan.objects.Camera;
import com.nekonyan.objects.Lens;

public class GoodsController {
  Lens lens = new Lens();
  Camera camera = new Camera();

  public void setLens(String brand, String model, String price){
    lens.setBrand(brand);
    lens.setModel(model);
    lens.setPrice(price);
  }

  public void setCamera(String brand, String model, String price){
    camera.setBrand(brand);
    camera.setModel(model);
    camera.setPrice(price);
  }

  public void getCamera(){
    System.out.println("Your cam is" + camera.getBrand() + camera.getModel() + camera.getPrice());
  }
}
