import { Component } from '@angular/core';
import { DeezerService } from '../service/deezer.service';
import { Artist } from '../model/artist';
import { Router } from '@angular/router';

@Component({
  selector: 'app-home',
  templateUrl: 'home.page.html',
  styleUrls: ['home.page.scss'],
})
export class HomePage {

  private listArtist: Artist[];

  constructor(public deezer:DeezerService, public routeur:Router) {}

  onSearchArtist(event: any){
    let val = event.target.value;
    console.log("recherche effectuée : " + val);

    this.deezer.getAuthors(val).then( (result) => {
      this.listArtist = result.data;
    });
  }

  searchArtistAlbum(name:string){
    this.routeur.navigate(["list-album/" + name]);
  }
}
