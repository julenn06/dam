import {
  Component,
  ChangeDetectionStrategy,
  Inject,
  PLATFORM_ID
} from '@angular/core';
import {
  CommonModule,
  isPlatformBrowser
} from '@angular/common';
import {
  RouterModule,
  ActivatedRoute
} from '@angular/router';
import {
  FormsModule
} from '@angular/forms';
import {
  Hero,
  allHeroes
} from '../../hero/hero';

@Component({
  selector: 'app-heroe-page',
  standalone: true,
  imports: [CommonModule, RouterModule, FormsModule],
  changeDetection: ChangeDetectionStrategy.OnPush,
  templateUrl: './heroe-page.html',
  styleUrl: './heroe-page.css',
})
export class HeroePage {
  hero: Hero | undefined;
  isEditing = false;
  editName = '';
  editPower = '';
  constructor(private route: ActivatedRoute, @Inject(PLATFORM_ID) private platformId: Object) {
    const id = Number(this.route.snapshot.paramMap.get('id'));
    this.hero = allHeroes.find((h) => h.id === id);
  }

  startEdit() {
    if (this.hero) {
      this.isEditing = true;
      this.editName = this.hero.name;
      this.editPower = this.hero.power;
    }
  }

  cancelEdit() {
    this.isEditing = false;
    this.editName = '';
    this.editPower = '';
  }

  saveEdit() {
    if (this.hero && this.editName.trim() && this.editPower.trim()) {
      const heroIndex = allHeroes.findIndex((h) => h.id === this.hero!.id);
      if (heroIndex !== -1) {
        allHeroes[heroIndex].name = this.editName.trim();
        allHeroes[heroIndex].power = this.editPower.trim();

        this.hero = {
          ...allHeroes[heroIndex]
        };
      }

      this.isEditing = false;
      this.editName = '';
      this.editPower = '';
      if (isPlatformBrowser(this.platformId)) {
        window.dispatchEvent(new Event('heroes-updated'));
      }
    }
  }
}
