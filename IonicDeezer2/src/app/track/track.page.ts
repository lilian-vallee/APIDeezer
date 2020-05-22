import { Component, OnInit } from '@angular/core';
import { Track } from '../model/track';
import { DeezerService } from '../service/deezer.service';
import { ActivatedRoute } from '@angular/router';

@Component({
  selector: 'app-track',
  templateUrl: './track.page.html',
  styleUrls: ['./track.page.scss'],
})
export class TrackPage implements OnInit {

  private albumId: string;
  private listTracks: Track[];
  private audio:HTMLAudioElement;

  constructor(public deezer:DeezerService, public activatedRoute: ActivatedRoute) {
    this.albumId = this.activatedRoute.snapshot.paramMap.get('id');
    console.log("Parametre : " + this.albumId);
    this.deezer.getTracks(this.albumId).then( (result) => {
      this.listTracks = result.data;
    });
    this.audio = new Audio();
  }

  play(src: any) {
    this.audio.src = src;
    this.audio.load();
    this.audio.play();
  }

  pause() {
    if(this.audio.paused) this.audio.play();
    else this.audio.pause();
  }

  ngOnInit() {
  }

}
