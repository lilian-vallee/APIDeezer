import { Component, OnInit } from '@angular/core';
import { Router, ActivatedRoute } from '@angular/router';
import { DeezerService } from '../service/deezer.service';
import { Album } from '../model/album';

@Component({
  selector: 'app-list-album',
  templateUrl: './list-album.page.html',
  styleUrls: ['./list-album.page.scss'],
})
export class ListAlbumPage implements OnInit {

  private artistName: string;
  private listAlbum: Album[];

  constructor(public deezer:DeezerService,public routeur:Router, public activatedRoute: ActivatedRoute) {
    this.artistName = this.activatedRoute.snapshot.paramMap.get('name');
    console.log("Parametre : " + this.artistName);

    this.deezer.getAlbum(this.artistName).then( (result) => {
      this.listAlbum = result.data;
    });
  }

  searchAlbumTrack(id: number){
    this.routeur.navigate(["track/" + id]);
  }

  ngOnInit() {}

}
