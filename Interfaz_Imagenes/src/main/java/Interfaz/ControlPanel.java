package Interfaz;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;


public class ControlPanel extends JPanel implements ActionListener, ChangeListener {
    private JButton fileButton;
    private Viewer viewer;
    private JButton image1;
    private JButton image2;
    private JButton image3;
    private JButton todo;
    private JButton recuadro;
    private JSlider sizeSlider;
    private JButton resetBrillo;
    private JSlider sliderBrillo;
    private JSlider sliderRed;
    private JSlider sliderGreen;
    private JSlider sliderBlue;
    private JButton greyConverter;
    private JSlider sliderFocus;
    private GridBagConstraints gbc = new GridBagConstraints();

    //Getters y setters


    public JButton getFileButton() {
        return fileButton;
    }

    public void setFileButton(JButton fileButton) {
        this.fileButton = fileButton;
    }

    public Viewer getViewer() {
        return viewer;
    }

    public void setViewer(Viewer viewer) {
        this.viewer = viewer;
    }

    public JButton getImage1() {
        return image1;
    }

    public void setImage1(JButton image1) {
        this.image1 = image1;
    }

    public JButton getImage2() {
        return image2;
    }

    public void setImage2(JButton image2) {
        this.image2 = image2;
    }

    public JButton getImage3() {
        return image3;
    }

    public void setImage3(JButton image3) {
        this.image3 = image3;
    }

    public JButton getTodo() {
        return todo;
    }

    public void setTodo(JButton todo) {
        this.todo = todo;
    }

    public JButton getRecuadro() {
        return recuadro;
    }

    public void setRecuadro(JButton recuadro) {
        this.recuadro = recuadro;
    }

    public JSlider getSizeSlider() {
        return sizeSlider;
    }

    public void setSizeSlider(JSlider sizeSlider) {
        this.sizeSlider = sizeSlider;
    }

    public JButton getResetBrillo() {
        return resetBrillo;
    }

    public void setResetBrillo(JButton resetBrillo) {
        this.resetBrillo = resetBrillo;
    }

    public JSlider getSliderBrillo() {
        return sliderBrillo;
    }

    public void setSliderBrillo(JSlider sliderBrillo) {
        this.sliderBrillo = sliderBrillo;
    }

    public JSlider getSliderRed() {
        return sliderRed;
    }

    public void setSliderRed(JSlider sliderRed) {
        this.sliderRed = sliderRed;
    }

    public JSlider getSliderGreen() {
        return sliderGreen;
    }

    public void setSliderGreen(JSlider sliderGreen) {
        this.sliderGreen = sliderGreen;
    }

    public JSlider getSliderBlue() {
        return sliderBlue;
    }

    public void setSliderBlue(JSlider sliderBlue) {
        this.sliderBlue = sliderBlue;
    }

    public JButton getGreyConverter() {
        return greyConverter;
    }

    public void setGreyConverter(JButton greyConverter) {
        this.greyConverter = greyConverter;
    }

    public JSlider getSliderFocus() {
        return sliderFocus;
    }

    public void setSliderFocus(JSlider sliderFocus) {
        this.sliderFocus = sliderFocus;
    }

    public GridBagConstraints getGbc() {
        return gbc;
    }

    public void setGbc(GridBagConstraints gbc) {
        this.gbc = gbc;
    }

    public ControlPanel(Viewer viewer){
        super();
        this.setViewer(viewer);
        this.setBackground(Color.lightGray);
        this.setLayout(new GridBagLayout());
        addFileButton();
        addImageChooser();
        addZone();
        addBrillo();
        addGreyConverter();
        addFilter();
        this.setVisible(true);
    }

    public void addFileButton(){
        this.fileButton = new JButton("Inserte archivo:");
        fileButton.addActionListener(this);
        JLabel labelFile = new JLabel("Archivo");

        gbc.gridx=0;
        gbc.gridy=0;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.weightx=0;
        gbc.weighty=0;
        gbc.anchor= GridBagConstraints.NORTH;
        gbc.ipadx = 1;
        gbc.ipady = 1;
        this.add(labelFile,gbc);

        gbc.gridx=1;
        gbc.gridy=0;
        gbc.gridheight=1;
        gbc.gridwidth=3;
        gbc.fill = GridBagConstraints.NONE;
        this.add(fileButton,gbc);

    }

    public void addImageChooser(){
        JLabel labelImageChooser = new JLabel("Imágenes");
        this.image1 = new JButton("Imagen 1");
        this.image2 = new JButton("Imagen 2");
        this.image3 = new JButton("Imagen 3");
        image1.addActionListener(this);
        image2.addActionListener(this);
        image3.addActionListener(this);


        gbc.gridx=0;
        gbc.gridy=1;
        gbc.gridwidth=1;
        gbc.gridheight=1;
        gbc.fill = GridBagConstraints.NONE;
        gbc.weightx=1;
        gbc.weighty=1;
        gbc.anchor = GridBagConstraints.NORTH;

        this.add(labelImageChooser,gbc);

        gbc.gridx=1;
        gbc.gridy=1;
        gbc.gridwidth=1;
        gbc.gridheight=1;
        this.add(image1,gbc);

        gbc.gridx=2;
        gbc.gridy=1;
        gbc.gridwidth=1;
        gbc.gridheight=1;
        this.add(image2,gbc);

        gbc.gridx=3;
        gbc.gridy=1;
        gbc.gridwidth=1;
        gbc.gridheight=1;
        this.add(image3,gbc);

    }

    public void addZone(){
        JLabel zonaLabel = new JLabel("Zona");
        this.todo = new JButton("Todo");
        this.recuadro = new JButton("Recuadro");

        gbc.gridx=0;
        gbc.gridy=2;
        gbc.gridwidth=1;
        gbc.gridheight=1;
        gbc.weightx=1;
        gbc.weighty=1;
        gbc.fill = GridBagConstraints.NONE;
        gbc.anchor = GridBagConstraints.NORTH;
        this.add(zonaLabel,gbc);

        gbc.gridx=1;
        gbc.gridy=2;
        gbc.gridwidth=2;
        gbc.gridheight=1;
        this.add(todo,gbc);

        gbc.gridx=3;
        gbc.gridy=2;
        gbc.gridheight=1;
        gbc.gridwidth=1;
        this.add(recuadro,gbc);

        addSizeSlider();
    }

    public void addSizeSlider(){
        JLabel sizeLabel = new JLabel("Tamaño");
        this.sizeSlider = new JSlider(0,10,5);

        gbc.gridx=0;
        gbc.gridy=3;
        gbc.gridwidth=1;
        gbc.gridheight=1;
        gbc.weightx=1;
        gbc.weighty=1;
        gbc.fill = GridBagConstraints.NONE;
        gbc.anchor = GridBagConstraints.NORTH;
        this.add(sizeLabel,gbc);

        gbc.gridx=1;
        gbc.gridy=3;
        gbc.gridwidth=3;
        gbc.gridheight=1;
        gbc.weightx = 1;
        gbc.weighty = 1;

        this.add(sizeSlider,gbc);

    }

    public void addBrillo(){
        JLabel brilloLabel = new JLabel("Brillo");
        this.resetBrillo = new JButton("Reset brillo");

        gbc.gridx=0;
        gbc.gridy=4;
        gbc.gridwidth=1;
        gbc.gridheight=1;
        gbc.weightx=1;
        gbc.weighty=1;
        gbc.fill = GridBagConstraints.NONE;
        gbc.anchor = GridBagConstraints.NORTH;
        this.add(brilloLabel,gbc);

        gbc.gridx=1;
        gbc.gridy=4;
        gbc.gridwidth=3;
        gbc.gridheight=1;
        gbc.weightx = 1;
        gbc.weighty = 1;

        this.add(resetBrillo,gbc);

        addSlidersBrillo();
    }

    public void addSlidersBrillo(){
        JLabel totalLabel = new JLabel("Total");
        this.sliderBrillo = new JSlider();
        JLabel redLabel = new JLabel("Canal Rojo");
        this.sliderRed = new JSlider();
        JLabel greenLabel = new JLabel("Canal Verde");
        this.sliderGreen = new JSlider();
        JLabel blueLabel = new JLabel("Canal Azul");
        this.sliderBlue = new JSlider();

        gbc.gridx=0;
        gbc.gridy=5;
        gbc.gridwidth=1;
        gbc.gridheight=1;
        gbc.weightx=1;
        gbc.weighty=1;
        gbc.fill = GridBagConstraints.NONE;
        gbc.anchor = GridBagConstraints.NORTH;
        this.add(totalLabel,gbc);

        gbc.gridx=1;
        gbc.gridy=5;
        gbc.gridwidth=3;
        gbc.gridheight=1;
        gbc.weightx=1;
        gbc.weighty=1;
        this.add(sliderBrillo,gbc);

        gbc.gridx=0;
        gbc.gridy=6;
        gbc.gridwidth=1;
        gbc.gridheight=1;
        gbc.weightx=1;
        gbc.weighty=1;
        gbc.fill = GridBagConstraints.NONE;
        gbc.anchor = GridBagConstraints.NORTH;
        this.add(redLabel,gbc);

        gbc.gridx=1;
        gbc.gridy=6;
        gbc.gridwidth=3;
        gbc.gridheight=1;
        gbc.weightx=1;
        gbc.weighty=1;
        this.add(sliderRed,gbc);

        gbc.gridx=0;
        gbc.gridy=7;
        gbc.gridwidth=1;
        gbc.gridheight=1;
        gbc.weightx=1;
        gbc.weighty=1;
        gbc.fill = GridBagConstraints.NONE;
        gbc.anchor = GridBagConstraints.NORTH;
        this.add(greenLabel,gbc);

        gbc.gridx=1;
        gbc.gridy=7;
        gbc.gridwidth=3;
        gbc.gridheight=1;
        gbc.weightx=1;
        gbc.weighty=1;
        this.add(sliderGreen,gbc);

        gbc.gridx=0;
        gbc.gridy=8;
        gbc.gridwidth=1;
        gbc.gridheight=1;
        gbc.weightx=1;
        gbc.weighty=1;
        gbc.fill = GridBagConstraints.NONE;
        gbc.anchor = GridBagConstraints.NORTH;
        this.add(blueLabel,gbc);

        gbc.gridx=1;
        gbc.gridy=8;
        gbc.gridwidth=3;
        gbc.gridheight=1;
        gbc.weightx=1;
        gbc.weighty=1;
        this.add(sliderBlue,gbc);
    }

    public void addGreyConverter(){
        this.greyConverter = new JButton("Convertir a gris");
        JLabel colorLabel = new JLabel("Color");

        gbc.gridx=0;
        gbc.gridy=9;
        gbc.gridwidth=1;
        gbc.gridheight=1;
        gbc.weightx=1;
        gbc.weighty=1;
        gbc.fill = GridBagConstraints.NONE;
        gbc.anchor = GridBagConstraints.NORTH;
        this.add(colorLabel,gbc);

        gbc.gridx=1;
        gbc.gridy=9;
        gbc.gridwidth=3;
        gbc.gridheight=1;
        gbc.weightx=1;
        gbc.weighty=1;
        this.add(greyConverter,gbc);
    }

    public void addFilter(){
        this.sliderFocus = new JSlider();
        JLabel filtroLabel = new JLabel("Filtros");
        JLabel minSlider = new JLabel("Focus");
        JLabel maxSlider = new JLabel("Unfocus");

        gbc.gridx=0;
        gbc.gridy=10;
        gbc.gridwidth=1;
        gbc.gridheight=1;
        gbc.weightx=1;
        gbc.weighty=1;
        gbc.fill = GridBagConstraints.NONE;
        gbc.anchor = GridBagConstraints.NORTH;
        this.add(filtroLabel,gbc);

        gbc.gridx=0;
        gbc.gridy=11;
        gbc.gridwidth=1;
        gbc.gridheight=1;
        gbc.weightx=1;
        gbc.weighty=1;
        gbc.fill = GridBagConstraints.NONE;
        gbc.anchor = GridBagConstraints.NORTH;
        this.add(minSlider,gbc);

        gbc.gridx=1;
        gbc.gridy=11;
        gbc.gridwidth=2;
        gbc.gridheight=1;
        gbc.weightx=1;
        gbc.weighty=1;
        gbc.fill = GridBagConstraints.NONE;
        gbc.anchor = GridBagConstraints.NORTH;
        this.add(sliderFocus,gbc);

        gbc.gridx=3;
        gbc.gridy=11;
        gbc.gridwidth=1;
        gbc.gridheight=1;
        gbc.weightx=1;
        gbc.weighty=1;
        gbc.fill = GridBagConstraints.NONE;
        gbc.anchor = GridBagConstraints.NORTH;
        this.add(maxSlider,gbc);
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        Viewer viewer = getViewer();

        switch (e.getActionCommand()){
            case "Inserte archivo:":
                FileDialog fileDialog = new FileDialog(new JFrame(),"pilla una foto", FileDialog.LOAD);
                fileDialog.setVisible(true);
                String path = fileDialog.getDirectory() + fileDialog.getFile();
                File file = new File(path);
                try {
                    viewer.getOriginalImage().setImagen(ImageIO.read(file));
                } catch (Exception exc) {

                }
                viewer.copyImages();
                break;
            case "Imagen 1":
                viewer.setCurrentImage(viewer.getImage1());
                break;
            case "Imagen 2":
                viewer.setCurrentImage(viewer.getImage2());
                break;
            case "Imagen 3":
                viewer.setCurrentImage(viewer.getImage3());
                break;
        }
    }

    @Override
    public void stateChanged(ChangeEvent e) {
        Viewer viewer = getViewer();

        if(e.getSource().equals(getSliderBrillo())){
            viewer.getCurrentImage().setPorcentajeBrilloTotal(getSliderBrillo().getValue());
            viewer.getCurrentImage().modificarImagen(viewer.getOriginalImage());
        }else if(e.getSource().equals(getSliderRed())){
            viewer.getCurrentImage().setPorcentajeCanalRojo(getSliderRed().getValue());
            viewer.getCurrentImage().modificarImagen(viewer.getOriginalImage());
        }else if(e.getSource().equals(getSliderGreen())){
            viewer.getCurrentImage().setPorcentajeCanalVerde(getSliderGreen().getValue());
            viewer.getCurrentImage().modificarImagen(viewer.getOriginalImage());
        }else if(e.getSource().equals(getSliderBlue())){
            viewer.getCurrentImage().setPorcentajeCanalAzul(getSliderBlue().getValue());
            viewer.getCurrentImage().modificarImagen(viewer.getOriginalImage());
        }
    }

}
