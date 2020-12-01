package Graficos;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.awt.image.DataBufferByte;
import java.io.File;
import java.io.IOException;

public class Imagen {
    private BufferedImage imagen;
    private int alto;
    private int ancho;
    private int canales;
    private byte[] vector;

    //propiedades para editar las imagenes
    private boolean esGris;
    private int porcentajeBrilloTotal;
    private int porcentajeCanalAzul;
    private int porcentajeCanalVerde;
    private int porcentajeCanalRojo;
    private int focusUnfocus;

    //<editor-fold desc="Getters and Setters">
    public BufferedImage getImagen() {
        return imagen;
    }

    public void setImagen(BufferedImage imagen) {
        this.imagen = imagen;
        this.alto = imagen.getHeight();
        this.ancho = imagen.getWidth();
        this.canales = imagen.getColorModel().getNumComponents();
        this.vector = ((DataBufferByte) this.getImagen().getRaster().getDataBuffer()).getData();
    }

    public int getPorcentajeBrilloTotal() {
        return porcentajeBrilloTotal;
    }

    public int getAlto() {
        return alto;
    }

    public void setAlto(int alto) {
        this.alto = alto;
    }

    public int getAncho() {
        return ancho;
    }

    public void setAncho(int ancho) {
        this.ancho = ancho;
    }

    public int getCanales() {
        return canales;
    }

    public void setCanales(int canales) {
        this.canales = canales;
    }

    public int getFocusUnfocus() {
        return focusUnfocus;
    }

    public void setFocusUnfocus(int focusUnfocus) {
        this.focusUnfocus = focusUnfocus;
    }

    public void setPorcentajeBrilloTotal(int porcentajeBrilloTotal) {
        this.porcentajeBrilloTotal = porcentajeBrilloTotal;
    }

    public int getPorcentajeCanalAzul() {
        return porcentajeCanalAzul;
    }

    public void setPorcentajeCanalAzul(int porcentajeCanalAzul) {
        this.porcentajeCanalAzul = porcentajeCanalAzul;
    }

    public int getPorcentajeCanalRojo() {
        return porcentajeCanalRojo;
    }

    public void setPorcentajeCanalRojo(int porcentajeCanalRojo) {
        this.porcentajeCanalRojo = porcentajeCanalRojo;
    }

    public int getPorcentajeCanalVerde() {
        return porcentajeCanalVerde;
    }

    public void setPorcentajeCanalVerde(int porcentajeCanalVerde) {
        this.porcentajeCanalVerde = porcentajeCanalVerde;
    }

    public byte[] getVector() {
        return vector;
    }

    public void setVector(byte[] vector) {
        this.vector = vector;
    }

    public boolean isEsGris() {
        return esGris;
    }

    public void setEsGris(boolean esGris) {
        this.esGris = esGris;
    }
    //</editor-fold>

    public Imagen(String path) throws IOException {
        this.setImagen(ImageIO.read(new File(path)));
        this.setAlto(this.getImagen().getHeight());
        this.setAncho(this.getImagen().getWidth());
        this.setCanales(this.getImagen().getColorModel().getNumComponents());
        this.setVector(((DataBufferByte) this.getImagen().getRaster().getDataBuffer()).getData());
        this.setEsGris(false);
        this.setPorcentajeBrilloTotal(1);

    }

    private void aumentarBrilloImagen(int porcentaje) {
        for (int i = 0; i < this.getAlto(); i++) {
            for (int j = 0; j < this.getAncho(); j++) {
                for (int k = 0; k < this.getCanales(); k++) {
                    int posicionVector = obtenerPosicionVector(i, j, k);
                    int valor = Byte.toUnsignedInt(this.getVector()[posicionVector]);
                    valor = (valor * (100 + porcentaje) / 100);
                    if (valor <= 255) {
                        this.getVector()[posicionVector] = (byte) valor;
                    } else {
                        this.getVector()[posicionVector] = (byte) 255;
                    }
                }
            }
        }
    }

    private void aumentarBrilloImagenBlue(int porcentaje) {
        for (int i = 0; i < this.getAlto(); i++) {
            for (int j = 0; j < this.getAncho(); j++) {
                int posicionVector = obtenerPosicionVector(i, j, 0);
                int valor = Byte.toUnsignedInt(this.getVector()[posicionVector]);
                valor = (valor * (100 + porcentaje) / 100);
                if (valor <= 255) {
                    this.getVector()[posicionVector] = (byte) valor;
                } else {
                    this.getVector()[posicionVector] = (byte) 255;
                }
            }
        }
    }

    private void aumentarBrilloImagenGreen(int porcentaje) {
        for (int i = 0; i < this.getAlto(); i++) {
            for (int j = 0; j < this.getAncho(); j++) {
                int posicionVector = obtenerPosicionVector(i, j, 1);
                int valor = Byte.toUnsignedInt(this.getVector()[posicionVector]);
                valor = (valor * (100 + porcentaje) / 100);
                if (valor <= 255) {
                    this.getVector()[posicionVector] = (byte) valor;
                } else {
                    this.getVector()[posicionVector] = (byte) 255;
                }
            }
        }
    }

    private void aumentarBrilloImagenRed(int porcentaje) {
        for (int i = 0; i < this.getAlto(); i++) {
            for (int j = 0; j < this.getAncho(); j++) {
                int posicionVector = obtenerPosicionVector(i, j, 2);
                int valor = Byte.toUnsignedInt(this.getVector()[posicionVector]);
                valor = (valor * (100 + porcentaje) / 100);
                if (valor <= 255) {
                    this.getVector()[posicionVector] = (byte) valor;
                } else {
                    this.getVector()[posicionVector] = (byte) 255;
                }
            }
        }
    }
    //</editor-fold>


    private int obtenerPosicionVector(int fila, int columna, int posicion) {
        //cambiamos el valor dentro del vector
        //componentes de cada pixel
        int posicionVector = ((fila) * (this.getAncho()) * this.getCanales()) + ((columna) * this.getCanales()) + (posicion);
        return posicionVector;
    }

    private void actualizarImagen(Imagen imagenOriginal) {
        for (int i = 0; i < vector.length; i++) {
            this.vector[i] = imagenOriginal.vector[i];
        }
    }

    private void suavizarImagen(Imagen origen, Matriz convolucion, int divisor,int vueltas) {
        //recorremos los pixeles de la matriz
        for (int aux = 0; aux <vueltas ; aux++) {
            if(aux!=0){
                origen=this;
            }
            for (int i = 0; i < this.getAlto(); i++) {
                for (int j = 0; j < this.getAncho(); j++) {
                    for (int k = 0; k < this.getCanales(); k++) {
                        //si es borde no hacemos nada
                        if (i == 0 || j == 0 || i == this.getAlto() - 1 || j == this.getAncho() - 1) {
                        } else {
                            //se obtiene el valor del canal mediante la operación de convulcion y se aplica el valor
                            //nuevo al vector
                            int valor = calcularValor(origen, convolucion, i, j, k, divisor);
                            this.getVector()[obtenerPosicionVector(i, j, k)] = (byte) valor;
                        }
                    }
                }
            }
        }

    }

    private int calcularValor(Imagen origen, Matriz convolucion, int fila, int columna, int profundidad, int divisor) {
        int valor = 0;
        byte[] origenVector = origen.getVector();
        int posicionVector;

        //vamos una fila y columna para atras y luego lo corregimos en la matriz de convolucion
        for (int i = -1; i < convolucion.getFilas() - 1; i++) {
            for (int j = -1; j < convolucion.getColumnas() - 1; j++) {
                posicionVector = obtenerPosicionVector(fila + i, columna + j, profundidad);
                valor += Byte.toUnsignedInt(origenVector[posicionVector]) * convolucion.getValores()[i + 1][j + 1];
            }
        }
        //obtenemos el valor final si es mayor que 255 se hace 255 y si es menor que cero se hace 0
        valor = valor / divisor;
        if (valor > 255) {
            valor = 255;
        } else if (valor < 0) {
            valor = 0;
        }
        return valor;
    }

    /**
     * Calcula el valor medio de los colores rgb del pixel dado
     *
     * @param posicionVector posicion del primer color del pixel
     * @return valor medio
     */
    private int actualizarValorMedioBGR(int posicionVector, Imagen imagenOriginal) {
        int valor = 0;
        for (int i = 0; i < this.getCanales(); i++) {
            valor += Byte.toUnsignedInt(imagenOriginal.getVector()[posicionVector + i]);
        }
        valor = valor / 3;
        for (int i = 0; i < this.getCanales(); i++) {
            this.getVector()[posicionVector + i] = (byte) (valor);
        }
        return valor / 3;
    }

    private void convertirImagenGris(Imagen imgOrignal) {
        for (int i = 0; i < this.getAlto(); i++) {
            for (int j = 0; j < this.getAncho(); j++) {
                int posicionVector = obtenerPosicionVector(i, j, 0);
                actualizarValorMedioBGR(posicionVector, imgOrignal);
            }
        }
    }

    public void modificarImagen(Imagen imagenOriginal) {
        actualizarImagen(imagenOriginal);
        if (getFocusUnfocus() != 0) {
            if (getFocusUnfocus() > 0) {
                Matriz aux = new Matriz(3, 3);
                aux.rellenarMatrizBlur();
                suavizarImagen(imagenOriginal, aux, Matriz.calcularDivisor(aux),getFocusUnfocus());

            } else {
                Matriz aux = new Matriz(3,3);
                aux.rellenarMatrizSharp();
                suavizarImagen(imagenOriginal,aux,3,getFocusUnfocus()*-1);
            }
        }

        aumentarBrilloImagen(this.getPorcentajeBrilloTotal());
        aumentarBrilloImagenBlue(this.getPorcentajeCanalAzul());
        aumentarBrilloImagenGreen(this.getPorcentajeCanalVerde());
        aumentarBrilloImagenRed(this.getPorcentajeCanalRojo());

        if (esGris) {
            this.convertirImagenGris(imagenOriginal);
        }

    }
}
