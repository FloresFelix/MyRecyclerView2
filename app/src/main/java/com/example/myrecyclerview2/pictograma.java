package com.example.myrecyclerview2;

public class pictograma {

    private int picto_foto;
    private String picto_nombre;
    private String picto_detalle;

    public pictograma(int picto_foto, String picto_nombre, String picto_detalle) {
        this.picto_foto = picto_foto;
        this.picto_nombre = picto_nombre;
        this.picto_detalle = picto_detalle;
    }

    public int getPicto_foto() {
        return picto_foto;
    }

    public String getPicto_nombre() {
        return picto_nombre;
    }

    public String getPicto_detalle() {
        return picto_detalle;
    }

    public void setPicto_foto(int picto_foto) {
        this.picto_foto = picto_foto;
    }

    public void setPicto_nombre(String picto_nombre) {
        this.picto_nombre = picto_nombre;
    }

    public void setPicto_detalle(String picto_detalle) {
        this.picto_detalle = picto_detalle;
    }
}
