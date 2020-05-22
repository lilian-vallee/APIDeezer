import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import { DataSearchArtist } from '../model/data-search-artist';
import { DataSearchAlbum } from '../model/data-search-album';
import { DataSearchTrack } from '../model/data-search-track';

@Injectable({
  providedIn: 'root'
})
export class DeezerService {
  private TAG: String = "DEEZER";

  constructor(private http: HttpClient) { }

  public getAuthors(artist:string):Promise<DataSearchArtist> {
    console.log(`${this.TAG} getAuthors ${artist}`);

    const url: string = 'https://api.deezer.com/search/artist?q=' + encodeURI(artist);
    console.log(`${this.TAG} url: ${url}`);

    return new Promise(resolve => {
      this.http.get(url).subscribe(data => {
      let json: DataSearchArtist = data as DataSearchArtist;
      resolve(json);
    }, err => {
      console.log(err);
    });
    });
  }

  public getAlbum(artist:string):Promise<DataSearchAlbum> {
    console.log(`${this.TAG} getAlbum of ${artist}`);

    const url: string = 'https://api.deezer.com/search/album?q=' + encodeURI(artist);
    console.log(`${this.TAG} url: ${url}`);

    return new Promise(resolve => {
      this.http.get(url).subscribe(data => {
      let json: DataSearchAlbum = data as DataSearchAlbum;
      resolve(json);
    }, err => {
      console.log(err);
      });
    });
  }
  getTracks(id: string):Promise<DataSearchTrack> {
    console.log(`${this.TAG} getTracks ${id}`);

    const url: string = "https://api.deezer.com/album/" + id + "/tracks";

    console.log(`${this.TAG} url ${url}`);

    return new Promise(resolve => {
      this.http.get(url).subscribe(data => {
        let json: DataSearchTrack = data as DataSearchTrack;
        resolve(json);
      }, err => {
        console.log(err);
      });
    });
  }
}
