import {
  Component,
  ChangeDetectionStrategy,
  ChangeDetectorRef,
  OnInit,
  OnDestroy,
  Inject,
  PLATFORM_ID
} from '@angular/core';
import {
  CommonModule,
  isPlatformBrowser
} from '@angular/common';
import {
  RouterModule
} from '@angular/router';
import {
  FormsModule
} from '@angular/forms';
import {
  allHeroes
} from '../../hero/hero';

@Component({
  selector: 'app-heroes-page',
  standalone: true,
  imports: [CommonModule, RouterModule, FormsModule],
  changeDetection: ChangeDetectionStrategy.OnPush,
  templateUrl: './heroes-page.html',
  styleUrl: './heroes-page.css',
})
export class HeroesPage implements OnInit, OnDestroy {
  allHeroes = [...allHeroes];

  showAddHero = false;
  newHeroName = '';
  newHeroPower = '';

  private _heroesUpdatedHandler = () => {
    this.allHeroes = [...allHeroes];
    this.cdr.markForCheck();
  };

  constructor(private cdr: ChangeDetectorRef, @Inject(PLATFORM_ID) private platformId: Object) {}

  ngOnInit(): void {
    if (isPlatformBrowser(this.platformId)) {
      window.addEventListener('heroes-updated', this._heroesUpdatedHandler);
    }
  }

  ngOnDestroy(): void {
    if (isPlatformBrowser(this.platformId)) {
      window.removeEventListener('heroes-updated', this._heroesUpdatedHandler);
    }
  }

  deleteHero(heroId: number) {
    const idx = allHeroes.findIndex(h => h.id === heroId);
    if (idx !== -1) {
      allHeroes.splice(idx, 1);
    }
    this.allHeroes = [...allHeroes];
    if (isPlatformBrowser(this.platformId)) {
      window.dispatchEvent(new Event('heroes-updated'));
    }
  }

  submitAddHero() {
    const newId = allHeroes.length ? Math.max(...allHeroes.map((h) => h.id)) + 1 : 1;
    const newHero = {
      id: newId,
      name: this.newHeroName,
      power: this.newHeroPower,
    };
    allHeroes.push(newHero);
    this.allHeroes = [...allHeroes];
    if (isPlatformBrowser(this.platformId)) {
      window.dispatchEvent(new Event('heroes-updated'));
    }
    this.closeAddHero();
  }

  closeAddHero() {
    this.showAddHero = false;
    this.newHeroName = '';
    this.newHeroPower = '';
  }

  trackById(_index: number, hero: {
    id: number
  }) {
    return hero.id;
  }
}
