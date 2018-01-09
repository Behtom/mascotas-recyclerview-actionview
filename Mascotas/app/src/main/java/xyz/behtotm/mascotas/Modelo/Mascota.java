package xyz.behtotm.mascotas.Modelo;

/**
 * Created by mrmar on 26/12/2017.
 */

public class Mascota {

     private boolean favorito;
     private int foto;
     private int likes;
     private String nombre;

     public Mascota() {}

     public Mascota(boolean favorito, int foto, int likes, String nombre) {
          this.favorito = favorito;
          this.foto = foto;
          this.likes = likes;
          this.nombre = nombre;
     }

     public int getFoto() {
          return foto;
     }

     public void setFoto(int foto) {
          this.foto = foto;
     }

     public int getLikes() {
          return likes;
     }

     public void setLikes() {
          if(isFavorito())
               this.likes += 1;
          else
               this.likes -= 1;
     }

     public String getNombre() {
          return nombre;
     }

     public void setNombre(String nombre) {
          this.nombre = nombre;
     }

     public boolean isFavorito() {
          return favorito;
     }

     public void setFavorito() {
          if(this.favorito)
               this.favorito = false;
          else
               this.favorito = true;
     }
}


