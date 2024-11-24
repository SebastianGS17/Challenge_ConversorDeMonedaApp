package com.aluramodelos.Logica;

public class Cotizacion {

    private double conversionDeMoneda;

    private String fechaDeCotizacion;

    private double montoConvertido;


    public void setConversionDeMoneda(double conversionDeMoneda) {
        this.conversionDeMoneda = conversionDeMoneda;
    }

    public void setFechaDeCotizacion(String fechaDeCotizacion) {
        this.fechaDeCotizacion = fechaDeCotizacion;
    }

    public void setMontoConvertido(double montoConvertido) {
        this.montoConvertido = montoConvertido;
    }

    String getFechaDeCotizacion(){
        return fechaDeCotizacion;
    }

    double getConversionDeMoneda(){
        return conversionDeMoneda;
    }

    public Cotizacion(double conversionDeMoneda, String fechaDeCotizacion) {
        this.conversionDeMoneda = conversionDeMoneda;
        this.fechaDeCotizacion = String.valueOf(fechaDeCotizacion);
    }


    void muestraCotizacion (){
        System.out.println("El valor de conversion es de: "+ conversionDeMoneda);
        System.out.println("La fecha de cotizacion es: "+ fechaDeCotizacion);
        System.out.println("La cotizacion de la moneda a la fecha es de: "+ montoConvertido);
    }
}
