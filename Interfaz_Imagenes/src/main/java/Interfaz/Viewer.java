package Interfaz;

import Graficos.Imagen;

import java.awt.*;
import java.awt.image.BufferedImage;

public class Viewer extends Canvas {
    private Imagen originalImage;
    private Imagen image1;
    private Imagen image2;
    private Imagen image3;
    private Imagen currentImage = null;

    public Imagen getOriginalImage() {
        return originalImage;
    }

    public void setOriginalImage(Imagen originalImage) {
        this.originalImage = originalImage;
    }

    public Imagen getImage1() {
        return image1;
    }

    public void setImage1(Imagen image1) {
        this.image1 = image1;
    }

    public Imagen getImage2() {
        return image2;
    }

    public void setImage2(Imagen image2) {
        this.image2 = image2;
    }

    public Imagen getImage3() {
        return image3;
    }

    public void setImage3(Imagen image3) {
        this.image3 = image3;
    }

    public Imagen getCurrentImage() {
        return currentImage;
    }

    public void setCurrentImage(Imagen currentImage) {
        this.currentImage = currentImage;
    }

    public Viewer(){

    }

    public void copyImages(){
        this.setImage1(this.getOriginalImage());
        this.setImage2(this.getOriginalImage());
        this.setImage3(this.getOriginalImage());
    }


    @Override
    public void paint(Graphics g) {
        int ancho = this.getWidth()/2;
        int alto = this.getHeight()/2;

        if(this.getOriginalImage()!=null){
            g.drawImage(getOriginalImage().getImagen(),0,0,ancho,alto,this);
            g.drawImage(getImage1().getImagen(),ancho,0,ancho,alto,this);
            g.drawImage(getImage2().getImagen(),0,alto,ancho,alto,this);
            g.drawImage(getImage3().getImagen(),ancho,alto,ancho,alto,this);
        }
    }
}
