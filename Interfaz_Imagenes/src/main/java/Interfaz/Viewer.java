package Interfaz;

import java.awt.*;
import java.awt.image.BufferedImage;

public class Viewer extends Canvas {
    private BufferedImage originalImage;
    private BufferedImage image1;
    private BufferedImage image2;
    private BufferedImage image3;

    public BufferedImage getOriginalImage() {
        return originalImage;
    }

    public void setOriginalImage(BufferedImage originalImage) {
        this.originalImage = originalImage;
    }

    public BufferedImage getImage1() {
        return image1;
    }

    public void setImage1(BufferedImage image1) {
        this.image1 = image1;
    }

    public BufferedImage getImage2() {
        return image2;
    }

    public void setImage2(BufferedImage image2) {
        this.image2 = image2;
    }

    public BufferedImage getImage3() {
        return image3;
    }

    public void setImage3(BufferedImage image3) {
        this.image3 = image3;
    }

    public Viewer(){

    }

    public void pintarImagenes(BufferedImage imagen){
        ;
    }
}
