package com.simo.etudiant.entite;

/**
 * Created by Simohamed on 2018-05-03.
 */
public class Voiture {
    private String porte;
    private String feneter;
    private String couleur;

    public Voiture() {
    }

    public Voiture(String porte, String feneter, String couleur) {
        this.porte = porte;
        this.feneter = feneter;
        this.couleur = couleur;
    }

    public String getPorte() {
        return porte;
    }

    public void setPorte(String porte) {
        this.porte = porte;
    }

    public String getFeneter() {
        return feneter;
    }

    public void setFeneter(String feneter) {
        this.feneter = feneter;
    }

    public String getCouleur() {
        return couleur;
    }

    public void setCouleur(String couleur) {
        this.couleur = couleur;
    }

    @Override
    public String toString() {
        return "Voiture{" +
                "porte='" + porte + '\'' +
                ", feneter='" + feneter + '\'' +
                ", couleur='" + couleur + '\'' +
                '}';
    }
}