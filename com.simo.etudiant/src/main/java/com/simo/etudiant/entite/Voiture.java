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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Voiture)) return false;

        Voiture voiture = (Voiture) o;

        if (couleur != null ? !couleur.equals(voiture.couleur) : voiture.couleur != null) return false;
        if (feneter != null ? !feneter.equals(voiture.feneter) : voiture.feneter != null) return false;
        if (porte != null ? !porte.equals(voiture.porte) : voiture.porte != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = porte != null ? porte.hashCode() : 0;
        result = 31 * result + (feneter != null ? feneter.hashCode() : 0);
        result = 31 * result + (couleur != null ? couleur.hashCode() : 0);
        return result;
    }
}